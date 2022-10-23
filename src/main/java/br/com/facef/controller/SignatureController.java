package br.com.facef.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.facef.domain.Payment;
import br.com.facef.services.PaymentService;

@RestController
@RequestMapping(value = "/signature")
public class SignatureController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Integer id){
		Payment payment = paymentService.findById(id);
		return ResponseEntity.ok().body(payment);
	}
	
	@PostMapping(value = "/paymentteste")
	public ResponseEntity<Object> insertt(@RequestBody Object obj){
		System.out.println("Object" + obj);
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping(value = "/payment")
	public ResponseEntity<Payment> insert(@RequestBody Payment obj){
		obj = paymentService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok().build();
    }
		
}
