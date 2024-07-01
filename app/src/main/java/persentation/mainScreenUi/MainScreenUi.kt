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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel
) {
    val gameStates = viewModel.state
    val gridState = remember {
        mutableStateListOf<Boolean>().apply {
            repeat(9) {
                add(false)
            }
        }
    }
    var animeGride by remember {
        mutableStateOf(false)
    }

    if(viewModel.isBoardFull()) {
        StatusDialog(
            title = "Draw",
            onConfirm = {
                viewModel.onAction(
                    UserActions.PlayAgainButtonClicked
                )
                gridState.apply {
                    repeat(9) {
                        add(false)
                    }
                }
            })
    }

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
            Column(
                modifier =
                Modifier
                    .fillMaxSize(0.3f)
                    .weight(0.3f),
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Card(
                    modifier = Modifier
                        .size(width = 110.dp, height = 110.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Play: X",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(width = 40.dp, height = 35.dp),

                                shape = RoundedCornerShape(6.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = BoxBg
                                ), elevation = CardDefaults.cardElevation(
                                    defaultElevation = 2.dp
                                )
                            ) {
                                X(
                                    10f
                                )
                            }
                        }
                    }

                }
                Card(
                    modifier = Modifier
                        .size(width = 95.dp, height = 25.dp)
                        .border(1.dp, color = BorderBg, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp,
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Won Rounds: ${gameStates.xWinRounds}",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            color = BorderBg,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


            }
            Column(
                modifier = Modifier
                    .fillMaxSize(0.3f)
                    .weight(0.3f)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .graphicsLayer {
                            shadowElevation = 6.dp.toPx()
                            shape = CircleShape
                            clip = true
                        }
                        .background(color = RoundCircle),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${gameStates.roundsPlayed} \n" +
                                "Round",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
                Box(modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Draw: ${gameStates.drawTimes} Times",
                        color = BoxBg,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
            }

            Column(
                modifier =
                Modifier
                    .fillMaxSize(0.3f)
                    .weight(0.3f),
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                ElevatedCard(
                    modifier = Modifier
                        .size(width = 110.dp, height = 110.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Play: O",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(width = 40.dp, height = 35.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = BoxBg
                                ), elevation = CardDefaults.cardElevation(
                                    defaultElevation = 2.dp
                                )
                            ) {
                                O(
                                    10f
                                )
                            }
                        }
                    }

                }
                Card(
                    modifier = Modifier
                        .size(width = 95.dp, height = 25.dp)
                        .border(1.dp, color = BorderBg, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp,
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Won Rounds: ${gameStates.oWinRounds}",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            color = BorderBg,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


            }

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
                animeGride = true
            }
            this@Column.AnimatedVisibility(
                visible = animeGride,
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
                                .padding(20.dp)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onAction(
                                        UserActions.BoardClicked(cellNo)
                                    )
                                    gridState[cellNo - 1] = !gridState[cellNo - 1]
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
                                if (gridState[cellNo - 1]) {
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

            }
        }

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


@Preview
@Composable
fun Preview() {

    MainScreen(
        viewModel = MainScreenViewModel()
    )

}