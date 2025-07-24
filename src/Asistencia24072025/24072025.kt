package Asistencia24072025

/**
Angel Gabriel Chavez Otzoy
 24248
 Tarea de asistencia 24/07/2025
 */


data class Student (
    var nombre: String,
    var carne: String,
    var nota1: Int,
    var nota2: Int,
    var nota3: Int
)

data class Notas (
    var nota1: Int,
    var nota2: Int,
    var nota3: Int
)

data class SuperStudent (
    var nombre: String,
    var carne: String,
    var nota1: Int,
    var nota2: Int,
    var nota3: Int,
    var promedio: Double,
    var aprovado: Boolean
)

fun createStudents (): MutableList<Student> {
    val students = mutableListOf<Student>(
        Student(
            nombre = "Juan",
            carne = "1",
            nota1 = 99,
            nota2 = 98,
            nota3 = 96
        ),
        Student(
            nombre = "Miguel",
            carne = "2",
            nota1 = 50,
            nota2 = 85,
            nota3 = 70
        ),
        Student(
            nombre = "Leo",
            carne = "3",
            nota1 = 61,
            nota2 = 61,
            nota3 = 60
        ),
        Student(
            nombre = "Samatha",
            carne = "5",
            nota1 = 50,
            nota2 = 30,
            nota3 = 65
        ),
        Student(
            nombre = "Maria",
            carne = "6",
            nota1 = 90,
            nota2 = 90,
            nota3 = 88
        ),
        Student(
            nombre = "Elena",
            carne = "8",
            nota1 = 71,
            nota2 = 82,
            nota3 = 93
        ),
        Student(
            nombre = "Cristiano",
            carne = "7",
            nota1 = 77,
            nota2 = 77,
            nota3 = 77
        ),
        Student(
            nombre = "Pablo",
            carne = "4",
            nota1 = 71,
            nota2 = 99,
            nota3 = 88
        )
    )
    return students
}

fun calcularPromedio (student: Student): Double {
    return (student.nota1 + student.nota2 + student.nota3) / 3.0
}

fun estudiantesReprobados (students: MutableList<Student>): MutableList<SuperStudent> {
    val estudiantesReprobadosList = mutableListOf<SuperStudent>()
    for (student in students) {
        if (calcularPromedio(student) <= 61) {
            estudiantesReprobadosList.add(SuperStudent(
                nombre = student.nombre,
                carne = student.carne,
                nota1 = student.nota1,
                nota2 = student.nota2,
                nota3 = student.nota3,
                promedio = calcularPromedio(student),
                aprovado = false
            ))
        }
    }
    return estudiantesReprobadosList
}

fun estudiantesAprobados (students: MutableList<Student>): MutableList<SuperStudent> {
    val estudiantesAprobadosList = mutableListOf<SuperStudent>()
    for (student in students) {
        if (calcularPromedio(student) >= 61) {
            estudiantesAprobadosList.add(SuperStudent(
                nombre = student.nombre,
                carne = student.carne,
                nota1 = student.nota1,
                nota2 = student.nota2,
                nota3 = student.nota3,
                promedio = calcularPromedio(student),
                aprovado = true
            ))
        }
    }
    return estudiantesAprobadosList
}

fun editStudent (students: MutableList<Student>, carnet: String, notas: Notas): MutableList<Student> {
    for (student in students) {
        if (student.carne == carnet) {
            student.nota1=notas.nota1
            student.nota2=notas.nota2
            student.nota3=notas.nota3
        }
    }
    return students
}

fun encontrarMejorEstudiante (students: MutableList<Student>): Student {
    var bestNota = 0.0
    var bestStudent: Student = Student(nombre = "", carne = "", nota1 = 0, nota2 = 0, nota3 = 0)
    for (student in students) {
        if (calcularPromedio(student)>bestNota) {
            bestNota = calcularPromedio(student)
            bestStudent = student
        }
    }
    return bestStudent
}

fun encontrarPeorEstudiante (students: MutableList<Student>): Student {
    var peorNota = 100.0
    var peorEstudiante: Student = Student(nombre = "", carne = "", nota1 = 0, nota2 = 0, nota3 = 0)
    for (student in students) {
        if (calcularPromedio(student)<peorNota) {
            peorNota = calcularPromedio(student)
            peorEstudiante = student
        }
    }
    return peorEstudiante
}


fun main() {
    var opt = ""
    while (opt != "0") {
        var students = createStudents()
        print("""
        =============================
        BIENVENIDO
        =============================
        (1) CALCULAR PROMEDIO
        (2) MEJOR Y PEOR ESTUDIANTE
        (3) ESTUDIANTES APROBADOS
        (4) ESTUDIANTES REPROBADOS
        (5) ACTUALIZAR NOTAS DE ESTUDIANTE
        (0) SALIR 
        
        >>>>>>>>>>>>>>  """.trimIndent())
        opt = readLine() ?: ""
        when (opt) {
            "1" -> {
                for (student in students) {
                    println("+ ${student.nombre} - ${calcularPromedio(student)}")
                }
            }
            "2" -> {
                val bestStudent = encontrarMejorEstudiante(students)
                val badStudent = encontrarPeorEstudiante(students)

                println("Mejor estudiante: ${bestStudent.nombre} - ${calcularPromedio(bestStudent)}")
                println("Peor estudiante: ${badStudent.nombre} - ${calcularPromedio(badStudent)}")
            }
            "3" -> {
                val aprobado = estudiantesAprobados(students)
                println("APROBADOS")
                for (student in aprobado) {
                    println("+ ${student.nombre} - ${student.promedio}")
                }
            }
            "4" -> {
                val reprobados = estudiantesReprobados(students)
                println("REPROBADOS")
                for (student in reprobados) {
                    println("+ ${student.nombre} - ${student.promedio}")
                }
            }
            "5" -> {
                print("Ingresar carnet: ")
                var carnet = readln() ?: ""
                print("Ingresar nota1: ")
                var nota1 = readln().toInt() ?: 0
                print("Ingresar nota2: ")
                var nota2 = readln().toInt() ?: 0
                print("Ingresar nota3: ")
                var nota3 = readln().toInt() ?: 0

                students = editStudent(students, carnet, Notas(nota1, nota2, nota3))
                for (student in students) {
                    if (student.carne==carnet && student.carne!="") {
                        println("+ ${student.nombre} - ${calcularPromedio(student)}")
                    }
                }
            }
            else -> println("Opcion invalida")
        }
    }
}