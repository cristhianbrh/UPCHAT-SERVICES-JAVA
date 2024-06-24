package com.upchat.dtos;

public class messageGetAllInfo_userDto {
    public int idUsuario;
    public String nombre;
    public String urlFoto;
    public messageGetAllInfo_userDto(int idUsuario, String nombre, String urlFoto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
    }
    
}
