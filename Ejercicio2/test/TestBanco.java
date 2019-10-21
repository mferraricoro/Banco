import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TestBanco {
    public Banco banco;
    public Cliente cliente;
    public Cuenta cuenta;

    @Before
    public void creandoCosas(){
        banco = new Banco();
    }

    @Test
    public void TestElBancoSeCreoCorrectamente(){
        Assert.assertNotNull(banco);
    }

    @Test
    public void TestElBancoTieneClienteVacios(){
        Assert.assertTrue(banco.obtenerClientes().isEmpty());
    }

    @Test
    public void TestAgregarCuenta(){
        cliente.agregarCuenta(cuenta);
        this.cliente.obtenerCuentas().put(cuenta.obtenerCbu(), cuenta);
        Assert.assertFalse(this.cliente.obtenerCuentas().isEmpty());
    }
    @Test
    public void TestAgregarCliente(){
        banco.agregarCliente(cliente);
        this.banco.obtenerClientes().put(cliente.obtenerDni(), cliente);
        Assert.assertFalse(this.banco.obtenerClientes().isEmpty());
    }


}
