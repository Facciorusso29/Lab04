package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	private List <Corso> corsi;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> BoxCorsi;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	try {
    		Corso corso=this.BoxCorsi.getValue();
        	if(corso==null) {
        		this.txtRisultato.setText("Selezionare un corso!");
        	}
        	List <Studente> studenti=model.getStudentiByCorso(corso);
        	for(Studente s: studenti) {
        		this.txtRisultato.appendText(s.toString()+"\n");
        	}
    	}catch(RuntimeException e) {
    		txtRisultato.setText("ERRORE DI CONNESSIONE AL DATABASE!");
    	}
    	
    }

    @FXML
    void doCercaNome(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	BoxCorsi.getSelectionModel().clearSelection();
    }
    public void setModel(Model m) {
    	this.model=m;
    	corsi=model.getCorsi();
    	this.BoxCorsi.getItems().addAll(corsi);
    }
    @FXML
    void initialize() {
        assert BoxCorsi != null : "fx:id=\"BoxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
}
