package id.co.orderfaz.feature.autotext.client

import id.co.orderfaz.core.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(Interceptor(){
            chain -> val request = chain.request().newBuilder()
        .addHeader("Authorization", Constants.BASE_TOKEN).addHeader("Content-type","application/json")
        chain.proceed(request.build())

    })

    private val builder : Retrofit.Builder = Retrofit.Builder().baseUrl(Constants.BASE_URL_AUTO_TEXT).addConverterFactory(
        GsonConverterFactory.create()).addCallAdapterFactory(
        RxJava3CallAdapterFactory.create()).client(
        okHttp.build())

    private val retrofit : Retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}