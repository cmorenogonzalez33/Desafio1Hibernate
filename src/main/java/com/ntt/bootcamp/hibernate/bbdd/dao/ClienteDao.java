package com.ntt.bootcamp.hibernate.bbdd.dao;

import java.util.List;

import com.ntt.bootcamp.hibernate.bbdd.Cliente;

/**
 * Método que inserta un nuevo Cliente
 * 
 * @param cliente Nuevo Cliente a guardar
 * 
 */
 public interface ClienteDao {
 
	public void insert(Cliente cliente);
	
	/**
	 * Método que busca un nuevo cliente
	 * 
	 * @param cliente Nuevo Cliente a guardar
	 * 
	 */
	public Cliente searchById(Long id);
	
	public List<Cliente> getClientes();
	
	public void actualizar(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public List<Cliente> searchByNombre(String name, String apellido1, String Apellido2);
	
}
