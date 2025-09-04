import java.util.Scanner;

public class EleccionesPremier {

    // Variables para los votos de cada candidato
    static int votosCandidato1 = 0;
    static int votosCandidato2 = 0;
    static int votosCandidato3 = 0;

    // Variables para los votos por tipo de publicidad
    static int votosInternet = 0;
    static int votosRadio = 0;
    static int votosTelevision = 0;

    // Costos por tipo de publicidad
    static final int COSTO_INTERNET = 700000;
    static final int COSTO_RADIO = 200000;
    static final int COSTO_TELEVISION = 600000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    votar(scanner);
                    break;
                case 2:
                    calcularCostoCampana();
                    break;
                case 3:
                    vaciarUrnas();
                    break;
                case 4:
                    mostrarTotalVotos();
                    break;
                case 5:
                    mostrarPorcentajeVotos();
                    break;
                case 6:
                    calcularCostoPromedioCampana();
                    break;
                case 7:
                    anunciarGanador();
                    break;
                case 8:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Elecciones Premier ---");
        System.out.println("1. Votar");
        System.out.println("2. Calcular costo de campaña por candidato");
        System.out.println("3. Vaciar todas las urnas");
        System.out.println("4. Conocer el número total de votos");
        System.out.println("5. Porcentaje de votos por candidato");
        System.out.println("6. Costo promedio de campaña en las elecciones");
        System.out.println("7. Conocer el candidato ganador");
        System.out.println("8. Salir");
    }

    public static void votar(Scanner scanner) {
        System.out.println("\n--- Votar ---");
        System.out.println("1. Candidato 1");
        System.out.println("2. Candidato 2");
        System.out.println("3. Candidato 3");
        System.out.print("Ingrese el número del candidato por el que desea votar: ");
        int candidatoVotado = scanner.nextInt();

        System.out.println("\n¿Qué medio publicitario influenció su voto?");
        System.out.println("1. Internet");
        System.out.println("2. Radio");
        System.out.println("3. Televisión");
        System.out.print("Ingrese el número del medio: ");
        int medioInfluencia = scanner.nextInt();

        // Incrementa los contadores de votos
        if (candidatoVotado == 1) {
            votosCandidato1++;
        } else if (candidatoVotado == 2) {
            votosCandidato2++;
        } else if (candidatoVotado == 3) {
            votosCandidato3++;
        } else {
            System.out.println("Candidato no válido.");
            return;
        }

        // Incrementa los contadores de votos por medio publicitario
        if (medioInfluencia == 1) {
            votosInternet++;
        } else if (medioInfluencia == 2) {
            votosRadio++;
        } else if (medioInfluencia == 3) {
            votosTelevision++;
        } else {
            System.out.println("Medio publicitario no válido.");
            return;
        }

        System.out.println("¡Voto registrado con éxito!");
    }

    public static void calcularCostoCampana() {
        long costoTotalCandidato1 = (long) votosInternet * COSTO_INTERNET + (long) votosRadio * COSTO_RADIO + (long) votosTelevision * COSTO_TELEVISION;
        long costoTotalCandidato2 = (long) votosInternet * COSTO_INTERNET + (long) votosRadio * COSTO_RADIO + (long) votosTelevision * COSTO_TELEVISION;
        long costoTotalCandidato3 = (long) votosInternet * COSTO_INTERNET + (long) votosRadio * COSTO_RADIO + (long) votosTelevision * COSTO_TELEVISION;

        System.out.println("\n--- Costo de Campaña ---");
        System.out.println("Costo total de campaña para el Candidato 1: $" + costoTotalCandidato1);
        System.out.println("Costo total de campaña para el Candidato 2: $" + costoTotalCandidato2);
        System.out.println("Costo total de campaña para el Candidato 3: $" + costoTotalCandidato3);
    }

    public static void vaciarUrnas() {
        votosCandidato1 = 0;
        votosCandidato2 = 0;
        votosCandidato3 = 0;
        votosInternet = 0;
        votosRadio = 0;
        votosTelevision = 0;

        System.out.println("\n¡Todas las urnas han sido vaciadas con éxito!");
    }

    public static void mostrarTotalVotos() {
        int totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3;
        System.out.println("\n--- Total de Votos ---");
        System.out.println("El número total de votos es: " + totalVotos);
    }

    public static void mostrarPorcentajeVotos() {
        int totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3;
        if (totalVotos == 0) {
            System.out.println("\nNo hay votos registrados para calcular porcentajes.");
            return;
        }

        double porcentajeCandidato1 = (double) votosCandidato1 / totalVotos * 100;
        double porcentajeCandidato2 = (double) votosCandidato2 / totalVotos * 100;
        double porcentajeCandidato3 = (double) votosCandidato3 / totalVotos * 100;

        System.out.println("\n--- Porcentaje de Votos ---");
        System.out.printf("Candidato 1: %.2f%%\n", porcentajeCandidato1);
        System.out.printf("Candidato 2: %.2f%%\n", porcentajeCandidato2);
        System.out.printf("Candidato 3: %.2f%%\n", porcentajeCandidato3);
    }

    public static void calcularCostoPromedioCampana() {
        long costoTotalGeneral = (long) votosInternet * COSTO_INTERNET + (long) votosRadio * COSTO_RADIO + (long) votosTelevision * COSTO_TELEVISION;
        int totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3;

        System.out.println("\n--- Costo Promedio de Campaña ---");
        if (totalVotos == 0) {
            System.out.println("No hay votos registrados para calcular el costo promedio.");
            return;
        }

        double costoPromedio = (double) costoTotalGeneral / totalVotos;
        System.out.printf("El costo promedio de campaña por voto es: $%.2f\n", costoPromedio);
    }

    public static void anunciarGanador() {
        System.out.println("\n--- Ganador de las Elecciones ---");
        if (votosCandidato1 > votosCandidato2 && votosCandidato1 > votosCandidato3) {
            System.out.println("El ganador es el Candidato 1 con " + votosCandidato1 + " votos.");
        } else if (votosCandidato2 > votosCandidato1 && votosCandidato2 > votosCandidato3) {
            System.out.println("El ganador es el Candidato 2 con " + votosCandidato2 + " votos.");
        } else if (votosCandidato3 > votosCandidato1 && votosCandidato3 > votosCandidato2) {
            System.out.println("El ganador es el Candidato 3 con " + votosCandidato3 + " votos.");
        } else {
            System.out.println("Hay un empate o no hay suficientes votos para determinar un ganador claro.");
        }
    }
}