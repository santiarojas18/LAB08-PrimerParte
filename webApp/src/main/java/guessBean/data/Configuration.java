package guessBean.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Configuration {
	@Id
    private String propiedad;

    private String valor;

    public Configuration(String propiedad, String valor) {
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public Configuration() {
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "propiedad='" + propiedad + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(propiedad, that.propiedad) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propiedad, valor);
    }
}
