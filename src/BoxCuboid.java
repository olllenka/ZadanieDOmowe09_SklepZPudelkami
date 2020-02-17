public class BoxCuboid extends Box{
    private double height;
    private double width;
    private double length;

    public BoxCuboid(String name, double height, double width, double length) {
        super(name);
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
