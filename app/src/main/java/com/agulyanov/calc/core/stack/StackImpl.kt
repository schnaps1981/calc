package com.agulyanov.calc.core.stack

class StackImpl : Stack{

    private var stack : MutableList<String> = mutableListOf()

    override fun push(item: String) { stack.add(item) }

    override fun pop(): String = if (!isEmpty()) stack.let { it.removeAt(it.lastIndex) } else "SE"

    override fun peek(): String = if (!isEmpty()) stack.last() else "SE"

    override fun clear() { stack.clear() }

    override fun isEmpty() = stack.size == 0

}

