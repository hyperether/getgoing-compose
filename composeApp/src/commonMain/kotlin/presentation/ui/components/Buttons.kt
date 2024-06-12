package presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LinkWithIcon(text: String, icon: ImageVector? = null, click: () -> Unit = {}) {
    Row(
        Modifier.clickable { click() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyle.Default.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary
            )
        )
        Icon(
            imageVector = icon ?: Icons.Filled.KeyboardArrowRight,
            contentDescription = "Button icon",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun PrimaryButton(text: String, click: () -> Unit) {
    Button(
        onClick = { click() },
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colors.onPrimary,
            backgroundColor = MaterialTheme.colors.primary
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun PlayButton(isRunning: Boolean = false, click: () -> Unit) {
    IconButton(
        onClick = { click() },
        Modifier
            .size(100.dp)
            .padding(1.dp)
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = if (isRunning) Icons.Default.Star else Icons.Default.Clear,
            contentDescription = "Play button",
            tint = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun BackButton(onNavigateBack: () -> Unit) {
    IconButton(
        modifier = Modifier
            .size(60.dp)
            .padding(bottom = 1.dp),
        onClick = { onNavigateBack() }) {
        Icon(
            modifier = Modifier.size(30.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun ConfirmButton(onClick: () -> Unit) {
    TextButton(
        onClick = {
            onClick()
        }
    ) {
        Text("Confirm")
    }
}

@Composable
fun DismissButton(onClick: () -> Unit) {
    TextButton(
        onClick = {
            onClick()
        }
    ) {
        Text("Cancel")
    }
}

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}
