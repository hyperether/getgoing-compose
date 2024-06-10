package com.hyperether.getgoing_cmp

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kmp.di.Factory
import kmp.repository.GgRepositoryImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = GgRepositoryImpl(Factory(this.application).getRoomDatabase())
        setContent {
            App(repository)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

}