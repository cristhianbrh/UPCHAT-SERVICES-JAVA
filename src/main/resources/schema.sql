create or alter procedure get_messages 
	@isPublication BIT = 0,
	@messageIdOne int = null,
	@idUser int = null
as 
begin
	SELECT
		mensaje.idMensaje,
			mensaje.messag,
			mensaje.asunto,
		   mensaje.estrellas,
			mensaje.urlArchivo,
			mensaje.nombreArchivo,
			mensaje.idCategoria,
			mensaje.fechaRegistro,
			mensaje.idMensajeReferencia,
			mensaje.estado,
			usuario.idUsuario,
			usuario.nombre,
			usuario.urlFoto,
		COALESCE(Referencias.cantidad, 0) AS cantidad,
		STARCALIFICATION.star,
		SC_USER.star as userStart
	FROM
		mensaje

	LEFT JOIN
		usuario ON mensaje.idUsuario = usuario.idUsuario
	LEFT JOIN (
		SELECT
			idMensajeReferencia,
			COUNT(*) AS cantidad
		FROM
			Mensaje
		GROUP BY
			idMensajeReferencia
	) Referencias

	ON
		mensaje.idMensaje = Referencias.idMensajeReferencia
	LEFT JOIN
	(
		select mensaje, avg(star) as star from STARCALIFICATION 
		group by mensaje
	) STARCALIFICATION
	on STARCALIFICATION.mensaje = Mensaje.idMensaje
	LEFT JOIN (
		select mensaje, star from STARCALIFICATION 
		where usuario = @idUser
	) SC_USER
	on SC_USER.mensaje = Mensaje.idMensaje
	where ((mensaje.idMensajeReferencia is null) or (@isPublication = 0)) 
		and (  @messageIdOne is null or (mensaje.idMensajeReferencia = @messageIdOne))
	order by mensaje.fechaRegistro desc
end