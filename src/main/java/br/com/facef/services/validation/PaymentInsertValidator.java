package br.com.facef.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.facef.controller.exceptions.FieldMessage;
import br.com.facef.domain.Payment;
import br.com.facef.repositories.PaymentRepository;

public class PaymentInsertValidator implements ConstraintValidator<PaymentInsert, Payment> {
	@Override
	public void initialize(PaymentInsert ann) {
	}
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public boolean isValid(Payment objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

//		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
//			list.add(new FieldMessage("cpfOuCnpj","CPF inválido"));
//		}
//		
//		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
//			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
//		}
//		
//		Optional<Payment> aux = paymentRepository.findByScheduleId(objDto.getScheduleId());
		
		Optional<Payment> aux = paymentRepository.findByScheduleId(objDto.getId());

		if(aux != null) {
			list.add(new FieldMessage("email", "Email já cadastrado! Insira um email válido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}