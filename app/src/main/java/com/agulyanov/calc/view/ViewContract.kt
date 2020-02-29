package com.agulyanov.calc.view

interface ViewContract {
    fun showResult(message : Int)
    fun showResult(message: String)
    fun showError(error : Int)
    fun showError(error : String)
    fun disableCalcButton()
    fun enableCalcButton()
}