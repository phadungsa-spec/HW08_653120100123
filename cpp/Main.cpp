#include <iostream>
#include <cmath>

using namespace std;

class Shape{
private:
    string name;

public:
    Shape(string name): name(name) {}

    string getName() const { return name; }
    void setName(string name) { this->name = name;}

    virtual double area() {
        return 0;
    }

    virtual void printInfo(){
        cout << "Shape : " << name << endl;
    }
};

class Circle: public Shape{
public:
    double radius;

    Circle(string name, double radius): Shape(name), radius(radius) {}

    double getRadius() { return radius; }
    void setRadius(double radius) { this->radius = radius; }

    double area(){ return M_PI * pow(radius, 2); }

    void printInfo() override {
        cout << getName() << "[ radius: " << radius << ", area: " << area() << " ]" << endl;
    }
};

class Cylinder: public Circle{
public:
    double length;

    Cylinder(string name, double radius, double length): Circle(name, radius), length(length) {}

    double getLength() { return length; }
    void setLength(double length) { this->length = length; }

    double area() override { return 2 * M_PI * radius * (radius + length); }

    virtual double volume() { return Circle::area() * length; }

    void printInfo() override {
        cout << getName() << "[ radius: " << radius << ", length: " << length << ", area: " << area() << ", volume: " << volume() << " ]" << endl;
    }


};

class Rectangle: public Shape{
public:
    double width;
    double height;

    Rectangle(string name, double width, double height): Shape(name), width(width), height(height) {}

    double getWidth() { return width; }
    void setWidth(double width) { this->width = width; }

    double getHeight() { return height; }
    void setHeight(double height) { this->height = height; }

    double area(){ return width * height; }

    void printInfo() override {
        cout << getName() << "[ width: " << width << ", height: " << height << ", area: " << area() << " ]" << endl;
    }
};

class Polygon: public Rectangle{
public:
    int n;

    Polygon(string name, double width, double height, int n): Rectangle(name,width,height), n(n) {}

    virtual double volume() { return Rectangle::area() * n; }

    void printInfo() override {
        cout << getName() << "[ width: " << width << ", height: " << height << ", area: " << area() << ", volume: " << volume() << " ]" << endl;
    }
};

int main(){
    Circle c("Circle", 2);
    c.printInfo();

    Cylinder cy("Cylinder", 2, 4);
    cy.printInfo();

    Rectangle r("Rectangle", 2, 4);
    r.printInfo();

    Polygon p("Polygon", 2, 4, 8);
    p.printInfo();

    return 0;
}