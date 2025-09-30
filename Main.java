public class Main {
  public static <F, S> void imprimirPar(Par<F, S> par) { 
    System.out.println(par); 
  } 
  public static void main(String[] args) {
    Par<String, Integer> par1 = new Par<>("Hola", 10); 
    Par<String, Integer> par2 = new Par<>("Hola", 10); 
    Par<String, Integer> par3 = new Par<>("Adiós", 5); 
    System.out.println("EJERCICIO 2 - Comparar pares:"); 
    System.out.println("par1 es igual a par2? " + par1.esIgual(par2)); // true 
    System.out.println("par1 es igual a par3? " + par1.esIgual(par3)); // false 
    System.out.println("\nEJERCICIO 3 - Método imprimirPar:"); 
    Par<String, Integer> p1 = new Par<>("Edad", 25); 
    Par<Double, Boolean> p2 = new Par<>(3.14, true); 
    class Persona { 
      String nombre; 
      Persona(String nombre) { 
        this.nombre = nombre;
      } 
      @Override 
      public String toString() { 
        return nombre;
      } 
    } 
    Par<Persona, Integer> p3 = new Par<>(new Persona("Juan"), 30); imprimirPar(p1); 
    imprimirPar(p2); imprimirPar(p3); 
    System.out.println("\nContenedor de pares:"); 
    Contenedor<String, Integer> contenedor = new Contenedor<>(); 
    contenedor.agregarPar("Uno", 1); 
    contenedor.agregarPar("Dos", 2); 
    contenedor.agregarPar("Tres", 3); 
    contenedor.mostrarPares(); 
    System.out.println("Segundo par: " + contenedor.obtenerPar(1)); 
  } 
}
