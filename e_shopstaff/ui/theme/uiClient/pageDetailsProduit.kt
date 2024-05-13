package com.example.e_shopstaff.ui.theme.uiClient

/*import androidx.compose.foundation.layout.ColumnScopeInstance.weight*/
/*import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight*/

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_shopstaff.R
import com.example.e_shopstaff.data.photo
import com.example.e_shopstaff.data.photos
import com.example.e_shopstaff.data.produit
import com.example.e_shopstaff.ui.theme.DancingScript
import com.example.e_shopstaff.ui.theme.MontserratBold
import com.example.e_shopstaff.ui.theme.SatisfyRegular
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun corpDétail(Produit : produit,
               modifier: Modifier = Modifier, ){

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                e_shopTopAppBar2()
            }
        },

        /*bottomBar = {

        },*/
        content = { innerPadding ->
            AfficherPhotoProduit( innerPadding = innerPadding, Produit = Produit)
            Spacer(modifier = Modifier.height(5.dp))
            Détails(Produit = Produit)

        },)
}


@Composable
fun AfficherPhotoProduit(
    Produit : produit,
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
){

    LazyRow(modifier = Modifier
        .padding(innerPadding)
        .padding(top = 5.dp)){
        items(photos.filter { it.codePro == Produit.codePro }) {

            PhotoItem(
                photo = it,
                modifier = Modifier
            )
        }
    }

    Spacer(modifier = Modifier.height(5.dp))
    Détails(Produit, modifier)
}


@Composable
fun PhotoItem(
    photo: photo,
    modifier: Modifier = Modifier,
    ) {

    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .padding(5.dp),

    ) {
        Image(
            painter = painterResource(id = photo.lienPhoto),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_détails))
                .fillMaxWidth(),

        )
    }
}

@Composable
fun topBarDétails(modifier: Modifier = Modifier){

    Row(){
        IconButton(onClick = { }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = stringResource(id = R.string.détails),
            modifier = modifier,
            textAlign = TextAlign.Center,
            fontFamily = DancingScript,
            fontSize = 24.sp
        )
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun e_shopTopAppBar2(modifier: Modifier = Modifier, ) {

    var TexteRecherche by remember { mutableStateOf("") }



    CenterAlignedTopAppBar(
        title = {


            Row() {
                IconButton(onClick = { }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
                }
                /*Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    contentDescription = null,
                    painter = painterResource(R.drawable.logo)
                )*/
                Text(
                    text = stringResource(id = R.string.détails),
                    /*style = MaterialTheme.typography.displayLarge,*/
                    fontSize = 25.sp,
                    fontFamily = MontserratBold
                )

            }
        },


        modifier = modifier
    )
}

@Composable
fun Détails(Produit: produit, modifier: Modifier = Modifier,){

    val nom = Produit.nomPro
    val prix = Produit.prix


    Row {
        Text(
            text = "Nom : $nom",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 10.sp,
            fontFamily = SatisfyRegular
        )

        Text(
            text = "Prix : $prix",
            style = MaterialTheme.typography.titleMedium,
            /*fontSize = 25.sp,*/
            fontFamily = SatisfyRegular
        )
    }
}











//Fenetre (methode principale)
@Composable
fun ProductDetailScreen(produit: produit) {
    Column(modifier = Modifier) {

        E_shopTopAppBar()
        Spacer(modifier = Modifier.width(16.dp))
        CorpsFenetreDetails(produit)

    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun E_shopTopAppBar(modifier: Modifier = Modifier) {
    var TexteRecherche by remember { mutableStateOf("") }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Détails du Produit",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Retour",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Panier",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        modifier = modifier
    )
}

/*@Composable
fun E_shopBottomAppBar() {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        IconButton(
            onClick = { /* Action de la page d'accueil */ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Accueil",
                tint = Color.White
            )
        }

        // Icône du menu ajoutée ici
        IconButton(
            onClick = { /* Action du menu */ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "Menu",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { /* Action des messages */ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Messages",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { /* Action du panier d'achat */ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Panier",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { /* Action du compte */ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Compte",
                tint = Color.White
            )
        }
    }
}*/

//Affiche les images du produit
@Composable
fun AfficheImageProduit(imageIds: List<Int>) {
    Spacer(modifier = Modifier.width(56.dp))
    var currentImageIndex by remember { mutableStateOf(0) }

    LaunchedEffect(currentImageIndex) {
        while (true) {
            delay(5000)
            currentImageIndex = (currentImageIndex + 1) % imageIds.size
        }
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState()
    ) {
        items(imageIds) { imageId ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(350.dp)
                    .height(350.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        // Handle image click if needed
                    }
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}



//Affiche les informations sur le produit
@Composable
fun AfficheDetails(produit: produit) {
    var taille by remember { mutableStateOf("") }
    var couleur by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Nom: ${produit.nomPro}", fontWeight = FontWeight.Bold)
                Text(text = "Prix: ${produit.prix}")
                Text(text = "Quantité disponible: ${produit.qte}")
                Text(text = "Taille Max: ${produit.size1}")
                Text(text = "Taille Min: ${produit.size2}")


            }
            IconButton(onClick = {  }) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Ajouter aux favoris")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ajouter au panier")
        }
    }
}

//Corps de la fenetre
@Composable
fun CorpsFenetreDetails(produit: produit) {
    Spacer(modifier = Modifier.width(66.dp))
    Column {
        /*AfficheImageProduit(produit.imageIds)*/

        Spacer(modifier = Modifier.width(16.dp))
        AfficheDetails(produit)
        // Ajoutez ici d'autres composants si nécessaire
    }
}