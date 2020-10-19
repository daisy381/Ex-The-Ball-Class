package com.company;

import java.util.Arrays;

class Book {
    private String name;
    private Author[] author;
    private double price;
    private int qty =0;

    public Book(String name, Author[] author, double price ){
        this.name=name;
        this.author=author;
        this.price=price;
    }

    public Book(String name, Author[] author, double price, int qty ){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qty=qty;

    }

    public String getName() {
        return name;
    }

    public Author[] getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + Arrays.toString(author) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorNames(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<2; i++){
            sb.append(author[i].getName());
            if(i == 1){
                sb.append(".");
            }else{
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
