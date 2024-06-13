package presentation.scenes.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDataItem(
    text: String,
    onClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    onClick = {
                        onClick()
                    }
                )
        ) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.background)
                    .padding(20.dp)
                    .size(50.dp),
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileTotalItem(
    text: String
) {
    Column(
        modifier = Modifier.size(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "",
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}