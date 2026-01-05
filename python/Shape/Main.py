import math

class Shape:
    def __init__(self, name:str):
        self.__name = name;

    @property
    def name(self):
        return self.__name
    
    @name.setter
    def name(self, name:str):
        self.__name = name;

    def area(self):
        return 0;

    def printInfo(self):
        print(f"Shape: {self.name}")

class Circle(Shape):
    def __init__(self, name, radius:float=1.0):
        super().__init__(name)
        self.__radius = radius;

    @property
    def radius(self):
        return self.__radius
    
    @radius.setter
    def radius(self, radius:float=1.0):
        self.__radius = radius

    def area(self):
        return math.pi * math.pow(self.__radius, 2)
    
    def printInfo(self):
        print(f"{self.name} [ radius: {self.radius:.2f}, area: {self.area():.2f} ]")

class Cylinder(Circle):
    def __init__(self, name, radius:float=1.0, length:float=1.0):
        super().__init__(name, radius)
        self.__length = length

    @property
    def length(self):
        return self.__length
    
    @length.setter
    def length(self, length:float=1.0):
        self.__length = length

    def area(self):
        return 2 * math.pi * self.radius * (self.radius + self.__length)
    
    def volume(self):
        return super().area() * self.__length
    
    def printInfo(self):
        print(f"{self.name} [ radius: {self.radius:.2f} length: {self.length} area: {self.area():.2f} volume: {self.volume():.2f} ]")

class Rectangle(Shape):
    def __init__(self, name, width:float=1.0, height:float=1.0):
        super().__init__(name)
        self.__width = width
        self.__height = height

    @property
    def width(self):
        return self.__width
    
    @width.setter
    def width(self, width:float=1.0):
        self.__width = width

    @property
    def height(self):
        return self.__height
    
    @height.setter
    def height(self, height:float=1.0):
        self.__height = height

    def area(self):
        return self.width * self.height
    
    def printInfo(self):
        print(f"{self.name} [ width: {self.width} height: {self.height} area: {self.area()} ]")

class Polygon(Rectangle):
    def __init__(self, name, width:float=1.0, height:float=1.0, n:int=1):
        super().__init__(name, width, height)
        self.__n = n

    @property
    def n(self):
        return self.__n
    
    @n.setter
    def n(self, n:int=1):
        self.__n = n

    def volume(self):
        return self.area() * self.__n
    
    def printInfo(self):
        print(f"{self.name} [ width: {self.width} height: {self.height} area: {self.area()} volume: {self.volume()} ]")

c = Circle("Circle", 2)
c.printInfo()

cy = Cylinder("Cylinder", 2, 4)
cy.printInfo()

r = Rectangle("Rectangle", 2, 4)
r.printInfo()

p = Polygon("Polygon", 2, 4, 8)
p.printInfo()