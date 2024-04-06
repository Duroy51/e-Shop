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
                            PageConnexion(modifier = Modifier, onLogin = onLogin)

                }


            }
        }
    }
}

@Composable
fun PageConnexion( modifier: Modifier = Modifier,onLogin: ((String, String) -> Unit)?=null, verify : Boolean = true)
{
    var numero by remember { mutableStateOf("") }
    var motDePasse by remember { mutableStateOf("") }
    var clé  by remember { mutableStateOf(0) }



    Column( modifier = Modifier.fillMaxSize(), // Remplit l'espace parent
        horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
        verticalArrangement = Arrangement.Center
    ){
        Row() {

            Image(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                contentDescription = null,
                painter = painterResource(R.drawable.logo)
            )
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )



        }
        Spacer(modifier = Modifier.height(40.dp))
        TextField(
            label = {Text(text = stringResource(R.string.Numéro_mobile))},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            leadingIcon = { Icon(Icons.Filled.Call, null) },
            value = numero, // Utiliser la valeur passée en paramètre
            onValueChange = { numero = it }, // Utiliser la fonction passée en paramètre
            singleLine = true,

            )




        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            modifier = Modifier,
            leadingIcon = { Icon(Icons.Rounded.Info, null) },
            label = {Text(text = stringResource(R.string.mot_de_passe))},
            value = motDePasse, // Utiliser la valeur passée en paramètre
            onValueChange = { motDePasse = it }, // Utiliser la fonction passée en paramètre
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        if (verifierConnexionMagasinier(numero, motDePasse) == false && verifierConnexionAdmin(numero, motDePasse) == false && verifierConnexionCaissier(numero, motDePasse) == false && clé == 1) {
            Text("Numéro mobile ou mot de passe incorrect", color = Color.Red) // Message d'erreur pour l'email
            Spacer(modifier = Modifier.height(20.dp))
        }


        Button(
            onClick = {verifierConnexionAdmin(numero, motDePasse)

                clé = 1

                if (onLogin != null) {
                    onLogin(numero, motDePasse)
                }


                      },
            content = { Text("Se Connecter") }
        )


    }
}


fun verifierConnexionAdmin(numero : String, motDePasse : String): Boolean{

    return ListeSuperAdmin.any {
        it.numero == numero && it.motDePasse == motDePasse
    }
}

fun verifierConnexionCaissier(numero : String, motDePasse : String): Boolean{

    return ListeCaissier.any {
        it.numero == numero && it.motDePasse == motDePasse
    }
}

fun verifierConnexionMagasinier(numero : String, motDePasse : String): Boolean{

    return ListeMagasinier.any {
        it.numero == numero && it.motDePasse == motDePasse
    }
}