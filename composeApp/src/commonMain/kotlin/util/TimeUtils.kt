package util

import kmp.util.Constants

object TimeUtils {

    fun getTimeEstimates(dist: Int): IntArray {
        val returnValues = IntArray(3)

        returnValues[0] = (dist / (Constants.AVG_SPEED_WALK * 60)).toInt()
        returnValues[1] = (dist / (Constants.AVG_SPEED_RUN * 60)).toInt()
        returnValues[2] = (dist / (Constants.AVG_SPEED_CYCLING * 60)).toInt()

        return returnValues
    }

    fun getTimeEstimateForTypeSeconds(dist: Int, exerciseType: ExerciseType?): Int {
        return when (exerciseType) {
            ExerciseType.RUNNING -> {
                ((dist / (Constants.AVG_SPEED_RUN * 60)) * 60).toInt()
            }

            ExerciseType.WALKING -> {
                ((dist / (Constants.AVG_SPEED_WALK * 60)) * 60).toInt()
            }

            ExerciseType.CYCLING -> {
                ((dist / (Constants.AVG_SPEED_CYCLING * 60)) * 60).toInt()
            }

            else -> {
                1
            }
        }
    }
}
