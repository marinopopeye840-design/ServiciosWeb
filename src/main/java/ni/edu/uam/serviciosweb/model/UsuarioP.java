
package ni.edu.uam.serviciosweb.model;

public class UsuarioP {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String fechaNacimiento;
    private String pais;
    private String ciudad;
    private String direccion;
    private double ingresoAnual;
    private int puntajeCrediticio;
    private boolean tieneDeuda;
    private double montoDeuda;
    private String estado;
    private String fechaCreacion;
    private String fechaActualizacion;

    public UsuarioP() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getIngresoAnual() {
        return ingresoAnual;
    }

    public void setIngresoAnual(double ingresoAnual) {
        this.ingresoAnual = ingresoAnual;
    }

    public int getPuntajeCrediticio() {
        return puntajeCrediticio;
    }

    public void setPuntajeCrediticio(int puntajeCrediticio) {
        this.puntajeCrediticio = puntajeCrediticio;
    }

    public boolean isTieneDeuda() {
        return tieneDeuda;
    }

    public void setTieneDeuda(boolean tieneDeuda) {
        this.tieneDeuda = tieneDeuda;
    }

    public double getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(double montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}