package com.agulyanov.calc.data.model

interface ModelContract {
    fun calculateExpression (expression : String) : String
}