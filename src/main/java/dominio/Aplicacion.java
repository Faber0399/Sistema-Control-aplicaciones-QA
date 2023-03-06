package dominio;

/**
 *
 * @author faber
 */
public class Aplicacion {
    private int idAplicacion;
    private String nombreAplicacion;
    private String version;
    private String cicloPruebas;
    private int metrica1;
    private int metrica2;
    private int metrica3;
    private int metrica4;
    private int metrica5;

    public Aplicacion() {
    }

    public Aplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Aplicacion(String nombreAplicacion, String version, String cicloPruebas, int metrica1, int metrica2, int metrica3, int metrica4, int metrica5) {
        this.nombreAplicacion = nombreAplicacion;
        this.version = version;
        this.cicloPruebas = cicloPruebas;
        this.metrica1 = metrica1;
        this.metrica2 = metrica2;
        this.metrica3 = metrica3;
        this.metrica4 = metrica4;
        this.metrica5 = metrica5;
    }

    public Aplicacion(int idAplicacion, String nombreAplicacion, String version, String cicloPruebas, int metrica1, int metrica2, int metrica3, int metrica4, int metrica5) {
        this.idAplicacion = idAplicacion;
        this.nombreAplicacion = nombreAplicacion;
        this.version = version;
        this.cicloPruebas = cicloPruebas;
        this.metrica1 = metrica1;
        this.metrica2 = metrica2;
        this.metrica3 = metrica3;
        this.metrica4 = metrica4;
        this.metrica5 = metrica5;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCicloPruebas() {
        return cicloPruebas;
    }

    public void setCicloPruebas(String cicloPruebas) {
        this.cicloPruebas = cicloPruebas;
    }

    public int getMetrica1() {
        return metrica1;
    }

    public void setMetrica1(int metrica1) {
        this.metrica1 = metrica1;
    }

    public int getMetrica2() {
        return metrica2;
    }

    public void setMetrica2(int metrica2) {
        this.metrica2 = metrica2;
    }

    public int getMetrica3() {
        return metrica3;
    }

    public void setMetrica3(int metrica3) {
        this.metrica3 = metrica3;
    }

    public int getMetrica4() {
        return metrica4;
    }

    public void setMetrica4(int metrica4) {
        this.metrica4 = metrica4;
    }

    public int getMetrica5() {
        return metrica5;
    }

    public void setMetrica5(int metrica5) {
        this.metrica5 = metrica5;
    }

    @Override
    public String toString() {
        return "Aplicacion{" + "idAplicacion=" + idAplicacion + ", nombreAplicacion=" + nombreAplicacion + ", version=" + version + ", cicloPruebas=" + cicloPruebas + ", metrica1=" + metrica1 + ", metrica2=" + metrica2 + ", metrica3=" + metrica3 + ", metrica4=" + metrica4 + ", metrica5=" + metrica5 + '}';
    }    
}
