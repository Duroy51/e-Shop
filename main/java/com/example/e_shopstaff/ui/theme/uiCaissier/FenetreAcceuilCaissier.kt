package com.example.e_shopstaff.ui.theme.uiCaissier

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.e_shopstaff.R

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
                text = stringResource(R.string.caissier),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = modifier
    )
}


@Composable
fun fenetreAcceuilCaissier(modifier: Modifier = Modifier,){

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                entete()
                SousEntete(fonction = R.string.caissier)

            }
        },

        ){it ->
        corpAcceuil()
    }

}

@Composable
fun corpAcceuil(){

    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
        verticalArrangement = Arrangement.Center
    ) {
        cardOptionCaissier(fonction = R.string.ConStock)
        cardOptionCaissier(fonction = R.string.GerCom)
        cardOptionCaissier(fonction = R.string.GerTon)


    }
}

@Composable
fun SousEntete(fonction : Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = fonction),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cardOptionCaissier(@StringRes fonction: Int, modifier: Modifier = Modifier ) {

    val color = MaterialTheme.colorScheme.tertiaryContainer
    Card( onClick = { /* Votre action ici */ },
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