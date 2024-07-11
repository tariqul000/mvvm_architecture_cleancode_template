package com.simec.gfs.data.remote.middleware

import android.content.Context
import com.simec.gfs.style.R
import com.simec.gfs.activity.isNetworkAvailable
import com.simec.gfs.middleware.ConnectivityInterceptor
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