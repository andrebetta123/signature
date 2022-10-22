package br.com.facef.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.facef.domain.Payment;
import br.com.facef.repositories.PaymentRepository;
import br.com.facef.services.exceptions.ObjectNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public Payment findById(Integer id) {
		Optional<Payment> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! ID: " + id + ", Tipo: " 
		+ Payment.class.getName()));
	}
	
	@Transactional
	public Payment insert(Payment obj) {
		repository.save(obj);
		return obj;
	}
	
	public Page<Payment> findByPage(Integer page, Integer linesPerPage, String orderBy, String direction){

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
		
	}
	
}
