package com.s.k_api.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.s.k_api.db.RocketDBHelper
import com.s.k_api.model.SpaceRocket
import com.s.k_api.network.RetroAPIService
import com.s.k_api.util.NetworkCheck

// Repository gets data from DB and API and sends to view
// DB and API parameters as reference to access data resp
class SpaceRepository( private val db: RocketDBHelper, private val retroService: RetroAPIService,
                       private  val applicationContext: Context) {

    private val rocketLiveData = MutableLiveData<List<SpaceRocket>>()
    val rocket: MutableLiveData<List<SpaceRocket>>
    get() = rocketLiveData

    suspend fun getRocketList(){

        // check if internet is ON , if no pass data from API
        if(NetworkCheck.checkConnection(applicationContext)){

            val result = retroService.getRockets()

            if(result.body() != null){
                if(db.getDao().getRocketList().containsAll(result.body()!!)){
                    rocketLiveData.postValue(result.body())
                    Log.d("DATAFLOW_check", "Already in DB")
//                    Toast.makeText(applicationContext,"Already in DB",Toast.LENGTH_LONG).show()

                }else{
                    db.getDao().addRocketListfromAPI(result.body()!!)
                    rocketLiveData.postValue(result.body())
                    Log.d("DATAFLOW_check", "Inserted in DB")
//                    Toast.makeText(applicationContext,"Inserted in DB",Toast.LENGTH_LONG).show()
                }
            }

            suspend fun delete(spaceRocket: SpaceRocket): Int {
                return db.getDao().deleteDBRecords()}

//      pass data from db if internet is OFF

        }else{

            rocketLiveData.postValue(db.getDao().getRocketList())
//            Toast.makeText(applicationContext,db.getDao().getRocketList().size,Toast.LENGTH_LONG).show()
    }


    }


}




