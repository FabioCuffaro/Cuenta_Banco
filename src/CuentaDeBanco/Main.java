package CuentaDeBanco;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CuentaDeBanco cuentaFabio = new CuentaDeBanco();
        cuentaFabio.setBalance(1000);
        cuentaFabio.setPassword("hola");

        Cajero cuenta = new Cajero(cuentaFabio);

        System.out.println("\nBienvenido al Cajero de Bancos S.L.\n");
        System.out.print("Introduzca su nombre: ");
        String nombre =sc.nextLine();
        cuentaFabio.setTitular(nombre);
        System.out.println("\nBuenas tardes "+cuentaFabio.getTitular());
        cuenta.Password();

        System.out.println("\nBienvenido/a "+cuentaFabio.getTitular());
        System.out.println();

        cuenta.Menu();



    }
}
