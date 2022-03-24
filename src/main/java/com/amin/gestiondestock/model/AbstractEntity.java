package com.amin.gestiondestock.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
	
	@Id
	private Integer id;
	
	@CreatedDate
	private Date creationDate;
	
	@LastModifiedDate
	private Date lastUpdateDate;

}
