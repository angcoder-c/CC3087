/**
 * Programación de plataformas móviles
 * Angel Gabriel Chavez Otzoy
 * 24248
 *
 * Nombre: Angel
 * Apellido: Chavez
 * Año de nacimiento: 2003
 * Color favritoRojo
 * USERNAME:  ANGch03R
 *
 *
 */


fun main() {
    /*
     * Solicite al usuario los siguientes datos:
     * 		Nombre
     * 		Apellido
     * 		Año de nacimiento (solo los últimos 2 dígitos, ej: si nació en 2005, ingresa 05)
     * 		Color favorito
    */
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Año de nacimiento: ")
    val nacimiento = readln().substring(2,4)
    print("Color favrito")
    val colorFav = readln()

    val username = genUsername(
        nombre= nombre,
        apellido= apellido,
        nacimiento= nacimiento,
        colorFav= colorFav
    )

    println(username)
}


fun genUsername (nombre: String, apellido:String, colorFav:String, nacimiento:String): String {
    /*
    * Genere un nombre de usuario siguiendo estas reglas:
        Las primeras 3 letras del nombre (en minúsculas)
        Las primeras 2 letras del apellido (en minúsculas)
        El año de nacimiento (2 dígitos)
        La primera letra del color favorito (en mayúscula)
    * */
    val first = nombre.substring(0,3).uppercase()
    val second = apellido.substring(0,2).lowercase()
    val color1CFav = colorFav.substring(0,1).uppercase()
    return  "$first$second$nacimiento$color1CFav"
}

