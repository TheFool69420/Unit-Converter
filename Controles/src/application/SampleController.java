package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{

    @FXML
    private RadioButton rdo2;

    @FXML
    private RadioButton rdo1;

    @FXML
    private Label lblcheck;

    @FXML
    private RadioButton rdo3;

    @FXML
    private ToggleGroup MyRadio;

    @FXML
    private Label lblradio, lblCouleur;

    @FXML
    private CheckBox chkOui;

    @FXML
    private Label lblmessage;

    @FXML
    private CheckBox chkNom;

    @FXML
    private TextField txtNom;
    
    @FXML
    private ComboBox<String> cboCouleur;
    
    @FXML
    private Label lblresult;
    
    @FXML
    private TextField txt1;
    
    @FXML
    private TextField txt2;
    
    public ObservableList<String> list=FXCollections.observableArrayList("Blanc","Rouge","Bleu");

    
    void afficher()
    {
    	lblmessage.setText("Bonjour "+ txtNom.getText());
    }
    void afficherCheck()
    {
    	if(chkNom.isSelected())
    		lblcheck.setText("Non");
    	if(chkOui.isSelected())
    		lblcheck.setText("Oui");
    }
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		cboCouleur.setItems(list);
		
	}
	
	void checkNum(TextField a)
	{
		try {
		int b=Integer.parseInt(a.getText());
		}catch (NumberFormatException e)
		
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Erreur");
			alert.setTitle("Attention");
			alert.setContentText("Numérique seulement");
			alert.show();
			a.requestFocus();
		}
	}
	@FXML
	
	void CheckText(KeyEvent e)
	{
		TextField txt=(TextField)e.getSource();
		checkNum(txt);
	}
	@FXML
	void Calculer(ActionEvent e)
	{
		Button btn=(Button)e.getSource();
		int num1=Integer.parseInt(txt1.getText());
		int num2=Integer.parseInt(txt1.getText());
		int res=0;
		if(btn.getId().equals("add"))
			res=num1+num2;
		if(btn.getId().equals("sous"))
			res=num1-num2;
		lblresult.setText(Integer.toString(res));
	}
	
	
	@FXML
	void comboChange()
	{
		//lblCouleur.setText(cboCouleur.getValue());
		lblCouleur.setText(cboCouleur.getSelectionModel().getSelectedItem());
	}
	
	
	
	/*
	public void additioner()
	{
		int one=Integer.parseInt(txt1.getText());
		int two=Integer.parseInt(txt2.getText());
		int total=one+two;
		String res=Integer.toString(total);
		lblresult.setText(res);
	}
	
	public void soustraire()
	{
		int one=Integer.parseInt(txt1.getText());
		int two=Integer.parseInt(txt2.getText());
		int total=one-two;
		String res=Integer.toString(total);
		lblresult.setText(res);
		
	}
	*/
	
	
}
