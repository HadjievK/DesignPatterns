import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class CaffeineBeverage {

  final void prepare() {
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  abstract void brew();

  abstract void addCondiments();

  void boilWater() {
    System.out.println("Boiling water...");
  }

  void pourInCup() {
    System.out.println("Pouring into cup");
  }

  //hook method- we can override it if we want-it is not must
  boolean customerWantsCondiments() {
    return true;
  }
}

class Coffee extends CaffeineBeverage {

  @Override
  void brew() {
    System.out.println("Dripping coffee through filter");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }

  @Override
  boolean customerWantsCondiments() {
    String answer = getUserInput();
    return answer.toLowerCase().startsWith("y");
  }

  String getUserInput() {
    String answer = null;
    System.out.println("Would you like milk and sugar  in your coffee (yes\no) ? ");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException ioe) {
      System.err.println("IO error trying read your input");
    }
    if (answer == null) {
      answer = "no";
    }
    return answer;

  }
}

class Tea extends CaffeineBeverage {

  @Override
  void brew() {
    System.out.println("Stepping the tea");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding Lemon");
  }

  @Override
  boolean customerWantsCondiments() {
    String answer = getUserInput();
    return answer.toLowerCase().startsWith("y");
  }

  String getUserInput() {
    String answer = null;
    System.out.println("Would you like lemon in your tea (yes\no) ? ");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException ioe) {
      System.err.println("IO error trying read your input");
    }
    if (answer == null) {
      answer = "no";
    }
    return answer;

  }
}

public class TemplatePattern {
  public static void main(String[] args) {
    Tea tea = new Tea();
    Coffee coffee = new Coffee();

    System.out.println("making the tea...");
    tea.prepare();

    System.out.println("making the coffee...");
    coffee.prepare();

  }
}
