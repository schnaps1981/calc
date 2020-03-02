package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants

class OperationPriority {
    companion object {
        fun priority(operator: String): Int {
            return when (operator) {
                in Constants.BRACKETS -> Constants.PRIORITY_BRACKETS
                in Constants.OPERATORS_PLUS_MINUS -> Constants.PRIORITY_PLUS_MINUS
                in Constants.OPERATORS_MUL_DIV -> Constants.PRIORITY_MUL_DIV
                Constants.RPN_UNARY_MINUS -> Constants.PRIORITY_UNARY_MINUS
                in Constants.LOGIC_OPERATORS -> Constants.PRIORITY_LOGIC
                in Constants.TERNARY_OPERATOR -> Constants.PRIORITY_TERNARY

                else -> Constants.PRIORITY_NOT_DEFINDED
            }
        }
    }
}