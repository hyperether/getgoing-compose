package presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Logo(size: Dp = 48.dp) {
    Icon(
        modifier = Modifier.size(size),
        imageVector = Icons.Default.Star,
        contentDescription = "Logo icon",
        tint = Color.Unspecified,
    )
}

@Composable
fun Profile(click: () -> Unit = {}) {
    Icon(
        imageVector = Icons.Default.Star,
        contentDescription = "Profile icon",
        tint = MaterialTheme.colors.primary,
        modifier = Modifier.size(32.dp).clickable { click() },
    )
}