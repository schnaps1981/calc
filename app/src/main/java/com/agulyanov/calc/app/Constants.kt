package com.agulyanov.calc.app

object Constants {
    //Регулярки
    //TODO допилдить регулярку, чтобы она отсекала числа типа 1.1.1
    const val NUMBERS_REGEXP = """[0-9]*\.?[0-9]+"""
    const val ARITHMETIC_OPERATORS_REGEXP = """[[\s\+\-\*\/\(\)]]"""
    const val LOGIC_OPERATORS_REGEXP = """[\?\:\>\<\=!]"""

    //Операторы и разделители
    const val OPERATOR_PLUS = "+"
    const val OPERATOR_MINUS = "-"
    const val OPERATORS_PLUS_MINUS = "$OPERATOR_PLUS$OPERATOR_MINUS"

    const val OPERATOR_MUL = "*"
    const val OPERATOR_DIV = "/"
    const val OPERATORS_MUL_DIV = "$OPERATOR_MUL$OPERATOR_DIV"

    const val OPERATOR_OPEN_BRACKET = "("
    const val OPERATOR_CLOSE_BRACKET = ")"
    const val BRACKETS = "$OPERATOR_OPEN_BRACKET$OPERATOR_CLOSE_BRACKET"

    const val SPACES = " "

    const val TERNARY_OPERATOR = "? :"

    const val LOGIC_OPERATORS = "> < >= <= != =="


    //Приоритеты операций
    const val PRIORITY_NOT_DEFINDED = -1
    const val PRIORITY_BRACKETS = 1
    const val PRIORITY_PLUS_MINUS = 2
    const val PRIORITY_MUL_DIV = 3
    const val PRIORITY_UNARY_MINUS = 4

    const val PRIORITY_COMP_LESS_GREAT = 10
    const val PRIORITY_COMP_EQUAL_NOTEQUAL = 11

    const val PRIORITY_LOGIC = 11
    const val PRIORITY_TERNARY = 12

    //Символы операторов для ОПЗ
    const val RPN_UNARY_MINUS = "@"
    const val RPN_EQUAL = "="
    const val RPN_MORE = ">"
    const val RPN_LESS = "<"
    const val RPN_MORE_EQUAL = "g"
    const val RPN_LESS_EQUAL = "l"
    const val RPN_TERNARY_IF_BEGIN = "?"
    const val RPN_TERNARY_IF_END = ":"


    const val OPN_OPERATOR_SYMBOLS =
            OPERATORS_PLUS_MINUS +
            OPERATORS_MUL_DIV +
            RPN_UNARY_MINUS +
            RPN_EQUAL +
            RPN_MORE +
            RPN_LESS +
            RPN_MORE_EQUAL +
            RPN_LESS_EQUAL


}
