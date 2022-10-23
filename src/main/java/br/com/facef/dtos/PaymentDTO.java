package br.com.facef.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO  implements Serializable  {

	private static final long serialVersionUID = 1752368879741493508L;

	private Integer id;
	private Integer scheduleId;
	private BigDecimal amount;
	private String paymentType;
	private String paymentCode;
	@JsonFormat(pattern="dd/MM/yyyy", timezone = "America/Sao_Paulo", locale = "pt_Br")
	private LocalDate createdAt;
	@JsonFormat(pattern="dd/MM/yyyy", timezone = "America/Sao_Paulo", locale = "pt_Br")
	private LocalDate updatedAt;
	
}

