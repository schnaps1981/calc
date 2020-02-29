package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl


class CalculatePostfixExpression {

    private var stack : Stack = StackImpl()

    fun calculate(expression : String) : String
    {
        val tokens = expression.split(" ").map { it.trim() }.toTypedArray()


        tokens.forEach {
            when {
                it.isOperand() -> stack.push(it)

                it == "@" -> stack.push(-stack.pop() )


                it == "+" -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand + secondOperand).toString())
                }

                it == "-" -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand - secondOperand).toString())
                }

                it == "*" -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand * secondOperand).toString())
                }

                it == "/" -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand / secondOperand).toString())
                }
            }
        }
        return stack.pop()
    }

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
//    private operator fun String.unaryMinus() = "-$this"
}




