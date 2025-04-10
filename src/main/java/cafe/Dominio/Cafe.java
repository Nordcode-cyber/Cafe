package cafe.Dominio;
public class Cafe {
    private int id_cafe;
    private String tipo;
    private String marca;
    private String region;
    private float peso;
    private String tostado;
    private String presentacion;
    private String secado;
    private float cafeina;
    private String notas;
    public Cafe(){
        
    }
    public Cafe(int id_cafe){
        this.id_cafe= id_cafe;
    }
    public Cafe(String tipo, String marca, String region, float peso, String tostado, String presentacion, String secado, float cafeina, String notas){
        this.tipo = tipo;
        this.marca = marca;
        this.region = region;
        this.peso = peso;
        this.tostado = tostado;
        this.presentacion = presentacion;
        this.secado = secado;
        this.cafeina = cafeina;
        this.notas = notas;

    }
    public Cafe(int id_cafe, String tipo, String marca, String region, float peso, String tostado, String presentacion,
            String secado, float cafeina, String notas) {
        this.id_cafe = id_cafe;
        this.tipo = tipo;
        this.marca = marca;
        this.region = region;
        this.peso = peso;
        this.tostado = tostado;
        this.presentacion = presentacion;
        this.secado = secado;
        this.cafeina = cafeina;
        this.notas = notas;
    }
    public int getId_cafe() {
        return id_cafe;
    }
    public void setId_cafe(int id_cafe) {
        this.id_cafe = id_cafe;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getTostado() {
        return tostado;
    }
    public void setTostado(String tostado) {
        this.tostado = tostado;
    }
    public String getPresentacion() {
        return presentacion;
    }
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    public String getSecado() {
        return secado;
    }
    public void setSecado(String secado) {
        this.secado = secado;
    }
    public float getCafeina() {
        return cafeina;
    }
    public void setCafeina(float cafeina) {
        this.cafeina = cafeina;
    }
    public String getNotas() {
        return notas;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    @Override
    public String toString() {
        return "Cafe [id_cafe=" + id_cafe + ", tipo=" + tipo + ", marca=" + marca + ", region=" + region + ", peso="
                + peso + ", tostado=" + tostado + ", presentacion=" + presentacion + ", secado=" + secado + ", cafeina="
                + cafeina + ", notas=" + notas + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_cafe;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + Float.floatToIntBits(peso);
        result = prime * result + ((tostado == null) ? 0 : tostado.hashCode());
        result = prime * result + ((presentacion == null) ? 0 : presentacion.hashCode());
        result = prime * result + ((secado == null) ? 0 : secado.hashCode());
        result = prime * result + Float.floatToIntBits(cafeina);
        result = prime * result + ((notas == null) ? 0 : notas.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cafe other = (Cafe) obj;
        if (id_cafe != other.id_cafe)
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
            return false;
        if (tostado == null) {
            if (other.tostado != null)
                return false;
        } else if (!tostado.equals(other.tostado))
            return false;
        if (presentacion == null) {
            if (other.presentacion != null)
                return false;
        } else if (!presentacion.equals(other.presentacion))
            return false;
        if (secado == null) {
            if (other.secado != null)
                return false;
        } else if (!secado.equals(other.secado))
            return false;
        if (Float.floatToIntBits(cafeina) != Float.floatToIntBits(other.cafeina))
            return false;
        if (notas == null) {
            if (other.notas != null)
                return false;
        } else if (!notas.equals(other.notas))
            return false;
        return true;
    }
}
