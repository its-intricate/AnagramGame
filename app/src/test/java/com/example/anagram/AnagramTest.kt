package com.example.anagram

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.*
import org.junit.Test

class AnagramTest{
    private val anagram = Anagram()

    @Test
    fun random_word_is_returned() {
        val result = anagram.randomWord()
        assertThat(result, instanceOf(String::class.java))
    }

    @Test
    fun word_characters_are_shuffled() {
        val word = anagram.randomWord()
        val result = anagram.shuffleWord(word)
        assertEquals(word.toCharArray().sort(), result.toCharArray().sort())
    }



}

