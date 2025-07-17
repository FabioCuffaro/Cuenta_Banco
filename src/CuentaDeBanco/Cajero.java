package CuentaDeBanco;

import java.util.Scanner;

/**
 * Clase Cajero donde estará toda la lógica de negocio
 */

public class Cajero {

    private CuentaDeBanco cuenta;

    /**
     * Constructor del Cajero, accedemos a la clase Cuenta de Banco
     * creando un una instancia de la clase y nombrando la variable.
     * @param cuenta
     */

    public Cajero(CuentaDeBanco cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * A partir de aquí le introducimos los métodos para:
     * ver Balance, Retirar Dinero e Ingresar Dinero
     */

    public void GetBalance() {
        System.out.println("Su balance en la cuenta es de: " + cuenta.getBalance() + " €");
    }



    public void RetireMoney(double money) {
        if (cuenta.getBalance() < money) {
            System.out.println("Lo siento, saldo insuficiente, volviendo al menu...");
        } else {
            System.out.println("Usted ha retirado la cantidad de: " + money + " €");
            cuenta.setBalance(cuenta.getBalance()-money);
            System.out.println("Su saldo en la cuenta es de: " + cuenta.getBalance() + " €");
        }
    }

    public void InsertMoney(double money) {
        System.out.println("Usted ha insertado: " + money + " €");
        cuenta.setBalance(cuenta.getBalance()+money);
        System.out.println("Su saldo en la cuenta es de: " + cuenta.getBalance() + " €");
    }

    /**
     * Método que verifica la contraseña del usuario
     */

    public void Password() {
        Scanner sc = new Scanner(System.in);
        byte contador = 3; // 3 intentos totales
        boolean key = false;

        while (contador > 0 && key == false) {
            System.out.println("Por favor, teclée la contraseña para acceder:");
            String password = sc.nextLine();

            if (password.equals(cuenta.getPassword())) {
                System.out.println("Contraseña correcta. Accediendo al sistema...");
                key = true; // sale del método
            } else {
                contador--;
                if (contador == 0) {
                    System.out.println("Usted ha agotado el número de intentos");
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                } else {
                    System.out.println("Lo sentimos, vuelva a introducir la contraseña, le quedan: " + contador + " intentos");
                }
            }
        }
    }

    /**
     * Método para el Menu del FrontEnd
     */

    public void Menu() {
        System.out.println("Accediendo al menú...\n");

        byte option = 0; // opción elegida por el usuario
        Scanner sc = new Scanner(System.in);

        do {
            boolean key = false; // IMPORTANTE: reiniciar en cada iteración para permitir leer de nuevo

            // Mostrar menú
            System.out.println("==== MENÚ ====");
            System.out.println("1. Ver Balance de cuenta");
            System.out.println("2. Ingresar dinero en la cuenta");
            System.out.println("3. Retirar dinero de la cuenta");
            System.out.println("4. Salir");
            System.out.print("\nPor favor teclee el número de la opción que desea: ");

            // Validar que el usuario introduzca un número válido
            while (!key) { // más legible que key == false
                if (sc.hasNextByte()) {
                    option = sc.nextByte();
                    sc.nextLine(); // limpiar el salto de línea pendiente
                    key = true;
                } else {
                    System.out.println("Lo siento, no ha introducido un número válido, vuelva a intentarlo");
                    sc.next(); // limpiar entrada inválida
                }
            }

            // Gestionar las opciones
            switch (option) {
                case 1:
                    GetBalance();
                    System.out.println("\nVolviendo al menú...\n");
                    break;
                case 2:
                    System.out.println("¿Cuánto dinero desea insertar?");
                    if (sc.hasNextDouble()) {
                        double money = sc.nextDouble();
                        sc.nextLine(); // limpiar salto de línea
                        InsertMoney(money);
                    } else {
                        System.out.println("Cantidad inválida...");
                        sc.next(); // limpiar entrada inválida
                    }
                    System.out.println("\nVolviendo al menú...\n");
                    break;
                case 3:
                    System.out.println("¿Cuánto dinero desea retirar?");
                    if (sc.hasNextDouble()) {
                        double retire = sc.nextDouble();
                        sc.nextLine(); // limpiar salto de línea
                        RetireMoney(retire);
                    } else {
                        System.out.println("Cantidad inválida...");
                        sc.next(); // limpiar entrada inválida
                    }
                    System.out.println("\nVolviendo al menú...\n");
                    break;
                case 4:
                    System.out.println("\nHa sido un placer atenderle "+cuenta.getTitular()+". Vuelva pronto");
                    System.out.println("Saliendo de la terminal...");
                    break;
                default:
                    System.out.println("Lo siento, el número introducido no es correcto");
            }

        } while (option != 4);

        sc.close(); //Cerramos el escaner al terminar para que no produzca fallos
    }

}
