package dev.phyo.todoapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TaskListScreen(modifier: Modifier = Modifier, viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    Scaffold { innerPadding ->
        Column(modifier = modifier.fillMaxSize()
            .padding(innerPadding)) {
            LazyColumn {
                items(tasks) { task ->
                    Row(modifier = modifier.fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)) {
                        Text(task.title)
                        IconButton(
                            onClick = { viewModel.deleteTask(task) }
                        ) {
                            Icon(Icons.Default.Delete, contentDescription = "delete")
                        }
                    }
                }
            }
            Button(onClick = { viewModel.addTask("New Task") }) {
                Text("Add Task")
            }
        }
    }
}