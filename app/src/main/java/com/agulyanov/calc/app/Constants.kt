package com.agulyanov.calc.app

object Constants {
    //Регулярки
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

    const val TERNARY_OPERATOR_IF = "?"
    const val TERNARY_OPERATOR_ELSE = ":"
    const val TERNARY_OPERATOR = "$TERNARY_OPERATOR_IF$TERNARY_OPERATOR_ELSE"

    const val LOGIC_MORE = ">"
    const val LOGIC_LESS = "<"
    const val LOGIC_MORE_EUQAL = ">="
    const val LOGIC_LESS_EQUAL = "<="
    const val LOGIC_NOT_EQUAL = "!="
    const val LOGIC_EQUAL = "=="
    const val LOGIC_OPERATORS = "$LOGIC_MORE $LOGIC_LESS $LOGIC_MORE_EUQAL $LOGIC_LESS_EQUAL $LOGIC_NOT_EQUAL $LOGIC_EQUAL"

    const val SPACES = " "

    //Приоритеты операций
    const val PRIORITY_NOT_DEFINDED = -1
    const val PRIORITY_BRACKETS = 0
    const val PRIORITY_TERNARY_IF = 1
    const val PRIORITY_TERNARY_ELSE = 2
    const val PRIORITY_PLUS_MINUS = 7
    const val PRIORITY_MUL_DIV = 8
    const val PRIORITY_UNARY_MINUS = 8
    const val PRIORITY_LOGIC = 6

    //Символы операторов для ОПЗ
    const val RPN_UNARY_MINUS = "@"
    const val RPN_EQUAL = "="
    const val RPN_MORE = LOGIC_MORE
    const val RPN_LESS = LOGIC_LESS
    const val RPN_MORE_EQUAL = "G"
    const val RPN_LESS_EQUAL = "L"
    const val RPN_NOT_EUQAL = "N"
    const val RPN_TERNARY_IF = TERNARY_OPERATOR_IF
    const val RPN_TERNARY_ELSE = TERNARY_OPERATOR_ELSE


    const val OPN_OPERATOR_SYMBOLS =
            OPERATORS_PLUS_MINUS +
            OPERATORS_MUL_DIV +
            RPN_UNARY_MINUS +
            RPN_EQUAL +
            RPN_MORE +
            RPN_LESS +
            RPN_MORE_EQUAL +
            RPN_LESS_EQUAL +
            RPN_NOT_EUQAL +
            RPN_TERNARY_IF +
            RPN_TERNARY_ELSE


}
