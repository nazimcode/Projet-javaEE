package org.exemple;

import java.util.stream.Stream;

import org.exemple.dao.EtudiantRepository;
import org.exemple.dao.FormationRepository;
import org.exemple.entities.Etudiant;
import org.exemple.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationsApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private FormationRepository formationRepository;
	public static void main(String[] args) {
		SpringApplication.run(FormationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("java","JEE","Oracle").forEach(nF->{
			Formation f= new Formation();
			f.setNom(nF);f.setDuree(30);
			formationRepository.save(f);
		});
	
		Stream.of("java","JEE","Oracle").forEach(nF->{
			Formation f= new Formation();
			f.setNom(nF);f.setDuree(30);
			formationRepository.save(f);
		});
	
		etudiantRepository.save(new Etudiant(1,"Asseum","Maya",new Formation(1,null,0,null)));
		etudiantRepository.save(new Etudiant(2,"ounouh","Ahmed",new Formation(2,null,0,null)));
		etudiantRepository.save(new Etudiant(3,"bekkouche","Hanane",new Formation(1,null,0,null)));
		etudiantRepository.save(new Etudiant(1,"Zmalache","ilyes",new Formation(3,null,0,null)));
		etudiantRepository.save(new Etudiant(1,"omira","Rafik",new Formation(1,null,0,null)));
		
		formationRepository.findAll().forEach(f->{
			System.out.println(f.getNom());
		});
		
		
	}

}
