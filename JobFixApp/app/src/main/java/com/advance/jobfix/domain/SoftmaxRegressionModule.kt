package com.advance.jobfix.domain

import android.util.Log
import com.advance.jobfix.data.JobLabeled
import com.advance.jobfix.data.utils.ScoreType
import com.chaquo.python.PyObject
import com.chaquo.python.Python

val etha : Array<DoubleArray> = arrayOf(
    doubleArrayOf(3.90980473, 1.0260188, -3.55942719),
    doubleArrayOf(-3.28357828, -1.25602308, 4.43756107),
    doubleArrayOf(-1.14401769, 1.09713446, 0.45495178),
    doubleArrayOf(2.72694485, -4.31271344, 0.94276786),
    doubleArrayOf(-3.71714505, 4.45781993, -0.92934432)
)

val jobs: List<String> = listOf("Astronomer", "Geologist", "Marine Biologist")
val columnsToEncode: Array<String> = arrayOf("P1", "P2", "P3")
val validCategories: Array<String> = arrayOf(ScoreType.AVG.toString(), ScoreType.BEST.toString(), ScoreType.POOR.toString(), ScoreType.NA.toString())
val columnsTrained: Array<String> = arrayOf("P1_AVG", "P1_POOR", "P2_POOR", "P3_AVG", "P3_BEST")

private fun oneHotEncode(
    jobLabeled: JobLabeled,
) : PyObject {

    val xPredictLabel = arrayOf(
        jobLabeled.linguisticLabel, jobLabeled.musicalLabel, jobLabeled.bodilyLabel)

    val py = Python.getInstance()
    val pyObj = py.getModule("utils")

    //Step 1: Parses input data to df.
    val resultParseToDf = pyObj.callAttr(
        "parse_to_df",
        xPredictLabel,
        columnsToEncode
        )
    Log.d(
        "SoftmaxRegressionModule[resultParseToDf]",
        resultParseToDf.toString()
    )

    //Step 2: Executes one hot encode.
    val resultOneHotEncode = pyObj.callAttr(
        "one_hot_encode",
        resultParseToDf,
        columnsToEncode,
        validCategories
    )
    Log.d(
        "SoftmaxRegressionModule[resultOneHotEncode]",
        resultOneHotEncode.toString()
    )

    //Step 3: Execute to get matrix full dimensions.
    val resultTransformFullDimension = pyObj.callAttr(
        "transform_full_dimension",
        columnsTrained,
        resultOneHotEncode
    )
    Log.d(
        "SoftmaxRegressionModule[resultTransformFullDimension]",
        resultTransformFullDimension.toString()
    )

    return resultTransformFullDimension
}

private fun softmaxRegression(
    encodingMatrix: PyObject
) : PyObject {

    val py = Python.getInstance()
    val pyObj = py.getModule("softmax_regression")

    val resultSoftmax = pyObj.callAttr(
        "softmax",
        etha,
        encodingMatrix
    )
    Log.d(
        "SoftmaxRegressionModule[resultSoftmax]",
        resultSoftmax.toString()
    )
    return resultSoftmax
}

fun predict(
    jobLabeled: JobLabeled,
) : String {

    val oneHotMatrix = oneHotEncode(jobLabeled)
    val prods = softmaxRegression(oneHotMatrix)

    val py = Python.getInstance()
    val pyObj = py.getModule("softmax_regression")

    val resultPredict = pyObj.callAttr(
        "predict_prods",
        prods
    )
    Log.d(
        "SoftmaxRegressionModule[resultPredict]",
        resultPredict.toString()
    )

    return jobs.get(resultPredict.toInt())
}