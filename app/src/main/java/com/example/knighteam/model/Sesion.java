package com.example.knighteam.model;

public class Sesion {

    private static Sesion sesion;
    private static User usuario;
    private static int numlobby;

    public static Sesion getInstance() {
        if (sesion == null) {
            sesion = new Sesion();
        }
        return sesion;
    }

    private Sesion() {
    }

    public int getNumLobby() {
        return numlobby;
    }

    public void setNumLobby(int numlobby) {
        Sesion.numlobby = numlobby;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        Sesion.usuario = usuario;
    }

    public Rol getRol() {
        return usuario.getRol();
    }

    //Del 0 al 4
    public void setRol(int rol) {
         usuario.setRol(Rol.values()[rol]);
    }

}


