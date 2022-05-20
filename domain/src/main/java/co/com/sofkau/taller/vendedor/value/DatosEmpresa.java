package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosEmpresa implements ValueObject<DatosEmpresa.Value> {

    private final String nombreEmpresa;
    private final String descripcion;

    public DatosEmpresa(String nombreEmpresa, String descripcion) {
        this.nombreEmpresa = Objects.requireNonNull(nombreEmpresa);
        this.descripcion = Objects.requireNonNull(descripcion);

        if(this.nombreEmpresa.isBlank()){
            throw new IllegalArgumentException("El nombre de la empresa no puede estar en blanco");
        }

        if(this.nombreEmpresa.length() > 50){
            throw new IllegalArgumentException("El nombre de la empresa no permite mas de 50 caracteres");
        }

        if(this.descripcion.isBlank()){
            throw new IllegalArgumentException("La Descripción no puede estar en blanco");
        }

        if(this.descripcion.length() > 500){
            throw new IllegalArgumentException("La Descripción no permite mas de 500 caracteres");
        }
    }

    @Override
    public DatosEmpresa.Value value() {
        return new Value() {
            @Override
            public String nombreEmpresa() {
                return nombreEmpresa;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Value {
        String nombreEmpresa();

        String descripcion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosEmpresa)) return false;
        DatosEmpresa that = (DatosEmpresa) o;
        return Objects.equals(nombreEmpresa, that.nombreEmpresa) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEmpresa, descripcion);
    }
}
