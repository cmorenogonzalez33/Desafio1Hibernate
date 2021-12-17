package com.ntt.bootcamp.hibernate.bbdd.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntt.bootcamp.hibernate.bbdd.Cliente;
import com.ntt.bootcamp.hibernate.bbdd.dao.ClienteDao;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	/**
	 * Manejador de entidades
	 */
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Insertamos en bbdd
		currentSession.save(cliente);
		
		//Cerramos la sesión
		currentSession.close();
	}
	
	@Override
	@Transactional
	public Cliente searchById(Long id) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
				
		//Buscamos en bbdd
		Cliente cliente = currentSession.find(Cliente.class, id);
				
		//Cerramos la sesión
		currentSession.close();
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Cliente> getClientes(){
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Buscamos en bbdd
		List<Cliente> clientes = currentSession.createQuery("FROM Cliente").list();	
		
		//Cierro la sesión
		currentSession.close();
		
		return clientes;
	}
	
	@Override
	@Transactional
	public void actualizar(Cliente cliente) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
				
		//Insertamos en bbdd
		currentSession.update(cliente);
						
		//Cerramos la sesión
		currentSession.close();
	}
	
	@Override
	@Transactional
	public void delete(Cliente cliente) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Elimino en bbdd
		entityManager.remove(entityManager.merge(cliente));
		
		//Cierro la sesión
		currentSession.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	@Transactional
	public List<Cliente> searchByNombre(String name, String apellido1, String apellido2) {
		
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		final List<Cliente> clientes = currentSession
				.createQuery("FROM Cliente WHERE nombre='" + name + "' AND primerApellido='" + apellido1 + "' AND segundoApellido='" + apellido2 + "'").list();
				
		//Cerramos la sesión
		currentSession.close();
		
		return clientes;
	}
}
