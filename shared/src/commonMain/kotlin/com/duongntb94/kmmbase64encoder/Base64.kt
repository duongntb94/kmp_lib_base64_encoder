package com.duongntb94.kmmbase64encoder

private const val BASE64_ALPHABET: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
private const val BASE64_MASK: Byte = 0x3f
private const val BASE64_PAD: Char = '='
private val BASE64_INVERSE_ALPHABET = IntArray(256) {
    BASE64_ALPHABET.indexOf(it.toChar())
}
private fun Int.toBase64(): Char = BASE64_ALPHABET[this]

object Base64Encoder {
    /**
     * Encode input plain string to base64 string
     */
    fun encodeToString(src: String): String {
        val srcByteArray = src.encodeToByteArray();
        fun ByteArray.getOrZero(index: Int): Int = if (index >= size) 0 else get(index).toInt()
        // 4n / 3 is expected Base64 payload
        val result = ArrayList<Byte>(4 * srcByteArray.size / 3)
        var index = 0
        while (index < srcByteArray.size) {
            val symbolsLeft = srcByteArray.size - index
            val padSize = if (symbolsLeft >= 3) 0 else (3 - symbolsLeft) * 8 / 6
            val chunk = (srcByteArray.getOrZero(index) shl 16) or (srcByteArray.getOrZero(index + 1) shl 8) or srcByteArray.getOrZero(index + 2)
            index += 3

            for (i in 3 downTo padSize) {
                val char = (chunk shr (6 * i)) and BASE64_MASK.toInt()
                result.add(char.toBase64().code.toByte())
            }
            // Fill the pad with '='
            repeat(padSize) { result.add(BASE64_PAD.code.toByte()) }
        }

        return buildString(result.size) {
            result.forEach { append(it.toInt().toChar()) }
        }
    }
}
