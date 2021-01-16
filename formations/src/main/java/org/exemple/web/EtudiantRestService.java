package org.exemple.web;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.exemple.dao.EtudiantRepository;
import org.exemple.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Path("/scolarite")
public class EtudiantRestService {
	@Autowired
	private EtudiantRepository etudiantRepository;
	/*afficher la liste des etudiants*/
	@GET
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> list(){
		return etudiantRepository.findAll();	
		
	}
	/* afficher un etudiant
	@GET
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant save(@javax.ws.rs.PathParam("id")Long id){		
		return etudiantRepository.findOne(id);	
		
	}*/
	/*ajouter un etudiant*/
	@POST
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant save(Etudiant etudiant){
		return etudiantRepository.save(etudiant);	
		
	}
	/*la mise a jour des données*/
	
	@PUT
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant update(@javax.ws.rs.PathParam("id")Long id, Etudiant etudiant){
		etudiant.setId(id);
		return etudiantRepository.save(etudiant);	
		
	}
	/*Suppression d'un etudiant*/
	@DELETE
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@javax.ws.rs.PathParam("id")Long id){
			
	}
}
