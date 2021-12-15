package com.ntt.bootcamp.hibernate.services;

import java.util.List;

import com.ntt.bootcamp.hibernate.bbdd.Cliente;

public interface ClienteService {
	
	/**
	 * Método que inserta un nuevo jugador
	 * 
	 * @param player nuevo jugador a guardar
	 */
	public void insertNewCliente(Cliente cliente);
	
	/**
	 * Método que busca un jugador por id
	 * 
	 * @param id del jugador
	 * @return Jugador encontrado
	 */
	public Cliente searchClienteById(Long id);
	
	public List<Cliente> findAllClient();
	
	public void eliminarCliente(Cliente cliente);
	
	public void actualizaCliente(Cliente cliente);
	
	public List<Cliente> searchClienteByNombre(String name, String apellido1, String apellido2);
}
