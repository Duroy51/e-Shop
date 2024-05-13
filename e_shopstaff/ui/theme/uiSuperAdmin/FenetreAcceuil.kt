package com.example.e_shopstaff.ui.theme.uiSuperAdmin

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_shopstaff.R
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun entete(modifier: Modifier = Modifier,){
    CenterAlignedTopAppBar(
        title = {

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

        },

        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffName(modifier: Modifier = Modifier,){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.sup_admin),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = modifier
    )
}


@Composable
fun fenetreAcceuilAdmin(
    navController: NavController,
    modifier: Modifier = Modifier,
    ){

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                entete()
                SousEntete(fonction = R.string.sup_admin)

            }
        },

        ){it ->
        corpFentreAcceuilAdmin(navController = navController, route1="gesArticle" , route2="", route3="")
    }

}

@Composable
fun corpFentreAcceuilAdmin(navController: NavController, route1 : String, route2 : String, route3 : String ){
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
        verticalArrangement = Arrangement.Center
    ) {
        cardOption(fonction = R.string.ges_Article, navController = navController, route = route1)
        cardOption(fonction = R.string.ges_compteCl,navController = navController, route = route2 )
        cardOption(fonction = R.string.ges_compteAd,navController = navController, route = route3 )


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cardOption(@StringRes fonction: Int, navController: NavController, modifier: Modifier = Modifier, route : String ) {

    val color = MaterialTheme.colorScheme.tertiaryContainer
    Card( onClick = { navController.navigate(route) },
        modifier = Modifier

            .height(90.dp) // Définit la hauteur de la Card à 200.dp
            .clip(RoundedCornerShape(1.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), // Remplit la taille de la Card
            horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
            verticalArrangement = Arrangement.Center // Centre verticalement
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {

                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    contentDescription = null,
                    painter = painterResource(R.drawable.logo2)
                )

                Text(
                    text = stringResource(id = fonction),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top =10.dp),
                    fontWeight = FontWeight.Bold // Style du texte (facultatif)
                )
                Spacer(modifier = Modifier.width(70.dp))
            }
        }
    }

    Spacer(modifier = Modifier.height(35.dp))
}

@Composable
fun SousEntete(fonction : Int){
    Box( modifier = Modifier
        .fillMaxWidth()
        .background(Color.White.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(id = fonction),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}






