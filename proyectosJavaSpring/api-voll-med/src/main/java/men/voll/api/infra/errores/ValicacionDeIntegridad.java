package men.voll.api.infra.errores;

public class ValicacionDeIntegridad extends RuntimeException {
    public ValicacionDeIntegridad(String s) {
        super(s);
    }
}
