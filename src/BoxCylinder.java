public class BoxCylinder extends Box{
    private double radius;
    private double length;

    public BoxCylinder(String name, double radius, double length) {
        super(name);
        this.radius = radius;
        this.length = length;
    }

    public double volume(){
        return Math.PI*Math.pow(radius,2)*length;
    }

    public double getRadius() {
        return radius;
    }

    public double getLength() {
        return length;
    }
}
