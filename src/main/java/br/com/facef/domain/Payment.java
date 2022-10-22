package br.com.facef.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
//@Getter @Setter @EqualsAndHashCode
@JsonDeserialize(as = Payment.class)
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1248794860772538520L;

	@Id
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("scheduleId")
	private Integer scheduleId;
	@JsonProperty("amount")
	private BigDecimal amount;
	@JsonProperty("paymentType")
	private String paymentType;
	@JsonProperty("paymentCode")
	private String paymentCode;
	private Date createdAt;
	private Date updatedAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, paymentCode, paymentType, scheduleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id) && Objects.equals(paymentCode, other.paymentCode)
				&& Objects.equals(paymentType, other.paymentType) && Objects.equals(scheduleId, other.scheduleId);
	}


}
