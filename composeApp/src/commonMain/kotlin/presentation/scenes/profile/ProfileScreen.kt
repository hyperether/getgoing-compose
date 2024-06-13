package presentation.scenes.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyperether.getgoing_kmp.android.presentation.scenes.profile.components.DialogType
import com.hyperether.getgoing_kmp.android.presentation.scenes.profile.components.EditAgeDialog
import com.hyperether.getgoing_kmp.android.presentation.scenes.profile.components.EditGenderDialog
import com.hyperether.getgoing_kmp.android.presentation.scenes.profile.components.EditHeightDialog
import com.hyperether.getgoing_kmp.android.presentation.scenes.profile.components.EditWeightDialog
import presentation.scenes.profile.components.ProfileDataItem
import presentation.scenes.profile.components.ProfileTotalItem
import presentation.scenes.profile.util.ProfileUtil.formatAge
import presentation.scenes.profile.util.ProfileUtil.formatGender
import presentation.scenes.profile.util.ProfileUtil.formatHeight
import presentation.scenes.profile.util.ProfileUtil.formatTotalKcal
import presentation.scenes.profile.util.ProfileUtil.formatTotalKm
import presentation.scenes.profile.util.ProfileUtil.formatWeight
import presentation.scenes.profile.util.ProfileUtil.getUserAge
import presentation.scenes.profile.util.ProfileUtil.getUserGender
import presentation.scenes.profile.util.ProfileUtil.getUserHeight
import presentation.scenes.profile.util.ProfileUtil.getUserWeight
import presentation.ui.components.AppToolbar
import presentation.ui.components.HeadlineText

@Composable
fun ProfileScreen(
    userId: Long,
    viewModel: ProfileViewModel,
    onNavigateBack: () -> Unit = {}
) {

    val user by viewModel.user.collectAsState()
    var currentDialog by remember { mutableStateOf(DialogType.None) }

    LaunchedEffect(key1 = userId) {
        if (userId != 0L) {
            viewModel.fetchUserById(userId)
        }
    }

    EditGenderDialog(
        showDialog = currentDialog == DialogType.GenderDialog,
        currentGender = getUserGender(user?.gender),
        onDismiss = {
            currentDialog = DialogType.None
        },
        onConfirm = {
            viewModel.updateUserGender(it)
            currentDialog = DialogType.None
        })

    EditAgeDialog(
        showDialog = currentDialog == DialogType.AgeDialog,
        currentAge = getUserAge(user?.age),
        onDismiss = {
            currentDialog = DialogType.None
        },
        onConfirm = {
            viewModel.updateUserAge(it)
            currentDialog = DialogType.None
        })

    EditHeightDialog(
        showDialog = currentDialog == DialogType.HeightDialog,
        currentHeight = getUserHeight(user?.height),
        onDismiss = {
            currentDialog = DialogType.None
        },
        onConfirm = {
            viewModel.updateUserHeight(it)
            currentDialog = DialogType.None
        })

    EditWeightDialog(
        showDialog = currentDialog == DialogType.WeightDialog,
        currentWeight = getUserWeight(user?.weight),
        onDismiss = {
            currentDialog = DialogType.None
        },
        onConfirm = {
            viewModel.updateUserWeight(it)
            currentDialog = DialogType.None
        })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        AppToolbar(
            title = "Profile",
            onNavigateBack = { onNavigateBack() }
        )

        Spacer(modifier = Modifier.height(30.dp))

        HeadlineText(
            text = "My data"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProfileDataItem(
                    text = formatGender(user?.gender),
                    onClick = {
                        currentDialog = DialogType.GenderDialog
                    })
                ProfileDataItem(
                    text = formatAge(user?.age),
                    onClick = {
                        currentDialog = DialogType.AgeDialog
                    })
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProfileDataItem(
                    text = formatHeight(user?.height),
                    onClick = {
                        currentDialog = DialogType.HeightDialog
                    })
                ProfileDataItem(
                    text = formatWeight(user?.weight),
                    onClick = {
                        currentDialog = DialogType.WeightDialog
                    })
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        HeadlineText(
            text = "Total activities"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileTotalItem(
                text = formatTotalKm(user?.totalKm)
            )
            ProfileTotalItem(
                text = formatTotalKcal(user?.totalKcal)
            )
        }
    }
}
