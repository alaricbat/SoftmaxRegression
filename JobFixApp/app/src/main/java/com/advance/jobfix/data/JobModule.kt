package com.advance.jobfix.data

import com.advance.jobfix.data.utils.ScoreType

fun JobScores.toJobLabeled() = JobLabeled (
    parseScoreToLabel(linguisticScore),
    parseScoreToLabel(musicalScore),
    parseScoreToLabel(bodilyScore)
)

private fun parseScoreToLabel(score: Int) : String {
    if (score >= 0 && score <= 10) {
        return ScoreType.POOR.toString()
    } else if (score >= 11 && score <= 14) {
        return ScoreType.AVG.toString()
    } else if (score >= 15) {
        return ScoreType.BEST.toString()
    } else {
        return ScoreType.NA.toString()
    }
}