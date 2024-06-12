package presentation.scenes.getgoing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.navigation.Screen
import presentation.ui.components.BoldMediumText
import presentation.ui.components.EndlessListExercise
import presentation.ui.components.LastExercise
import presentation.ui.components.LinkWithIcon
import presentation.ui.components.Logo
import presentation.ui.components.MediumText
import presentation.ui.components.PrimaryButton
import presentation.ui.components.Profile
import presentation.ui.components.ShapedColumn
import util.ExerciseType

@Composable
fun GetGoingScreen(
    viewModel: GetGoingViewModel,
    start: (Int) -> Unit = {},
    navigateTo: (String) -> Unit = {}
) {
    LaunchedEffect(true) {
        viewModel.getLastRoute()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ShapedColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Logo()
                    Profile(click = {
                        val userId = 1
                        navigateTo("${Screen.ProfileScreen.route}/${userId}")
                    })
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 24.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BoldMediumText(text = "Last exercise")
                        LinkWithIcon("View all", Icons.Default.KeyboardArrowRight)
                    }

                    LastExercise(
                        viewModel.lastRouteSelectedExercise.value,
                        viewModel.lastRouteDistance.value,
                        viewModel.lastRouteProgress.floatValue,
                        viewModel.lastRouteKcal.value,
                        viewModel.lastRouteDuration.value,
                        viewModel.lastRouteTimeProgress.floatValue
                    )
                }

                Column(modifier = Modifier.padding(bottom = 24.dp)) {
                    BoldMediumText(text = "Choose your exercise")
                    LinkWithIcon(text = "Can we burn our legs?")
                }


                EndlessListExercise(
                    list = ExerciseType.entries
                ) {
                    viewModel.selectExercise(it)
                }
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MediumText(text = viewModel.exerciseState.value)

            PrimaryButton("Get ready") {
                if (true) {
                    start(viewModel.getSelectedExerciseId())
                } else {

                }
            }
        }
    }
}
