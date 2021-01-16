package test;




import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.geometry.Insets;


public class ClientJMS extends Application  {
	private Session session;
	private MessageProducer  messageProducer ;
	
	public static void main(String[]args)  {
	
		
	}
	@Override
	public void start(Stage primaryStage)  {
		
		initialisation();		
		primaryStage.setTitle("Client JMS");
		GridPane gridPane=new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(10));
		
		Label labelNom= new Label("Nom :");
		TextField textFieldNom=new TextField();
		
		Label labelPrenom= new Label("Prenom :");
		TextField textFieldPrenom=new TextField();
		
		Button buttonInscrire=new Button("Inscrire");
		gridPane.add(labelNom, 0, 0);
		gridPane.add(textFieldNom, 1, 0);
		gridPane.add(labelPrenom, 0, 1);
		gridPane.add(textFieldPrenom, 1, 1);
		gridPane.add(buttonInscrire, 0, 2);
		
	
		Scene scene=new Scene(gridPane,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		buttonInscrire.setOnAction(e->{
			try {
				String nom=textFieldNom.getText();
				String prenom=textFieldPrenom.getText();			
				// a chaque fois que je clique sur la boutton je vais envoyer un message
				TextMessage textMessage=session.createTextMessage();
				textMessage.setText(nom+"_"+prenom);
				messageProducer.send(textMessage);
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			});
	}
	public void initialisation() {
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

			 connectionFactory.setBrokerURL("tcp://localhost:61616");
			Connection connection=connectionFactory.createConnection();
			session=connection.createSession
					(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			Destination d=session.createQueue("scolarite.queue");
		    messageProducer=session.createProducer(d);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
