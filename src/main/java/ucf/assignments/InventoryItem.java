package ucf.assignments;

public class InventoryItem {

    //Create attributes for the name, serial number and value of an item.
    String name;
    String serialNumber;
    double value;

    //Create a constructor.
    public InventoryItem(String name, String serialNumber, double value) {
        //Initialize the attributes of the object with the information passed as parameters.
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    //Create a function to set the name of an item.
    public void setName(String name) {this.name = name;}
    //Create a function to set the serial number of an item.
    public void setSerialNumber(String serialNumber) {this.serialNumber = serialNumber;}
    //Create a function to set the value of an item.
    public void setValue(double value) {this.value = value;}

    //Create a function that returns the name of an item.
    public String getName() {return name;}
    //Create a function that returns the serial number of item.
    public String getSerialNumber() {return serialNumber;}
    //Create a function that returns the value of item.
    public double getValue() {return value;}

    //Create a to string function that returns the information of an item in TSV format.
    @Override
    public String toString(){return getSerialNumber() + "\t" + getName() + "\t$" + getValue();}


}
