package com.agulyanov.calc.extensions

import com.agulyanov.calc.app.Constants
import java.lang.NumberFormatException

fun String.isNumber() =
    try {
        this.toFloat().let { true }
    } catch (e: NumberFormatException) {
        false
    }

fun String.isOperator() = this in Constants.OPN_OPERATOR_SYMBOLS

fun String.isOpenBracket() = this == Constants.OPERATOR_OPEN_BRACKET

fun String.isCloseBracket() = this == Constants.OPERATOR_CLOSE_BRACKET

fun String.isTernaryElse() = this == Constants.TERNARY_OPERATOR_ELSE

//Унарный минус это символ "минус" в начале выражения либо после любого любого разделителя (в том числе "(" или символа операции), кроме ")" )
fun String.isUnaryMinus(currIt: String, prevIt: String) = (currIt == "-" && prevIt == "") || (prevIt != ")" && isDelimiter(
    prevIt
))

fun isDelimiter(arg: String) = arg in Constants.OPERATORS_PLUS_MINUS.plus(Constants.OPERATORS_MUL_DIV).plus(Constants.BRACKETS).plus(Constants.TERNARY_OPERATOR).plus(Constants.LOGIC_OPERATORS)


