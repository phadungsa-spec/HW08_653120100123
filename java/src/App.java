public class App {
    public static void main(String[] args) throws Exception {
        Circle c = new Circle("Circle", 2);
        c.printInfo();

        Cylinder cy = new Cylinder("Cylinder", 2, 4);
        cy.printInfo();
        System.out.println(cy.toString());

        Rectangle r = new Rectangle("Rectangle", 2, 4);
        r.printInfo();

        Polygon p = new Polygon("Polygon", 2, 4, 8);
        p.printInfo();
        System.out.println(p.toString());
    }
}

class Shape{
    public String name;

    public Shape(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double area(){
        return 0;
    }

    public void printInfo(){
        System.out.println("Shape :" + name);
    }
}

class Circle extends Shape{
    public double radius;

    public Circle(String name,double radius){
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void printInfo(){
        System.out.println( name + "[ radius: " + radius + ", area: " + area() + " ]");
    }

}

class Cylinder extends Circle{
    public double length;

    public Cylinder(String name, double radius, double length){
        super(name, radius);
        this.length = length;
    }
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double area(){
        return 2 * Math.PI * radius * (radius + length);
    }

    public double volume(){
        return super.area() * length;
    }

    @Override
    public void printInfo(){
        System.out.println( name + "[ radius: " + radius + ", length: " + length + ", area: " + area() + ", volume: " + volume() + " ]");
    }

    @Override
    public String toString(){
        return name + "r: " + radius + " l: "+ length + " a: " + area() + " v: " + volume();
    }
}

class Rectangle extends Shape{
    public double width;
    public double height;

    public Rectangle(String name, double width, double height){
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public double area(){
        return width * height;
    }

    @Override
    public void printInfo(){
        System.out.println( name + "[ width: " + width + ", height: " + height + ", area: " + area());
    }
}

class Polygon extends Rectangle{
    public int n;

    public Polygon(String name, double width, double height, int n){
        super(name, width, height);
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public double volume(){
        return super.area() * n;
    }

    @Override
    public void printInfo(){
        System.out.println( name + "[ width: " + width + ", height: " + height + ", n: " + n + ", area: " + area() + ", volume: " + volume() + " ]");
    }

    @Override
    public String toString(){
        return name + "w: " + width + " h: " + height + " n: " + n + " a: " + area() + " v: " + volume();
    }
}