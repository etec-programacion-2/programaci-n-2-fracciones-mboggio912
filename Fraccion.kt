package org.example

class Fraccion (_numerador: Int, _denominador: Int) {
    var numerador: Int = _numerador
        get() = field
        set(value) { field = value }

    var denominador: Int = _denominador
        get() = field
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    fun validador(denominador: Int){

    }

    override fun toString(): String {
        if (denominador == 0){
            return "EL denominador no puede ser cero"
        }
        else {
            return "$numerador/$denominador"
        }
    }

    fun mostrar(){
        var mostrando = toString()
        return println(mostrando)
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun simplifyFraction(numerador: Int, denominador: Int): String {
        val commonDivisor = gcd(numerador, denominador)
        var newnumerador = (numerador / commonDivisor)
        var newdenominador = (denominador / commonDivisor)
        return  "$newnumerador/$newdenominador"
    }

    fun sumar(denominador: Int, numerador: Int): String{
        if (denominador == 0 || this.denominador == 0){
            return "El denominador no puede ser cero"
        }
        else {
            var numeradornew = (this.numerador * denominador + numerador * this.denominador)
            var denominadornew = (this.denominador * denominador)
            var finalfuncion = simplifyFraction(numeradornew, denominadornew)
            return finalfuncion
        }
    }
    fun restar(denominador: Int, numerador: Int): String{
        if (denominador == 0 || this.denominador == 0){
            return "El denominador no puede ser cero"
        }
        else {
            var numeradornew = this.numerador * denominador - numerador * this.denominador
            var denominadornew = (this.denominador * denominador)
            var finalfuncion = simplifyFraction(numeradornew, denominadornew)
            return finalfuncion
        }

    }

    fun multiplicar(denominador: Int, numerador: Int): String{
        if (denominador == 0 || this.denominador == 0){
            return "El denominador no puede ser cero"
        }
        else {
            var numeradornew = (this.numerador * numerador)
            var denominadornew = (this.denominador * denominador)
            var finalfuncion = simplifyFraction(numeradornew, denominadornew)
            return finalfuncion
        }

    }

    fun dividir(denominador: Int, numerador: Int): String{
        if (numerador == 0  || this.denominador == 0){
            return "El denominador no puede ser cero"
        }

        else {
            var denominadornew = (this.numerador * denominador)
            var numeradornew = (this.denominador * numerador)
            var finalfuncion = simplifyFraction(numeradornew, denominadornew)
            return finalfuncion
        }

    }




    fun esMayor (numerador: Int, denominador: Int): String{
        var frac1 =this.numerador / this.denominador
        var frac2 = numerador / denominador
        if (frac1 > frac2){
            return "mayor"
        }
        else if (frac2 > frac1){
            return "menor"
        }
        else return "igual"

    }

    fun aDecimal (): Float{
        var decimal = (this.numerador / this.denominador).toFloat()
        return decimal

    }

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            // Casos especiales
            if (decimal == 0.0) return Fraccion(0, 1)
            if (decimal.isNaN() || decimal.isInfinite()) {
                throw IllegalArgumentException("No se puede convertir NaN o infinito a fracción")
            }

            // Determinar si es negativo
            val esNegativo = decimal < 0
            val decimalAbs = kotlin.math.abs(decimal)

            // Convertir a string para analizar los decimales
            val decimalStr = decimalAbs.toString()

            // Separar parte entera y decimal
            val partes = decimalStr.split(".")
            val parteEntera = partes[0].toLong()

            if (partes.size == 1 || partes[1] == "0") {
                // Es un número entero
                val resultado = if (esNegativo) -parteEntera.toInt() else parteEntera.toInt()
                return Fraccion(resultado, 1)
            }

            val parteDecimal = partes[1]
            val numDigitosDecimales = parteDecimal.length

            // Crear fracción: decimal = parteEntera + parteDecimal/10^numDigitos
            val denominadorBase = kotlin.math.pow(10.0, numDigitosDecimales.toDouble()).toLong()
            val numeradorDecimal = parteDecimal.toLong()
            val numeradorTotal = parteEntera * denominadorBase + numeradorDecimal

            // Aplicar signo si es necesario
            val numeradorFinal = if (esNegativo) -numeradorTotal.toInt() else numeradorTotal.toInt()

            return Fraccion(numeradorFinal, denominadorBase.toInt())
        }
    }





}

