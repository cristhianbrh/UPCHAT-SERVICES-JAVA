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
	mensaje.estado,
	usuario.id_usuario,
	usuario.nombre,
	usuario.url_foto,
	COALESCE(Referencias.cantidad, 0) AS cantidad,
	star_calification.star,
	SC_USER.star as userStart
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
	WHERE usuario = 1 //usuario actual
) SC_USER
on SC_USER.MENSAJE = MENSAJE.id_mensaje
where mensaje.id_mensaje_referencia = 0  --si es publicaci'on
   and mensaje.id_mensaje_referencia  = 1 --si tiene un mensaje de referencia o en otras palabras si es una respuesta
order by mensaje.fecha_registro desc