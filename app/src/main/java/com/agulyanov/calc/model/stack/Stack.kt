package com.agulyanov.calc.model.stack

interface Stack {
    fun push(item : String) //Положить в стек элемент
    fun pop() : String     //Взять элемент с вершины стека и удалить его
    fun peek() : String    //Взять элемент с вершины стека, но не удалять его
    fun clear()             //очистить стек
    fun isEmpty() : Boolean//true - стек пуст
}