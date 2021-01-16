package org.exemple.web;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.exemple.dao.EtudiantRepository;
import org.exemple.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListeners {
	@Autowired
	private EtudiantRepository etudiantRepository; 
	
	@JmsListener(destination="scolarite.queue")
	public void receive(Message message) throws Exception {
		if(message instanceof TextMessage) {
			String contenu=((TextMessage) message).getText();
			System.out.println("******************************");
			System.out.println("reception du message :"+contenu);
			System.out.println("*******************************");
			Etudiant et=new Etudiant();			
			String[] tab= contenu.split("_");
			String nom=tab[0];
			String prenom=tab[1];
			
			et.setNom(nom);
			et.setPrenom(nom);
			
			etudiantRepository.save(et);
		}
		
	}
	
}
