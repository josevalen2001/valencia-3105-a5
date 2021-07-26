package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jose Valencia
 */

public class InventoryTrackerController implements Initializable {

    //Create the FXML objects.
    //TableView:
    @FXML
    private TableView<InventoryItem> inventoryTable;
    //Columns:
    @FXML
    private TableColumn<InventoryItem, String> serialNumberColumn;
    @FXML
    private TableColumn<InventoryItem, String> nameColumn;
    @FXML
    private TableColumn<InventoryItem, Double> valueColumn;
    //Buttons:
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
    //TextFields:
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

    //Create an inventory for the program.
    Inventory mainInventory =  new Inventory();
    //Create an ObservableList for the TableView to display.
    ObservableList<InventoryItem> listOfItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Set each of our columns to display the correct attribute of each InventoryItem Object in the TableView.
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("serialNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("value"));
    }

    @FXML
    void addItemBtnClicked(Event event) {
        //Check if the name, serial number and value entered by the user meet all requisites.
        if((newName.getText().length() < 2 || newName.getText().length() > 256) || (newSerialNumber.getText().length() != 10) || (newValue.getText().isEmpty())) {
            //If they don't clear the fields the user just used.
            newName.setText("");
            newSerialNumber.setText("");
            newValue.setText("");
            //Return without making any other actions.
            return;
        }

        //If the user has entered a valid name, serial number and value for the item to add...
        //Save the name, serial number and value from the TextFields.
        String name = newName.getText();
        String serialNumber = newSerialNumber.getText();
        double value = Double.parseDouble(newValue.getText());

        //Check for repeated serial number with all of the other items already in out inventory.
        boolean repeatedSN = false;
        for(int i = 0; i < mainInventory.items.size(); i++)
            if(serialNumber.equals(mainInventory.items.get(i).getSerialNumber()))
                repeatedSN = true;
        //If another item with the same serial number is found...
        if(repeatedSN) {
            //Clear the fields that the user just used.
            newName.setText("");
            newSerialNumber.setText("");
            newValue.setText("");
            //Return without making any other actions.
            return;
        }

        //If the serial number is unique...
        //Create an InventoryItem object with the information provided by the user.
        InventoryItem temp = new InventoryItem(name, serialNumber, value);

        //Add the item previously created to our inventory.
        mainInventory.addItem(temp);

        //Add the item previously created to out ObservableList.
        listOfItems.add(temp);
        //Update the table of data.
        inventoryTable.setItems(listOfItems);

        //Clear the fields the user just used.
        newName.setText("");
        newSerialNumber.setText("");
        newValue.setText("");
    }

    @FXML
    void removeBtnClicked(Event event) {
        //Get the item to remove and its serial number from the item selected in the TableView.
        InventoryItem itemToRemove = inventoryTable.getSelectionModel().getSelectedItem();
        String SnOfItemToRemove = inventoryTable.getSelectionModel().getSelectedItem().getSerialNumber();

        //Remove the item from the inventory and the ObservableList.
        mainInventory.removeItem(SnOfItemToRemove);
        listOfItems.remove(itemToRemove);

        //Update the table of date.
        inventoryTable.setItems(listOfItems);
    }

    @FXML
    void editItemBtnClicked(Event event) {
        //Get the serial number of the item to edit from the item selected in the tableView.
        String SnOfItemToEdit = inventoryTable.getSelectionModel().getSelectedItem().getSerialNumber();

        //If the there is no a name, serial number and value entered in the TextFields or they are not valid...
        if((editName.getText().length() < 2 || editName.getText().length() > 256) || (editSerialNumber.getText().length() != 10) || (editValue.getText().isEmpty())) {
            //Clear the fields that the user just used.
            editName.setText("");
            editSerialNumber.setText("");
            editValue.setText("");
            //Return without making any other actions.
            return;
        }

        //If the user has entered a valid name, serial number and value for the item to edit...
        //Save the name, serial number and value from the TextFields.
        String newName = editName.getText();
        String newSN = editSerialNumber.getText();
        double newValue = Double.parseDouble(editValue.getText());

        //Check for repeated serial number with all of the other items already in out inventory.
        boolean repeatedSN = false;
        for(int i = 0; i < mainInventory.items.size(); i++)
            if(newSN.equals(mainInventory.items.get(i).getSerialNumber()))
                repeatedSN = true;
        //If another item with the same serial number is found...
        if(repeatedSN) {
            //Clear the fields that the user just used.
            editName.setText("");
            editSerialNumber.setText("");
            editValue.setText("");
            //Return without making other actions.
            return;
        }

        //If the serial number is unique...
        //Modify the item selected by the user in the inventory.
        mainInventory.editNameOfItem(SnOfItemToEdit, newName);
        mainInventory.editValueOfItem(SnOfItemToEdit, newValue);
        mainInventory.editSerialNumberOfItem(SnOfItemToEdit, newSN);

        //Clear out ObservableList.
        listOfItems.clear();
        //Add the updated items from our inventory back into the ObservableList.
        for(int i = 0 ; i < mainInventory.items.size(); i++)
            listOfItems.add(mainInventory.items.get(i));

        //Clear the fields the user just used.
        editName.setText("");
        editSerialNumber.setText("");
        editValue.setText("");
    }

    @FXML
    void exportToTxtBtnClicked(Event event) {
        //Check if the fields for the file location and name are not empty.
        if(txtFileLocation.getText().isEmpty() || txtFileName.getText().isEmpty())
            //If they are just return without making any other action.
            return;

        //If there is a file location and name...
        //Save the file location and name.
        String fileLocation = txtFileLocation.getText();
        String fileName = txtFileName.getText();
        //Export the inventory with that information.
        mainInventory.exportTSV(fileLocation, fileName);

        //Clear the fields the user just used.
        txtFileLocation.setText("");
        txtFileName.setText("");
    }

    @FXML
    void exportToHtmlBtnClicked(Event event) {
        //Check if the fields for the file location and name are not empty.
        if(htmlFileLocation.getText().isEmpty() || htmlFileName.getText().isEmpty())
            //If they are just return without making any other action.
            return;

        //If there is a file location and name...
        //Save the file location and name.
        String fileLocation = htmlFileLocation.getText();
        String fileName = htmlFileName.getText();
        //Export the inventory with that information.
        mainInventory.exportHTML(fileLocation, fileName);

        //Clear the fields the user just used.
        htmlFileLocation.setText("");
        htmlFileName.setText("");
    }

    @FXML
    void sortByNameBtnClicked(Event event) {
        //Sort the inventory as desired.
        mainInventory.sortByName();
        //Update the ObservableList.
        listOfItems.clear();
        for(int i = 0 ; i < mainInventory.items.size(); i++)
            listOfItems.add(mainInventory.items.get(i));
    }

    @FXML
    void sortBySerialNumberBtnClicked(Event event) {
        //Sort the inventory as desired.
        mainInventory.sortBySerialNumber();
        //Update the ObservableList.
        listOfItems.clear();
        for(int i = 0 ; i < mainInventory.items.size(); i++)
            listOfItems.add(mainInventory.items.get(i));
    }

    @FXML
    void sortByValueBtnClicked(Event event) {
        //Sort the inventory as desired.
        mainInventory.sortByValue();
        //Update the ObservableList.
        listOfItems.clear();
        for(int i = 0 ; i < mainInventory.items.size(); i++)
            listOfItems.add(mainInventory.items.get(i));
    }

    @FXML
    void searchByNameBtnClicked(Event event) {
        //Save the name to search for.
        String nameSearch = nameToSearch.getText();
        //Check if it is a valid name.
        if(nameSearch.length() > 2 && nameSearch.length() < 256) {
            //Check if there are any items with that name.
            if(mainInventory.searchByName(nameSearch).size() > 0) {
                //If there are clear and display those items in the ObservableList.
                listOfItems.clear();
                for(int i = 0; i < mainInventory.searchByName(nameSearch).size(); i++)
                    listOfItems.add(mainInventory.searchByName(nameSearch).get(i));
            }
        }

        //Clear the field the user just used.
        nameToSearch.setText("");
    }

    @FXML
    void searchBySerialNumberBtnClicked(Event event) {
        //Save the serial number to search for.
        String snToSearch = serialNumberToSearch.getText();
        //Check if the serial number is valid.
        if(snToSearch.length() != 10) {
            //Check if there are any items with that serial number.
            if (mainInventory.searchBySerialNumber(snToSearch) != null) {
                //If there are clear and display that item.
                listOfItems.clear();
                listOfItems.add(mainInventory.searchBySerialNumber(snToSearch));
            }
        }

        //Clear the field the user just used.
        serialNumberToSearch.setText("");
    }

    @FXML
    void viewAllBtnClicked(Event event) {
        //Reset the ObservableList.
        listOfItems.clear();
        for(int i = 0 ; i < mainInventory.items.size(); i++)
            listOfItems.add(mainInventory.items.get(i));
    }

    @FXML
    void importBtnClicked(Event event) {

    }
}
