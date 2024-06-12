package util


enum class ExerciseType(val value: String, val id: Int) {
    RUNNING(value = "Running", id = 2),
    WALKING(value = "Walking", id = 1),
    CYCLING(value = "Cycling", id = 3)
}