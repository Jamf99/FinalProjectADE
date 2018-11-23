package gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {

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
    private ToggleGroup type;

    @FXML
    private RadioButton adyacentList;

    @FXML
    private ChoiceBox<?> origin;

    @FXML
    private ChoiceBox<?> ending;

    @FXML
    private ChoiceBox<?> startMst;

    @FXML
    private Label kilometers;

    @FXML
    void foundTheShortestRoad(ActionEvent event) {

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

}
