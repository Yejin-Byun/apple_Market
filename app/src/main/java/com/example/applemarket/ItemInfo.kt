package com.example.applemarket

data class ItemInfo(
    val img: Int,
    val name: String,
    val info: String,
    val seller: String,
    val price: Int,
    val locate: String,
    val heart: Int,
    val chat: Int
) {
    companion object
}
