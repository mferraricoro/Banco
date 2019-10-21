import java.math.BigDecimal;

public abstract class Cuenta{
    public BigDecimal monto;
    public Integer cbu;

    public abstract void extraer(BigDecimal monto) throws ErrorExtraccion;
    public void depositar(BigDecimal monto){
        //Varia dependiendo que tipo de cuenta es.
    };

    public BigDecimal obtenerMonto() {
        return this.monto;
    }

    public Cuenta(int cbu, BigDecimal monto) {
        this.cbu = cbu;
        this.monto = monto;
    }

    protected void cambiarMonto(BigDecimal monto) {
        this.monto = monto;
    }

    protected Integer obtenerCbu(){
        return this.cbu;
    }
}
