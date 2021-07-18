package ucf.assignments;

import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryTrackerController implements Initializable {

    @FXML
    private TableView<?> inventoryTable;

    @FXML
    private TableColumn<?, ?> serialNumberColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> valueColumn;

    @FXML
    private Button addItemBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button editItemBtn;
    @FXML
    private Button sortByNameBtn;
    @FXML
    private Button sortBySerialNumberBtn;
    @FXML
    private Button sortByValueBtn;
    @FXML
    private Button searchByNameBtn;
    @FXML
    private Button searchBySerialNumberBtn;
    @FXML
    private Button viewAllBtn;
    @FXML
    private Button exportToTxtBtn;
    @FXML
    private Button exportToHtmlBtn;
    @FXML
    private Button importBtn;

    @FXML
    private TextField newSerialNumber;
    @FXML
    private TextField newValue;
    @FXML
    private TextField newName;
    @FXML
    private TextField editSerialNumber;
    @FXML
    private TextField editName;
    @FXML
    private TextField editValue;
    @FXML
    private TextField txtFileName;
    @FXML
    private TextField txtFileLocation;
    @FXML
    private TextField htmlFileName;
    @FXML
    private TextField htmlFileLocation;
    @FXML
    private TextField importFileLocation;
    @FXML
    private TextField nameToSearch;
    @FXML
    private TextField serialNumberToSearch;


    @Override
    public void initialize(URL url, ResourceBundle rb){}

    @FXML
    void addItemBtnClicked(Event event) {

    }

    @FXML
    void editItemBtnClicked(Event event) {

    }

    @FXML
    void exportToHtmlBtnClicked(Event event) {

    }

    @FXML
    void exportToTxtBtnClicked(Event event) {

    }

    @FXML
    void importBtnClicked(Event event) {

    }

    @FXML
    void removeBtnClicked(Event event) {

    }

    @FXML
    void searchByNameBtnClicked(Event event) {

    }

    @FXML
    void searchBySerialNumberBtnClicked(Event event) {

    }

    @FXML
    void sortByNameBtnClicked(Event event) {

    }

    @FXML
    void sortBySerialNumberBtnClicked(Event event) {

    }

    @FXML
    void sortByValueBtnClicked(Event event) {

    }

    @FXML
    void viewAllBtnClicked(Event event) {

    }

}
