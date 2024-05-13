package com.example.e_shopstaff

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room

import com.example.e_shopstaff.dao.categorieDao
import com.example.e_shopstaff.data.eShopDatabase
import com.example.e_shopstaff.route.AppNavigation
import com.example.e_shopstaff.route.eShopApp
import com.example.e_shopstaff.ui.theme.EShopStaffTheme

import com.example.e_shopstaff.ui.theme.uiSuperAdmin.fenetreAcceuilAdmin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SuperAdminActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)


        setContent {
            EShopStaffTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    CoroutineScope(Dispatchers.IO).launch {initDatabase( getApplicationContext())}
                    AppNavigation()
                }
            }
        }

    }
}


fun initDatabase(context: Context): eShopDatabase {
    return eShopDatabase.getDatabase(context)
}
