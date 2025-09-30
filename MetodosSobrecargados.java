package MarcoTeorico;

class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}

public class MetodosSobrecargados {
    
    // Método genérico único para todos los tipos
    public static <T> void imprimirArreglo(T[] arregloEntrada) {
        for (T elemento : arregloEntrada)
            System.out.printf("%s ", elemento);
        System.out.println();
    }

    // Método sobrecargado con validación de índices
    public static <T> int imprimirArreglo(T[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
        // Validaciones combinadas
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || 
            subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException(
                "Índices inválidos: inferior=" + subindiceInferior + 
                ", superior=" + subindiceSuperior + 
                ". Rango válido: 0 a " + (arregloEntrada.length - 1)
            );
        }
        
        // Imprimir porción del arreglo
        for (int i = subindiceInferior; i <= subindiceSuperior; i++)
            System.out.printf("%s ", arregloEntrada[i]);
        System.out.println();
        
        return subindiceSuperior - subindiceInferior + 1;
    }

    public static void main(String args[]) {
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println("Arreglos completos:");
        imprimirArreglo(arregloInteger);
        imprimirArreglo(arregloDouble);
        imprimirArreglo(arregloCharacter);

        System.out.println("\nPorciones con índices:");
        System.out.println("Integer[1,4]: " + imprimirArreglo(arregloInteger, 1, 4) + " elementos");
        System.out.println("Double[2,5]: " + imprimirArreglo(arregloDouble, 2, 5) + " elementos");
        System.out.println("Character[0,2]: " + imprimirArreglo(arregloCharacter, 0, 2) + " elementos");

        System.out.println("\nPruebas de error:");
        probarIndiceInvalido(arregloInteger, -1, 3);
        probarIndiceInvalido(arregloInteger, 1, 10);
        probarIndiceInvalido(arregloInteger, 3, 2);
    }
    
    // Método auxiliar para pruebas de error
    private static void probarIndiceInvalido(Integer[] arr, int inf, int sup) {
        try {
            imprimirArreglo(arr, inf, sup);
        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
