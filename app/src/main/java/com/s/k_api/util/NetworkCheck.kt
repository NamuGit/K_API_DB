package com.s.k_api.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


class NetworkCheck {

    companion object{
        @SuppressLint("MissingPermission")
        fun checkConnection(context: Context): Boolean {

            (context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager).run {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_INTERNET
                    ) ?: false
                } else {
                   return this.activeNetworkInfo?.isConnected ?: false
                }
            }

            }

        }
    }
