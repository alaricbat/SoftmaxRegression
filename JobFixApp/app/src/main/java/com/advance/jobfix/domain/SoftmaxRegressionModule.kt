package com.advance.jobfix.domain

import com.advance.jobfix.data.JobLabeled
import com.advance.jobfix.data.utils.ScoreType
import krangl.DataFrame
import krangl.dataFrameOf

val etha : List<List<Double>> = listOf(
listOf(3.90980473, 1.0260188, -3.55942719),
listOf(-3.28357828, -1.25602308, 4.43756107),
listOf(-1.14401769, 1.09713446, 0.45495178),
listOf(2.72694485, -4.31271344, 0.94276786),
listOf(-3.71714505, 4.45781993, -0.92934432)
)

val jobs: List<String> = listOf("Astronomer", "Geologist", "Marine Biologist")
val columnsToEncode: List<String> = listOf("P1", "P2", "P3")
val validCategories: List<String> = listOf(
    ScoreType.AVG.toString(),
    ScoreType.BEST.toString(),
    ScoreType.POOR.toString(),
    ScoreType.NA.toString()
)

fun oneHotEncode(
    dataFrame: DataFrame,
    columnToEncode: List<String>,
    validCategories: List<String>
) {
    val encodedDf = dataFrame
    val newColumns = listOf<String>()
    columnsToEncode.forEach { colName ->
//        if (!dataFrame.cols.contains(colName)) {
//
//        }
    }
}

fun estimateJob(jobLabeled: JobLabeled) : String {
    val jobPredictDf: DataFrame = dataFrameOf(
        columnsToEncode
    ) (
        jobLabeled.linguisticLabel, jobLabeled.musicalLabel, jobLabeled.bodilyLabel
    )
    return ""
}