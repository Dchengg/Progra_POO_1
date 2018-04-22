package aplicacion;

public class Estado {
    public static long val = 1;
    private String idConsecutivo;
    private String descripcion;
    
    
    /**
        * Crea el estado del paquete
        * @param pDescripcion es la descripcion del estado del paquete
        */
    
    public Estado(String pDescripcion){
        setDescripcion(pDescripcion);
        setIdConsecutivo(generarCodigo());
        val++;
    }
    
    /**
        * Genera el codigo del estado
        * @return  String
        */
    
    public static String generarCodigo(){
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
