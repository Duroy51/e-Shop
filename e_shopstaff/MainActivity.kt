package com.example.e_shopstaff


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.ObjectsCompat.toString
import com.example.e_shopstaff.data.ListeSuperAdmin
import com.example.e_shopstaff.ui.theme.EShopStaffTheme
import android.content.Intent
import android.content.Context
import com.example.e_shopstaff.data.ListeCaissier
import com.example.e_shopstaff.data.ListeMagasinier
import com.example.e_shopstaff.route.clientNavigation
import com.example.e_shopstaff.ui.theme.uiClient.PageConnexion
import com.example.e_shopstaff.ui.theme.uiClient.fenetreAcceuilClient
import com.example.e_shopstaff.ui.theme.uiClient.verifierConnexionAdmin
import com.example.e_shopstaff.ui.theme.uiClient.verifierConnexionCaissier
import com.example.e_shopstaff.ui.theme.uiClient.verifierConnexionMagasinier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            setContent {
                EShopStaffTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        val onLogin: (String, String) -> Unit = { numero, motDePasse ->
                            if (verifierConnexionAdmin(numero, motDePasse)) {
                                // Redirection vers AdminActivity si les informations sont correctes
                                val intent = Intent(this, SuperAdminActivity::class.java)
                                this.startActivity(intent)
                            } else if(verifierConnexionCaissier(numero, motDePasse) ){

                                val intent = Intent(this, CaissierActivity::class.java)
                                this.startActivity(intent)
                            } else if( verifierConnexionMagasinier(numero, motDePasse)){

                                val intent = Intent(this, MagasinierActivity::class.java)
                                this.startActivity(intent)
                            } else {


                            }
                        }
                        clientNavigation(onLogin = onLogin)
                            //PageConnexion(modifier = Modifier, onLogin = onLogin)
                }


            }
        }
    }
}

