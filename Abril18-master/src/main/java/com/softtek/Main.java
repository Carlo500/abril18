package com.softtek;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String nombreUsuario = "Paco";
        List<Integer> numeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        int posicion = 5;

        Optional<String> usuario = Optional.ofNullable(nombreUsuario);
        usuario.ifPresentOrElse(
                usuarioPresente -> System.out.println("Nombre de usuario: " + usuarioPresente),
                () -> System.out.println("Nombre de usuario inválido.")
        );

        Optional<Integer> numero = numeros.isEmpty() || posicion < 0 || posicion >= numeros.size() ?
                Optional.empty() : Optional.of(numeros.get(posicion));
        System.out.println("\nNumero: " + numero.orElse(0));
    }
}
