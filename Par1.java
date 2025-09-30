import java.util.Objects;
public class Par<F, S> {
  private F primero;
  private S segundo;

  public Par(F primero, S segundo){
    this.primero = primero;
    this.segundo = segundo;
  }
  public F getPrimero() {
    return primero;
  }
  public S getSegundo() {
    return segundo;
  }
  public void setPrimero (F primero) {
    this.primero = primero;
  }
  public void setSegundo (S segundo) {
    this.segundo = segundo;
  }
  public String toString() {
    return "(Primero: " + primero+ ", Segundo: " + segundo + ")";
  }
  //Metodo incluido de la parte dos de la actividad 
  public boolean esIgual (Par <f, S> otroPar){
    if (otroPar == null){
      return false;
  }
  return Objects.equals(this.primero, otroPar.primero) && Objects.equals(this, otroPar.segundo);
  }
}
