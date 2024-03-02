/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package G;

/**
 *
 * @author Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo g = new Grafo(7); // Crear un grafo con 7 vértices

        // Agregar los vértices al grafo
        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarVertice("E");
        g.agregarVertice("F");
        g.agregarVertice("G");

        // Agregar las aristas al grafo
        g.agregarArista("A", "B", 2);
        g.agregarArista("B", "A", 2);

        g.agregarArista("A", "C", 4);
        g.agregarArista("C", "A", 4);

        g.agregarArista("A", "D", 1);
        g.agregarArista("D", "A", 1);

        g.agregarArista("B", "D", 3);
        g.agregarArista("D", "B", 3);

        g.agregarArista("B", "E", 10);
        g.agregarArista("E", "B", 10);

        g.agregarArista("C", "D", 2);
        g.agregarArista("D", "C", 2);

        g.agregarArista("C", "F", 5);
        g.agregarArista("F", "C", 5);

        g.agregarArista("D", "E", 2);
        g.agregarArista("E", "D", 2);

        g.agregarArista("D", "F", 8);
        g.agregarArista("F", "D", 8);

        g.agregarArista("E", "G", 6);
        g.agregarArista("G", "E", 6);

        g.agregarArista("F", "G", 1);
        g.agregarArista("G", "F", 1);

        g.agregarArista("D", "G", 4);
        g.agregarArista("G", "D", 4);

        g.mostrarMatriz();
        System.out.println();

        g.Dijkstra("C", "E");
    }  
}
