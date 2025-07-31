package org.example
import kotlin.math.pow
import java.util.Scanner
fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    println("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner): Fraccion {
    print("Numerador: ")
    val numerador = scanner.nextInt()
    print("Denominador: ")
    val denominador = scanner.nextInt()
    return Fraccion(numerador, denominador)
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")

    val f1 = Fraccion(1, 2)  // 1/2
    val f2 = Fraccion(1, 3)  // 1/3

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1.sumar(f2.denominador, f2.numerador)}")
    println("Resta: $f1 - $f2 = ${f1.restar(f2.denominador, f2.numerador)}")
    println("Multiplicación: $f1 * $f2 = ${f1.multiplicar(f2.denominador, f1.numerador)}")
    println("División: $f1 / $f2 = ${f1.dividir(f2.denominador, f1.numerador)}")
    println("¿$f1 > $f2? La primera fraccion es ${f1.comparador(f2.numerador, f2.denominador)} en comparacion a la otra")

    println("$f1 en decimal: ${f1.aDecimal()}")
}


fun main() {


    val scanner = Scanner(System.`in`)
    mostrarMenu()
    val principal = scanner.nextInt()

    if (principal == 1) {

        var fraccion = leerFraccion(scanner)
        println("definir segunda fraccion")
        var fraccion2 = leerFraccion(scanner, )
        var suma = fraccion.sumar(fraccion2.denominador, fraccion2.numerador)
        println("La suma es igual a: $suma")

    }
    else if (principal == 2) {

        var fraccion = leerFraccion(scanner)
        println("definir segunda fraccion")
        var fraccion2 = leerFraccion(scanner, )
        var resta = fraccion.restar(fraccion2.denominador, fraccion2.numerador)
        println("La resta es igual a: $resta")
    }
    else if (principal == 3) {


        var fraccion = leerFraccion(scanner, )
        println("definir segunda fraccion")
        var fraccion2 = leerFraccion(scanner, )
        var mult = fraccion.multiplicar(fraccion2.denominador, fraccion2.numerador)


        println("La multiplicacion es igual a: $mult ")
    }
    else if (principal == 4) {

        var fraccion = leerFraccion(scanner, )
        println("definir segunda fraccion")
        var fraccion2 = leerFraccion(scanner, )
        var div = fraccion.dividir(fraccion2.denominador, fraccion2.numerador)

        println("La division es igual a: $div")
    }
    else if (principal == 5) {

        var fraccion = leerFraccion(scanner, )
        println("definir segunda fraccion")
        var fraccion2 = leerFraccion(scanner, )
        var com = fraccion.comparador(fraccion2.denominador, fraccion2.numerador)
        println("La primera fraccion es $com en comparacion a la otra")
    }
    else if (principal == 6) {

        var fraccion = leerFraccion(scanner, )
        var decimal = fraccion.aDecimal()
        println("La fraccion convertia a decimal es igual a: $decimal")
    }
    else if (principal == 7) {
         println("El decimal, que tine que ser si o si un numero con coma, (ejemplo 2,0, 2,54, 0,3, -3,0) " +
                 "pasado a fraccion es igual a: ")
        var decimal = scanner.nextDouble()
        var decimalpasadoafrac = Fraccion.desdeDecimal(decimal)
        println(decimalpasadoafrac)
    }
    else if (principal == 8) {
         println("LOs ejemplos predefinidos son: ")
        mostrarEjemplos()
    }




}