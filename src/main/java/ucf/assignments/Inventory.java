package ucf.assignments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Comparator.comparing;

public class Inventory {

    //Create an ArrayList for the items in the inventory.
    ArrayList<InventoryItem> items;

    //Create a constructor.
    public Inventory() {
        //Initialize the attribute.
        items = new ArrayList<InventoryItem>();
    }

    //Create a function to get the ArrayList of items in this object.
    public ArrayList<InventoryItem> getItems () {
        //Return the items ArrayList.
        return items;
    }

    //Create a function to add items to the list of items in the inventory.
    public void addItem(InventoryItem item) {
        //Add the item passed to the ArrayList of items.
        items.add(item);
    }

    //Create a function to remove items from the list of items in the inventory.
    public void removeItem(String serialNumber) {
        //Look for the item to remove by serial number.
        for(int i = 0; i < items.size(); i++)
            //Find the item.
            if(items.get(i).getSerialNumber().equals(serialNumber))
                //Remove the item.
                items.remove(i);
    }

    //Create a function to edit the name of the items in the list of items in the inventory.
    public void editNameOfItem(String serialNumber, String newName) {
        //Look for the item by serial number.
        for(int i = 0; i < items.size(); i++)
            //Find the item.
            if(items.get(i).getSerialNumber().equals(serialNumber))
                //Change the name of the item.
                items.get(i).setName(newName);
    }

    //Create a function to edit the serial number of the items in the list of items in the inventory.
    public void editSerialNumberOfItem(String serialNumber, String newSerialNumber) {
        //Look for the item by serial number.
        for(int i = 0; i < items.size(); i++)
            //Find the item.
            if(items.get(i).getSerialNumber().equals(serialNumber))
                //Change the serial number of the item.
                items.get(i).setSerialNumber(newSerialNumber);
    }

    //Create a function to edit the value of the items in the list of items in the inventory.
    public void editValueOfItem(String serialNumber, int newValue) {
        //Look for the item by serial number.
        for(int i = 0; i < items.size(); i++)
            //Find the item.
            if(items.get(i).getSerialNumber().equals(serialNumber))
                //Change the value of the item.
                items.get(i).setValue(newValue);
    }

    //Create a function to sort the list of items in the inventory by name.
    public void sortByName(){
        //Sort the ArrayList comparing the name of the items.
        items.sort(comparing(InventoryItem::getName));
    }

    //Create a function to sort the list of items in the inventory by serial number.
    public void sortBySerialNumber(){
        //Sort the ArrayList comparing the serial number of the items.
        items.sort(comparing(InventoryItem::getSerialNumber));
    }

    //Create a function to sort the list of items in the inventory by value.
    public void sortByValue(){
        //Sort the ArrayList comparing the value of the items.
        items.sort(comparing(InventoryItem::getValue));
    }

    //Create a function to find an item in the list of items in the inventory by name.
    public InventoryItem searchByName(String nameSearched) {
        //Look for the item by name.
        for(int i = 0; i < items.size(); i++)
            //Find the target item.
            if(items.get(i).getName().equals(nameSearched))
                //Return the target item.
                return items.get(i);

        //Return null if no item is found with this name.
        return null;
    }

    //Create a function to find an item in the list of items in the inventory by serial number.
    public InventoryItem searchBySerialNumber(String serialNumberSearched) {
        //Look for the item by serial number.
        for(int i = 0; i < items.size(); i++)
            //Find the target item.
            if(items.get(i).getSerialNumber().equals(serialNumberSearched))
                //Return the target item.
                return items.get(i);

        //Return null if no item is found with this serial number.
        return null;
    }

    //Create a function to export an inventory to a .txt file in TSV format.
    public String exportTSV(String fileLocation, String fileName) {
        try {
            //Create a writer and pass it the file location and name.
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation + "/" + fileName + ".txt"));
            //Write the items one item on each line. The attributes of the items will be separated by tabs.
            for(int i = 0; i < items.size(); i++)
                bw.write(items.get(i).toString() + "\n");
            //Close the writer.
            bw.close();
            //Return successful to know that writer worked.
            return "Successful";
        } catch (IOException e){
            //If the writer did not work return failure.
            return "Failure";
        }
    }

    //Create a function to export an inventory to a .html file in HTML format.
    public String exportHTML(String fileLocation, String fileName) {
        try {
            //Create a writer and pass it the file location and name.
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation + "/" + fileName + ".html"));
            //Write some HTML tags.
            bw.write("<html>\n");
            bw.write("<head>" + "\n \"" + fileName + "\"\n</head>\n");
            bw.write("<body>\n");
            //Write the items one item on each line. The attributes of the items will be separated by tabs.
            for(int i = 0; i < items.size(); i++)
                bw.write(items.get(i).toString() + "<br>\n");
            //Write some more HTML tags.
            bw.write("</body>\n");
            bw.write("</html>\n");
            //Close the writer.
            bw.close();
            //Return successful to know that writer worked.
            return "Successful";
        } catch (IOException e){
            //If the writer did not work return failure.
            return "Failure";
        }
    }
}
