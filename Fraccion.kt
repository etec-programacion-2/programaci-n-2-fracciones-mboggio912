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

}