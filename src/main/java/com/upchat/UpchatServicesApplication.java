package com.upchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upchat.model.Categoria;
import com.upchat.model.Rol;
import com.upchat.repositorio.ICategoriaRepo;
import com.upchat.services.ICategoriaService;
import com.upchat.services.IRolService;

@SpringBootApplication
public class UpchatServicesApplication  implements CommandLineRunner {

	private static Logger logger= LoggerFactory.getLogger(UpchatServicesApplication.class);
	Rol newRol1;
	
	@Autowired
	IRolService rolService;

	@Autowired
	ICategoriaService categoriaService;

	public static void main(String[] args) {
		SpringApplication.run(UpchatServicesApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		
		//logger.warn("Mi aplicació con Spring tiene problemas al ejecutarse");
		
		// TODO Auto-generated method stub
		newRol1 = new Rol();
		newRol1.setIdRol(252);
		newRol1.setDescripcion("usuario");
		newRol1.setEsActivo(true);
		
		Rol newRol2 = new Rol();
		newRol2.setIdRol(253);
		newRol2.setDescripcion("admin");
		newRol2.setEsActivo(true);


		Categoria newCategory = new Categoria();
		newCategory.setIdCategoria(1);
		newCategory.setDescripcion("Todos");

		newRol1 = rolService.createRol(newRol1);

		categoriaService.addCategoria(newCategory);
		rolService.createRol(newRol2);
		logger.info("Mi aplicacion con Spring esta funcionando");
	}



}
