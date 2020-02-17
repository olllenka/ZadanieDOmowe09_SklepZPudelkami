public class ProductCuboid extends Product {
    private double height;
    private double width;
    private double length;

    public ProductCuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double volume(){
        return height*width*length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
