package com.example.e_shopstaff

import android.app.Application
import com.example.e_shopstaff.data.eShopDatabase


class eShopApplication: Application() {


    lateinit var container: AppContainer


        override fun onCreate() {
            if (::container.isInitialized)
            {
            super.onCreate()
            container = AppDataContainer(this)
        }
    }
}