
class Program
{
    static void Main()
    {
        Circle c = new Circle("Circle", 2);
        c.printInfo();

        Cylinder cy = new Cylinder("Cylinder", 2, 4);
        cy.printInfo();
        System.Console.WriteLine(cy.ToString());

        Rectangle r = new Rectangle("Rectangle", 2, 4);
        r.printInfo();

        Polygon p = new Polygon("Polygon", 2, 4, 8);
        p.printInfo();
        System.Console.WriteLine(p.ToString());
    }
}

class Shape
{
    public string Name { get; set; }

    public Shape(string name)
    {
        Name = name;
    }

    public virtual double Area => 0;

    public virtual void printInfo() => System.Console.WriteLine($"Shape: {Name}");
}

class Circle: Shape
{
    public double Radius { get; set; } = 1.0;

    public Circle(string name, double radius): base(name){ Radius = radius; }

    public override double Area => Math.PI * Math.Pow(Radius, 2);

    public override void printInfo() => System.Console.WriteLine($"{Name} [ radius: {Radius:N2}, area: {Area:N2} ]");
}

class Cylinder: Circle
{
    public double Length { get; set; } = 1.0;

    public Cylinder(string name, double radius, double length):base(name,radius) { Length = length; }

    public override double Area => 2 * Math.PI * Radius * (Radius + Length);

    public virtual double Volume => base.Area * Length;

    public override void printInfo() => System.Console.WriteLine($"{Name} [ radius: {Radius:N2}, length: {Length:N2}, area: {Area:N2}, volume: {Volume:N2} ]");

    public override string ToString() => $"{Name} [ r: {Radius:N2} l: {Length:N2} a: {Area:N2} v: {Volume:N2} ]";
}

class Rectangle: Shape
{
    public double Width { get; set; } = 1.0;
    public double Height { get; set; } = 1.0;

    public Rectangle(string name, double width, double height): base(name)
    {
        Width = width;
        Height = height;
    }

    public override double Area => Width * Height;

    public override void printInfo() => System.Console.WriteLine($"{Name} [ width: {Width}, height: {Height}, area: {Area} ]");

}

class Polygon: Rectangle
{
    public int N { get; set; } = 1;

    public Polygon(string name, double width, double height, int n):base(name, width, height){ N = n; }

    public virtual double Volume => base.Area * N;

    public override void printInfo() => System.Console.WriteLine($"{Name} [ width: {Width}, height: {Height}, area: {Area}, volume: {Volume} ]");

    public override string ToString() => $"{Name} [ w: {Width} h: {Height} a: {Area} v: {Volume}]";
}
