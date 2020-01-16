package com.example.morgan.utils

interface OnCartItemClickEvent {
    fun deleteItem(pos: Int)
    fun addItem(pos: Int)
    fun minusItem(pos: Int)
}