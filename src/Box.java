public class Box {
    private String name;

    public Box(String name) {
        this.name = name;
    }

    public double volume(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public void showInfo(){
        System.out.println(name);
    }
}
