package persentation.mainScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.attia.xvso.ui.theme.MainBg


@Composable
fun StatusDialog(
    title: String,
    onConfirm: () -> Unit
) {

    AlertDialog(
        onDismissRequest = {  },
        confirmButton = {
                        TextButton(onClick = {
                            onConfirm()
                        }) {
                            Text( text = "Play Again")
                        }
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = "Do You Want To Play Again?",
                fontWeight = FontWeight.Bold)
        },
        containerColor = MainBg,
    )

}

@Preview
@Composable
fun StatusDialogShower() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)) {
        StatusDialog(
            title = "Draw",
            onConfirm = {}
        )
    }
}





