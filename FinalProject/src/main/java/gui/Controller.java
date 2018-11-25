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
import structures.InterfaceGraph;

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
    			paint(list);
    		}catch(Exception e) {
    			
    		}
    	}
    }
    
    public void paint(List<String> list) {
    	int size = list.size();
    	for(int i = 0; i < size; i++) {
    		String value = list.get(i);
    		if(vertexMap.containsKey(value)) {
    			vertexMap.get(value).setFill(Color.RED);
    		}
    		try {
    			if(i+1<size) {
    				Edge<String> aux = foundEdge(list.get(i), list.get(i+1));
    				if(edgeMap.containsKey(aux)) {
    	    			edgeMap.get(aux).setStroke(Color.RED);
    	    		}
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public Edge<String> foundEdge(String start, String ending) {
    	for(Edge<String> edge: model.getGraph().getEdges()) {
    		if((edge.getEnding().equalsIgnoreCase(ending) || edge.getEnding().equals(start)) && (edge.getStart().equalsIgnoreCase(start) || edge.getStart().equals(ending))) {
    			return edge;
    		}
    	}
    	return null;
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
    	String origin = startMst.getSelectionModel().getSelectedItem();
    	try {
    		if(adyacentMatrix.isSelected()) {
    			InterfaceGraph<String> graphMatrix = model.getOperator().prim(model.getGraph(), origin);
    			graphMatrix.getVertices();
    			for(String r : graphMatrix.getVertices()) {
    				if(vertexMap.containsKey(r)) {
    					vertexMap.get(r).setFill(Color.ORANGE);
    				}
    			}
    			for(Edge<String> edges: graphMatrix.getEdges()) {
    				if(edgeMap.containsKey(edges)) {
    					edgeMap.get(edges).setStroke(Color.ORANGE);
    				}
    			}
    		}else {
    		
    		}
    	}catch(Exception e) {
    		
    	}
    }
    
    public void revert() {
    	kilometers.setText(0+"");
    	menga.setFill(Color.DODGERBLUE);torreCali.setFill(Color.DODGERBLUE);chiminangos.setFill(Color.DODGERBLUE);pasoDelComercio.setFill(Color.DODGERBLUE);
    	floraIndustrial.setFill(Color.DODGERBLUE);sanBosco.setFill(Color.DODGERBLUE);sucre.setFill(Color.DODGERBLUE);salomia.setFill(Color.DODGERBLUE);
    	melendez.setFill(Color.DODGERBLUE);unidadDeportiva.setFill(Color.DODGERBLUE);manzanaSaber.setFill(Color.DODGERBLUE);buitrera.setFill(Color.DODGERBLUE);
    	refugio.setFill(Color.DODGERBLUE);universidades.setFill(Color.DODGERBLUE);univalle.setFill(Color.DODGERBLUE);pampalinda.setFill(Color.DODGERBLUE);	
    	menga_floraIndustrial.setStroke(Color.BLACK);chiminangos_pasoComercio.setStroke(Color.BLACK);chiminangos_pasoComercio.setStroke(Color.BLACK);
    	chiminangos_menga.setStroke(Color.BLACK);menga_torreCali.setStroke(Color.BLACK);floraIndustrial_manzanaSaber.setStroke(Color.BLACK);
    	pasoComercio_menga.setStroke(Color.BLACK);torreCali_sanBosco.setStroke(Color.BLACK);floraIndustrial_sanBosco.setStroke(Color.BLACK);
    	sucre_salomia.setStroke(Color.BLACK);sucre_melendez.setStroke(Color.BLACK);melendez_buitrera.setStroke(Color.BLACK);salomia_manzanaSaber.setStroke(Color.BLACK);
    	melendez_unidadDeportiva.setStroke(Color.BLACK);unidadDeportiva_manzanaSaber.setStroke(Color.BLACK);unidadDeportiva_pampalinda.setStroke(Color.BLACK);
    	melendez_pampalinda.setStroke(Color.BLACK);pampalinda_refugio.setStroke(Color.BLACK);buitrera_refugio.setStroke(Color.BLACK);
    	buitrera_universidades.setStroke(Color.BLACK);refugio_universidades.setStroke(Color.BLACK);manzanaSaber_univalle.setStroke(Color.BLACK);
    	manzanaSaber_universidades.setStroke(Color.BLACK);univalle_universidades.setStroke(Color.BLACK);sanBosco_sucre.setStroke(Color.BLACK);
    }
    
    

    @FXML
    void repaint(ActionEvent event) {
    	revert();
    }
    
    @FXML
    void selectAdyacentList(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(true);
    	revert();
    	model = new Mio(false);
    }

    @FXML
    void selectAdyacentMatrix(ActionEvent event) {
    	butGenerateAdyacentMatrix.setDisable(false);
    	revert();
    	model = new Mio(true);
    }

    public void start() {
    	vertexMap = new HashMap<String, Circle>();
		edgeMap = new HashMap<Edge<String>, Line>();
    	lines = new Line[24];
		lines[0] = refugio_universidades;lines[1] = sanBosco_sucre;lines[2] = menga_torreCali;
		lines[3] = torreCali_sanBosco;lines[4] = sucre_salomia;lines[5] = melendez_pampalinda;
		lines[6] = menga_floraIndustrial;lines[7] = unidadDeportiva_manzanaSaber;lines[8] = pasoComercio_menga;
		lines[9] = melendez_unidadDeportiva;lines[10] = pampalinda_refugio;lines[11] = sucre_melendez;
		lines[12] = buitrera_universidades;lines[13] = univalle_universidades;lines[14] = buitrera_refugio;
		lines[15] = unidadDeportiva_pampalinda;lines[16] = salomia_manzanaSaber;lines[17] = chiminangos_menga;
		lines[18] = manzanaSaber_univalle;lines[19] = melendez_buitrera;lines[20] = chiminangos_pasoComercio;
		lines[21] = manzanaSaber_universidades;lines[22] = floraIndustrial_sanBosco;lines[23] = floraIndustrial_manzanaSaber;
		
		vertexMap.put("Chiminangos", chiminangos);vertexMap.put("Paso del Comercio", pasoDelComercio);vertexMap.put("Menga", menga);
		vertexMap.put("Torre de Cali", torreCali);vertexMap.put("San Bosco", sanBosco);vertexMap.put("Sucre", sucre);
		vertexMap.put("Flora industrial", floraIndustrial);vertexMap.put("Salomia", salomia);vertexMap.put("Melendez", melendez);
		vertexMap.put("Unidad deportiva", unidadDeportiva);vertexMap.put("Manzana del saber", manzanaSaber);vertexMap.put("Buitrera", buitrera);
		vertexMap.put("Pampalinda", pampalinda);vertexMap.put("Refugio", refugio);vertexMap.put("Univalle", univalle);vertexMap.put("Universidades", universidades);
		asignateEdges();
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
		start();
	}

}
