package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BluetoothSearching
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().fillMaxHeight(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Greeting("Android", Modifier.padding(start = 20.dp))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.Red
    )
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row (
        modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 20.dp, bottom = 15.dp)
    ) {
        Icon(
            Icons.Default.BluetoothSearching,
            contentDescription = "Bluetooth Searching Icon",
            modifier = Modifier.height(80.dp).width(60.dp).padding(start = 10.dp, end = 10.dp),
            tint = Color.Blue
        )
        Image(
            painterResource(id = R.drawable.jetpack_compose_logo),
            contentDescription = "jetpack compose logo picture",  //这个描述用于无障碍
        )
        Column {
            Text(text = msg.author, modifier = Modifier
                .height(40.dp)
                .padding(start = 20.dp))
            Text(text = msg.body, modifier = Modifier
                .height(40.dp)
                .padding(start = 20.dp))
        }
    }
}

@Preview(showBackground = true, name = "Text preview")
@Composable
fun GreetingPreview() {
    BasicsCodelabTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize().fillMaxHeight(),
            color = MaterialTheme.colorScheme.primary
        ) {
            MessageCard(
                msg = Message("Jetpack Compose 博物馆", "我们开始更新啦")
            )
        }
    }
}