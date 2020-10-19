package com.company;

public class Invoice {
    private int Id;
    private Customer customer;
    private double amount;

    public Invoice(int Id, Customer customer, double amount){
        this.customer=customer;
        this.amount= amount;
        this.Id= Id;
    }

    public int getId() {
        return Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCustomerName(){
        return customer.getName();
    }
   // public double AmountAfterDiscount(){
       // return amount-((amount* customer.getDiscount())/100);
    }

//}
