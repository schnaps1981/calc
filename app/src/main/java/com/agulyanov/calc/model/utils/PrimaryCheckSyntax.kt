package com.agulyanov.calc.model.utils

import com.agulyanov.calc.app.Constants

class PrimaryCheckSyntax {

    fun check(expression: String): Boolean {

        //если последний символ оператор, выражение некорректно
        if (expression.trim(*Constants.SPACES.toCharArray()).last().toString().isOperator()) return false

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

                //Удалить символы тернарного и логических операторов.
                //.replace(Constants.LOGIC_OPERATORS_REGEXP.toRegex(), "")
        }

        //проверка сочетаемости скобок
        val isBracketsEqualAmount = EqualAmount.check(expression, '(', ')')
        val isTernaryEqualAmount = EqualAmount.check(expression, '?', ':')

        return isValidSymbols.isEmpty() && isBracketsEqualAmount && isTernaryEqualAmount
    }


}