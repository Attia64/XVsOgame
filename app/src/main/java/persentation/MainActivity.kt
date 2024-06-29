package persentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import persentation.mainScreen.MainScreen
import com.attia.xvso.ui.theme.XVsOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XVsOTheme {
                MainScreen(1, 1)
            }
        }
    }
}
