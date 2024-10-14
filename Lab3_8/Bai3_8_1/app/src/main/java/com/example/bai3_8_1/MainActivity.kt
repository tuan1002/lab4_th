package com.example.bai3_8_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bai3_8_1.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sử dụng Jetpack Compose để xây dựng UI
        setContent {
            MyAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // Giao diện Material Design với Scaffold
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Jetpack Compose Demo") }
            )
        }
    ) { paddingValues -> // Thêm paddingValues vào đây
        // Nội dung chính của giao diện, truyền paddingValues cho MainContent
        MainContent(Modifier.padding(paddingValues))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    // Biến trạng thái để theo dõi số lần nhấn nút
    var count by remember { mutableStateOf(0) }
    // Giao diện chính với Column
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bạn đã nhấn vào nút $count lần",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(16.dp)) // Khoảng cách giữa các thành phần
        // Nút nhấn sử dụng Button của Material Design
        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(backgroundColor =
            MaterialTheme.colors.primary)
        ) {
            Text("Click Me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        MyApp()
    }
}

