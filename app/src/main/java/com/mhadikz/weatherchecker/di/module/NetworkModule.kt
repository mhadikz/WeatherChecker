package com.mhadikz.weatherchecker.di.module

import com.mhadikz.weatherchecker.api.ApiService
import com.mhadikz.weatherchecker.api.ApiUrls
import com.mhadikz.weatherchecker.api.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(provideInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(ApiUrls.BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    companion object {
        private const val NETWORK_CALL_TIMEOUT = 20L
    }

}