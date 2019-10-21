import java.math.BigDecimal;
import java.util.HashMap;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private HashMap<Integer, Cuenta> cuentas = new HashMap();

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public int obtenerDni(){
        return this.dni;
    }

    public void agregarCuenta(Cuenta cuenta) {
        int cbu = cuenta.obtenerCbu();
        this.cuentas.put(cuenta.obtenerCbu(), cuenta);
    }

    public HashMap<Integer, Cuenta> obtenerCuentas(){
        return this.cuentas;
    }
}
