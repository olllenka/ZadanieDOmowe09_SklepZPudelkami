import java.util.Arrays;

public class BoxShop {
    private Box[] boxes;
    private int index = 0;

    public BoxShop(int size){
        boxes = new Box[size];
    }

    void addBox(Box box){
        if(index < boxes.length) {
            boxes[index] = box;
            index++;
        } else {
            System.out.println("Zbyt wiele pudełek!!!!");
        }
    }

    public Box theBestBox(Product product){
        sortBoxesVolumeASC(boxes);
        int index = findIndexOfFirstBigger(product.volume(),boxes);
        if(product instanceof ProductCuboid){
            ProductCuboid prodCuboid = (ProductCuboid) product;
            for(int i=index; i<boxes.length; i++){
                if(boxes[i] instanceof BoxCuboid){
                    BoxCuboid boxCuboid = (BoxCuboid) boxes[i];
                    if(PCuboidFitsBCuboid(boxCuboid,prodCuboid))
                        return boxes[i];
                }
                else if(boxes[i] instanceof BoxCylinder){
                    BoxCylinder boxCylinder = (BoxCylinder) boxes[i];
                    if(PCuboidFitsBCylinder(boxCylinder,prodCuboid))
                        return boxes[i];
                }
            }
        }
        else if(product instanceof ProductBall){
            ProductBall prodBall = (ProductBall) product;
            for(int i=index; i<boxes.length; i++){
                if(boxes[i] instanceof BoxCuboid){
                    BoxCuboid boxCuboid = (BoxCuboid) boxes[i];
                    if(PBallFitsBCuboid(boxCuboid, prodBall))
                        return boxes[i];
                }
                else if(boxes[i] instanceof BoxCylinder){
                    BoxCylinder boxCylinder = (BoxCylinder) boxes[i];
                    if(PBallFitsBCylinder(boxCylinder, prodBall))
                        return boxes[i];
                }
            }
        }
        return null;
    }

    private boolean PCuboidFitsBCuboid(BoxCuboid box, ProductCuboid product) {
        double prodLongestSide = longestSide(product.getHeight(), product.getLength(),product.getWidth());
        double prodMiddleSide = middleSide(product.getHeight(), product.getLength(),product.getWidth());
        double prodShortestSide = shortestSide(product.getHeight(), product.getLength(),product.getWidth());

        double boxLongestSide = longestSide(box.getHeight(), box.getLength(),box.getWidth());
        double boxMiddleSide = middleSide(box.getHeight(), box.getLength(),box.getWidth());
        double boxShortestSide = shortestSide(box.getHeight(), box.getLength(),box.getWidth());

        if(boxLongestSide>prodLongestSide && boxMiddleSide>prodMiddleSide && boxShortestSide>prodShortestSide)
            return true;
        else
            return false;
    }



    private boolean PCuboidFitsBCylinder(BoxCylinder box, ProductCuboid product) {
        double prodLongestSide = longestSide(product.getHeight(), product.getLength(),product.getWidth());
        double prodMiddleSide = middleSide(product.getHeight(), product.getLength(),product.getWidth());
        double boxDiameter = 2*box.getRadius();
        double boxLength = box.getLength();

        if(boxLength>prodLongestSide && boxDiameter>prodMiddleSide)
            return true;
        else if(boxLength>prodMiddleSide && boxDiameter>prodLongestSide)
            return true;
        else
            return false;
    }

    private double shortestSide(double height, double length, double width) {
        if(height<length && height<width)
            return height;
        else if(length<height && length<width)
            return length;
        else
            return width;
    }

    private double middleSide(double height, double length, double width) {
        if(height>length && height<width)
            return height;
        else if(length>height && length<width)
            return length;
        else
            return width;
    }

    private double longestSide(double height, double length, double width) {
        if(height>length && height>width)
            return height;
        else if(length>height && length>width)
            return length;
        else
            return width;
    }

    private boolean PBallFitsBCuboid(BoxCuboid box, ProductBall product) {
        double diameter = 2* product.getRadius();
        return (box.getHeight()>diameter && box.getLength()>diameter && box.getWidth()>diameter);
    }

    private boolean PBallFitsBCylinder(BoxCylinder box, ProductBall product) {
        return box.getRadius()>product.getRadius() && box.getLength()>2*product.getRadius();
    }


    private int findIndexOfFirstBigger(double volume, Box[] boxes) {
        for(int i=0; i<boxes.length; i++){
            if(boxes[i].volume() > volume)
                return i;
        }
        return -1;
    }

    private void sortBoxesVolumeASC(Box[] boxes) {
        boolean hasChanged = true;

        while(hasChanged){
            hasChanged = false;
            for (int i = 0; i < boxes.length - 1; i++) {
                double firstNum = boxes[i].volume();
                double secondNum = boxes[i + 1].volume();

                Box firstBox = boxes[i];
                Box secondBox = boxes[i+1];

                if (firstNum > secondNum) {
                    boxes[i + 1] = firstBox;
                    boxes[i] = secondBox;
                    hasChanged = true;
                }
            }
        }
    }

    public void showInfo() {
        for(int i=0; i<boxes.length; i++){
            System.out.println(boxes[i].getName() + ", pojemność: " + boxes[i].volume() + ", ");
        }
    }
}
