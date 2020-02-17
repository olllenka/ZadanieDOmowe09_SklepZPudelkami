public class Main {
    public static void main(String[] args) {

        Box box1 = new BoxCuboid("1 - prostopadłościan", 10,15,20);
        Box box2 = new BoxCuboid("2 - prostopadłościan",30,35,50);
        Box box3 = new BoxCylinder("3 - cylinder", 3,12);
        Box box4 = new BoxCylinder("4 - cylinder", 8,25);

        BoxShop boxshop = new BoxShop(4);
        boxshop.addBox(box1);
        boxshop.addBox(box2);
        boxshop.addBox(box3);
        boxshop.addBox(box4);
        boxshop.showInfo();

        Product product = new ProductBall(2);

        Box bestBox = boxshop.theBestBox(product);
        //sprawdzenie czy się posortowały poprawnie
        //boxshop.showInfo();
        System.out.println("Najlepiej pasuje pudełko: ");
        bestBox.showInfo();

    }
}
