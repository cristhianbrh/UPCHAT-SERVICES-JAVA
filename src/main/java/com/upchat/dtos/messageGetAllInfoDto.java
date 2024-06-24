package com.upchat.dtos;

import java.util.Date;

public class messageGetAllInfoDto {
    public int id_mensaje;
    public String messag;
    public String asunto;
    public int estrellas;
    public String url_archivo;
    public String nombre_archivo;
    public int id_categoria;
    public Date fecha_registro;
    public int id_mensaje_referencia;
    public boolean estado;
    public int cantidad;
    public double stars;
    public messageGetAllInfo_userDto usuario;
    public int userStar;
    public messageGetAllInfoDto(int id_mensaje, String messag, String asunto, int estrellas, String url_archivo,
            String nombre_archivo, int id_categoria, Date fecha_registro, int id_mensaje_referencia, boolean estado,
            int cantidad, double stars, messageGetAllInfo_userDto usuario, int userStar) {
        this.id_mensaje = id_mensaje;
        this.messag = messag;
        this.asunto = asunto;
        this.estrellas = estrellas;
        this.url_archivo = url_archivo;
        this.nombre_archivo = nombre_archivo;
        this.id_categoria = id_categoria;
        this.fecha_registro = fecha_registro;
        this.id_mensaje_referencia = id_mensaje_referencia;
        this.estado = estado;
        this.cantidad = cantidad;
        this.stars = stars;
        this.usuario = usuario;
        this.userStar = userStar;
    }
    
}
