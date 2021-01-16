package org.exemple.entities;

import java.io.Serializable;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
	@Id 
	@GeneratedValue
	private long id;
	private String nom;
	private String prenom;
	@ManyToOne
	private Formation formation;
	

}
