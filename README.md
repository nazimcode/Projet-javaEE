# ServiceWeb
Le projet est simulation à la gestion de scolarité tel qu’un étudiant est inscrit à une formation et une formation peut contenir plusieurs étudiants pour cela nous avons :
-Créer un microcontrôleur REST :
    	RestController de Spring MVC
 -Utilisation d’un SGBD Mémoire (H2)
-JMS utilisant le broker ActiveMQ
Description : elle est basée sur plusieurs couches : 
Couche DAO : dans laquelle il y’a les entitées Etudiant et Formation les interface JPA Repository .
Couche web : Tamcat et creation du web service Web en utilisant RestController de Spring MVC et JMS Listener ce dernier pour pouvoir
communiquer d’une manière Asynchrone entre le microservice et le client JMS
Client JMS
