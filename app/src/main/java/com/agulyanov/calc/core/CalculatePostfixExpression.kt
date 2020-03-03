package com.agulyanov.calc.core

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.extensions.isNumber
import com.agulyanov.calc.core.stack.Stack
import com.agulyanov.calc.core.stack.StackImpl
import java.lang.NumberFormatException


class CalculatePostfixExpression : NumberFormatException() {

    private var stack: Stack = StackImpl()

    fun calculate(expression: String): String {
        val tokens = expression.split(Constants.SPACES).map { it.trim() }.toTypedArray()

        tokens.forEach {
            try {
                when {
                    it.isNumber() -> stack.push(it)

                    it == Constants.RPN_MORE -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand > secondOperand).toString())
                    }

                    it == Constants.RPN_LESS -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand < secondOperand).toString())
                    }

                    it == Constants.RPN_EQUAL -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand == secondOperand).toString())
                    }

                    it == Constants.RPN_MORE_EQUAL -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand >= secondOperand).toString())
                    }

                    it == Constants.RPN_LESS_EQUAL -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand <= secondOperand).toString())
                    }

                    it == Constants.RPN_NOT_EUQAL -> {
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toFloat()
                        stack.push((firstOperand != secondOperand).toString())
                    }

                    it == Constants.RPN_TERNARY_IF -> {
                        val thirdOperand = stack.pop().toFloat()
                        val secondOperand = stack.pop().toFloat()
                        val firstOperand = stack.pop().toBoolean()
                        stack.push((if (firstOperand) secondOperand else thirdOperand).toString())
                    }

                    it == Constants.RPN_UNARY_MINUS -> {
                        val firstOperand = stack.pop().toFloat() * -1.0
                        stack.push(firstOperand.toString())
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
                        stack.push((firstOperand / secondOperand).toString())
                    }
                }
            }
            catch(e : Exception)
            {
                when (e) {
                    is NumberFormatException -> return "Ошибка в выражении!"
                    is ArithmeticException -> return "Деление на ноль!"
                }
            }

        }
        return stack.pop()
    }

}




