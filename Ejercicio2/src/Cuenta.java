import java.math.BigDecimal;

public abstract class Cuenta{
    public BigDecimal monto;
    public Integer cbu;

    public abstract void extraer(BigDecimal monto) throws ErrorExtraccion;

    public void depositar(BigDecimal monto) throws ErrorDeposito {
        if (monto.compareTo(new BigDecimal("0")) > 0){
            this.monto = this.monto.add(monto);
        }else{
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Error: Quisiste depositar un monto invalido: ").append(monto);
            throw new ErrorDeposito(mensaje.toString());
        }
    }

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
