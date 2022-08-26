package com.example.testing

import com.example.testing.network.RetrofitHttp.postService
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkStatusCode() {
        val response = postService().listPosts().execute()
        assertEquals(response.code(), 200)
    }

    @Test
    fun responseIsSuccessful() {
        val response = postService().listPosts().execute()
        assertTrue(response.isSuccessful)
    }

    @Test
    fun checkPostListNotNull() {
        val response = postService().listPosts().execute()
        assertNotNull(response.body())
    }

    @Test
    fun checkPostListSize() {
        val response = postService().listPosts().execute()
        val posts = response.body()
        assertEquals(posts!!.size, 100)
    }

    @Test
    fun checkFirstUserId() {
        val response = postService().listPosts().execute()
        val posts = response.body()
        val post = posts!![0]
        assertEquals(post.userId, 1)
    }

}