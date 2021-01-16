package org.exemple.dao;

import org.exemple.entities.Etudiant;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
