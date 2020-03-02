package com.agulyanov.calc.app

object Constants {
    //Регулярки
    const val NUMBERS_REGEXP = """[0-9]*\.?[0-9]+"""
    const val ARITHMETIC_OPERATORS_REGEXP = """[[\s\+\-\*\/\(\)]]"""
    const val LOGIC_OPERATORS_REGEXP = """[\?\:\>\<]"""
    const val NUMBERS_ANY_DIGHT = """\d"""

    //Операторы и разделители
    const val OPERATORS = "+-*/"
    const val BRACKETS = "()"
    const val SPACES = " "


    //Приоритеты операций
    const val PRIORITY_NOT_DEFINDED = -1
    const val PRIORITY_BRACKETS = 1
    const val PRIORITY_PLUS_MINUS = 2
    const val PRIORITY_MUL_DIV = 3
    const val PRIORITY_UNARY_MINUS = 3

    const val PRIORITY_COMP_LESS_GREAT = 10
    const val PRIORITY_COMP_EQUAL_NOTEQUAL = 11
    const val PRIORITY_TERNARY = 12

    //Символы операторов для ОПЗ
    const val OPN_UNARY_MINUS = "@"


    const val OPN_OPERATOR_SYMBOLS =
        OPERATORS +
        OPN_UNARY_MINUS

}
