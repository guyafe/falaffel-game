package my_game;

import DB.ExcelTable;
import game.ShapeListener;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import java.util.ArrayList;

public class Toppings{

    private final SaladContainer saladContainer = new SaladContainer();
    private final FriesContainer friesContainer = new FriesContainer();
    private final HumusContainer humusContainer = new HumusContainer();
    private final FalafelContainer falafelContainer = new FalafelContainer();
    private ArrayList<Topping> toppings;

    public void initToppings(){
        this.toppings=new ArrayList<Topping>();

        Topping T = new Topping("salad");
        
        T.setLocation(new Point(20, 20));
        T.setQuantity(10);
        toppings.add(T);

        T = new Topping("fries");
        T.setLocation(new Point(40, 20));
        T.setQuantity(15);
        toppings.add(T);

        T = new Topping ("humus");
        T.setLocation(new Point(20, 40));
        T.setQuantity(10);
        toppings.add(T);

        T = new Topping("falafel");
        T.setLocation(new Point(20, 40));
        T.setQuantity(10);
        toppings.add(T);
    }

    public ArrayList<Topping> getToppings() {
		return toppings;
	}
}