import java.util.*;

public class Grafo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== REPRESENTACION DE GRAFOS =====");
        System.out.println("1. Matriz de Adyacencia");
        System.out.println("2. Lista de Adyacencia");
        System.out.print("Seleccione una opcion: ");

        int opcion = sc.nextInt();

        System.out.print("Ingrese la cantidad de nodos: ");
        int nodos = sc.nextInt();

        switch (opcion) {

            case 1:
                matrizAdyacencia(sc, nodos);
                break;

            case 2:
                listaAdyacencia(sc, nodos);
                break;

            default:
                System.out.println("Opcion no valida");
        }

        sc.close();
    }

    // ================= MATRIZ DE ADYACENCIA =================
    public static void matrizAdyacencia(Scanner sc, int nodos) {

        int[][] matriz = new int[nodos][nodos];

        System.out.print("Ingrese la cantidad de aristas: ");
        int aristas = sc.nextInt();

        for (int i = 0; i < aristas; i++) {

            System.out.println("\nArista " + (i + 1));

            System.out.print("Nodo origen: ");
            int origen = sc.nextInt();

            System.out.print("Nodo destino: ");
            int destino = sc.nextInt();
            
            matriz[origen][destino] = 1;
            matriz[destino][origen] = 1; // Grafo no dirigido
        }

        // Mostrar matriz
        System.out.println("\n===== MATRIZ DE ADYACENCIA =====");

        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ================= LISTA DE ADYACENCIA =================
    public static void listaAdyacencia(Scanner sc, int nodos) {

        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();

        for (int i = 0; i < nodos; i++) {
            lista.add(new ArrayList<>());
        }

        System.out.print("Ingrese la cantidad de aristas: ");
        int aristas = sc.nextInt();

        for (int i = 0; i < aristas; i++) {

            System.out.println("\nArista " + (i + 1));

            System.out.print("Nodo origen: ");
            int origen = sc.nextInt();

            System.out.print("Nodo destino: ");
            int destino = sc.nextInt();

            lista.get(origen).add(destino);
            lista.get(destino).add(origen); // Grafo no dirigido
        }

        // Mostrar lista
        System.out.println("\n===== LISTA DE ADYACENCIA =====");

        for (int i = 0; i < nodos; i++) {

            System.out.print(i + " -> ");

            for (Integer vecino : lista.get(i)) {
                System.out.print(vecino + " ");
            }

            System.out.println();
        }
    }
}