package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DistancesMatrixController implements Initializable {

    @FXML
    private TableView<Integer> table;

    @FXML
    private TableColumn<String, Integer> chiminangos;

    @FXML
    private TableColumn<String, Integer> pasoComercio;

    @FXML
    private TableColumn<String, Integer> menga;

    @FXML
    private TableColumn<String, Integer> torreCali;

    @FXML
    private TableColumn<String, Integer> sanBosco;

    @FXML
    private TableColumn<String, Integer> sucre;

    @FXML
    private TableColumn<String, Integer> floraIndustrial;

    @FXML
    private TableColumn<String, Integer> salomia;

    @FXML
    private TableColumn<String, Integer> melendez;

    @FXML
    private TableColumn<String, Integer> unidadDeportiva;

    @FXML
    private TableColumn<String, Integer> manzanaSaber;

    @FXML
    private TableColumn<String, Integer> buitrera;

    @FXML
    private TableColumn<String, Integer> pampalinda;

    @FXML
    private TableColumn<String, Integer> refugio;

    @FXML
    private TableColumn<String, Integer> univalle;

    @FXML
    private TableColumn<String, Integer> universidades;
    
    public void generateMatrix(double[][] matrix) {
    	data.add(0) ;   	
    }
    
    private ObservableList<Integer> data = FXCollections.observableArrayList();
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chiminangos.setCellValueFactory(new PropertyValueFactory<String, Integer>("chiminangos"));	
		pasoComercio.setCellValueFactory(new PropertyValueFactory<String, Integer>("pasoComercio"));	
		menga.setCellValueFactory(new PropertyValueFactory<String, Integer>("menga"));	
		torreCali.setCellValueFactory(new PropertyValueFactory<String, Integer>("torreCali"));	
		sanBosco.setCellValueFactory(new PropertyValueFactory<String, Integer>("sanBosco"));	
		sucre.setCellValueFactory(new PropertyValueFactory<String, Integer>("sucre"));	
		floraIndustrial.setCellValueFactory(new PropertyValueFactory<String, Integer>("floraIndustrial"));	
		salomia.setCellValueFactory(new PropertyValueFactory<String, Integer>("salomia"));	
		melendez.setCellValueFactory(new PropertyValueFactory<String, Integer>("melendez"));	
		unidadDeportiva.setCellValueFactory(new PropertyValueFactory<String, Integer>("unidadDeportiva"));	
		manzanaSaber.setCellValueFactory(new PropertyValueFactory<String, Integer>("manzanaSaber"));	
		buitrera.setCellValueFactory(new PropertyValueFactory<String, Integer>("buitrera"));	
		pampalinda.setCellValueFactory(new PropertyValueFactory<String, Integer>("pampalinda"));	
		refugio.setCellValueFactory(new PropertyValueFactory<String, Integer>("refugio"));	
		univalle.setCellValueFactory(new PropertyValueFactory<String, Integer>("univalle"));	
		universidades.setCellValueFactory(new PropertyValueFactory<String, Integer>("universidades"));	
		table.setItems(data);
	}

}
