package gui;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import model.Mio;

public class Controller implements Initializable {
	
	private Mio model;

    @FXML
    private Circle menga;

    @FXML
    private Circle torreCali;

    @FXML
    private Line menga_torreCali;

    @FXML
    private Circle melendez;

    @FXML
    private Circle salomia;

    @FXML
    private Circle buitrera;

    @FXML
    private Circle sucre;

    @FXML
    private Circle refugio;

    @FXML
    private Circle chiminangos;

    @FXML
    private Circle pasoDelComercio;

    @FXML
    private Circle floraIndustrial;

    @FXML
    private Circle unidadDeportiva;

    @FXML
    private Circle manzanaSaber;

    @FXML
    private Circle universidades;

    @FXML
    private Circle univalle;

    @FXML
    private Circle pampalinda;

    @FXML
    private Circle sanBosco;

    @FXML
    private Line buitrera_refugio;

    @FXML
    private Line manzanaSaber_universidades;

    @FXML
    private Line univalle_universidades;

    @FXML
    private Line refugio_universidades;

    @FXML
    private Line chiminangos_menga;

    @FXML
    private Line floraIndustrial_sanBosco;

    @FXML
    private Line torreCali_sanBosco;

    @FXML
    private Line sanBosco_sucre;

    @FXML
    private Line menga_floraIndustrial;

    @FXML
    private Line pasoComercio_menga;

    @FXML
    private Line buitrera_universidades;

    @FXML
    private Line melendez_unidadDeportiva;

    @FXML
    private Line sucre_melendez;

    @FXML
    private Line sucre_salomia;

    @FXML
    private Line floraIndustrial_manzanaSaber;

    @FXML
    private Line unidadDeportiva_pampalinda;

    @FXML
    private Line melendez_buitrera;

    @FXML
    private Line salomia_manzanaSaber;

    @FXML
    private Line chiminangos_pasoComercio;

    @FXML
    private Line pampalinda_refugio;

    @FXML
    private Line manzanaSaber_univalle;

    @FXML
    private RadioButton adyacentMatrix;
    
    @FXML
    private Button butGenerateAdyacentMatrix;

    @FXML
    private ToggleGroup type;

    @FXML
    private RadioButton adyacentList;

    @FXML
    private ChoiceBox<String> origin;

    @FXML
    private ChoiceBox<String> ending;

    @FXML
    private ChoiceBox<String> startMst;

    @FXML
    private Label kilometers;

    @FXML
    void foundTheShortestRoad(ActionEvent event) {
    	String v1 = origin.getSelectionModel().getSelectedItem();
    	String v2 = ending.getSelectionModel().getSelectedItem();
    	if(v1.equals(v2)) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText("There is not distance between "+v1+" and "+v2);
    		alert.showAndWait();
    		kilometers.setText(0+"");
    	}else {
    		try {
    			model.getOperator().Dijkstra(model.getGraph(), v1, v2);
    		}catch(Exception e) {
    			
    		}
    	}
    }

    @FXML
    void generateAdyacentMatrix(ActionEvent event) {

    }

    @FXML
    void generateDistanceMatrix(ActionEvent event) {

    }

    @FXML
    void generateMST(ActionEvent event) {

    }

    @FXML
    void repaint(ActionEvent event) {

    }
    
    @FXML
    void selectAdyacentList(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(true);
    }

    @FXML
    void selectAdyacentMatrix(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(false );
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = new Mio(adyacentMatrix.isSelected());
		ObservableList<String> states = FXCollections.observableArrayList("Chiminangos", "Paso del Comercio", "Menga", "Torre de Cali",
				"San Bosco", "Sucre", "Flora industrial", "Salomia", "Melendez", "Unidad deportiva", "Manzana del saber", "Buitrera",
				"Pampalinda", "Refugio", "Univalle", "Universidades");
		origin.setItems(states);
		origin.getSelectionModel().select(0);
		ending.setItems(states);
		ending.getSelectionModel().select(1);
		startMst.setItems(states);
		startMst.getSelectionModel().select(0);
	}

}
