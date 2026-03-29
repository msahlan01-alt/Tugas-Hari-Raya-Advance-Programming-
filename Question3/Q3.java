package Question3; // package name sesuai dengan nama folder
public class Q3 {
    public static void main(String[] args) {

        Food f1 = new Food("Beef Rendang", 15000);
        Food f2 = new RegularMenu("Chicken Ramen", 20000);
        Food f3 = new SpecialMenu("Fiery Fried Rice", 80000);

        f1.getInfo();
        System.out.println();

        f2.getInfo();
        System.out.println();
        
        f3.getInfo();
    }
}

class Food {
    protected String name;
    protected int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int calcPrice() {
        return price + 5000; // labour cost
    }

    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
    }
}

class RegularMenu extends Food {
    public RegularMenu(String name, int price) {
        super(name, price);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 10000;
    }
}

class SpecialMenu extends Food {
    public SpecialMenu(String name, int price) {
        super(name, price);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 20000;
    }
}