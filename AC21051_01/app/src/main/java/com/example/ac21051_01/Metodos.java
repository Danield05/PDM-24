package com.example.ac21051_01;

public class Metodos {
    public static String suma(float valor1, float valor2, float valor3) {
        String sumastr;
        float sumafloat= valor1+valor2 + valor3;
        sumastr = String.valueOf(sumafloat);
        return sumastr;
    }
    public static String resta(float valor1, float valor2, float valor3) {
        String restastr;
        float restafloat= valor1-valor2 - valor3;
        restastr = String.valueOf(restafloat);
        return restastr;
    }
    public static String mult(float valor1, float valor2, float valor3) {
        if (valor3 > 0) {
            String multstr;
            float multfloat = valor1 * valor2 * valor3;
            multstr = String.valueOf(multfloat);
            return multstr;
        } else {
            return "El tercer parámetro debe ser mayor que 0";
        }
    }

}
