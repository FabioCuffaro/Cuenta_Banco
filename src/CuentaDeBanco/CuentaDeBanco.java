package CuentaDeBanco;

/**
 * Clase de la que se recogeran Titular, Balance y Contraseña
 * Getters Y Setters para acceder a los datos
 */

public class CuentaDeBanco {

    private String titular;
    private double balance;
    private String password;


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
