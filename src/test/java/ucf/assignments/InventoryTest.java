package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addItemTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create an item to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        //Add the item.
        testInventory.addItem(testItem);
        //Check if the inventory has one item.
        assertEquals(testInventory.items.size(), 1);
    }

    @Test
    void removeItemTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create an item to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        //Add the item.
        testInventory.addItem(testItem);
        //Remove the item.
        testInventory.removeItem("ABCDE12345");
        //Check if the inventory has no items.
        assertEquals(testInventory.items.size(), 0);
    }

    @Test
    void editNameOfItemTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create an item to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        //Add the item.
        testInventory.addItem(testItem);
        //Edit the item's name.
        testInventory.editNameOfItem("ABCDE12345", "TestItem2");
        //Check if the name changed in the inventory.
        assertEquals("TestItem2", testInventory.items.get(0).getName());
    }

    @Test
    void editSerialNumberOfItemTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create an item to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        //Add the item.
        testInventory.addItem(testItem);
        //Edit the item's serial number.
        testInventory.editSerialNumberOfItem("ABCDE12345", "12345ABCDE");
        //Check if the serial number changed in the inventory.
        assertEquals("12345ABCDE", testInventory.items.get(0).getSerialNumber());
    }

    @Test
    void editValueOfItemTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create an item to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        //Add the item.
        testInventory.addItem(testItem);
        //Edit the item's value.
        testInventory.editValueOfItem("ABCDE12345", 200);
        //Check if the value changed in the inventory.
        assertEquals(200, testInventory.items.get(0).getValue());
    }

    @Test
    void sortByNameTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items not sorted.
        testInventory.addItem(testItem2);
        testInventory.addItem(testItem);
        //Sort the items.
        testInventory.sortByName();
        //Check if the first item is the one it should be.
        assertEquals("TestItem", testInventory.items.get(0).getName());

    }

    @Test
    void sortBySerialNumberTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items not sorted.
        testInventory.addItem(testItem2);
        testInventory.addItem(testItem);
        //Sort the items.
        testInventory.sortBySerialNumber();
        //Check if the first item is the one it should be.
        assertEquals("ABCDE12345", testInventory.items.get(0).getSerialNumber());
    }

    @Test
    void sortByValueTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items not sorted.
        testInventory.addItem(testItem2);
        testInventory.addItem(testItem);
        //Sort the items.
        testInventory.sortByValue();
        //Check if the first item is the one it should be.
        assertEquals(100, testInventory.items.get(0).getValue());
    }

    @Test
    void searchByNameTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items not sorted.
        testInventory.addItem(testItem2);
        testInventory.addItem(testItem);
        //Look for an item and save it.
        InventoryItem temp = testInventory.searchByName("TestItem");
        //Check the name of the saved item is the correct one.
        assertEquals("TestItem", temp.getName());
    }

    @Test
    void searchBySerialNumberTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items not sorted.
        testInventory.addItem(testItem2);
        testInventory.addItem(testItem);
        //Look for an item and save it.
        InventoryItem temp = testInventory.searchBySerialNumber("ABCDE12345");
        //Check the name of the saved item is the correct one.
        assertEquals("TestItem", temp.getName());
    }

    @Test
    void exportTSVTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items.
        testInventory.addItem(testItem);
        testInventory.addItem(testItem2);
        //Export and save status.
        String status = testInventory.exportTSV("src/test/resources", "test");
        //Check for success.
        assertEquals("Successful", status);
    }

    @Test
    void exportHTMLTest() {
        //Create an Inventory.
        Inventory testInventory = new Inventory();
        //Create some items to add.
        InventoryItem testItem = new InventoryItem("TestItem", "ABCDE12345", 100);
        InventoryItem testItem2 = new InventoryItem("TestItem2", "ABCDE67890", 200);
        //Add the items.
        testInventory.addItem(testItem);
        testInventory.addItem(testItem2);
        //Export and save status.
        String status = testInventory.exportHTML("src/test/resources", "test");
        //Check for success.
        assertEquals("Successful", status);
    }
}