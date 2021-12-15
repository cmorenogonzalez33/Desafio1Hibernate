package com.ntt.bootcamp.hibernate.services.impl;

import com.ntt.bootcamp.hibernate.bbdd.Cliente;
import com.ntt.bootcamp.hibernate.bbdd.dao.ClienteDao;
import com.ntt.bootcamp.hibernate.services.ClienteService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional
	public void insertNewCliente(Cliente cliente) {
		clienteDao.insert(cliente);
	}
	
	@Override
	@Transactional
	public Cliente searchClienteById(Long id) {
		Cliente cliente = null;
		
		if(null != id) {
			cliente = clienteDao.searchById(id);
		}
		
		return cliente;
	}
	
	@Override
	@Transactional
	public List<Cliente> findAllClient(){
		return clienteDao.getClientes();
	}
	
	@Override
	@Transactional
	public void actualizaCliente(Cliente cliente){
		clienteDao.actualizar(cliente);
	}
	
	@Override
	@Transactional
	public void eliminarCliente(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
	@Override
	@Transactional
	public List<Cliente> searchClienteByNombre(String name, String apellido1, String apellido2){
		return clienteDao.searchByNombre(name, apellido1, apellido2);
	}
}
