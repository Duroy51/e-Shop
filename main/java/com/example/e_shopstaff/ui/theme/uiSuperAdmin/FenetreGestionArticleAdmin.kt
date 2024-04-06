package com.example.e_shopstaff.ui.theme.uiSuperAdmin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.e_shopstaff.R


@Composable
fun fenetreGestionArticleAdmin(modifier: Modifier = Modifier,
                               onNextButtonClicked: (Int) -> Unit,

                               ){

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                topAppBar()


            }
        },

        ){it ->

    }

}


@Composable
fun topAppBar(modifier: Modifier = Modifier){

    Row(){
        Icon(
            Icons.Rounded.KeyboardArrowLeft,
            modifier = Modifier.size(28.dp),
            contentDescription = " "
        )

        Text(
            text = stringResource(R.string.ges_Article),
            modifier = modifier,
        )
    }
}

fun corp(){

}