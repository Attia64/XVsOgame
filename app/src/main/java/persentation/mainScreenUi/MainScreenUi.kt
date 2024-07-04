package persentation.mainScreenUi


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.attia.xvso.ui.theme.BorderBg
import com.attia.xvso.ui.theme.BoxBg
import com.attia.xvso.ui.theme.MainBg
import com.attia.xvso.ui.theme.RoundCircle
import com.attia.xvso.ui.theme.StateShape
import persentation.viewModels.MainScreenViewModel
import persentation.viewModels.UserActions
import java.util.Locale


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel
) {


    val gameStates = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBg)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            PlayersDataSection(
                rounds = gameStates.xWinRounds,
                player = "X",
                content = {
                    X(
                        10f
                    )
                },
                modifier = Modifier
                    .fillMaxSize(0.3f)
                    .weight(1f)
            )

            CenterShape(
                rounds = gameStates.roundsPlayed,
                drawTimes = gameStates.drawTimes,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
            )

            PlayersDataSection(
                rounds = gameStates.oWinRounds,
                player = "O",
                content = {
                    O(
                        15f
                    )
                },
                modifier = Modifier
                    .fillMaxSize(0.3f)
                    .weight(1f)
            )

        }

        GameBox(
            viewModel = viewModel,
            gameStates = gameStates
        )

        Box(
            modifier = Modifier
                .size(width = 150.dp, height = 45.dp)
                .graphicsLayer {
                    shadowElevation = 6.dp.toPx()
                    shape = RoundedCornerShape(15.dp)
                    clip = true

                }
                .background(color = StateShape, RoundedCornerShape(15.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = gameStates.hintText,
                    fontSize = 16.sp
                )
            }
        }

    }
}


@Composable
fun PlayersDataSection(
    rounds: Int,
    player: String,
    content: @Composable () -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .graphicsLayer {
                    shadowElevation = 4.dp.toPx()
                    shape = RoundedCornerShape(16.dp)
                    clip = true

                }
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Play: $player",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 35.dp)
                            .graphicsLayer {
                                shadowElevation = 8.dp.toPx()
                                shape = RoundedCornerShape(4.dp)
                                clip = true
                            }
                            .background(BoxBg),

                        ) {
                        content()
                    }
                }
            }

        }
        Box(
            modifier = Modifier
                .size(width = 100.dp, height = 30.dp)
                .border(1.dp, color = BorderBg, RoundedCornerShape(16.dp))
                .graphicsLayer {
                    shadowElevation = 4.dp.toPx()
                    shape = RoundedCornerShape(16.dp)
                    clip = true
                }
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Won Rounds: $rounds",
                    fontSize = 11.sp,
                    textAlign = TextAlign.Center,
                    color = BorderBg,
                    fontWeight = FontWeight.Bold
                )
            }
        }


    }

}

@Composable
fun CenterShape(
    rounds: Int,
    drawTimes: Int,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        Box(
            modifier = Modifier.size(80.dp)
                .graphicsLayer {
                    shadowElevation = 6.dp.toPx()
                    shape = CircleShape
                    clip = true
                }
                .background(color = RoundCircle),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$rounds\n" + if(rounds > 1) "Rounds" else "Round",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = buildAnnotatedString {
                    append("Draw: ")
                    withStyle(
                        style = SpanStyle(
                            color = BoxBg,
                            fontSize = 10.sp,
                        )
                    ) {
                        append("$drawTimes times")
                    }
                },
                color = Color.Black,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 1

            )
        }
    }

}


@Composable
fun GameBox(
    viewModel: MainScreenViewModel,
    gameStates: GameStates
) {

    var animeGrid by remember {
        mutableStateOf(false)
    }

    if (viewModel.isBoardFull() || gameStates.hasWon) {
        var winner = "Draw"
        if (gameStates.hasWon) {
            winner = if (gameStates.currentTurn == BoardCellValue.O) {
                "X Won"
            } else {
                "O Won"
            }
        }
            StatusDialog(
                title = winner,
                onConfirm = {
                    viewModel.onAction(
                        UserActions.PlayAgainButtonClicked
                    )
                },
                showDialog = true )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = RoundedCornerShape(20.dp)
                clip = true

            }
            .background(BoxBg)
            .border(4.dp, Color.White, RoundedCornerShape(20.dp))

    ) {
        LaunchedEffect(key1 = true) {
            animeGrid = true
        }
        AnimatedVisibility(
            visible = animeGrid,
            enter = expandHorizontally(
                tween(
                    1000
                )
            )
        ) {
            BoardGrid()
        }
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            columns = GridCells.Fixed(3),
            userScrollEnabled = false
        ) {
            viewModel.boardItem.forEach { (cellNo, boardCellValue) ->
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .padding(15.dp)
                            .clickable(
                                enabled = !gameStates.hasWon,
                                interactionSource = MutableInteractionSource(),
                                indication = null
                            ) {
                                viewModel.onAction(
                                    UserActions.BoardClicked(cellNo)
                                )

                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AnimatedVisibility(
                            visible = viewModel.boardItem[cellNo] != BoardCellValue.NONE,
                            enter = fadeIn(
                                tween(
                                    durationMillis = 500
                                )
                            )
                        ) {
                            if (boardCellValue == BoardCellValue.O) {
                                O(
                                    30f
                                )
                            } else if (boardCellValue == BoardCellValue.X) {
                                X(
                                    30f
                                )
                            }
                        }

                    }
                }
            }

        }
        AnimatedVisibility(
            visible = gameStates.hasWon,
            enter = fadeIn(
                tween(
                    1000
                )
            )
        ) {
            DrawVictoryBg(gameStates = gameStates)
        }
    }
}

@Composable
fun DrawVictoryBg(
    gameStates: GameStates
) {
    val lang = Locale.getDefault().language

    when (gameStates.victoryType) {
        VictoryType.HORIZONTAL1 -> WinHorizontalLine1()

        VictoryType.HORIZONTAL2 -> WinHorizontalLine2()

        VictoryType.HORIZONTAL3 -> WinHorizontalLine3()

        VictoryType.VERTICAL1 -> if (lang == "ar") {
            WinVerticalLine3()
        } else {
            WinDiagonalLine1()
        }

        VictoryType.VERTICAL2 -> WinVerticalLine2()

        VictoryType.VERTICAL3 -> if (lang == "ar") {
            WinVerticalLine1()
        } else {
            WinVerticalLine3()
        }

        VictoryType.DIAGONAL1 -> if (lang == "ar") {
            WinDiagonalLine2()
        } else {
            WinDiagonalLine1()
        }

        VictoryType.DIAGONAL2 -> if (lang == "ar") {
            WinDiagonalLine1()
        } else {
            WinDiagonalLine2()
        }

        VictoryType.NONE -> {}
    }
}


@Preview
@Composable
fun Preview() {

    MainScreen(
        viewModel = MainScreenViewModel()
    )


}