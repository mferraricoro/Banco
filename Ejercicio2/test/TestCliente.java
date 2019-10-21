import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TestCliente {
    public Banco banco;
    public Cuenta cuenta1;
    public Cuenta cuenta2;
    public Cuenta cuenta3;
    public Cuenta cuenta4;
    public Cliente clienteWilson;
    public Cliente clienteGarcia;
    public Cliente clienteNakayama;

    @Before
    public void creandoCosas(){
        banco = new Banco();
        creandoClientes();
        creandoCuentas();
    }

    private void creandoClientes(){
        clienteWilson = new Cliente(1, "Wilson", "Algoritmos");
        clienteGarcia = new Cliente(2, "Garcia", "Algoritmos");
        clienteNakayama = new Cliente(3, "Nakayama", "Algoritmos");
    }

    private void creandoCuentas(){
        cuenta1 = new CuentaCorriente(1, new BigDecimal("3600"), new BigDecimal("400"));
        cuenta2 = new CuentaCorriente(2, new BigDecimal("4500"), new BigDecimal("400"));
        cuenta3 = new CuentaCorriente(3, new BigDecimal("5500"), new BigDecimal("500"));
        cuenta4 = new CuentaAhorro(4, new BigDecimal("3000"), new BigDecimal("0.001"));
    }

    @Test
    public void asignacionCuentaCliente(){
        clienteWilson.agregarCuenta(cuenta1);
        clienteGarcia.agregarCuenta(cuenta2);
        clienteNakayama.agregarCuenta(cuenta3);
        clienteNakayama.agregarCuenta(cuenta4);
    }

    @Test
    public void extraerConSaldo() throws ErrorExtraccion {
        cuenta1.extraer(new BigDecimal("1000"));
        Assert.assertEquals(new BigDecimal("2600"), cuenta1.obtenerMonto());
    }

    @Test
    public void extraerNegativo() throws ErrorExtraccion {
        try {
            cuenta1.extraer(new BigDecimal("-1000"));
            Assert.fail();
        } catch(ErrorExtraccion e){
            Assert.assertEquals(new BigDecimal("3600"), cuenta1.obtenerMonto());
        }
    }

    @Test
    public void extraerSinSaldo(){
        try {
            cuenta1.extraer(new BigDecimal("6000"));
            Assert.fail();
        } catch(ErrorExtraccion e){
            Assert.assertEquals(new BigDecimal("3600"), cuenta1.obtenerMonto());
        }
    }
}
