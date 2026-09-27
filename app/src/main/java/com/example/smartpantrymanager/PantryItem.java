package com.example.smartpantrymanager;

public class PantryItem {
    private  int id;
    private  String name;
    private  int quantity;
    private  String expiryDate;

    public PantryItem(int id , String name, int quantity ,String expiryDate){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public  String getExpiryDate(){return  expiryDate;}




}