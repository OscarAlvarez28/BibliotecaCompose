
package com.sena.bibliotecacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sena.bibliotecacompose.navigation.AppNavigation
import com.sena.bibliotecacompose.ui.theme.BibliotecaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BibliotecaComposeTheme {
                AppNavigation()
            }
        }
    }
}
