package aplicacion;

public class Estados {
    public static long val = 1;
    private String idConsecutivo;
    private String descripcion;
    
    
    public Estados(String pDescripcion){
        setDescripcion(pDescripcion);
        setIdConsecutivo(generarCodigo());
        val++;
    }
    
    private String generarCodigo(){
        String codigo = "EST " + val;
        return codigo;
    }
    

    public void setIdConsecutivo(String idConsecutivo) {
        this.idConsecutivo = idConsecutivo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getIdConsecutivo() {
        return idConsecutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Estados{" + "idConsecutivo=" + idConsecutivo + ", descripcion=" + descripcion + '}';
    }
    
}
