package persentation.mainScreenUi

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.attia.xvso.ui.theme.xColor


@Composable
fun BoardGrid() {


    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 3, y = 0f),
            end = Offset(x = size.width * 1 / 3, y = size.height),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )

        drawLine(
            color = Color.White,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )

        drawLine(
            color = Color.White,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 3),
            end = Offset(x = size.width, y = size.height * 1 / 3),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )

        drawLine(
            color = Color.White,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )

    }
}

@Composable
fun X(
    stroke: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        drawLine(
            color = xColor,
            strokeWidth = stroke,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )

        drawLine(
            color = xColor,
            strokeWidth = stroke,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )

    }
}

@Composable
fun O(
    stroke: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        drawCircle(
            color = Color.White,
            style = Stroke(width = stroke)
        )
    }
}

@Composable
fun WinHorizontalLine1() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 6),
            end = Offset(x = size.width, y = size.height * 1 / 6)
        )
    }
}

@Composable
fun WinHorizontalLine2() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 3 / 6),
            end = Offset(x = size.width, y = size.height * 3 / 6)
        )
    }
}

@Composable
fun WinHorizontalLine3() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 5 / 6),
            end = Offset(x = size.width, y = size.height * 5 / 6)
        )
    }
}


@Composable
fun WinVerticalLine1() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 6, y = 0f),
            end = Offset(x = size.width * 1 / 6, y = size.height)
        )
    }
}

@Composable
fun WinVerticalLine2() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 15f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 3 / 6, y = 0f),
            end = Offset(x = size.width * 3 / 6, y = size.height)
        )
    }
}


@Composable
fun WinVerticalLine3() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 5 / 6, y = 0f),
            end = Offset(x = size.width * 5 / 6, y = size.height)
        )
    }
}


@Composable
fun WinDiagonalLine1() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
    }
}


@Composable
fun WinDiagonalLine2() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.White,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width, y = 0f),
            end = Offset(x = 0f, y = size.height),
        )
    }
}

@Preview
@Composable
fun Shower() {
//    O(
//        30f
//    )
//    X(
//        30f
//    )
    BoardGrid()
//    WinHorizontalLine1()
//    WinHorizontalLine2()
//    WinHorizontalLine3()
//    WinVerticalLine1()
 //   WinVerticalLine2()
    WinVerticalLine3()
//    WinDiagonalLine1()
//    WinDiagonalLine2()
}