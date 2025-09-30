import java.util.ArrayList; 
public class Contenedor<F, S> { 
  private ArrayList<Par<F, S>> listaPares; 
  public Contenedor() { 
    listaPares = new ArrayList<>(); 
  } 
  public void agregarPar(F primero, S segundo) { 
    listaPares.add(new Par<>(primero, segundo)); 
  }
  public Par<F, S> obtenerPar(int indice) { 
    if (indice >= 0 && indice < listaPares.size()) { 
      return listaPares.get(indice);
    } 
    return null;
  } 
  public ArrayList<Par<F, S>> obtenerTodosLosPares() { 
    return listaPares; 
  } 
  public void mostrarPares() { 
    for (Par<F, S> par : listaPares) { 
      System.out.println(par); 
    } 
  } 
}
