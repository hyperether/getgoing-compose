package presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoldMediumText(text: String, color: Color = MaterialTheme.colors.onBackground) {
    Text(
        text = text,
        style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp)
    )
}

@Composable
fun MediumText(text: String, color: Color = MaterialTheme.colors.onBackground) {
    Text(
        text = text,
        style = TextStyle.Default.copy(fontSize = 20.sp)
    )
}

@Composable
fun RegularText(text: String, color: Color = MaterialTheme.colors.onBackground) {
    Text(
        text = text,
        style = TextStyle.Default.copy(fontSize = 16.sp)
    )
}

@Composable
fun SmallText(text: String, color: Color = MaterialTheme.colors.onBackground) {
    Text(
        text = text,
        style = TextStyle.Default.copy(fontSize = 12.sp)
    )
}

@Composable
fun LargeText(text: String, color: Color = MaterialTheme.colors.secondary) {
    Text(
        text = text,
        style = TextStyle.Default.copy(fontSize = 20.sp)
    )
}

@Composable
fun HeadlineText(
    text: String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        text = text,
        style = MaterialTheme.typography.h2,
    )
}