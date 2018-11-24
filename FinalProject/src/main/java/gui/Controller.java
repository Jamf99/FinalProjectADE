package gui;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import model.Mio;
import structures.Edge;

public class Controller implements Initializable {
	
	private Mio model;
	
	private HashMap<String, Circle> vertexMap;
	
	private HashMap<Edge<String>, Line> edgeMap;
	
	private Line[] lines;

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
    private Line unidadDeportiva_manzanaSaber;
    
    @FXML
    private Line melendez_pampalinda;

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
    	revert();
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
    			kilometers.setText(model.getOperator().Dijkstra(model.getGraph(), v1, v2).getDist()+"");
    			List<String> list = model.getOperator().Dijkstra(model.getGraph(), v1, v2).getList();
    			paintVertices(list);
    		}catch(Exception e) {
    			
    		}
    	}
    }
    
    public void paintVertices(List<String> list) {
    	for(int i = 0; i < list.size(); i++) {
    		String value = list.get(i);
    		if(vertexMap.containsKey(value)) {
    			vertexMap.get(value).setFill(Color.RED);
    		}
//    		try {
//    			if(list.get(i+1)!= null) {
//    				Edge<String> aux = model.getGraph().exist
//    				if(edgeMap.containsKey(aux)) {
//    	    			edgeMap.get(aux).setFill(Color.RED);
//    	    		}
//    			}
//    		}catch(Exception e) {
//    			
//    		}
    	}
    }
    
    public void asignateEdges() {
    	int i = 0;
    	for(Edge<String> edge: model.getGraph().getEdges()) {
    		edgeMap.put(edge, lines[i]);
    		i++;
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
    	revert();
    }
    
    public void revert() {
    	kilometers.setText(0+"");
    	menga.setFill(Color.DODGERBLUE);torreCali.setFill(Color.DODGERBLUE);chiminangos.setFill(Color.DODGERBLUE);pasoDelComercio.setFill(Color.DODGERBLUE);
    	floraIndustrial.setFill(Color.DODGERBLUE);sanBosco.setFill(Color.DODGERBLUE);sucre.setFill(Color.DODGERBLUE);salomia.setFill(Color.DODGERBLUE);
    	melendez.setFill(Color.DODGERBLUE);unidadDeportiva.setFill(Color.DODGERBLUE);manzanaSaber.setFill(Color.DODGERBLUE);buitrera.setFill(Color.DODGERBLUE);
    	refugio.setFill(Color.DODGERBLUE);universidades.setFill(Color.DODGERBLUE);univalle.setFill(Color.DODGERBLUE);pampalinda.setFill(Color.DODGERBLUE);	
    	menga_floraIndustrial.setFill(Color.BLACK);chiminangos_pasoComercio.setFill(Color.BLACK);chiminangos_pasoComercio.setFill(Color.BLACK);
    	chiminangos_menga.setFill(Color.BLACK);menga_torreCali.setFill(Color.BLACK);floraIndustrial_manzanaSaber.setFill(Color.BLACK);
    	pasoComercio_menga.setFill(Color.BLACK);torreCali_sanBosco.setFill(Color.BLACK);floraIndustrial_sanBosco.setFill(Color.BLACK);
    	sucre_salomia.setFill(Color.BLACK);sucre_melendez.setFill(Color.BLACK);melendez_buitrera.setFill(Color.BLACK);salomia_manzanaSaber.setFill(Color.BLACK);
    	melendez_unidadDeportiva.setFill(Color.BLACK);unidadDeportiva_manzanaSaber.setFill(Color.BLACK);unidadDeportiva_pampalinda.setFill(Color.BLACK);
    	melendez_pampalinda.setFill(Color.BLACK);pampalinda_refugio.setFill(Color.BLACK);buitrera_refugio.setFill(Color.BLACK);
    	buitrera_universidades.setFill(Color.BLACK);refugio_universidades.setFill(Color.BLACK);manzanaSaber_univalle.setFill(Color.BLACK);
    	manzanaSaber_universidades.setFill(Color.BLACK);univalle_universidades.setFill(Color.BLACK);sanBosco_sucre.setFill(Color.BLACK);
    }
    
    

    @FXML
    void repaint(ActionEvent event) {
    	revert();
    }
    
    @FXML
    void selectAdyacentList(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(true);
    	revert();
    	
    }

    @FXML
    void selectAdyacentMatrix(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(false);
    	revert();
    }

    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		vertexMap = new HashMap<String, Circle>();
		edgeMap = new HashMap<Edge<String>, Line>();
		lines = new Line[24];
		lines[0] = chiminangos_pasoComercio;lines[1] = chiminangos_menga;lines[2] = pasoComercio_menga;
		lines[3] = menga_torreCali;lines[4] = menga_floraIndustrial;lines[5] = torreCali_sanBosco;
		lines[6] = floraIndustrial_sanBosco;lines[7] = sanBosco_sucre;lines[8] = sucre_salomia;
		lines[9] = sucre_melendez;lines[10] = salomia_manzanaSaber;lines[11] = unidadDeportiva_manzanaSaber;
		lines[12] = melendez_pampalinda;lines[13] = melendez_unidadDeportiva;lines[14] = melendez_buitrera;
		lines[15] = unidadDeportiva_pampalinda;lines[16] = pampalinda_refugio;lines[17] = buitrera_refugio;
		lines[18] = refugio_universidades;lines[19] = buitrera_universidades;lines[20] = manzanaSaber_universidades;
		lines[21] = manzanaSaber_univalle;lines[22] = univalle_universidades;lines[23] = floraIndustrial_manzanaSaber;
		
		vertexMap.put("Chiminangos", chiminangos);vertexMap.put("Paso del Comercio", pasoDelComercio);vertexMap.put("Menga", menga);
		vertexMap.put("Torre de Cali", torreCali);vertexMap.put("San Bosco", sanBosco);vertexMap.put("Sucre", sucre);
		vertexMap.put("Flora Industrial", floraIndustrial);vertexMap.put("Salomia", salomia);vertexMap.put("Melendez", melendez);
		vertexMap.put("Unidad deportiva", unidadDeportiva);vertexMap.put("Manzana del saber", manzanaSaber);vertexMap.put("Buitrera", buitrera);
		vertexMap.put("Pampalinda", pampalinda);vertexMap.put("Refugio", refugio);vertexMap.put("Univalle", univalle);vertexMap.put("Universidades", universidades);

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
		asignateEdges();
	}

}
