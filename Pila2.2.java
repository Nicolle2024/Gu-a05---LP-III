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
            throw new ExcepcionPilaLlena(String.format(
                "La Pila esta llena, no se puede meter %s", valorAMeter));
        elementos[++superior] = valorAMeter;
    }

    public E pop() {
        if (superior == -1)
            throw new ExcepcionPilaVacia("La Pila esta vacia, no se puede sacar");
        return elementos[superior--];
    }

    // Método para comparar si dos pilas son iguales
    public boolean esIgual(Pila<E> otraPila) {
        // Si no son del mismo tamaño, no pueden ser iguales
        if (this.superior != otraPila.superior) {
            return false;
        }
        
        // Compara cada elemento desde el fondo hasta el tope
        for (int i = 0; i <= superior; i++) {
            E elemento1 = this.elementos[i];
            E elemento2 = otraPila.elementos[i];
            
            // Si uno es null y el otro no, no son iguales
            if (elemento1 == null) {
                if (elemento2 != null) {
                    return false;
                }
            } else {
                // Si ambos no son null, usa equals para comparar
                if (!elemento1.equals(elemento2)) {
                    return false;
                }
            }
        }
        
        // Si pasó todas las comparaciones, las pilas son iguales
        return true;
    }

    // Método auxiliar para ver el tamaño actual
    public int tamaño() {
        return superior + 1;
    }
}

class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }
}
public class PruebaPilaIgual {
    public static void main(String[] args) {
        // Crear dos pilas iguales
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);
        
        pila1.push(10);
        pila1.push(20);
        pila1.push(30);
        
        pila2.push(10);
        pila2.push(20);
        pila2.push(30);
        
        System.out.println("Pilas iguales: " + pila1.esIgual(pila2)); // true
        
        // Crear pilas diferentes
        Pila<Integer> pila3 = new Pila<>(5);
        pila3.push(10);
        pila3.push(25);
        pila3.push(30);
        
        System.out.println("Pilas diferentes: " + pila1.esIgual(pila3)); // false
        
        // Pilas de diferente tamaño
        Pila<Integer> pila4 = new Pila<>(5);
        pila4.push(10);
        pila4.push(20);
        
        System.out.println("Pilas diferente tamaño: " + pila1.esIgual(pila4)); // false
        
        // Probar con pilas de String
        Pila<String> pilaStr1 = new Pila<>();
        Pila<String> pilaStr2 = new Pila<>();
        
        pilaStr1.push("Hola");
        pilaStr1.push("Mundo");
        
        pilaStr2.push("Hola");
        pilaStr2.push("Mundo");
        
        System.out.println("Pilas String iguales: " + pilaStr1.esIgual(pilaStr2)); // true
    }
}
