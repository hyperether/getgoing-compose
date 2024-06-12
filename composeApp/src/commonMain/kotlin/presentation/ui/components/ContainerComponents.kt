package presentation.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.repository.room.Route
import util.ExerciseType


@Composable
fun AppToolbar(
    title: String,
    onNavigateBack: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton {
            onNavigateBack()
        }

        Text(
            text = title,
            style = MaterialTheme.typography.h2,
        )
    }
}

@Composable
fun AppToolbarDynamic(
    title: String,
    onNavigateBack: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton {
            onNavigateBack()
        }

        Text(
            text = title,
            style = MaterialTheme.typography.h2,
        )
    }
}

@Composable
fun LastExercise(
    exercise: ExerciseType,
    distance: String,
    exerciseProgress: Float,
    kcal: String,
    duration: String,
    timeProgress: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.7f)
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProgressWithIconAndText(
                exercise,
                distance,
                exerciseProgress
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "kcal",
                    fontSize = 14.sp,
                    style = TextStyle.Default.copy(
                        fontSynthesis = FontSynthesis.None,
                        color = MaterialTheme.colors.onPrimary
                    )
                )
                Text(
                    text = kcal,
                    fontSize = 16.sp,
                    style = TextStyle.Default.copy(
                        fontSynthesis = FontSynthesis.None,
                        color = MaterialTheme.colors.onPrimary
                    )
                )
            }

            ProgressWithIconAndText(
                null,
                duration,
                timeProgress
            )
        }
    }
}

@Composable
fun ProgressWithIconAndText(
    type: ExerciseType? = null,
    textValue: String,
    progress: Float
) {
    Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = 1f,
            modifier = Modifier.size(100.dp),
            color = MaterialTheme.colors.surface
        )
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(100.dp),
            color = MaterialTheme.colors.onPrimary
        )
        Column(
            modifier = Modifier.size(100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (type) {
                ExerciseType.RUNNING -> {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Activity icon",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }

                ExerciseType.WALKING -> {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Activity icon",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }

                ExerciseType.CYCLING -> {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Activity icon",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }

                null -> {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Activity icon",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }

            Text(
                text = textValue,
                fontSize = 16.sp,
                style = TextStyle.Default.copy(
                    fontSynthesis = FontSynthesis.None,
                    color = MaterialTheme.colors.onPrimary
                ),
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = type?.value ?: "Time",
                fontSize = 14.sp,
                style = TextStyle.Default.copy(
                    fontSynthesis = FontSynthesis.None,
                    color = MaterialTheme.colors.onPrimary
                )
            )
        }
    }
}

@Composable
fun CirceButtonContainer() {
    Box(contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .size(115.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colors.surface)
        )

        Box(
            Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colors.surface)
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndlessListExercise(list: List<ExerciseType>, selected: (ExerciseType) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val pagerState = rememberPagerState(pageCount = { 50 })
        var scrolled by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(key1 = true) {
            pagerState.scrollToPage(24)
            scrolled = true
        }

        CirceButtonContainer()

        HorizontalPager(
            modifier = Modifier.height(70.dp),
            pageSpacing = 15.dp,
            contentPadding = PaddingValues(horizontal = 120.dp),
            state = pagerState
        ) { index ->

            list.getOrNull(
                index % (list.size)
            )?.let { item ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (scrolled) {
                        var size = 50.dp
                        var color = MaterialTheme.colors.secondary
                        if (index == pagerState.settledPage) {
                            size = 60.dp
                            color = MaterialTheme.colors.primary
                            selected(list[pagerState.settledPage % (list.size)])
                        }
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Exercise item",
                            modifier = Modifier.size(size),
                            tint = color
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun ShapedColumn(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    color: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .drawBehind {
                val path = generateGGPath(size)
                drawPath(path = path, color = color, style = Fill)
            },
        verticalArrangement = verticalArrangement
    ) {
        content()
    }
}

@Composable
fun GoalProgress(
    bgColor: Color = MaterialTheme.colors.secondary,
    color: Color = MaterialTheme.colors.primary,
    canvasSize: Dp = 240.dp,
    progress: Float = 0f
) {
    var expanded by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        expanded = true
    }
    val p by animateFloatAsState(
        targetValue = if (expanded) progress else 0f,
        animationSpec = tween(
            durationMillis = 1000 // Set the duration to 3 seconds for a slow expansion
        )
    )

    Canvas(
        modifier = Modifier
            .size(240.dp, 200.dp)
    ) {
        val strokeWidthPx = 12.dp.toPx()
        val arcSize = Size(240.dp.toPx(), 240.dp.toPx()).width - strokeWidthPx

        drawArc(
            color = bgColor,
            30f,
            -240f,
            useCenter = false,
            size = Size(arcSize, arcSize),
            style = Stroke(strokeWidthPx, cap = StrokeCap.Round),
            topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
        )

        var angle = p * 250f
        if (angle > 250f) {
            angle = 250f
        }
        drawArc(
            color = color,
            -210f,
            angle,
            useCenter = false,
            size = Size(arcSize, arcSize),
            style = Stroke(strokeWidthPx, cap = StrokeCap.Round),
            topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
        )
    }
}

@Composable
fun GraphView(
    mergedRoutes: List<Route>,
    goal: Float,
    animated: Boolean = true,
    selected: (Long) -> Unit
) {
    if (mergedRoutes.isNotEmpty())
        Column(Modifier.padding(top = 24.dp)) {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "Goal")
                Text(
                    text = "___________________________________________________________________________________",
                    style = TextStyle(color = MaterialTheme.colors.primary),
                    maxLines = 1,
                    modifier = Modifier
                        .weight(1f)
                        .offset(y = 2.dp)
                )
                Text(text = "5.00km")
            }

            var selectedId by remember {
                mutableLongStateOf(mergedRoutes.last().id)
            }
            val scrollState = rememberLazyListState(mergedRoutes.size - 1)

            LazyRow(
                Modifier
                    .height(160.dp)
                    .padding(start = 30.dp, end = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                state = scrollState
            ) {
                items(mergedRoutes) {
                    var expanded by remember { mutableStateOf(false) }
                    var x = 130.dp * (it.length.toFloat() / goal)
                    if (x > 130.dp) {
                        x = 130.dp
                    }

                    LaunchedEffect(Unit) {
                        expanded = true
                    }

                    val height by animateDpAsState(
                        targetValue = if (expanded) x else 0.dp,
                        animationSpec = tween(
                            durationMillis = 1000 // Set the duration to 3 seconds for a slow expansion
                        )
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.noRippleClickable {
                            selectedId = it.id
                            selected(it.id)
                        }) {
                        Box(
                            modifier = Modifier
                                .height(130.dp)
                                .width(12.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(if (animated) height else x)
                                    .width(12.dp)
                                    .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                                    .background(
                                        if (it.id == selectedId) {
                                            MaterialTheme.colors.primary
                                        } else {
                                            MaterialTheme.colors.primary.copy(
                                                alpha = 0.2f
                                            )
                                        }
                                    )
                            )
                        }

                        Text(text = it.date.slice(0..5))
                    }
                }
            }
        }
}
