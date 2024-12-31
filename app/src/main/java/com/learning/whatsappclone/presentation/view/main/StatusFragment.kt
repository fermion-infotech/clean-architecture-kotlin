package com.learning.whatsappclone.presentation.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class StatusFragment : Fragment() {

    var  listing = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireActivity()).apply {
            setContent {
                Body(){
                    Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @Composable
    fun Body(selectedItem: (String)-> (Unit)) {

        /*val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .border(2.dp, Color.Cyan)
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in 1..100) {
                Text(
                    text = "Body Count $i", fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp)
                )
                HorizontalDivider(thickness = 1.dp, color = Color.Blue)
            }
        }*/


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Cyan),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(100){
                Text(
                    text = "Body Count ${it+1}", fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp).clickable {
                        selectedItem(it.toString())
                    }
                )
                HorizontalDivider(thickness = 1.dp, color = Color.Blue)
                AsyncImage(
                    model = "https://uatdigitalonboarding.utkarsh.bank/check-blob-image-return/1",
                    contentDescription = ""
                )
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewUiBody() {
        Body{

        }
    }
}