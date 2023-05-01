package id.co.orderfaz.core.client


object ApiService {

//    inline fun <reified T> create(context: Context, baseUrl: String): T {
//
//        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        // Create the Collector
//        val chuckerCollector = ChuckerCollector(
//            context = context,
//            // Toggles visibility of the notification
//            showNotification = true,
//            // Allows to customize the retention period of collected data
//            retentionPeriod = RetentionManager.Period.ONE_HOUR
//        )
//
//        val chuckInterceptor = ChuckerInterceptor.Builder(context)
//            .collector(chuckerCollector)
//            .build()
//
//        val client = OkHttpClient.Builder()
//            .readTimeout(30, TimeUnit.SECONDS)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor(httpLoggingInterceptor)
//            .addInterceptor(chuckInterceptor)
//            .build()
//
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .client(client)
//            .build()
//            .create(T::class.java)
//    }

}