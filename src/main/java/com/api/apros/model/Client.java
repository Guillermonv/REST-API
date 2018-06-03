package com.api.apros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    @Column(name = "DNI")
    long DNI;

    @Column(name = "Nombre")
    String Nombre;

    @Column(name = "Apellido")
    String Apellido;

    @Column(name = "Edad")
    int Edad;

    public Client() {
        super();
    }

    public Client(int ID, long DNI, String nombre, String Apellido, int edad) {
        this.ID = ID;
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Apellido = Apellido;
        this.Edad = edad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}