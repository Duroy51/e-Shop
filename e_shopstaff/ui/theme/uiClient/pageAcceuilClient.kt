package com.example.e_shopstaff.ui.theme.uiClient



import androidx.compose.animation.*
import androidx.compose.animation.core.*

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.OpenInFull
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_shopstaff.R
import com.example.e_shopstaff.data.categorie
import com.example.e_shopstaff.data.categories
import com.example.e_shopstaff.data.categorietest
import com.example.e_shopstaff.data.photos
import com.example.e_shopstaff.data.produit
import com.example.e_shopstaff.data.produitTest
import com.example.e_shopstaff.data.produits
import com.example.e_shopstaff.ui.theme.DancingScript
import com.example.e_shopstaff.ui.theme.SatisfyRegular
import com.example.e_shopstaff.ui.theme.TitanOne

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fenetreAcceuilClient(navController: NavController){

    var TexteRecherche by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            barreLatérale(navController = navController)

        }
    ) {

        Scaffold(
            topBar = {

                Column(modifier = Modifier) {

                    e_shopTopAppBar()
                    Spacer(modifier = Modifier.height(1.dp))
                    BarreRecherche(
                        value = TexteRecherche,
                        onValueChange = { TexteRecherche = it },
                        modifier = Modifier
                        // Votre code pour le modifier
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    /*Row() {
                        IconeTouteLesCategorie()
                    }*/
                }

            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.height(100.dp)


                ) {
                    e_shopBottomBar(onSelectionChanged = drawerState)
                }
            },

            content = {innerPadding ->
            CorpsPageAcceuil( innerPadding = innerPadding, navController = navController)
        },
        )
    }

}






@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun e_shopTopAppBar(modifier: Modifier = Modifier, ) {

    var TexteRecherche by remember { mutableStateOf("") }



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
                    text = "e-Shop",
                    style = MaterialTheme.typography.displayLarge
                )

            }
        },


        modifier = modifier
    )
}

@Composable
fun BarreRecherche(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,){

    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            modifier = Modifier.weight(0.75f),
            shape = RoundedCornerShape(32.dp),
            placeholder = { Text("Rechercher un produit") },
            value = value, // Utiliser la valeur passée en paramètre
            onValueChange = onValueChange, // Utiliser la fonction passée en paramètre
            singleLine = true,



            )
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Search, contentDescription = "Rechercher")
        }
    }
}

@Composable
fun CorpsPageAcceuil(modifier: Modifier = Modifier, innerPadding: PaddingValues,navController: NavController ) {


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(top = 20.dp)
    ) {

        /*LazyColumn {
            items(categories) { categorie ->
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1000)) +
                            scaleIn(animationSpec = tween(durationMillis = 1000)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 1000)) +
                            scaleOut(animationSpec = tween(durationMillis = 1000))
                ) {
                    tableCategorie2(
                        Catégorie = categorie,
                        navController = navController
                    )
                }
            }
        }*/
        listePresentation()
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .width(10.dp)
        )
    }


}


@Composable
fun IconeTouteLesCategorie(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .height(80.dp) // Définit la hauteur de la Card à 200.dp

            .clip(RoundedCornerShape(1.dp))
            .clickable { },
    ) {
        Row(){
            Column(modifier = Modifier
                .clip(RoundedCornerShape(90.dp)) // Pour les coins arrondis
                .background(Color.Blue)
                .width(70.dp) // Largeur de 200 dp
                .height(50.dp) // Hauteur de 50
            ){

                Icon(
                    Icons.Rounded.Category,
                    modifier = Modifier.size(40.dp),
                    contentDescription = " "
                )
            }

            Spacer(modifier = Modifier.width(9.dp))
            Column(modifier = Modifier,
                verticalArrangement = Arrangement.Center
                ) {
                Text(
                    text = "Toutes les catégories",
                    modifier = modifier,
                    textAlign = TextAlign.Center,
                    fontFamily = DancingScript,
                    fontSize = 24.sp
                )
            }
        }
    }
}





/*@Composable
fun cadreProduit(produit: produit, modifier: Modifier = Modifier){


        Column( modifier = Modifier) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier

                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                val image = photos.firstOrNull { it.codePro == produit.codePro }
                image?.let {
                    Image(
                        painter = painterResource(id = it.lienPhoto),
                        contentDescription = null,

                        )
                }
            }
            Text(
                text = produit.nomPro,
                textAlign = TextAlign.Center,
                modifier = modifier,
            )

        }
    }*/



@Composable
fun e_shopBottomBar(
    modifier: Modifier = Modifier,
    onSelectionChanged: DrawerState ,

){
    Row( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly ){

        IconButton(onClick = { onSelectionChanged }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }

        IconButton(onClick = { }) {
            Icon(Icons.Rounded.Home,  modifier = Modifier.size(28.dp), contentDescription = "Page d'accueil")
        }

        IconButton(onClick = { }) {
            Icon(Icons.Filled.ShoppingCart,  modifier = Modifier.size(28.dp), contentDescription = "Panier d'achat")
        }



        IconButton(onClick = { }) {
            Icon(Icons.Rounded.Person,  modifier = Modifier.size(28.dp), contentDescription = "Création de compte")
        }
    }
}


@Composable
fun barreLatérale(
    modifier: Modifier = Modifier,
    navController: NavController

){
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(0.9f)
    ){
        Column {
            /*Row {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.ArrowBackIosNew  ,  modifier = Modifier.size(28.dp), contentDescription = "Création de compte")
                }
            }*/

            Column {
                Box(modifier = Modifier
                    .background(Color.White.copy(alpha = 0.6f))
                    .clickable(onClick = { /* Réaction au clic ici */ })){
                    Image(
                        painter = painterResource(R.drawable.badge),
                        contentDescription = null,

                        )
                    /*Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White.copy(alpha = 0.3f))
                            .clickable(onClick = { /* Réaction au clic ici */ })
                    )*/
                }

                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text =stringResource(id = R.string.se_connecter_a_tant_que_gérant) ,
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )

                Button(onClick = {navController.navigate("pageConnexion" ) },content = { Text("Connection") })



            }
        }
    }
}

@Composable
fun tableCategorie2(
    Catégorie: categorie,
    modifier: Modifier = Modifier,
    navController: NavController
    ){
    val produitsFiltres = remember(Catégorie.idCat) {
        produits.filter { it.idCategorie == Catégorie.idCat}
    }

    Column {
        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)) {

            Text(
                text = Catégorie.nomCat,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 10.dp),
                fontFamily = SatisfyRegular,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.width(9.dp))
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowUpward,
                    modifier = Modifier
                        .size(30.dp)
                        .rotate(90f),
                    contentDescription = ""
                )
            }

        }
        LazyRow {
            items(produitsFiltres) { produit ->
                val isVisible = remember { mutableStateOf(true) }
                AnimatedVisibility(
                    visible = isVisible.value,
                    enter = fadeIn() + expandIn(),
                    exit = fadeOut() + shrinkOut()
                ) {
                    cadreProduit2(
                        Produit = produit,
                        modifier = Modifier,
                        navController = navController
                    )
                }
            }
        }
    }
    
}

/*@Composable
fun PulsingIcon() {
    // Créez une valeur animatable pour la taille de l'icône
    val animatedSize = remember { Animatable(1f) }

    // Lancez l'animation lorsque le composable est appelé
    LaunchedEffect(true) {
        animatedSize.animateTo(
            targetValue = 1.2f, // Taille cible de l'animation
            animationSpec = tween(durationMillis = 500) // Durée de l'animation
        )
        animatedSize.animateTo(
            targetValue = 1f, // Retour à la taille normale
            animationSpec = tween(durationMillis = 500)
        )
    }

    Icon(
        imageVector = Icons.Default.ArrowForward,
        contentDescription = "Flèche droite",
        modifier = Modifier.size(animatedSize.value.dp),
        tint = Color.Black
    )
}*/



@Composable
fun cadreProduit2(Produit: produit,
                  modifier: Modifier = Modifier,
                  navController: NavController
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(20.dp),
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            val image = photos.first { it.codePro == Produit.codePro }
            image?.let {
                Image(
                    painter = painterResource(id = it.lienPhoto),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_produit))

                        /*.padding(dimensionResource(id = R.dimen.padding_small))*/,
                )
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = Produit.nomPro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 9.dp),
                    fontFamily = SatisfyRegular,
                    style = MaterialTheme.typography.titleLarge,

                )
                Text(
                    text = Produit.prix.toString()+" "+"Fcfa",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 9.dp),
                    fontFamily = SatisfyRegular,
                    style = MaterialTheme.typography.titleMedium,

                    )
                Spacer(modifier = Modifier.height(9.dp))
                ButtonJeShoppe(modifier = Modifier.align(Alignment.CenterHorizontally), Produit = Produit, navController = navController )
                Spacer(modifier = Modifier.height(9.dp))
            }
        }

    }
}


@Composable
fun listePresentation(){
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.horizontalScroll(scrollState)){
        cadrePresentation(image = R.drawable.homme, noms = "Homme")
        cadrePresentation(image = R.drawable.femme, noms = "Femme")
        cadrePresentation(image = R.drawable.enfant, noms = "Enfant")
        cadrePresentation(image = R.drawable.jk, noms = "")

    }
}

@Composable
fun cadrePresentation(image: Int, noms: String = "",modifier: Modifier = Modifier, ){

    val scrollState = rememberScrollState()

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(5.dp)

    ){

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_presentation))

                /*.padding(dimensionResource(id = R.dimen.padding_small))*/,
            )
        if(noms != "") {


            Text(
                text = noms,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 9.dp),

                fontFamily = SatisfyRegular,
                style = MaterialTheme.typography.titleLarge,

                )
        }

    }

}

@Composable
fun cadrePresentationCliquable(image: Int, noms: String,modifier: Modifier = Modifier, ){

    val scrollState = rememberScrollState()

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(5.dp)

    ){

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_presentation))

            /*.padding(dimensionResource(id = R.dimen.padding_small))*/,
        )


        Text(
            text = noms,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 9.dp),

            fontFamily = SatisfyRegular,
            style = MaterialTheme.typography.titleLarge,

            )

    }

}


@Composable
fun cadreProduit3(
    Produit: produit,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(20.dp)
            /*.scaleIn(initialScale = 0.9f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))*/
            .background(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Votre code pour l'image et les textes ici
            val image = photos.first { it.codePro == Produit.codePro }
            image?.let {
                Image(
                    painter = painterResource(id = it.lienPhoto),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_produit))

                    /*.padding(dimensionResource(id = R.dimen.padding_small))*/,
                )
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = Produit.nomPro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 9.dp),
                    fontFamily = SatisfyRegular,
                    style = MaterialTheme.typography.titleLarge,

                    )
                Text(
                    text = Produit.prix.toString() + " " + "Fcfa",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 9.dp),
                    fontFamily = SatisfyRegular,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            // Bouton personnalisé avec un style minimaliste
            ButtonJeShoppe(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                Produit = Produit,
                navController = navController
            )
        }
    }
}


@Composable
fun ButtonJeShoppe(modifier: Modifier = Modifier, navController: NavController, Produit : produit){

    var isClicked by remember { mutableStateOf(false) }
    val codePro = Produit.codePro

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isClicked) MaterialTheme.colorScheme.primaryContainer else Color.White,
        ),
        modifier = Modifier
            .size(width = 110.dp, height = 50.dp)
            .fillMaxSize()
            .clickable {
                // Gérez l'événement de clic ici
                //isClicked = !isClicked
                navController.navigate("productDetails/${Produit.codePro}")
            },
    )

    {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row {

                Text(
                    text = stringResource(id = R.string.Shopper),
                    textAlign = TextAlign.Center,
                    modifier = modifier,
                    /*fontFamily = TitanOne,*/
                    /*color = if (isClicked) Color.White else Color.Black,*/
                )
                /*Spacer(modifier = Modifier.width(9.dp))*/
                Icon(
                    Icons.Rounded.ChevronRight,
                    modifier = Modifier.size(18.dp),
                    contentDescription = ""
                )
            }
        }
    }
}