package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import java.util.*

class TokenizeExpression {
    companion object {
        fun from(expression: String): Array<String> {
            val result: MutableList<String> = mutableListOf()

            val tokens = StringTokenizer(
                expression,
                Constants.OPERATORS_PLUS_MINUS
                    .plus(Constants.OPERATORS_MUL_DIV)
                    .plus(Constants.BRACKETS)
                    .plus(Constants.SPACES)
                    .plus(Constants.TERNARY_OPERATOR),
                true
            )
            loop@ while (tokens.hasMoreTokens()) {
                when (val token = tokens.nextToken()) {
                    Constants.SPACES -> continue@loop
                    else -> result.add(token)
                }
            }

            return result.toTypedArray()
        }
    }
}