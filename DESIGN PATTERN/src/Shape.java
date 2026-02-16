interface Shape { void draw(); }

class Circle implements Shape {
    public void draw(){ System.out.println("Circle"); }
}

class ShapeFactory {
    public static Shape getShape(String type){
        if(type.equals("circle")) return new Circle();
        return null;
    }
}
