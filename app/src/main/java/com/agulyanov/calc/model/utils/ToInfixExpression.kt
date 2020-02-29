package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl

class ToInfixExpression {
    private var stack: Stack = StackImpl()

    fun create(expression: Array<String>): String {
        val result = StringBuilder()

        var prevIt = ""
        expression.forEach {
            when {
                it.isOperand() -> result.append(it).append(" ")

                it.isOpenBracket() -> stack.push(it)

                it.isCloseBracket() -> {
                    var topStackItem = stack.pop()

                    while (topStackItem != "(") {
                        if (stack.isEmpty()) return "Ошибка! Не согласованы скобки, или ошибка в выражении!"

                        result.append(topStackItem).append(" ")
                        topStackItem = stack.pop()

                    }
                }

                it.isOperator() -> {
                    if (it.isUnaryMinus(it, prevIt)) {
                        stack.push("@")
                    } else {

                        val itPriority = OperationPriority.priority(it)
                        var stackPriority = OperationPriority.priority(stack.peek())
                        while (stackPriority >= itPriority && !stack.isEmpty()) {

                            result.append(stack.pop()).append(" ")
                            stackPriority = OperationPriority.priority(stack.peek())
                        }
                        stack.push(it)
                    }
                }
            }

            prevIt = it
        }

        while (!stack.isEmpty()) {
            if (stack.peek().isOperator()) result.append(stack.pop()).append(" ") else return "Ошибка! Не согласованы скобки, или ошибка в выражении!"
        }

        return result.toString()
    }

//        private fun isOperand(value: String) =
//            value.contains("[0-9]".toRegex())


//    //TODO улучишть механику опрпеделенния того, что это число
//    private fun String.isOperand() = this.contains(Constants.NUMBERS_REGEXP.toRegex())
//
//    private fun String.isOperator() =
//        this.contains("+") || this.contains("-") || this.contains("*") || this.contains("/")
//
//    private fun String.isOpenBracket() = this == "("
//
//    private fun String.isCloseBracket() = this == ")"
//
//    //Унарный минус это символ "минус" в начале выражения либо после любого любого разделителя (в том числе "(" или символа операции), кроме ")" )
//    private fun String.isUnaryMinus(currIt: String, prevIt: String): Boolean {
//        return (currIt == "-" && prevIt == "") || (prevIt != ")" && isDelimiter(prevIt))
//    }
//
//    private fun isDelimiter(prevIt: String) : Boolean {
//        return delimiters.contains(prevIt)
//    }

}




