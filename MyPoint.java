package com.company;

class MyPoint {
    private int x =0;
    private int y =0;

    public MyPoint(){

    }

    public MyPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int[] arr = new int[]{this.x,this.y};
        return arr;
    }

    public void setXY(int x, int y){
        int[] arr = new int[]{this.x=x , this.y=y};
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    public double distance(int x, int y){
        int xDiff = this.x -x;
        int yDiff = this.y -y;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

    public double distance(MyPoint another){
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }
    public double distance(){
        int xDiff = this.x;
        int yDiff = this.y;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

}
