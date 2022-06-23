package com.s.k_api.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.s.k_api.db.RocketDBHelper
import com.s.k_api.model.RocketDetails
import com.s.k_api.model.SpaceRocket
import com.s.k_api.network.RetroAPIService
import com.s.k_api.util.NetworkCheck

// Repository gets data from DB and API and sends to view
// DB and API parameters as reference to access data resp
class SpaceRepository( private val db: RocketDBHelper, private val retroService: RetroAPIService,
                       private  val applicationContext: Context) {


    // initialize live data for SpaceRocket model
    private val rocketLiveData = MutableLiveData<List<SpaceRocket>>()
    val rocket: MutableLiveData<List<SpaceRocket>>
    get() = rocketLiveData    // get()- gets the updated value and sets to variable(i.e rocketLiveData)


    // initialize live data for RocketDetails Model

    private val rocketDetailsList = MutableLiveData<RocketDetails>()
    val details : MutableLiveData<RocketDetails>
    get() =rocketDetailsList



    suspend fun getRocketListfromRepo(){

        // check if internet is ON , if no pass data from API
        if(NetworkCheck.checkConnection(applicationContext)){

            val result = retroService.getRockets()

            if(result.body() != null){

                    db.getDao().addRocketListfromAPI(result.body()!!)
                    rocketLiveData.postValue(result.body())
                    Log.d("DATAFLOW_check", "Inserted in DB")
//                    Toast.makeText(applicationContext,"Inserted in DB",Toast.LENGTH_LONG).show()

            }
            suspend fun delete(spaceRocket: SpaceRocket): Int {
                return db.getDao().deleteDBRecords()}
//      pass data from db if internet is OFF
        }else{
            rocketLiveData.postValue(db.getDao().getRocketList())
    }
    }

    suspend fun getRocketDetailsfromRepo(idd: String){
        var id= idd
        if(idd.isEmpty()){
         id="5e9d0d95eda69955f709d1eb"
        }

        Log.d("ID_valuefromclick","is "+id)
        if(NetworkCheck.checkConnection(applicationContext)){

            val detail_result = retroService.getRocketsDetails(id)
            if(detail_result.body() != null){
                    db.getDao().addDetailsListfromAPI(detail_result.body()!!)
                    rocketDetailsList.postValue(detail_result.body())
                    Log.d("RocketDetails_check", "Inserted in DB")
//                    Toast.makeText(applicationContext,"Inserted in DB",Toast.LENGTH_LONG).show()
                }

            suspend fun delete(spaceRocket: SpaceRocket): Int {
                return db.getDao().deleteDBRecords()}

//      pass data from db if internet is OFF

        }else{
            rocketDetailsList.postValue(db.getDao().getRocketDetails())
        }
    }


}




