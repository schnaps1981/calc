package com.agulyanov.calc.model

import com.agulyanov.calc.model.utils.CalculatePostfixExpression
import com.agulyanov.calc.model.utils.ToInfixExpression
import com.agulyanov.calc.model.utils.PrimaryCheckSyntax
import com.agulyanov.calc.model.utils.TokenizeExpression

class ModelImpl : ModelContract {
    private val expressionChecker : PrimaryCheckSyntax = PrimaryCheckSyntax()
    private lateinit var tokenizedExpression : Array<String>
    private lateinit var infixExpression : String
    private lateinit var calculatePostfix : String

    override fun calculateExpression(expression: String): String {

        if(!expressionChecker.check(expression)) return "Ошибка в выражении!"

        tokenizedExpression = TokenizeExpression.from(expression)

        infixExpression = ToInfixExpression().create(tokenizedExpression)

        if (infixExpression.contains("Ошибка"))
            return infixExpression
        else
            calculatePostfix = CalculatePostfixExpression().calculate(infixExpression)

        return calculatePostfix
    }
}