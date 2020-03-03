package com.agulyanov.calc.core.utils

import com.agulyanov.calc.core.stack.Stack
import com.agulyanov.calc.core.stack.StackImpl

class EqualAmount {
    companion object {
        fun check(expression: String, first: Char, second: Char): Boolean {
            val stack: Stack = StackImpl()
            var result = true
            expression.forEach {
                if (it == first) stack.push(it.toString())
                if (it == second)
                    if (stack.isEmpty())
                        result = false
                    else
                        stack.pop()
            }
            if (!stack.isEmpty()) result = false
            stack.clear()
            return result
        }
    }
}