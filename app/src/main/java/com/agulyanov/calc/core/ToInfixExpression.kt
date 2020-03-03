package com.agulyanov.calc.core

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.extensions.*
import com.agulyanov.calc.core.stack.Stack
import com.agulyanov.calc.core.stack.StackImpl
import com.agulyanov.calc.core.utils.OperationPriority

class ToInfixExpression {
    private var stack: Stack = StackImpl()

    fun create(expression: Array<String>): String {
        val result = StringBuilder()

        var prevIt = ""
        expression.forEach {
            when {
                it.isNumber() -> result.append(it).append(Constants.SPACES[0])

                it.isOpenBracket() ->
                    stack.push(it)

                it.isCloseBracket() -> {
                    var topStackItem = stack.pop()

                    while (topStackItem != "(") {
                        if (stack.isEmpty()) return "Ошибка! Не согласованы скобки, или ошибка в выражении!"

                        result.append(topStackItem).append(Constants.SPACES[0])
                        topStackItem = stack.pop()

                    }
                }
                it.isOperator().and(it.isUnaryMinus(it, prevIt)) ->
                    stack.push(Constants.RPN_UNARY_MINUS)

                it.isOperator().and(!it.isUnaryMinus(it, prevIt)) -> {
                    val itPriority =
                        OperationPriority.priority(
                            it
                        )
                    var stackPriority =
                        OperationPriority.priority(
                            stack.peek()
                        )
                    while (stackPriority >= itPriority && !stack.isEmpty()) {
                        result.append(stack.pop()).append(Constants.SPACES[0])
                        stackPriority =
                            OperationPriority.priority(
                                stack.peek()
                            )
                    }
                    if (!it.isTernaryElse()) stack.push(it) //Тернарное "если" в стек не ложится
                }
            }

            prevIt = it
        }

        while (!stack.isEmpty()) {
            if (stack.peek().isOperator()) result.append(stack.pop()).append(Constants.SPACES[0]) else return "Ошибка! Не согласованы скобки, или ошибка в выражении!"
        }

        return result.toString()
    }

}








