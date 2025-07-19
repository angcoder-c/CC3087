/**
Angel Gabriel Chavez Otzoy
24248
Programacion de plataformas moviles
19/07/2025
 */

// products
var products: Array<Array<Any>> = arrayOf(
    arrayOf("Proteina", 5, true),
    arrayOf("Caseina", 4, true),
    arrayOf("Esteroides", 3, true),
    arrayOf("Vitamina C", 2, true),
    arrayOf("Ashwagandha", 1, true)
)

fun main() {

    var option = ""
    while (option != "0") {
        print(
            """
            =========================
            BIENVENIDO
            =========================
            (1) Mostrar inventario completo
            (2) Buscar producto
            (3) Actualizar cantidad de producto
            (4) Estadisticas
            (0) Salir
            >>>  """.trimIndent()
        )
        option = readLine() ?: ""

        when (option) {
            "1" -> {
                println("Disponibilidad     Producto    Cantidad")
                println("---------------------------------------")
                val inventario = mostrarInventario()
                for (producto in inventario.indices) {
                    println(inventario[producto])
                }
            }
            "2" -> {
                print("Nombre de producto: ")
                val productName = readln() ?: ""
                val product = buscarProducto(productName)

                println("Buscando...")
                println("---------------------------------------")

                if (product != -1) {
                    println("Cantidad: ${products[product][1]} \nDisponibilidad: ${products[product][2]}")
                } else {
                    println("Producto $productName no encontrado")
                }
            }
            "3" -> {
                print("Nombre de producto: ")
                val productName = readln() ?: ""
                val product = buscarProducto(productName)

                println("Buscando...")
                println("---------------------------------------")

                if (product != -1) {
                    println("Cantidad: ${products[product][1]} \nDisponibilidad: ${products[product][2]}")
                    print("Nueva cantidad: ")
                    var nuevaCantidad = products[product][1] as Int
                    try {
                        nuevaCantidad = readln().toInt()
                    } catch (e: NumberFormatException) {}

                    if (modificarCantidadProducto(product, nuevaCantidad)) {
                        println("Producto modificado\nCantidad: $nuevaCantidad \nDisponibilidad: ${products[product][2]}")
                    } else {
                        "Ocurrio un error al modificar el producto"
                    }

                } else {
                    println("Producto $productName no encontrado")
                }
            }
            "4" -> {
                println("Productos disponibles \t Cantidad")
                println("---------------------------------------")
                println("${productosDisponibles()}\t${cantidadProductosDisponibles()}")

            }
            "5" -> println("Bye")
            else -> "Opcion invalida"
        }
    }
}

fun mostrarInventario(): Array<String> {
    // listar inventario
    var tempProducts: Array<String> = arrayOf()
    for (i in products.indices) {
        val disponibleProduct = if (products[i][2]!=false) {
            "+"
        } else {
            "-"
        }
        val line = "$disponibleProduct \t ${products[i].get(0)} \t ${products[i].get(1)}"
        tempProducts = tempProducts.plus(line)
    }
    return tempProducts
}

fun buscarProducto(name:String): Int {
    // buscar un producto por su nombre en lowercase
    for (i in products.indices) {
        if (products[i][0].toString().lowercase()==name.lowercase()) {
            return i
        }
    }
    return -1
}

fun modificarCantidadProducto(index: Int, cantidad: Int): Boolean {
    // modifica la cantidad index=1 y valida la disponibilidad index=2
    if (cantidad in 0..100) {
        products[index][1] = cantidad
        products[index][2] = if (cantidad > 0) true else false
        return true
    }
    return false
}

fun productosDisponibles(): Int{
    // suma los productos disponibles
    var totalProductos = 0
    for (i in products.indices) {
        if (products[i][2] != false) {
            totalProductos++
        }
    }
    return totalProductos
}

fun cantidadProductosDisponibles(): Int{
    // suma la cantidad de productos de los productos disponibles
    var totalProductos = 0
    for (i in products.indices) {
        val cant = products[i][1]
        if (products[i][2] != false && cant is Int) {
            totalProductos += cant
        }
    }
    return totalProductos
}
