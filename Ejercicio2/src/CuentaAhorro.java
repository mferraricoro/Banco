import java.math.BigDecimal;

public class CuentaAhorro extends Cuenta {
    private BigDecimal tasaInteres;

    public CuentaAhorro(Integer cbu, BigDecimal monto, BigDecimal tasaInteres) {
        super(cbu, monto);
        this.tasaInteres = new BigDecimal(String.valueOf(tasaInteres));
    }

    @Override
    public void extraer(BigDecimal monto) throws ErrorExtraccion {
        if(this.monto.compareTo(monto) >= 0 && monto.compareTo(new BigDecimal("0")) > 0){
            this.monto = this.monto.subtract(monto);
        }else{
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Error: Quisiste extraer ").append(monto).append(", pero la cuenta tiene ").append(obtenerMonto());
            throw new ErrorExtraccion(mensaje.toString());
        }
    }

    public void cambiarTasaInteres(BigDecimal tasaInteres){
        this.tasaInteres = tasaInteres;
    }


}
