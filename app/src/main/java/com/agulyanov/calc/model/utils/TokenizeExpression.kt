package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import java.util.*

class TokenizeExpression {
    companion object {
        fun from(expression: String): Array<String> {
            val result: MutableList<String> = mutableListOf()
            val tokens = StringTokenizer(
                expression,
                Constants.OPERATORS.plus(Constants.BRACKETS).plus(Constants.SPACES),
                true
            )
            while (tokens.hasMoreTokens()) {
                val token = tokens.nextToken()
                if (!Constants.SPACES.contains(token))
                    result.add(token)
            }
            return result.toTypedArray()
        }
    }
}