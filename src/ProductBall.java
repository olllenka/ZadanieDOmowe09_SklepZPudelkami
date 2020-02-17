public class ProductBall extends Product {
    private double radius;

    public ProductBall(double radius) {
        this.radius = radius;
    }

    public double volume(){
        return 4/3*Math.PI*Math.pow(radius,3);
    }

    public double getRadius() {
        return radius;
    }
}
