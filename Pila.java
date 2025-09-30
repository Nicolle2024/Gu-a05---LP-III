package MarcoTeorico;

public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila(){
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valorAMeter) {
        if (superior == tamanio - 1)
            throw new RuntimeException("La Pila esta llena, no se puede meter " + valorAMeter);
        elementos[++superior] = valorAMeter;
    }

    public E pop() {
        if (superior == -1)
            throw new RuntimeException("La Pila esta vacia, no se puede sacar");
        return elementos[superior--];
    }

    // Método contains busca si un elemento está en la pila
    public boolean contains(E elemento) {
        // Busca desde arriba hacia abajo
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
}
public class PruebaPila {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>(5);
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        
        System.out.println("¿La pila contiene 20? " + pila.contains(20));
        System.out.println("¿La pila contiene 50? " + pila.contains(50));
        
        Pila<String> pilaPalabras = new Pila<>();
        pilaPalabras.push("Hola");
        pilaPalabras.push("Mundo");
        pilaPalabras.push("Java");
        
        System.out.println("¿La pila contiene 'Java'? " + pilaPalabras.contains("Java"));
        System.out.println("¿La pila contiene 'Python'? " + pilaPalabras.contains("Python"));
    }
}
