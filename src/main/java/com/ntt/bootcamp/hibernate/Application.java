package com.ntt.bootcamp.hibernate;

import com.ntt.bootcamp.hibernate.bbdd.Cliente;
import com.ntt.bootcamp.hibernate.services.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Iniciando la app");
		
		//Creamos un jugador
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Cliente1");
		cliente1.setPrimerApellido("Apellido1");
		cliente1.setSegundoApellido("Apellidos1");
		cliente1.setNif("11111111A");
		
		//Lo guardamos en bbdd
		clienteService.insertNewCliente(cliente1);
		System.out.println("Se ha insertado el Cliente1");
		
		//Creamos un jugador
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Cliente2");
		cliente2.setPrimerApellido("Apellido2");
		cliente2.setSegundoApellido("Apellidos2");
		cliente2.setNif("22222222A");
				
		//Lo guardamos en bbdd
		clienteService.insertNewCliente(cliente2);
		System.out.println("Se ha insertado el Cliente2");
		
		//Creamos un jugador
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Cliente3");
		cliente3.setPrimerApellido("Apellido3");
		cliente3.setSegundoApellido("Apellidos3");
		cliente3.setNif("33333333A");
				
		//Lo guardamos en bbdd
		clienteService.insertNewCliente(cliente3);
		System.out.println("Se ha insertado el Cliente3");
		
		//Consultamos los Clientes
		List<Cliente> clientes = clienteService.findAllClient();
		
		System.out.println("Se han insertado los Clientes:");
		
		for(Cliente cliente: clientes) {
			System.out.println("Cliente " + cliente.toString());
		}
		
		//Buscamos un cliente por Id
		Cliente searchCliente = clienteService.searchClienteById(3L);
		
		if(null!= searchCliente) {
			System.out.println("El cliente encontrado es " + searchCliente.getNombre());
		} else {
			System.out.println("No se ha encontrado el cliente con el id 3");
		}
		
		//Actualizo el Cliente3:
		searchCliente.setNif("12345678M");
		clienteService.actualizaCliente(searchCliente);
		System.out.println("Se ha modificado el Cliente 3.");
		
		
		//Buscamos un cliente por Nombre
		clientes = clienteService.searchClienteByNombre("Cliente3", "Apellido3", "Apellidos3");
		
		for (Cliente cli: clientes)
		System.out.println("Cliente " + cli.toString());
		
				
		if(null!= searchCliente) {
			System.out.println("El cliente encontrado es " + searchCliente.getNombre());
		} else {
			System.out.println("No se ha encontrado el Cliente3");
		}
		
		//Elimino el último cliente que inserté
		clienteService.eliminarCliente(searchCliente);
		System.out.println("Se ha eliminado el Cliente3");		
		
		//Consultamos los Clientes
		clientes = clienteService.findAllClient();
				
		for(Cliente cliente: clientes) {
			System.out.println("Cliente " + cliente.toString());
		}
	}
}
