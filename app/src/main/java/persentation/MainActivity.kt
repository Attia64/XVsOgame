package persentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import persentation.mainScreenUi.MainScreen
import com.attia.xvso.ui.theme.XVsOTheme
import persentation.viewModels.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XVsOTheme {
                val viewModel = viewModel<MainScreenViewModel>()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
