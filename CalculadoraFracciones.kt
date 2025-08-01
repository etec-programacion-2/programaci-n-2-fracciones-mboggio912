package org.example
import kotlin.math.pow
import java.util.*

fun mostrarMenu() {
    println("\n=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    print("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, numero: String = ""): Fraccion? {
    while (true) {
        try {
            println("=== Ingrese la ${numero}fracción ===")
            print("Numerador: ")
            val numerador = scanner.nextInt()
            print("Denominador: ")
            val denominador = scanner.nextInt()

            return Fraccion(numerador, denominador)

        } catch (e: IllegalArgumentException) {
            println("\n❌ Error: ${e.message}")
            println("Por favor, intente nuevamente.")
            scanner.nextLine() // Limpiar buffer
        } catch (e: InputMismatchException) {
            println("\n❌ Error: Debe ingresar números enteros válidos.")
            println("Por favor, intente nuevamente.")
            scanner.nextLine() // Limpiar buffer
        }
    }
}

fun leerDecimal(scanner: Scanner): Double? {
    while (true) {
        try {
            scanner.useLocale(Locale.US) // Forzar punto como separador decimal
            print("Ingrese el número decimal (use punto como separador, ej: 2.5): ")
            val decimal = scanner.nextDouble()
            return decimal

        } catch (e: InputMismatchException) {
            println("\n❌ Error: Debe ingresar un número decimal válido.")
            println("Use punto como separador decimal (ejemplo: 2.5, -1.25, 0.333)")
            scanner.nextLine() // Limpiar buffer

            print("¿Desea intentar nuevamente? (s/n): ")
            val continuar = scanner.nextLine().lowercase()
            if (continuar != "s" && continuar != "si") {
                return null
            }
        }
    }
}

fun realizarSuma(scanner: Scanner) {
    println("\n=== SUMA DE FRACCIONES ===")
    val fraccion1 = leerFraccion(scanner, "primera ") ?: return
    val fraccion2 = leerFraccion(scanner, "segunda ") ?: return

    val resultado = fraccion1.sumar(fraccion2.denominador, fraccion2.numerador)
    println("\n✅ Resultado: $fraccion1 + $fraccion2 = $resultado")
}

fun realizarResta(scanner: Scanner) {
    println("\n=== RESTA DE FRACCIONES ===")
    val fraccion1 = leerFraccion(scanner, "primera ") ?: return
    val fraccion2 = leerFraccion(scanner, "segunda ") ?: return

    val resultado = fraccion1.restar(fraccion2.denominador, fraccion2.numerador)
    println("\n✅ Resultado: $fraccion1 - $fraccion2 = $resultado")
}

fun realizarMultiplicacion(scanner: Scanner) {
    println("\n=== MULTIPLICACIÓN DE FRACCIONES ===")
    val fraccion1 = leerFraccion(scanner, "primera ") ?: return
    val fraccion2 = leerFraccion(scanner, "segunda ") ?: return

    val resultado = fraccion1.multiplicar(fraccion2.denominador, fraccion2.numerador)
    println("\n✅ Resultado: $fraccion1 × $fraccion2 = $resultado")
}

fun realizarDivision(scanner: Scanner) {
    println("\n=== DIVISIÓN DE FRACCIONES ===")
    val fraccion1 = leerFraccion(scanner, "primera ") ?: return
    val fraccion2 = leerFraccion(scanner, "segunda ") ?: return

    val resultado = fraccion1.dividir(fraccion2.denominador, fraccion2.numerador)
    println("\n✅ Resultado: $fraccion1 ÷ $fraccion2 = $resultado")
}

fun realizarComparacion(scanner: Scanner) {
    println("\n=== COMPARACIÓN DE FRACCIONES ===")
    val fraccion1 = leerFraccion(scanner, "primera ") ?: return
    val fraccion2 = leerFraccion(scanner, "segunda ") ?: return

    val resultado = fraccion1.comparador(fraccion2.numerador, fraccion2.denominador)
    println("\n✅ Resultado: $fraccion1 es $resultado que $fraccion2")
}

fun convertirADecimal(scanner: Scanner) {
    println("\n=== CONVERSIÓN A DECIMAL ===")
    val fraccion = leerFraccion(scanner) ?: return

    val decimal = fraccion.aDecimal()
    println("\n✅ Resultado: $fraccion = $decimal")
}

fun crearDesdeDecimal(scanner: Scanner) {
    println("\n=== CREAR FRACCIÓN DESDE DECIMAL ===")
    val decimal = leerDecimal(scanner) ?: return

    try {
        val fraccion = Fraccion.desdeDecimal(decimal)
        println("\n✅ Resultado: $decimal = $fraccion")
        println("Verificación: ${fraccion.aDecimal()}")

    } catch (e: IllegalArgumentException) {
        println("\n❌ Error: ${e.message}")
    }
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")

    val f1 = Fraccion(1, 2)  // 1/2
    val f2 = Fraccion(1, 3)  // 1/3

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1.sumar(f2.denominador, f2.numerador)}")
    println("Resta: $f1 - $f2 = ${f1.restar(f2.denominador, f2.numerador)}")
    println("Multiplicación: $f1 × $f2 = ${f1.multiplicar(f2.denominador, f2.numerador)}")
    println("División: $f1 ÷ $f2 = ${f1.dividir(f2.denominador, f2.numerador)}")
    println("Comparación: $f1 es ${f1.comparador(f2.numerador, f2.denominador)} que $f2")
    println("$f1 en decimal: ${f1.aDecimal()}")
    println("$f2 en decimal: ${f2.aDecimal()}")
}

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int

    println("¡Bienvenido a la Calculadora de Fracciones!")

    do {
        try {
            mostrarMenu()
            opcion = scanner.nextInt()
            scanner.nextLine() // Limpiar buffer después de nextInt()

            when (opcion) {
                1 -> realizarSuma(scanner)
                2 -> realizarResta(scanner)
                3 -> realizarMultiplicacion(scanner)
                4 -> realizarDivision(scanner)
                5 -> realizarComparacion(scanner)
                6 -> convertirADecimal(scanner)
                7 -> crearDesdeDecimal(scanner)
                8 -> mostrarEjemplos()
                0 -> println("\n¡Hasta luego! 👋")
                else -> println("\n❌ Opción inválida. Por favor, seleccione una opción del 0 al 8.")
            }

        } catch (e: InputMismatchException) {
            println("\n❌ Error: Debe ingresar un número válido para la opción del menú.")
            scanner.nextLine() // Limpiar buffer
            opcion = -1 // Continuar el bucle
        }

        if (opcion != 0) {
            println("\nPresione Enter para continuar...")
            scanner.nextLine()
        }

    } while (opcion != 0)

    scanner.close()
}