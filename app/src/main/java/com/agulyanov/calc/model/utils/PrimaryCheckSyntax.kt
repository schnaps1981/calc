package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants
import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl

class PrimaryCheckSyntax {

    private var stack: Stack = StackImpl()

    fun check(expression: String): Boolean {

        //TODO если последний символ оператор, выражение некорректно


        val isValidSymbols = with(expression) {
            // здесь важен порядок удаления!
            this.replace(
                Constants.NUMBERS_REGEXP.toRegex(),
                ""
            ) //Удаляем все цифры (целые и вещественные)
                .replace(
                    Constants.ARITHMETIC_OPERATORS_REGEXP.toRegex(),
                    ""
                ) //Удаляем пробелы, стандартные символы арифметических операторов и скобки

                //Удалить символы логических операторов. здесь важен порядок удаления!
                .replace("==", "")
                .replace(">=", "")
                .replace("<=", "")
                .replace("!=", "")
                .replace(Constants.LOGIC_OPERATORS_REGEXP.toRegex(), "")
        }

        //проверка сочетаемости скобок
        val isBracketsEqualAmount = {
            var result = true
            expression.forEach {
                if (it == '(') stack.push(it.toString())
                if (it == ')')
                    if (stack.isEmpty())
                        result = false
                    else
                        stack.pop()
            }
            if (!stack.isEmpty()) result = false
            result
        }

        return isValidSymbols.isEmpty() && isBracketsEqualAmount()
    }


}