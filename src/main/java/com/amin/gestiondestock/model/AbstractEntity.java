package com.amin.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(name="creationDate", nullable = false, updatable = false)
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name="lastModifiedDate")
	private Instant lastModificationDate;

	//@PrePersist
	//void prePersist() {
		//creationDate = Instant.now();
	//}

	// @PreUpdate
	//void preUpdate() {
	//	 lastModificationDate = Instant.now();
	//}

}
