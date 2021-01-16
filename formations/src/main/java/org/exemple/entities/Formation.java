package org.exemple.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation implements Serializable{
	@Id @GeneratedValue
	private long id;
	private String nom;
	private int duree;
	@OneToMany(mappedBy="formation")
	@JsonIgnore
	private Collection<Etudiant> etudiants;

}
