package com.codebaum.beginnerandroidexamples.helpers

import java.util.*

/**
 * Created on 1/14/18.
 */

sealed class SmartCast {

    class SubSmartCast1 : SmartCast() {

        fun returnTest1String(): String {
            return "Test1"
        }
    }

    class SubSmartCast2 : SmartCast() {

        fun returnTest2String(): String {
            return "Test2"
        }
    }

    class SubSmartCast3 : SmartCast() {

        fun returnTest3String(): String {
            return "Test3"
        }
    }

    // basically Kotlin's version of static
    companion object {
        val random: SmartCast
            get() {
                val randomNumber = Random().nextInt(2)
                return when (randomNumber) {
                    0 -> SubSmartCast1()
                    1 -> SubSmartCast2()
                    else -> SubSmartCast3()
                }
            }
    }
}
