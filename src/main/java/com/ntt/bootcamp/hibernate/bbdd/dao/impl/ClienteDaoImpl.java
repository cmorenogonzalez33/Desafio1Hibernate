package com.ntt.bootcamp.hibernate.bbdd.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
	@Override
	@Transactional
	public List<Cliente> getClientes(){
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Buscamos en bbdd
		List<Cliente> clientes = (List<Cliente>) currentSession.createQuery("FROM Cliente").list();	
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
		
		Cliente cli = (Cliente) currentSession.load(Session.class, cliente.getId());
		
		//Elimino en bbdd
		currentSession.delete(cli);
		
		//Cierro la sesión
		currentSession.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	@Transactional
	public List<Cliente> searchByNombre(String name, String apellido1, String apellido2) {
		
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery("SELECT p FROM clientes p WHERE nombre=? AND primerApellido=? AND segundoApellido=?");
		query.setString(0, name);
		query.setString(1, apellido1);
		query.setString(2, apellido2);
						
		//Buscamos en bbdd
		List<Cliente> clientes = query.list();
				
		//Cerramos la sesión
		currentSession.close();
		return clientes;
	}
}
