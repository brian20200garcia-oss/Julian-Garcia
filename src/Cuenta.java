public class Cuenta {
    private int NumeroCuenta;
    private int dniCuenta;
    private double saldo;


    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, int dniCuenta, double saldo) {
        NumeroCuenta = numeroCuenta;
        this.dniCuenta = dniCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public int getDniCuenta() {
        return dniCuenta;
    }

    public void setDniCuenta(int dniCuenta) {
        this.dniCuenta = dniCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Metodo para depositar
    public void depositar(double valor){
        saldo = saldo + valor;
        System.out.println("Saldo depositado: " + valor + "Saldo atual: " + saldo);
    }

    //Metodo para retirar
    public void retirar(double valor){
        saldo = saldo - valor;
        System.out.println("Saldo retirado: " + valor + "Saldo atual: " + saldo);
    }

    //Metodo extraccion rapida
    public void extraccionrapida(double valor){
        double limite = saldo * 0.20;
        if(valor > limite){
            System.out.println("No puede extraer mas del 20%");
        }else{
            saldo = saldo - valor;
            System.out.println("Saldo extraer: " + valor + "Saldo atual: " + saldo);
        }
    }

    //Metodo consultar saldo
    public void consultarsaldo(){
        System.out.println("Saldo consultado: " + saldo);
    }


    //Metodo Consultar Datos
    public void consultardatos(){
        System.out.println("DATOS DE LA CUENTA");
        System.out.println("Numero de cuenta: " + NumeroCuenta);
        System.out.println("DNI cuenta: " + dniCuenta);
        System.out.println("Saldo Actual: " + saldo);
    }


}
