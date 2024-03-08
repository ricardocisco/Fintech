package br.com.fiap.fintechbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.navArgument
import br.com.fiap.fintechbank.screens.ConfigScreen
import br.com.fiap.fintechbank.screens.HomeScreen
import br.com.fiap.fintechbank.screens.LoginScreen
import br.com.fiap.fintechbank.screens.ReceiptScreen
import br.com.fiap.fintechbank.screens.SpendScreen
import br.com.fiap.fintechbank.ui.theme.FintechBankTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FintechBankTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val valController = rememberAnimatedNavController()
                    AnimatedNavHost(navController = valController, startDestination = "login"){
                        composable(route = "login"){ LoginScreen(valController) }
                        composable(route = "home/{nome}/{saldo}",
                            arguments = listOf(navArgument("nome") { defaultValue = "" })
                        ){ HomeScreen(valController, it.arguments?.getString("nome")!!, it.arguments?.getString("saldo")!!) }
                        composable(
                            route = "config/{agencia}/{conta}/{nome}"
                        ){ ConfigScreen(valController, it.arguments?.getString("agencia")!!, it.arguments?.getString("conta")!!, it.arguments?.getString("nome")!!
                        )
                        }
                        composable(route = "receipt"){ ReceiptScreen(valController) }
                        composable(route = "spend"){ SpendScreen(valController) }
                    }
                }
            }
        }
    }
}
