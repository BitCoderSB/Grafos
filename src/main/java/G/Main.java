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
        
        Grafo g = new Grafo(6);

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarVertice("E");
        g.agregarVertice("F");

        g.agregarArista("A", "B", 2);
        g.agregarArista("B", "A", 2);

        g.agregarArista("B", "E", 6);
        g.agregarArista("E", "B", 6);

        g.agregarArista("E", "C", 9);
        g.agregarArista("C", "E", 9);

        g.agregarArista("C", "F", 3);
        g.agregarArista("F", "C", 3);

        g.agregarArista("F", "D", 2);
        g.agregarArista("D", "F", 2);

        g.agregarArista("D", "A", 8);
        g.agregarArista("A", "D", 8);

        g.agregarArista("B", "D", 5);
        g.agregarArista("D", "B", 5);
        
        g.agregarArista("D", "E", 3);
        g.agregarArista("E", "D", 3);

        g.agregarArista("E", "F", 1);
        g.agregarArista("F", "E", 1);


        g.mostrarMatriz();


        System.out.println();

        g.BFS("A");
        g.restore();

        System.out.println();
        g.DFS("A");

    }
    
}
