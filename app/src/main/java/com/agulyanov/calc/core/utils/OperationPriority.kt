package com.agulyanov.calc.core.utils

import com.agulyanov.calc.app.Constants

class OperationPriority {
    companion object {
        fun priority(operator: String): Int {
            return when (operator) {
                in Constants.BRACKETS -> Constants.PRIORITY_BRACKETS

                in Constants.OPERATORS_PLUS_MINUS -> Constants.PRIORITY_PLUS_MINUS

                in Constants.OPERATORS_MUL_DIV -> Constants.PRIORITY_MUL_DIV

                Constants.RPN_UNARY_MINUS -> Constants.PRIORITY_UNARY_MINUS

                Constants.TERNARY_OPERATOR_IF -> Constants.PRIORITY_TERNARY_IF
                Constants.TERNARY_OPERATOR_ELSE -> Constants.PRIORITY_TERNARY_ELSE

                Constants.RPN_EQUAL -> Constants.PRIORITY_LOGIC
                Constants.RPN_MORE -> Constants.PRIORITY_LOGIC
                Constants.RPN_LESS -> Constants.PRIORITY_LOGIC
                Constants.RPN_MORE_EQUAL -> Constants.PRIORITY_LOGIC
                Constants.RPN_LESS_EQUAL -> Constants.PRIORITY_LOGIC
                Constants.RPN_NOT_EUQAL -> Constants.PRIORITY_LOGIC

                else -> Constants.PRIORITY_NOT_DEFINDED
            }
        }
    }
}