package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl


class CalculatePostfixExpression {

    private var stack : Stack = StackImpl()

    fun calculate(expression : String) : String
    {
        val tokens = expression.split(Constants.SPACES).map { it.trim() }.toTypedArray()

        tokens.forEach {
            when {
                it.isNumber() -> stack.push(it)

                it == Constants.RPN_UNARY_MINUS -> {
                    val firstOperand = stack.pop().toFloat() * -1.0
                    stack.push(firstOperand.toString() )
                }

                it == Constants.OPERATOR_PLUS -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand + secondOperand).toString())
                }

                it == Constants.OPERATOR_MINUS -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand - secondOperand).toString())
                }

                it == Constants.OPERATOR_MUL -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    stack.push((firstOperand * secondOperand).toString())
                }

                it == Constants.OPERATOR_DIV -> {
                    val secondOperand = stack.pop().toFloat()
                    val firstOperand = stack.pop().toFloat()
                    if (firstOperand.equals(0.0f)) return "Деление на ноль!"
                    stack.push((firstOperand / secondOperand).toString())
                }
            }
        }
        return stack.pop()
    }
}




