package com.api.apros.util;

public enum SystemEvent {

    INVALID_NOMBRE {
        public String toString() {
            return "nombre deber ser no nullo y menor de 30 caracteres";
        }
    },

    INVALID_APELLIDO {
        public String toString() {
            return "apellido deber ser no nullo y menor de 30 caracteres";
        }
    },
    INVALIDAD_EDAD {
        public String toString() {
            return "la edad deber ser mayor de 18 y menor a 120";
        }
    }

}
