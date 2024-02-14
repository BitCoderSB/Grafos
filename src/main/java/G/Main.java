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
        
        Grafo g = new Grafo(9);

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarVertice("E");
        g.agregarVertice("F");
        g.agregarVertice("G");
        g.agregarVertice("H");
        g.agregarVertice("I");

        g.mostrarVertices();
        System.out.println();
        g.agregarArista("A", "B", 3);
        g.agregarArista("A", "G", 1);
        g.agregarArista("A", "D", 1);
        g.agregarArista("B", "C", 8);
        g.agregarArista("B", "G", 6);
        g.agregarArista("C", "H", 7);
        g.agregarArista("C", "I", 1);
        g.agregarArista("D", "G", 3);
        g.agregarArista("D", "E", 10);
        g.agregarArista("F", "H", 5);
        g.agregarArista("F", "I", 8);
        g.agregarArista("E", "G", 9);
        g.agregarArista("E", "F", 2);
        g.agregarArista("H", "I", 6);

        g.mostrarMatriz();
        System.out.println();
        g.getDegree("A");
        System.out.println();
        g.eliminarVertice("A");
        g.mostrarVertices();
        g.mostrarMatriz();
        System.out.println();
        g.getDegree("A");

        g.getDegree("B");
        g.agregarArista("A", "Z",7);
        g.eliminarVertice("Y");
        g.eliminarArista("A", "Z");

    }
    
}
