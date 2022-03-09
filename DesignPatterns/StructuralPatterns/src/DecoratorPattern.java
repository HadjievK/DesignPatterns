abstract class Beverage {
  String description = "Undefined beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
  public abstract String getDescription();

}

//base beverage subclasses
class Espresso extends Beverage {
  public Espresso() {
    description = "espresso";
  }

  @Override
  public double cost() {
    return 1.99;
  }
}

class HouseBlend extends Beverage {

  HouseBlend() {
    description = "house-blend coffee";
  }

  @Override
  public double cost() {
    return .89;
  }
}

class DarkRoast extends Beverage {

  DarkRoast() {
    description = "Dark-roasted coffee";
  }

  @Override
  public double cost() {
    return .99;
  }
}

class Decaf extends Beverage {

  Decaf() {
    description = "Decaf";
  }

  @Override
  public double cost() {
    return 1.05;
  }
}

//implement condiments
class Mocha extends CondimentDecorator {

  Beverage beverage;

  Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }

  @Override
  public double cost() {
    return beverage.cost() + .20;
  }
}

class Whip extends CondimentDecorator {

  Beverage beverage;

  Whip(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }

  @Override
  public double cost() {
    return beverage.cost() + .10;
  }
}

class Soy extends CondimentDecorator {

  Beverage beverage;


  Soy(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Soy";
  }

  @Override
  public double cost() {
    return beverage.cost() + .15;
  }
}


public class DecoratorPattern {
  public static void main(String[] args) {

    Beverage beverage = new Espresso();
    System.out.println(beverage.getDescription() + " -$" + beverage.cost());


    Beverage beverage1 = new DarkRoast();
    beverage1 = new Mocha(beverage1);
    beverage1 = new Mocha(beverage1);
    beverage1 = new Whip(beverage1);
    System.out.println(beverage1.getDescription() + " -$" + beverage1.cost());


    Beverage beverage2 = new HouseBlend();
    beverage2 = new Soy(beverage2);
    beverage2 = new Whip(beverage2);
    beverage2 = new Mocha(beverage2);
    System.out.println(beverage2.getDescription() + " -$" + beverage2.cost());


  }
}
