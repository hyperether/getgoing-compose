package presentation.scenes.getgoing

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import di.DependencyProvider
import kmp.model.User
import kmp.repository.GgRepository
import kotlinx.coroutines.launch
import util.ExerciseType
import util.TimeUtils

class GetGoingViewModel(val repository: GgRepository? = DependencyProvider.repository) :
    ViewModel() {

    val exerciseState = mutableStateOf("")
    var user: User? = null
    private var selectedExercise = ExerciseType.WALKING

    var lastRouteSelectedExercise = mutableStateOf(ExerciseType.WALKING)
    var lastRouteDistance = mutableStateOf("")
    var lastRouteProgress = mutableFloatStateOf(0f)
    var lastRouteKcal = mutableStateOf("")
    var lastRouteDuration = mutableStateOf("")
    var lastRouteTimeProgress = mutableFloatStateOf(0f)

    init {
        viewModelScope.launch {
            repository?.getAllUsersFlow()?.collect {
                if (it.isNotEmpty()) {
                    user = it[0] // for now we only have one user
                }
            }
        }
    }

    fun selectExercise(exercise: ExerciseType) {
        selectedExercise = exercise
        exerciseState.value = exercise.value
    }

    fun getSelectedExerciseId(): Int {
        return selectedExercise.id
    }

    suspend fun getLastRoute() {

        repository?.getLastRoute()?.let { r ->
            ExerciseType.entries.find { it.id == r.activity_id }?.let {
                lastRouteSelectedExercise.value = it
                lastRouteDistance.value = "${r.length.toInt()}m"
                lastRouteProgress.floatValue = r.length.toFloat() / r.goal.toFloat()
                lastRouteKcal.value = r.energy.toString()
                lastRouteDuration.value = r.duration.toString()
                lastRouteTimeProgress.floatValue =
                    (r.duration.toFloat() / TimeUtils.getTimeEstimateForTypeSeconds(
                        r.goal.toInt(),
                        it
                    ).toFloat())
            }
        }


    }
}