import javax.script.ScriptEngine;
import java.util.ArrayList;

abstract class Pizza {
  String name;
  String dough;
  String sauce;
  ArrayList toppings = new ArrayList();

  void prepare() {
    System.out.println("Preparing..." + name);
    System.out.println("Tossing dough...");
    System.out.println("Adding sauce...");
    System.out.println("Adding toppings: ");
    for (int i = 0; i < toppings.size(); i++) {
      System.out.println(" " + toppings.get(i));
    }
  }


  void bake() {
    System.out.println("Bake for 25 minutes at 350");

  }

  void cut() {
    System.out.println("Cutting the pizza...");
  }

  void box() {
    System.out.println("Boxing the pizza...");
  }

  public String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "name='" + name + '\'' +
        ", dough='" + dough + '\'' +
        ", sauce='" + sauce + '\'' +
        ", toppings=" + toppings +
        '}';
  }
}

abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza;

    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    ;
    pizza.cut();
    pizza.box();

    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}

class NYStyleCheesePizza extends Pizza {
  @Override
  void prepare() {
    super.prepare();
  }

  public NYStyleCheesePizza() {
    name = "NYStyle sauce and cheese pizza";
    dough = "Thin crust dough";
    sauce = "marinara sauce";
    toppings.add("grated reggiano cheese");
  }

}

class NYStyleVeggiePizza extends Pizza {
  @Override
  void prepare() {
    super.prepare();

  }

  public NYStyleVeggiePizza() {
    name = "NYStyleVeggiePizza sauce and cheese pizza";
    dough = "extra thick crust dough veggie";
    sauce = "tomato sauce veggie ";
    toppings.add("grated veggie cheese");

  }

}

class NYPizzaStore extends PizzaStore {
  @Override
  protected Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else if (type.equals("veggie")) {
      return new NYStyleVeggiePizza();
    } else return null;
  }
}

class ChicagoStyleCheesePizza extends Pizza {

  @Override
  void prepare() {
    super.prepare();

  }

  public ChicagoStyleCheesePizza() {
    name = "ChicagoStyle sauce and cheese pizza";
    dough = "extra thick crust dough";
    sauce = "tomato sauce";
    toppings.add("grated mozzarella cheese");
  }

  void cut() {
    System.out.println("Cutting the pizza into box");

  }
}

class ChicagoStylePepperoniPizza extends Pizza {

  @Override
  void prepare() {
    super.prepare();

  }

  public ChicagoStylePepperoniPizza() {
    name = "ChicagoStyle sauce and cheese pizza pepperoni";
    dough = "extra thick crust dough pepperoni";
    sauce = "tomato sauce pepperoni";
    toppings.add("grated mozzarella cheese pepperoni");
  }

  void cut() {
    System.out.println("Cutting the pepperoni pizza into box");

  }
}


class ChicagoPizzaStore extends PizzaStore {
  @Override
  protected Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
    } else if (type.equals("veggie")) {
      return new ChicagoStylePepperoniPizza();
    } else return null;
  }
}


public class FactoryPattern {


  public static void main(String[] args) {
    PizzaStore NY = new NYPizzaStore();
    PizzaStore chicago = new ChicagoPizzaStore();

    Pizza pizza = NY.orderPizza("cheese");
    System.out.println(pizza.getName() + "\n");

    pizza = chicago.orderPizza("cheese");
    System.out.println(pizza.getName() + "\n");

    // ChicagoStyleCheesePizza a = new ChicagoStyleCheesePizza();
    //System.out.println(a);

  }
}
