package com.agulyanov.calc.presenter

import com.agulyanov.calc.model.ModelImpl
import com.agulyanov.calc.model.ModelContract
import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl
import com.agulyanov.calc.view.ViewContract

class Presenter {

    private var view : ViewContract? = null
    private val model : ModelContract = ModelImpl()

    fun calculate(expression : String)
    {
        view?.disableCalcButton()
        view?.showResult(model.calculateExpression(expression))
        view?.enableCalcButton()
    }


    fun attachView(view : ViewContract) { this.view = view }
    fun detachView() {  view = null }
}