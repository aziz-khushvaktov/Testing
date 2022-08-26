package com.example.testing.model

import java.io.Serializable

data class Post(
    var id: Int,
    var userId: Int,
    var title: String = "",
    var body: String = ""
): Serializable {
    override fun toString(): String {
        return "Post { " + "id = " + id + ", userId = " + userId + ", title = " + title + ", body = " + body
    }
}
