package com.agulyanov.calc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.agulyanov.calc.R
import com.agulyanov.calc.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewContract {

    val presenter : Presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        btn_calculate.setOnClickListener {
            presenter.calculate(et_expression.text.toString())
        }
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showResult(message: Int) {
        tv_result.text = getString(message)
    }

    override fun showResult(message: String) {
        tv_result.text = message
    }

    override fun showError(error: Int) {
        tv_error.text = getString(error)
    }

    override fun showError(error: String) {
        tv_error.text = error
    }

    override fun disableCalcButton() {
        btn_calculate.isEnabled = false
    }

    override fun enableCalcButton() {
        btn_calculate.isEnabled = true
    }
}
