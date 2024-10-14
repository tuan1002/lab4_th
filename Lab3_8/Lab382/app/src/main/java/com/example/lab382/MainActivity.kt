package com.example.lab382

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
import androidx.compose.foundation.lazy.items
import com.example.lab382.ui.theme.MyAppTheme
import androidx.compose.foundation.lazy.LazyColumn


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                title = { Text("Todo List") }
            )
        }
    ) {paddingValues -> // Sửa đổi: nhận padding từ Scaffold
        MainContent(paddingValues)
    }
}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    // Biến trạng thái để lưu danh sách các công việc
    var taskText by remember { mutableStateOf("") }
    var taskList by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // TextField để nhập công việc
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            label = { Text("Enter a task") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nút Add để thêm công việc
        Button(
            onClick = {
                if (taskText.isNotEmpty()) {
                    taskList = taskList + taskText // Thêm công việc vào danh sách
                    taskText = "" // Xóa nội dung trong TextField sau khi thêm
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Hiển thị danh sách công việc bằng LazyColumn
        LazyColumn {
            items(taskList) { task ->
                TaskItem(task = task) {
                    taskList = taskList - task // Xóa công việc khi nhấn nút Delete
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: String, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = task, style = MaterialTheme.typography.body1)
        Button(
            onClick = onDelete,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
        ) {
            Text("Delete", color = MaterialTheme.colors.onError)
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
