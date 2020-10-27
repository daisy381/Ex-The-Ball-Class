package com.company;

/*
A class called MyDate, which models a date instance, is defined as shown in the class diagram.
The MyDate class contains the following private instance variables:
    - year (int): Between 1 to 9999.
    - month (int): Between 1 (Jan) to 12 (Dec).
    - day (int): Between 1 to 28|29|30|31, where the last day depends on the month and whether it is a leap year for Feb (28|29).
It also contains the following public static final variables (drawn with underlined in the class diagram):
    - MONTHS (String[]), DAYS (String[]), and DAY_IN_MONTHS (int[]): static variables, initialized as shown, which are used in the methods.
The MyDate class has the following public static methods (drawn with underlined in the class diagram):

    - isLeapYear(int year): returns true if the given year is a leap year. A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.
    - isValidDate(int year, int month, int day): returns true if the given year, month, and day constitute a valid date. Assume that year is between 1 and 9999, month is between 1 (Jan) to 12 (Dec) and day shall be between 1 and 28|29|30|31 depending on the month and whether it is a leap year on Feb.
    - getDayOfWeek(int year, int month, int day): returns the day of the week, where 0 for Sun, 1 for Mon, ..., 6 for Sat, for the given date. Assume that the date is valid. Read the earlier exercise on how to determine the day of the week (or Wiki "Determination of the day of the week").
    
The MyDate class has one constructor, which takes 3 parameters: year, month and day. It shall invoke setDate() method (to be described later) to set the instance variables.

The MyDate class has the following public methods:

    - setDate(int year, int month, int day): It shall invoke the static method isValidDate() to verify that the given year, month and day constitute a valid date.
    (Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid year, month, or day!".)
    - setYear(int year): It shall verify that the given year is between 1 and 9999.
    (Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid year!".)
    - setMonth(int month): It shall verify that the given month is between 1 and 12.
    (Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid month!".)
    - setDay(int day): It shall verify that the given day is between 1 and dayMax, where dayMax depends on the month and whether it is a leap year for Feb.
    (Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid month!".)
    - getYear(), getMonth(), getDay(): return the value for the year, month and day, respectively.
    - toString(): returns a date string in the format "xxxday d mmm yyyy", e.g., "Tuesday 14 Feb 2012".
    - nextDay(): update this instance to the next day and return this instance. Take note that nextDay() for 31 Dec 2000 shall be 1 Jan 2001.
    - nextMonth(): update this instance to the next month and return this instance. Take note that nextMonth() for 31 Oct 2012 shall be 30 Nov 2012.
    - nextYear(): update this instance to the next year and return this instance. Take note that nextYear() for 29 Feb 2012 shall be 28 Feb 2013.
    (Advanced: throw an IllegalStateException with the message "Year out of range!" if year > 9999.)
    - previousDay(), previousMonth(), previousYear(): similar to the above.
    */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public String[] days= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public int[] days_in_months={31,28,31,30,31,30,31,31,30,31,30,31};

    public boolean isLeapYear(int year){
        if(year%4==0 && year%100!=0 || year%400==0){
            return true;
        }else return false;
    }


    public boolean isValidDate(int year, int month, int day){
        if(isLeapYear(year)){
            days_in_months[1]=29;
        }
        int temp=0;
        for(int i=0; i<=months.length;i++){
            if(i == (month)){
                temp = days_in_months[i-1];
            }
        }

        if(year>=1 && year<=9999 && month>=1 && month<=12 && day>=1 && day<=temp){
            return true;
        }else return false;
    }

    public int getDayOfWeek(int year, int month, int day){
        int[] century_0= new int[100];
        int[] century_6= new int[100];
        int[] century_4= new int[100];
        int[] century_2= new int[100];
        int[] obtained_form_month = new int[12];
        if(isLeapYear(year)){
            obtained_form_month = new int[]{6,2,3,6,1,4,6,2,5,0,3,5};
        }else{
            obtained_form_month =new int[]{0,3,3,6,1,4,6,2,5,0,3,5};
        }



        for(int i = 0, j = 0; i < 100; i+=4, j++) {
            century_6[j] = i;
        }
        for(int i = 1, j = 0; i < 100; i+=4, j++) {
            century_4[j] = i;
        }
        for(int i = 2, j = 0; i < 100; i+=4, j++) {
            century_2[j] = i;
        }
        for(int i = 3, j = 0; i < 100; i+=4, j++) {
            century_0[j] = i;
        }

        if(isValidDate(year,month,day)){
            int first_part_year=0;
            for(int i = 0; i < 100; i++) {
                if(century_0[i] == year/100){
                    first_part_year = 0;

                }else if(century_2[i] == year/100) {
                    first_part_year = 2;
                }
                else if(century_4[i] == year/100) {
                    first_part_year = 4;
                }else  {
                    first_part_year = 6;
                }
            }
            int second_part_year = year % 100;
            int third_part = second_part_year / 4;
            int fourth_part =0;

            for(int i = 0; i <= 12; i++) {
                if(month-1 == i) {
                    fourth_part=obtained_form_month[i];
                }
            }
            return (first_part_year + second_part_year + third_part + fourth_part + day)%7;
        }else{
            return -1;
        }



    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return days[getDayOfWeek(year,month,day)] + " " + day + " " + months[month-1] + " "  + year;
    }

    public MyDate nextDay(){
        if(isLeapYear(year)){
            days_in_months[1]=29;
            //System.out.println(days_in_months[1]);
        }
        ++day;
        if(day > days_in_months[month-1]) {
            day = 1;
            ++month;
            if(month > 12){
                month = 1;
                ++year;
            }
        }
        return  this;
    }

    public MyDate nextMonth(){
        ++month;
        if(month > 12) {
            month = 1;
            ++year;
        }
        return this;
    }

    public MyDate nextYear(){
        ++year;
        return this;
    }

    public MyDate previousDay() {
        if(isLeapYear(year)){
            days_in_months[1]=29;
            //System.out.println(days_in_months[1]);
        }
        --day;
        if(day < 1) {
            day = days_in_months[month-1];
            --month;
            if(month < 1) {
                month = 12;
                --year;

            }
        }
        return  this;
    }

    public MyDate previousMonth() {
        --month;
        if(month < 1) {
            month = 12;
            --year;
        }
        return this;
    }

    public MyDate previousYear() {
        if(isLeapYear(year)){
            days_in_months[1]=29;
            --day;
        }
        --year;
        return this;
    }
}
