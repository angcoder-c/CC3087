package `LAB-2`

enum class ElementType {
    ENTERO,
    CADENA,
    BOOLEANO
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

class ItemData(
    var originalPos: Int,
    var originalValue: Any?,
    var type: ElementType,
    var info: String?
) {
    // item data to string
    override fun toString(): String {
        // value to string
        val value = when (originalValue) {
            is String -> "'${originalValue}'"
            else -> originalValue.toString()
        }

        val typeStr = elementType2String(type)
        return "$value estaba en la posición $originalPos, es de tipo $typeStr e info es ${info}"
    }
}

fun processList(list: List<Any?>?): MutableList<ItemData>? {
    if (list == null) {
        return null
    }
    val result = mutableListOf<ItemData>()
    return result
}

fun main() {

}