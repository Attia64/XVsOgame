package persentation.mainScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.attia.xvso.R
import com.attia.xvso.ui.theme.MainBg
import kotlinx.coroutines.delay


@Composable
fun StatusDialog(
    title: String,
    onConfirm: () -> Unit,
    showDialog: Boolean
) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = showDialog) {
        if (showDialog) {
            delay(1000)
            isVisible = true
        }
    }

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onConfirm()
                    }) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Play Again",
                        textAlign = TextAlign.Right
                    )
                }
            },
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    textAlign = TextAlign.Left
                )
            },
            text = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Do You Want To Play Again",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            },
            containerColor = MainBg,
        )
    }

}

@Preview
@Composable
fun StatusDialogShower() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)
    ) {
        StatusDialog(
            title = "Draw",
            onConfirm = {},
            true
        )
    }
}





