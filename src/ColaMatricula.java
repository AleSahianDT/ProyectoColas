import java.util.LinkedList;
import java.util.Queue;
//add: agregar a cola (encolar)
//poll: (el pop de colas) desencolar
public class ColaMatricula {
    private Queue<Vehiculo> carros;

    public ColaMatricula() {
        carros = new LinkedList<Vehiculo>();
    }

    public void encolar(String propietario, String marca, int anio){
        carros.add(new Vehiculo(propietario, marca, anio));
    }
    public Vehiculo desencolar() throws Exception{
        if(carros.isEmpty())
            throw new Exception("no hay vehiculos en la cola");
        return carros.poll(); //Pop en pilas, poll en colas
    }
    public String listarVehiculos(){
        String mensaje="";
        for(Vehiculo v:carros){
            mensaje += v.toString();
        }
        return mensaje;
    }

}
