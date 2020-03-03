package com.agulyanov.calc.ui.presenter

import com.agulyanov.calc.data.model.ModelImpl
import com.agulyanov.calc.data.model.ModelContract
import com.agulyanov.calc.ui.view.ViewContract

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