package org.example

import java.util.Scanner
import java.util.InputMismatchException

/**
 * CLI (Command Line Interface) para la calculadora de fracciones
 * Este programa permite al usuario interactuar con las fracciones desde la consola
 */

/**
 * Muestra el menú principal con todas las opciones disponibles
 */
fun mostrarMenu() {
    println("\n" + "=".repeat(40))
    println("    CALCULADORA DE FRACCIONES")
    println("=".repeat(40))
    println("1. Sumar fracciones")
    println("2. Restar fracciones") 
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    println("=".repeat(40))
    print("Ingrese su opción: ")
}

/**
 * Lee una fracción del usuario de forma segura
 * @param scanner El scanner para leer la entrada
 * @param mensaje El mensaje a mostrar al usuario
 * @return La fracción leída o null si hay error
 */
fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion? {
    return try {
        println("\n$mensaje")
        print("Numerador: ")
        val numerador = scanner.nextInt()
        print("Denominador: ")
        val denominador = scanner.nextInt()
        
        Fraccion(numerador, denominador)
        
    } catch (e: InputMismatchException) {
        println("❌ Error: Debe ingresar números enteros.")
        scanner.nextLine() // Limpiar el buffer
        null
    } catch (e: IllegalArgumentException) {
        println("❌ Error: ${e.message}")
        null
    }
}

/**
 * Realiza la suma de dos fracciones
 */
fun realizarSuma(scanner: Scanner) {
    println("\n--- SUMA DE FRACCIONES ---")
    
    val fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    if (fraccion1 == null) return
    
    val fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")  
    if (fraccion2 == null) return
    
    val resultado = fraccion1 + fraccion2
    
    println("\n✅ RESULTADO:")
    println("$fraccion1 + $fraccion2 = $resultado")
    println("En decimal: ${resultado.aDecimal()}")
}

/**
 * Realiza la resta de dos fracciones
 */
fun realizarResta(scanner: Scanner) {
    println("\n--- RESTA DE FRACCIONES ---")
    
    val fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    if (fraccion1 == null) return
    
    val fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    if (fraccion2 == null) return
    
    val resultado = fraccion1 - fraccion2
    
    println("\n✅ RESULTADO:")
    println("$fraccion1 - $fraccion2 = $resultado")
    println("En decimal: ${resultado.aDecimal()}")
}

/**
 * Realiza la multiplicación de dos fracciones
 */
fun realizarMultiplicacion(scanner: Scanner) {
    println("\n--- MULTIPLICACIÓN DE FRACCIONES ---")
    
    val fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    if (fraccion1 == null) return
    
    val fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    if (fraccion2 == null) return
    
    val resultado = fraccion1 * fraccion2
    
    println("\n✅ RESULTADO:")
    println("$fraccion1 × $fraccion2 = $resultado")
    println("En decimal: ${resultado.aDecimal()}")
}

/**
 * Realiza la división de dos fracciones
 */
fun realizarDivision(scanner: Scanner) {
    println("\n--- DIVISIÓN DE FRACCIONES ---")
    
    val fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción (dividendo):")
    if (fraccion1 == null) return
    
    val fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción (divisor):")
    if (fraccion2 == null) return
    
    try {
        val resultado = fraccion1 / fraccion2
        
        println("\n✅ RESULTADO:")
        println("$fraccion1 ÷ $fraccion2 = $resultado")
        println("En decimal: ${resultado.aDecimal()}")
        
    } catch (e: IllegalArgumentException) {
        println("❌ Error: ${e.message}")
    }
}

/**
 * Compara dos fracciones
 */
fun realizarComparacion(scanner: Scanner) {
    println("\n--- COMPARACIÓN DE FRACCIONES ---")
    
    val fraccion1 = leerFraccion(scanner, "Ingrese la primera fracción:")
    if (fraccion1 == null) return
    
    val fraccion2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
    if (fraccion2 == null) return
    
    println("\n✅ RESULTADOS DE COMPARACIÓN:")
    println("Fracción 1: $fraccion1 (${fraccion1.aDecimal()})")
    println("Fracción 2: $fraccion2 (${fraccion2.aDecimal()})")
    
    when {
        fraccion1.esMayor(fraccion2) -> {
            println("🔺 $fraccion1 es MAYOR que $fraccion2")
        }
        fraccion1.esMenor(fraccion2) -> {
            println("🔻 $fraccion1 es MENOR que $fraccion2")
        }
        else -> {
            println("⚖️ Las fracciones son IGUALES")
        }
    }
    
    // Información adicional
    println("\nComparación detallada:")
    println("• ¿$fraccion1 > $fraccion2? ${fraccion1.esMayor(fraccion2)}")
    println("• ¿$fraccion1 < $fraccion2? ${fraccion1.esMenor(fraccion2)}")
    println("• ¿$fraccion1 = $fraccion2? ${fraccion1 == fraccion2}")
}

/**
 * Convierte una fracción a decimal
 */
fun convertirADecimal(scanner: Scanner) {
    println("\n--- CONVERSIÓN A DECIMAL ---")
    
    val fraccion = leerFraccion(scanner, "Ingrese la fracción a convertir:")
    if (fraccion == null) return
    
    val decimal = fraccion.aDecimal()
    
    println("\n✅ RESULTADO:")
    println("$fraccion = $decimal")
    
    // Información adicional
    when {
        decimal % 1.0 == 0.0 -> println("📝 Es un número entero")
        decimal.toString().length > 10 -> println("📝 Es un decimal con muchas cifras")
        else -> println("📝 Es un decimal finito")
    }
}

/**
 * Crea una fracción desde un número decimal
 */
fun crearDesdeDecimal(scanner: Scanner) {
    println("\n--- CREAR FRACCIÓN DESDE DECIMAL ---")
    
    try {
        print("Ingrese el número decimal: ")
        val decimal = scanner.nextDouble()
        
        val fraccion = Fraccion.desdeDecimal(decimal)
        
        println("\n✅ RESULTADO:")
        println("$decimal = $fraccion")
        println("Verificación: $fraccion = ${fraccion.aDecimal()}")
        
    } catch (e: InputMismatchException) {
        println("❌ Error: Debe ingresar un número decimal válido.")
        scanner.nextLine() // Limpiar buffer
    } catch (e: IllegalArgumentException) {
        println("❌ Error: ${e.message}")
    }
}

/**
 * Muestra ejemplos predefinidos de todas las operaciones
 */
fun mostrarEjemplos() {
    println("\n" + "=".repeat(50))
    println("           EJEMPLOS PREDEFINIDOS")
    println("=".repeat(50))
    
    // Crear fracciones de ejemplo
    val f1 = Fraccion(1, 2)  // 1/2
    val f2 = Fraccion(1, 3)  // 1/3
    val f3 = Fraccion(2, 4)  // 2/4 = 1/2
    val f4 = Fraccion(3, 4)  // 3/4
    
    println("📚 Fracciones de ejemplo:")
    println("• Fracción A: $f1 (${f1.aDecimal()})")
    println("• Fracción B: $f2 (${f2.aDecimal()})")
    println("• Fracción C: $f3 (${f3.aDecimal()}) - se simplifica automáticamente")
    println("• Fracción D: $f4 (${f4.aDecimal()})")
    
    println("\n🧮 OPERACIONES BÁSICAS:")
    println("Suma:           $f1 + $f2 = ${f1 + f2}")
    println("Resta:          $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 × $f2 = ${f1 * f2}")
    println("División:       $f1 ÷ $f2 = ${f1 / f2}")
    
    println("\n🔍 COMPARACIONES:")
    println("¿$f1 > $f2? ${f1.esMayor(f2)} (${f1.aDecimal()} > ${f2.aDecimal()})")
    println("¿$f1 < $f4? ${f1.esMenor(f4)} (${f1.aDecimal()} < ${f4.aDecimal()})")
    println("¿$f1 = $f3? ${f1 == f3} (ambos equivalen a ${f1.aDecimal()})")
    
    println("\n🔄 CONVERSIONES:")
    println("$f4 en decimal: ${f4.aDecimal()}")
    val desdeDecimal = Fraccion.desdeDecimal(0.25)
    println("0.25 como fracción: $desdeDecimal")
    
    println("\n💡 CASOS ESPECIALES:")
    val negativa = Fraccion(-3, 4)
    val cero = Fraccion(0, 5)
    val entero = Fraccion(10, 2)
    println("Fracción negativa: $negativa")
    println("Fracción cero: $cero") 
    println("Fracción entera: $entero")
}

/**
 * Espera que el usuario presione Enter para continuar
 */
fun esperarEnter(scanner: Scanner) {
    println("\n" + "-".repeat(40))
    println("Presione Enter para continuar...")
    scanner.nextLine() // Limpiar buffer
    scanner.nextLine() // Esperar Enter
}

/**
 * Función principal - punto de entrada del programa
 */
fun main() {
    // Crear el scanner para leer entradas del usuario
    val scanner = Scanner(System.`in`)
    var opcion: Int
    
    println("🎉 ¡Bienvenido a la Calculadora de Fracciones!")
    
    // Bucle principal del programa
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
                0 -> {
                    println("\n👋 ¡Gracias por usar la Calculadora de Fracciones!")
                    println("¡Hasta luego!")
                }
                else -> println("❌ Opción inválida. Por favor, elija una opción entre 0 y 8.")
            }
            
            // Pausa después de cada operación (excepto salir)
            if (opcion != 0) {
                esperarEnter(scanner)
            }
            
        } catch (e: InputMismatchException) {
            println("❌ Error: Debe ingresar un número entero.")
            scanner.nextLine() // Limpiar buffer
            opcion = -1 // Continuar el bucle
        }
        
    } while (opcion != 0)
    
    // Cerrar el scanner
    scanner.close()
}