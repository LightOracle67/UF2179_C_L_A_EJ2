package ejercicio;

import java.util.Objects;

public class Autocar {
private String matricula;
private String marca;
private String modelo;
private Double kms;
private Integer plazas;

protected Autocar(String matricula,String marca,String modelo,Double kms, Integer plazas) {
	this.matricula = matricula;
	this.marca = marca;
	this.modelo = modelo;
	this.kms = kms;
	this.plazas = plazas;
}

protected String getMatricula() {
	return matricula;
}
protected void setMatricula(String matricula) {
	this.matricula = matricula;
}
protected String getMarca() {
	return marca;
}
protected void setMarca(String marca) {
	this.marca = marca;
}
protected String getModelo() {
	return modelo;
}
protected void setModelo(String modelo) {
	this.modelo = modelo;
}
protected Double getKms() {
	return kms;
}
protected void setKms(Double kms) {
	this.kms = kms;
}
protected Integer getPlazas() {
	return plazas;
}
protected void setPlazas(Integer plazas) {
	this.plazas = plazas;
}
@Override
public int hashCode() {
	return Objects.hash(matricula);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Autocar other = (Autocar) obj;
	return Objects.equals(matricula, other.matricula);
}

@Override
public String toString() {
	return "Autocar [" + (getMarca() != null ? "marca=" + getMarca() + ", " : "")
			+ (getModelo() != null ? "modelo=" + getModelo() + ", " : "")
			+ (getKms() != null ? "kilometros=" + getKms() + ", " : "")
			+ (getPlazas() != null ? "plazas=" + getPlazas() + ", " : "")
			+ (getMatricula() != null ? "matricula=" + getMatricula() + ", " : "")
			+ "]";
}




}
