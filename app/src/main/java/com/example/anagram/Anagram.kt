package com.example.anagram

import kotlin.random.Random

class Anagram {

    var wordlist = arrayOf(
            "ACCOUNT", "ADDITION", "AGREEMENT", "ANGRY", "ANIMAL", "BEHAVIOUR", "BETWEEN", "BLACK",
            "CHEMICAL", "FOOLISH", "FREQUENT", "GOVERNMENT", "GRAIN", "GRASS", "HOSPITAL",
            "PAYMENT", "POLITICAL", "PROCESS", "SHAME", "SMASH", "SMOOTH", "STATEMENT", "SUBSTANCE",
            "TEACHING", "TENDENCY", "TOMORROW", "TOUCH", "UMBRELLA", "WEATHER", "YESTERDAY"
    )

    fun randomWord(): String {
        return wordlist[Random.nextInt(wordlist.size)]
    }

    fun shuffleWord(word: String): String {
        if (word != null && "" != word) {
            val a = word.toCharArray()
            for (i in a.indices) {
                val j: Int = Random.nextInt(a.size)
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
            return String(a)
        }
        return word
    }
}