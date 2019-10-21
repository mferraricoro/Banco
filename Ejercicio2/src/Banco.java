import java.util.HashMap;

public class Banco {
    private HashMap<Integer, Cliente> clientes;

    public Banco(){
        this.clientes = new HashMap();
    }

    public void cambiarClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Integer, Cliente> obtenerClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.put(cliente.obtenerDni(), cliente);
    }
}
