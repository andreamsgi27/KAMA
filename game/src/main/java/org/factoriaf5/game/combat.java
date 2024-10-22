package org.factoriaf5.game;

import java.util.Scanner;

java.util.Scanner;

public class Combat {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
System.out.println("Un "+Monster.getName+" apareció delante de Aiden");


System.out.println("¿Que quieres hacer? \n 1. Ataque básico \n 2. Habilidad: Ataque potenciado \n 3.  Habilidad: Defensa \n 4. Usar Objeto");
int opcion =  sc.nextInt();
int turnocontador = 0;

switch (opcion) {

    case 1:

        System.out.println("Has seleccionado el ataque básico");
        System.out.println("Realizas un ataque básico que le  hace "  + Aiden.getAidenDamage() + " de daño a " + Monster.getName());
        System.out.println();
        break;

    case 2:


    break;
    default:System.out.println(" Opcion no valida , intentalo de nuevo \n ¿Que quieres hacer? \\n" + //
                " 1. Ataque básico \\n" + //
                " 2. Habilidad: Ataque potenciado \\n" + //
                " 3.  Habilidad: Defensa \\n" + //
                " 4. Usar Objeto ");
        break;

}
}

}
