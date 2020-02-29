package com.agulyanov.calc.model.utils

class TokenizeExpression {
    //TODO сделать разделение на лексемы не только пробелом, а так же скобокой и оператором
    companion object {
        fun from(expression: String): Array<String> {
            return expression.split(" ").map { it.trim() }.toTypedArray()
        }
    }
}