package com.example.eduk8t.network

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val CLIENT_ID = "38JCZ4kPdHVL0zCSdTFLeOrcKj8iAEmnHln4yH5J"
        val CLIENT_SECRET = "VoFpeAPvC25pOP7xhtDW9Hx094BkoQunlyo0lyOY90DhbOK2T0VI47qKpaW51bxkEJqB8MREcDYOdfMAvKPteJF5W9dP43KB5K7rxK5Ny5QFK7emfGwuqhOKmOdObJc5"

        val authPayload = "$CLIENT_ID:$CLIENT_SECRET"
        val data = authPayload.toByteArray()
        val base64 = Base64.encodeToString(data, Base64.NO_WRAP)
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Basic $base64".trim())
            .build()
        return chain.proceed(request)
    }
}