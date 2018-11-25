package gui;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
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
		if (v1.equals(v2)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("There is not distance between " + v1 + " and " + v2);
			alert.showAndWait();
			kilometers.setText(0 + "");
		} else {
			try {
				kilometers.setText(model.getOperator().Dijkstra(model.getGraph(), v1, v2).getDist() + "");
				List<String> list = model.getOperator().Dijkstra(model.getGraph(), v1, v2).getList();
				paint(list);
			} catch (Exception e) {

			}
		}
	}

	public void paint(List<String> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String value = list.get(i);
			if (vertexMap.containsKey(value)) {
				vertexMap.get(value).setFill(Color.RED);
			}
			try {
				if (i + 1 < size) {
					Edge<String> aux = foundEdge(list.get(i), list.get(i + 1));
					if (edgeMap.containsKey(aux)) {
						edgeMap.get(aux).setStroke(Color.RED);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Edge<String> foundEdge(String start, String ending) {
		for (Edge<String> edge : model.getGraph().getEdges()) {
			if ((edge.getEnding().equalsIgnoreCase(ending) || edge.getEnding().equals(start))
					&& (edge.getStart().equalsIgnoreCase(start) || edge.getStart().equals(ending))) {
				return edge;
			}
		}
		return null;
	}

	public void asignateEdges() {
		int i = 0;
		for (Edge<String> edge : model.getGraph().getEdges()) {
			edgeMap.put(edge, lines[i]);
			i++;
		}
	}

	@FXML
	void generateAdyacentMatrix(ActionEvent event) {
		double[][] matrix = model.getGraph().generateWeightMatrix();
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("|");
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == Double.POSITIVE_INFINITY) {
					System.out.print("-");
				}else {
					System.out.print(matrix[i][j]);
				}
				if(j!=matrix[i].length-1) {
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/adyacentMatrix.fxml"));
			loader.load();
			DistancesMatrixController estado = loader.getController();
			Parent p = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.setTitle("Distances Matrix");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/view/logo.jpg")));
			stage.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void generateDistanceMatrix(ActionEvent event) {

	}

	@FXML
	void generateMST(ActionEvent event) {
		revert();
		String origin = startMst.getSelectionModel().getSelectedItem();
		try {
			InterfaceGraph<String> graph = model.getOperator().prim(model.getGraph(), origin);
			for (String r : graph.getVertices()) {
				if (vertexMap.containsKey(r)) {
					vertexMap.get(r).setFill(Color.DARKORANGE);
				}
			}
			double distance = 0;
			for (Edge<String> edges : graph.getEdges()) {
				if (edgeMap.containsKey(edges)) {
					edgeMap.get(edges).setStroke(Color.DARKORANGE);
					distance+=edges.getValue();
				}
			}
			vertexMap.get(origin).setFill(Color.ORANGE);
			kilometers.setText(distance+"");
		} catch (Exception e) {

		}
	}

	public void revert() {
		kilometers.setText(0 + "");
		for(Circle entry : vertexMap.values()) {
			entry.setFill(Color.DODGERBLUE);
		}
		for(Line entry : edgeMap.values()) {
			entry.setStroke(Color.BLACK);
		}
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
		lines[0] = refugio_universidades;
		lines[1] = sanBosco_sucre;
		lines[2] = menga_torreCali;
		lines[3] = torreCali_sanBosco;
		lines[4] = sucre_salomia;
		lines[5] = melendez_pampalinda;
		lines[6] = menga_floraIndustrial;
		lines[7] = unidadDeportiva_manzanaSaber;
		lines[8] = pasoComercio_menga;
		lines[9] = melendez_unidadDeportiva;
		lines[10] = pampalinda_refugio;
		lines[11] = sucre_melendez;
		lines[12] = buitrera_universidades;
		lines[13] = univalle_universidades;
		lines[14] = buitrera_refugio;
		lines[15] = unidadDeportiva_pampalinda;
		lines[16] = salomia_manzanaSaber;
		lines[17] = chiminangos_menga;
		lines[18] = manzanaSaber_univalle;
		lines[19] = melendez_buitrera;
		lines[20] = chiminangos_pasoComercio;
		lines[21] = manzanaSaber_universidades;
		lines[22] = floraIndustrial_sanBosco;
		lines[23] = floraIndustrial_manzanaSaber;

		vertexMap.put("Chiminangos", chiminangos);
		vertexMap.put("Paso del Comercio", pasoDelComercio);
		vertexMap.put("Menga", menga);
		vertexMap.put("Torre de Cali", torreCali);
		vertexMap.put("San Bosco", sanBosco);
		vertexMap.put("Sucre", sucre);
		vertexMap.put("Flora industrial", floraIndustrial);
		vertexMap.put("Salomia", salomia);
		vertexMap.put("Melendez", melendez);
		vertexMap.put("Unidad deportiva", unidadDeportiva);
		vertexMap.put("Manzana del saber", manzanaSaber);
		vertexMap.put("Buitrera", buitrera);
		vertexMap.put("Pampalinda", pampalinda);
		vertexMap.put("Refugio", refugio);
		vertexMap.put("Univalle", univalle);
		vertexMap.put("Universidades", universidades);
		asignateEdges();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = new Mio(adyacentMatrix.isSelected());

		ObservableList<String> states = FXCollections.observableArrayList("Chiminangos", "Paso del Comercio", "Menga",
				"Torre de Cali", "San Bosco", "Sucre", "Flora industrial", "Salomia", "Melendez", "Unidad deportiva",
				"Manzana del saber", "Buitrera", "Pampalinda", "Refugio", "Univalle", "Universidades");

		origin.setItems(states);
		origin.getSelectionModel().select(0);
		ending.setItems(states);
		ending.getSelectionModel().select(1);
		startMst.setItems(states);
		startMst.getSelectionModel().select(0);
		start();
	}

}
