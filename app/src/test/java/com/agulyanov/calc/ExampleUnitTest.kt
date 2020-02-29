package com.agulyanov.calc

import com.agulyanov.calc.model.stack.Stack
import com.agulyanov.calc.model.stack.StackImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val stack : Stack = StackImpl()
    @Test
    fun popFromEmptyStack() {
        stack.clear()
        assertEquals(stack.pop(), "SE")
    }

    @Test
    fun peekFromEmptyStack() {
        stack.clear()
        assertEquals(stack.peek(), "SE")
    }

    @Test
    fun pushValueAndPeekIt()
    {
        val value = "TEST"
        stack.push(value)
        assertEquals(value, stack.peek())
    }

    @Test
    fun checkEmptyAndClear()
    {
        stack.push("1")
        stack.push("2")
        stack.push("3")
        assertEquals(stack.isEmpty(), false)
        stack.clear()
        assertEquals(stack.isEmpty(), true)
    }

}
