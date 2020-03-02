package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import java.lang.NumberFormatException


//fun String.isOperand() = this.contains(Constants.NUMBERS_REGEXP.toRegex())
fun String.isOperand() : Boolean =
    try {
        this.toFloat().let { true }
    } catch (e: NumberFormatException) {
        false
    }

fun String.isOperator() = Constants.OPN_OPERATOR_SYMBOLS.contains(this)

fun String.isOpenBracket() = this == "("

fun String.isCloseBracket() = this == ")"

operator fun String.unaryMinus() = "-$this"

//Унарный минус это символ "минус" в начале выражения либо после любого любого разделителя (в том числе "(" или символа операции), кроме ")" )
fun String.isUnaryMinus(currIt: String, prevIt: String): Boolean {
    return (currIt == "-" && prevIt == "") || (prevIt != ")" && isDelimiter(prevIt))
}

fun isDelimiter(arg: String): Boolean {
    return Constants.OPERATORS.plus(Constants.BRACKETS).contains(arg)
}