package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants

class OperationPriority {
    companion object {
        fun priority(operator: String): Int {
            return when (operator) {
                "(", ")" -> Constants.PRIORITY_BRACKETS
                "+", "-" -> Constants.PRIORITY_PLUS_MINUS
                "*", "/" -> Constants.PRIORITY_MUL_DIV
                "@" -> Constants.PRIORITY_UNARY_MINUS


                else -> Constants.PRIORITY_NOT_DEFINDED
            }
        }
    }
}