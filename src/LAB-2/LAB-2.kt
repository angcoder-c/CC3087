/*
* Angel Gabriel Chavez Otzoy
* 24248
* Programacion de plataformas moviles
* https://github.com/angcoder-c/CC3087/blob/main/src/LAB-2/LAB-2.kt
* */

fun main() {
    val inputList = listOf(10, "Hola", null, false, 7, "PC", true, 15.5)
    val result = processList(inputList)
    println("Resultado:")
    if (result != null) {
        for (item in result) {
            println(item)
        }
    }
}

data class ItemData(
    val originalPos: Int,
    val originalValue: Any,
    val type: ElementType,
    val info: String
) {
    // item data to string
    override fun toString(): String {
        // value to string
        val value = when (originalValue) {
            is String -> "'$originalValue'"
            else -> "'$originalValue'"
        }
        val typeStr = elementType2String(type)
        return "$value estaba en la posición $originalPos, es de tipo $typeStr e info es $info".lowercase()
    }
}

enum class ElementType {
    CADENA,
    ENTERO,
    BOOLEANO,
    DESCONOCIDO
}

fun processList(inputList: List<Any?>?): MutableList<ItemData>? {
    if (inputList == null) {
        return null
    }
    // resultado
    val listaMutable = mutableListOf<ItemData>()
    for ((index, item) in inputList.withIndex()) {
        if (item != null) {
            val type = type2ElementType(item)
            val info = getInfoByItem(item)
            listaMutable.add(
                ItemData(
                    index,
                    item,
                    type,
                    info
                )
            )
        }
    }

    return listaMutable
}

fun elementType2String (type: ElementType): String {
    // type to string
    return when (type) {
        ElementType.ENTERO -> "entero"
        ElementType.CADENA -> "cadena"
        ElementType.BOOLEANO -> "booleano"
        else -> "desconocido"
    }
}

fun type2ElementType (item: Any?): ElementType {
        // asignar un element type segun el tipo del item
        return when (item) {
            is Int -> ElementType.ENTERO
            is String -> ElementType.CADENA
            is Boolean -> ElementType.BOOLEANO
            else -> ElementType.DESCONOCIDO
        }
    }


fun getInfoByItem(item: Any): String {
    // obtener informacion en string segun el tipo del item
    return when (item) {
        is Int -> when {
            item % 10 == 0 -> "M10"
            item % 5 == 0 -> "M5"
            item % 2 == 0 -> "M2"
            else -> "-"
        }
        is String -> "L${item.length}"
        is Boolean -> if (item) "verdadero" else "falso"
        else -> "desconocido"
    }
}