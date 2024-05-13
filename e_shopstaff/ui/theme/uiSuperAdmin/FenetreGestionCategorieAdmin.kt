package com.example.e_shopstaff.ui.theme.uiSuperAdmin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_shopstaff.AppViewModelProvider

import com.example.e_shopstaff.R
import com.example.e_shopstaff.dao.categorieDao
import com.example.e_shopstaff.data.categorie
import com.example.e_shopstaff.data.categories
import com.example.e_shopstaff.models.modelSuperAdmin.GestionCategorieViewModel
import com.example.e_shopstaff.models.modelSuperAdmin.GestionCategorieUiState
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun fenetreGestionArticleAdmin(
    modifier: Modifier = Modifier,
    viewModel: GestionCategorieViewModel = viewModel(factory = AppViewModelProvider.Factory)

){
    val gestionCategorieUiState by viewModel.gestionCategorieUiState.collectAsState()


    Scaffold(
        topBar = {
                topAppBar()
        },

        ){innerPadding ->
        corp(contentPadding = innerPadding, categories = gestionCategorieUiState.categories, )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier = Modifier){

    TopAppBar(
        title = { "Categories des Articles" },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun corp(
    categories: List<categorie>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {

    val layoutDirection = LocalLayoutDirection.current
    Column(
        modifier = modifier.padding(
            start = contentPadding.calculateStartPadding(layoutDirection),
            end = contentPadding.calculateEndPadding(layoutDirection),
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    bottom = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Nom de la Categorie")
            Text("Identifiant")
        }
        Divider()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
        ) {
            if (categories.isEmpty()) {
                Text(
                    text = "La liste des categorie est Vide",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(contentPadding),
                )
            } else {

            }
        }

    }
}