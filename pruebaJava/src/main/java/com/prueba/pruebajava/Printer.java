package com.prueba.pruebajava;

import com.prueba.pruebajava.Prime.*;

public class Printer {
    public static void main(String[] args) {
        //Instancia el objeto Prime
        Prime prime = new Prime();
        //Genera los nros primos
        prime.getPrimes();
        //genera la paginación de los números primos generados
        prime.paginate();       
    }
}