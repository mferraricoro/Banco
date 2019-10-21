import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta{
    private BigDecimal sobreGiro;

    public CuentaCorriente(Integer cbu, BigDecimal monto, BigDecimal sobreGiro) {
        super(cbu, monto);
        this.sobreGiro = sobreGiro;
    }

    public void cambiarSobreGiro(BigDecimal sobreGiro){
        this.sobreGiro = sobreGiro;
    }

    public void obtenerSobreGiro(BigDecimal sobreGiro){
        this.sobreGiro = sobreGiro;
    }

    @Override
    public void extraer(BigDecimal monto) throws ErrorExtraccion {
        if(monto.compareTo(this.monto.add(this.sobreGiro)) < 0){
            if(monto.compareTo(this.monto) == 1){
                this.sobreGiro.subtract(monto.subtract(this.monto));
                this.cambiarMonto(this.monto);
            }else{
                this.cambiarMonto(monto);
            }
        }else{
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Error: Quisiste extraer ").append(monto).append(", pero la cuenta tiene ").append(obtenerMonto());
            throw new ErrorExtraccion(mensaje.toString());
        }
    }
}
