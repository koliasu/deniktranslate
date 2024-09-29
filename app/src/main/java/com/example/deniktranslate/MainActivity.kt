package com.example.deniktranslate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deniktranslate.ui.theme.DeniktranslateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeniktranslateTheme {
                MainScreen()  // вызов основной функции интерфейса
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Отображение версии приложения
            Text(
                text = "Версия: 1.0", // Измените на актуальную версию
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp) // небольшой отступ внизу
            )

            // Поля ввода для режима и темы
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Режим") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp) // небольшой отступ вниз
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Тема") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp) // отступ вниз
            )

            // Основное окно для отображения текста или перевода с белой каймой
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(4.dp) // отступ вокруг белой каймы
                    .background(Color.White, shape = RoundedCornerShape(8.dp)) // белая кайма с закругленными углами
                    .padding(16.dp) // внутренний отступ
            ) {
                Text(
                    text = "Здесь будет отображаться текст или перевод",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Информация о сопряженном устройстве
            Text(
                text = "Подключенное устройство: Не подключено", // Замените на актуальную информацию о подключенном устройстве
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp) // отступ сверху
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
