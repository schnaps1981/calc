package com.agulyanov.calc.model

interface ModelContract {
    fun calculateExpression (expression : String) : String
}