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
            var numeradornew = (this.numerador * denominador - numerador * this.denominador)
            var denominadornew = (this.denominador * denominador)
            var finalfuncion = simplifyFraction(numeradornew, denominadornew)
            return finalfuncion
        }

    }



}