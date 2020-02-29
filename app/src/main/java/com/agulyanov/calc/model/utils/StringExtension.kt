package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants


//TODO улучишть механику опрпеделенния того, что это число
fun String.isOperand() = this.contains(Constants.NUMBERS_REGEXP.toRegex())

fun String.isOperator() =
    this.contains("+") || this.contains("-") || this.contains("*") || this.contains("/")

fun String.isOpenBracket() = this == "("

fun String.isCloseBracket() = this == ")"

operator fun String.unaryMinus() = "-$this"

//Унарный минус это символ "минус" в начале выражения либо после любого любого разделителя (в том числе "(" или символа операции), кроме ")" )
fun String.isUnaryMinus(currIt: String, prevIt: String): Boolean {
    return (currIt == "-" && prevIt == "") || (prevIt != ")" && isDelimiter(prevIt))
}

fun isDelimiter(prevIt: String): Boolean {
    return Constants.DELIMITERS.contains(prevIt)
}