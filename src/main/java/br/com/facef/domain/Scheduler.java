package br.com.facef.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
//@Getter @Setter @EqualsAndHashCode
public abstract class Scheduler implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Long userId;
	private Long startedAt;
	private Long finishedAt;
	private Long amount;
	private Long createdAt;
	private Long updatedAt;

}
