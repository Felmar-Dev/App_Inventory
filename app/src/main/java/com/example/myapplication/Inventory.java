package com.example.myapplication;
import java.util.ArrayList;
public class Inventory {
    ArrayList inventory = new ArrayList();


    public void addItem(String name, String description, int quantity, double price){
        Object _item = name + "//" + description + "//" + quantity + "//" + price;
        inventory.add(_item);
    }

    public Object getItem(int _index){
        return inventory.get(_index);
    }

    public String getItemName(int _index){
        return inventory.get(_index).toString().split("//")[0];
    }

    public String getItemDescription(int _index){
        return inventory.get(_index).toString().split("//")[1];
    }

    public String getItemQuantity(int _index){
        return inventory.get(_index).toString().split("//")[2];
    }

    public String getItemPrice(int _index){
        return inventory.get(_index).toString().split("//")[3];
    }

    public Object getAllItem(){
        return inventory.iterator();
    }

    public void updateItemName(int _index, String newVal){
        String[] _item = inventory.get(_index).toString().split("//");
        String oldDescription = _item[1];
        String oldQuantity = _item[2];
        String oldPrice = _item[3];
        String newName = newVal;
        Object edited_item =  newName + "//" + oldDescription + "//" + oldQuantity + "//" + oldPrice;
    }

    public void updateItemDescription(int _index, String newVal){
        String[] _item = inventory.get(_index).toString().split("//");
        String oldName = _item[0];
        String oldQuantity = _item[2];
        String oldPrice = _item[3];
        String newDescription = newVal;
        Object edited_item =  oldName + "//" + newDescription + "//" + oldQuantity + "//" + oldPrice;
    }
    public void updateItemQuantity(int _index, String newVal){
        String[] _item = inventory.get(_index).toString().split("//");
        String oldName = _item[0];
        String oldDescription = _item[1];
        String oldPrice = _item[3];
        String newQuantity = newVal;
        Object edited_item =  oldName + "//" + oldDescription + "//" + newQuantity + "//" + oldPrice;
    }

    public void updateItemPrice(int _index, String newVal){
        String[] _item = inventory.get(_index).toString().split("//");
        String oldName = _item[0];
        String oldDescription = _item[1];
        String oldQuantity = _item[2];
        String newPrice = newVal;
        Object edited_item =  oldName + "//" + oldDescription + "//" + oldQuantity + "//" + newPrice;
    }

    public void deleteItem(int _index){
        inventory.remove(_index);
    }
    public void searchItem(String _hint){
        System.out.println("searched items >>>");
        for (int x = 0; x <= inventory.size(); x++){
            if (inventory.get(x).toString().equals(_hint) & inventory.get(x).toString().contains(_hint)){
                System.out.println(inventory.get(x));
            }
        }
    }


}
