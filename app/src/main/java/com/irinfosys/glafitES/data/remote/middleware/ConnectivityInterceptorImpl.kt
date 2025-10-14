package com.irinfosys.glafitES.data.remote.middleware

import android.content.Context
import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.activity.isNetworkAvailable
import com.irinfosys.glafitES.middleware.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(
    context: Context
): ConnectivityInterceptor {

    private val appContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!appContext.isNetworkAvailable()) {
            throw IOException(appContext.getString(R.string.message_network_error))
        }
        return chain.proceed(chain.request())
    }
}