package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                     ArtSpace()
                }
            }
        }
    }
}


@Composable
fun ArtSpace() {
    var state by remember{
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when(state){
            1 -> ImageWithText(imageID = R.drawable.lemon_drink, title = R.string.title, desc = R.string.desc)
            2 -> ImageWithText(imageID = R.drawable.lemon_restart, title = R.string.title, desc = R.string.desc)
            3 -> ImageWithText(imageID = R.drawable.lemon_squeeze, title = R.string.title, desc = R.string.desc)
            else -> ImageWithText(imageID = R.drawable.lemon_tree, title = R.string.title, desc = R.string.desc)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { state-- },
                modifier = Modifier.weight(1f)
            ) {
                Text("prev")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { state++ },
                modifier = Modifier.weight(1f)
            ) {
                Text("next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        //ArtSpace()
        ArtSpace()
    }
}

@Composable
fun ImageWithText(imageID: Int, title:Int, desc:Int){
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imageID),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .border(5.dp, Color.Gray)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = desc),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}