/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Carlos
 */



class Vertice {

    public String name;
    public int degree;
    public boolean visited;
    public int pesoT; 
    public int pesoF;

    public Vertice(String name){
        this.name = name;
        degree = 0;
        visited = false;

        pesoF = -1;
        pesoT = Integer.MAX_VALUE;

    }

    public int getDegree(){
        return degree;
    }
    
    public String getName(){
        return name;
    }
}





public class Grafo {

    private int[][] M;
    private String[] array;
    private int cont;
    private HashMap<String, Vertice> vertices;
    private Stack<Integer> pila;
    private Queue<Integer> cola;
    private boolean a;

    public Grafo(int n){

        M = new int[n][n];
        cont = 0;
        vertices = new HashMap<>();
        array = new String[n];
        a = true;
        pila = new Stack<Integer>();
        cola = new LinkedList<Integer>();

        for(int i = 0; i < n; i++){
            array[i] = "nd";
        }

    }
    
    public boolean agregarVertice(String name){
        if(cont <= M.length && !vertices.containsKey(name)){
            Vertice v = new Vertice(name);
            vertices.put(name, v);

            for(int i = 0; i < array.length; i++){
                if(array[i].equals("nd")){
                    array[i] = name;
                    break;
                }
            }

            cont++;
            return true;
        }
        System.out.println("Ya existe el vertice");
        return false;
    }

    public boolean eliminarVertice(String name){

        if(vertices.containsKey(name)){
            filtrar(name);
            vertices.remove(name);
            array[index(name)] = "nd";
            cont--;
            return true;
        }
        System.out.println("No existe el vertice");
        return false;
    }


    public boolean agregarArista(String v1, String v2){

        if(vertices.containsKey(v1) && vertices.containsKey(v2)){
            Vertice v = vertices.get(v1);
            v.degree++;

            M[index(v1)][index(v2)] = 1;

            return true;
        }
        System.out.println("No existe un vertice");
        return false;
    }

    public boolean agregarArista(String v1, String v2, int peso){
        
        if(vertices.containsKey(v1) && vertices.containsKey(v2)){
            Vertice v = vertices.get(v1);
            v.degree++;
            M[index(v1)][index(v2)] = peso;
            return true;
        }
        System.out.println("No existe un vertice");
        return false;
    }


    public boolean eliminarArista(String v1, String v2){

        if(vertices.containsKey(v1) && vertices.containsKey(v2) && M[index(v1)][index(v2)] != 0){
            M[index(v1)][index(v2)] = 0;
            Vertice v = vertices.get(v1);
            v.degree--;
            return true;
        }

        System.out.println("No existe la relacion entre los vertices");
        return false;
    }

    public void mostrarMatriz(){

        if(vertices.isEmpty()){
            System.out.println("No hay ningun vertice");
            return;
        }
        System.out.print("\t");
        for(int i = 0; i < array.length; i++){
            if(!array[i].equals("nd")){
                System.out.print(array[i] + "\t");
            }
            
        }
        System.out.println("\n");
        for(int i = 0; i < array.length; i++){
            
            if(!array[i].equals("nd")){
                System.out.print(array[i] + "\t");
            }
            
            for(int j = 0; j < array.length; j++){
                if(!array[i].equals("nd") && !array[j].equals("nd")){
                    
                    System.out.print(M[i][j] + "\t");
                }
            }
            
            if(!array[i].equals("nd")){
                System.out.println();
            }
        }



    }

    public void mostrarVertices(){
        if(vertices.isEmpty()){
            System.out.println("No hay vertices");
            return;
        }

        Collection<Vertice> valores = vertices.values();

        for (Vertice valor : valores) {
            System.out.println("Vertice: " + valor.name);
        }
    }

    public void getDegree(String name){
        if(!vertices.containsKey(name)){
            System.out.println("No existe vertice");
            return;
        }
        Vertice v = vertices.get(name);
        System.out.println(v.degree);
    }

    public void DFS(String name){

        Vertice v = vertices.get(name);
        v.visited = true;

        int indice = index(name);
        
        
        

        for(int j = 0; j < array.length; j++){
            if(M[indice][j] != 0){
                v = vertices.get(array[j]);                
                if(v.visited == false){
                    System.out.println(name);
                    pila.push(indice);
                    DFS(v.name);
                    
                }

            }
        }
        
        if(!pila.isEmpty()){
            if(a){
                System.out.println(name);
                a = false;
            }
            DFS(array[pila.pop()]);
        }else{
            a = true;
            return;
        }

    }

    public void BFS(String name){

        if(a){
            System.out.println(name);
            a = false;
        }
        Vertice v = vertices.get(name);
        v.visited = true;

        int indice = index(name);

        for(int j = 0; j < array.length; j++){
            if(M[indice][j] != 0){
                v = vertices.get(array[j]);
                if(v.visited == false){
                    System.out.println(array[j]);
                    cola.offer(j);
                    v.visited = true;
                }
            }
        }

        if(!cola.isEmpty()){
            BFS(array[cola.poll()]);
        }else{
            a = true;
            return;
        }

    }

    private int index(String name){

        for(int i = 0; i < array.length; i++){
            if(array[i].equals(name)){
                return i;
            }
        }

        return 0;
    }

    public void mostrarArray(){
        for (String elemento : array) {
            System.out.println(elemento);
        }
    }

    private void filtrar(String name){
        
        int id = index(name);
        Vertice v;
        for(int i = 0; i < array.length; i++){
            
            if(M[i][id] != 0){
                v = vertices.get(array[i]);
                v.degree--;
            }

        }

        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i == id || j == id){
                    
                    M[i][j] = 0;
                }
            }
        }
        
        
        

    }

    public void restore(){
        for (Map.Entry<String, Vertice> entry : vertices.entrySet()) {
            Vertice value = entry.getValue();
            value.visited = false;
        }
    }



    // ============================================Dijstra================================================================

    public void Dijkstra(String Origen, String Final){

        Vertice v = vertices.get(Origen);
        Vertice v1;

        ArrayList<String> list = new ArrayList<>();

        v.pesoT = 0;
        v.pesoF = 0;

        int indice = index(Origen);

        while (pF()) {
            System.out.println("1");
            
            for(int i = 0; i < array.length; i++){
                v1 = vertices.get(array[i]);

                if(M[indice][i] != 0 && v1.pesoF == -1){
                    int peso = v.pesoF + M[indice][i];

                    if(peso < v1.pesoT){
                        v1.pesoT = peso;
                    }
                }

            }

            int menorPeso = Integer.MAX_VALUE;

            for(String k : vertices.keySet()){
                v1 = vertices.get(k);

                if(v1.pesoF == -1 && v1.pesoT < menorPeso){
                    v = v1;
                    menorPeso = v1.pesoT;
                }
            }

            v.pesoF = v.pesoT;

            indice = index(v.name);

        }

        v = vertices.get(Final);
        indice = index(Final);
        list.add(v.name);
        while(!v.name.equals(Origen)){

            for(int i = 0; i < array.length; i++){
                
                v1 = vertices.get(array[i]);
                int peso = v.pesoF - M[indice][i];
                if(peso == v1.pesoF){
                    list.add(v1.name);
                    v = v1;
                    indice = index(v.name);
                    break;
                }

            }



        }

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }


    private boolean pF(){

        Vertice v;

        for(String k : vertices.keySet()){

            v = vertices.get(k);

            if(v.pesoF == -1){
                return true;
            }

        }

        return false;
    }


}
