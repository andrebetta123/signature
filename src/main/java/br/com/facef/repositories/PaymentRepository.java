package br.com.facef.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facef.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Optional<Payment> findByScheduleId(Integer integer);
}
