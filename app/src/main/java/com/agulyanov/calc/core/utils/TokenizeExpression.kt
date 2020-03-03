package com.agulyanov.calc.core.utils

import com.agulyanov.calc.app.Constants
import java.util.*

class TokenizeExpression {
    companion object {
        fun from(rawExpression: String): Array<String> {
            val result: MutableList<String> = mutableListOf()

            //Замена двухсимвольных операторов (>= == <= !=) на их односимвольные мнемоники
            val expression = rawExpression
                .replace(Constants.LOGIC_EQUAL, Constants.RPN_EQUAL)
                .replace(Constants.LOGIC_NOT_EQUAL, Constants.RPN_NOT_EUQAL)
                .replace(Constants.LOGIC_LESS_EQUAL, Constants.RPN_LESS_EQUAL)
                .replace(Constants.LOGIC_MORE_EUQAL, Constants.RPN_MORE_EQUAL)

            val tokens = StringTokenizer(
                expression,
                Constants.OPERATORS_PLUS_MINUS
                    .plus(Constants.OPERATORS_MUL_DIV)
                    .plus(Constants.BRACKETS)
                    .plus(Constants.SPACES)
                    .plus(Constants.OPN_OPERATOR_SYMBOLS),
                true
            )

            while (tokens.hasMoreTokens()) {
                when (val token = tokens.nextToken()) {
                    !in Constants.SPACES -> result.add(token)
                }
            }

            return result.toTypedArray()
        }
    }
}