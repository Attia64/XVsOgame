package persentation.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun MainScreen(
    roundsX: Int = 0,
    roundsY: Int = 0,
    currentRoundNum: Int = 1,
    turn: String = "X"
) {

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
                            text = "Play X",
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
                                X()
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
                            text = "Won Rounds: $roundsX",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            color = BorderBg,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


            }
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .graphicsLayer {
                        shadowElevation = 6.dp.toPx()
                        shape = CircleShape
                        clip = true
                    }
                    .background(color = RoundCircle)
                    .weight(0.17f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$currentRoundNum \n" +
                            "Round",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
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
                            text = "Play O",
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
                                O()
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
                            text = "Won Rounds: $roundsY",
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
            BoardGrid()
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
                    text = "$turn Turn",
                    fontSize = 16.sp)
            }
        }

    }
}


@Preview
@Composable
fun Preview() {

    MainScreen(1, 1)

}