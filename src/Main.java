import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Cuenta> cuentas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int opcionCuenta;
        int opcionOperacion;


        for(int i = 1; i <= 3; i++){
            System.out.println("Crear la cuenta");
            Cuenta cuenta = new Cuenta();

            System.out.println("Ingrese el nombre del cuenta: " + i);
            cuenta.setNumeroCuenta(teclado.nextInt());

            System.out.println("Ingrese el DNI de la cuenta: " + i);
            cuenta.setDniCuenta(teclado.nextInt());

            System.out.println("Ingrese el saldo de la cuenta: " + i);
            cuenta.setSaldo(teclado.nextDouble());

            teclado.nextLine();

            cuentas.add(cuenta);
        }

        // Bucle principal para el menú de selección de cuenta
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("Seleccione una cuenta:");
            for (int i = 0; i < cuentas.size(); i++) {
                System.out.println((i + 1) + ". Cuenta Numero: " + cuentas.get(i).getNumeroCuenta());
            }
            System.out.println("0. Salir");

            System.out.print("Ingrese su opción: ");
            opcionCuenta = teclado.nextInt();

            if (opcionCuenta >= 1 && opcionCuenta <= 3) {
                Cuenta cuentaSeleccionada = cuentas.get(opcionCuenta - 1);

                // Bucle para el submenú de operaciones
                do {
                    System.out.println("\n--- OPERACIONES PARA LA CUENTA #" + cuentaSeleccionada.getNumeroCuenta() + " ---");
                    System.out.println("1. Consultar Saldo");
                    System.out.println("2. Depositar Dinero");
                    System.out.println("3. Retirar Dinero");
                    System.out.println("4. Extracción Rápida (20%)");
                    System.out.println("5. Consultar Datos");
                    System.out.println("0. Volver al menú principal");

                    System.out.print("Ingrese su opción: ");
                    opcionOperacion = teclado.nextInt();

                    double cantidad;
                    switch (opcionOperacion) {
                        case 1:
                            cuentaSeleccionada.consultarsaldo();
                            break;
                        case 2:
                            System.out.print("Ingrese la cantidad a depositar: ");
                            cantidad = teclado.nextDouble();
                            cuentaSeleccionada.depositar(cantidad);
                            break;
                        case 3:
                            System.out.print("Ingrese la cantidad a retirar: ");
                            cantidad = teclado.nextDouble();
                            cuentaSeleccionada.retirar(cantidad);
                            break;
                        case 4:
                            System.out.print("Ingrese la cantidad para extracción rápida: ");
                            cantidad = teclado.nextDouble();
                            cuentaSeleccionada.extraccionrapida(cantidad);
                            break;
                        case 5:
                            cuentaSeleccionada.consultardatos();
                            break;
                        case 0:
                            System.out.println("Volviendo al menú principal...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                } while (opcionOperacion != 0);

            } else if (opcionCuenta != 0) {
                System.out.println("Número de cuenta no válido. Por favor, intente de nuevo.");
            }

        } while (opcionCuenta != 0);
        System.out.println("\nGracias por usar el sistema bancario.");
        teclado.close();

    }
}