package com.example.basicscodelab.learn

import com.example.basicscodelab.R

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.data.Message
import com.example.basicscodelab.data.SampleData
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class BaseDemo1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }


    @Composable
    fun MessageCard(msg: Message) {
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
            shape = MaterialTheme.shapes.medium, // 使用 MaterialTheme 自带的形状
            // elevation = 5.dp,
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Row(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.jetpack_compose_logo),
                    contentDescription = "jetpack compose logo picture", //这个描述用于无障碍
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(
                            1.5.dp,
                            color = MaterialTheme.colorScheme.primary, CircleShape
                        )
                )
                Spacer(Modifier.padding(horizontal = 8.dp))
                Column(
                    modifier = Modifier.clickable{ isExpanded = !isExpanded }
                ) {
                    Text(
                        text = msg.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall // 添加 style
                    )
                    Spacer(Modifier.padding(vertical = 4.dp))
                    Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                        Text(
                            text = msg.body,
                            modifier = Modifier.padding(all = 4.dp),
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            style = MaterialTheme.typography.bodyMedium // 添加 style
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        BasicsCodelabTheme {
            Conversation(SampleData.conversationSample)
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark mode"
    )
    @Composable
    fun GreetingPreview() {
        BasicsCodelabTheme {
            // A surface container using the 'background' color from the theme
            Surface {
                MessageCard(
                    msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
                )
            }
        }
    }
}
