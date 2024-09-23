import java.util.Scanner;

public class Cliente extends Pessoa {
    private float saldo;
    private float deposito;


    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getDeposito() {
        return this.deposito;
    }

    public void setDeposito(float deposito) {
        this.deposito = deposito;
    }
}