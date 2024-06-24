package com.upchat.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upchat.dtos.messageGetAllInfoQuery;
import com.upchat.model.Mensaje;

@Repository
public interface IMensajeRepo extends JpaRepository<Mensaje, Integer> {
    Mensaje findByIdMensajeReferencia(int id);

    @Query(value = """
                        select
            	mensaje.id_mensaje,
            	mensaje.messag,
            	mensaje.asunto,
            	mensaje.estrellas,
            	mensaje.url_archivo ,
            	mensaje.nombre_archivo  ,
            	mensaje.categoria   ,
            	mensaje.fecha_registro  ,
            	mensaje.id_mensaje_referencia ,
            	mensaje.estado ,
            	usuario.id_usuario ,
            	usuario.nombre as user_nombre,
            	usuario.url_foto as url_foto,
            	COALESCE(Referencias.cantidad, 0) AS cantidad,
            	star_calification.star,
            	SC_USER.star as user_start
            from mensaje
            LEFT JOIN usuario on mensaje.id_usuario = usuario.id_usuario
            LEFT JOIN (
             SELECT id_mensaje_referencia,
                  count(*) as cantidad
                  from  Mensaje
                  GROUP BY id_mensaje_referencia
            ) Referencias
            ON mensaje.id_mensaje = Referencias.id_mensaje_referencia
            LEFT JOIN
            (
             SELECT mensaje, avg(star) as star from STAR_CALIFICATION GROUP BY mensaje
            ) STAR_CALIFICATION
            on STAR_CALIFICATION.mensaje = Mensaje.id_mensaje
            LEFT JOIN (
            	SELECT mensaje, star from STAR_CALIFICATION
            	WHERE usuario = :currentUserId //usuario actual
            ) SC_USER
            on SC_USER.MENSAJE = MENSAJE.id_mensaje
            where ((:id_mensaje_referencia = -1) and mensaje.id_mensaje_referencia = 0)  
               or (( :id_mensaje_referencia != -1) and mensaje.id_mensaje_referencia = :id_mensaje_referencia)
            order by mensaje.fecha_registro desc
                        """, nativeQuery = true)
    List<Object[]> findCustomMessages(
        @Param("currentUserId") int currentUserId,
        @Param("id_mensaje_referencia") int id_mensaje_referencia
    );
}
