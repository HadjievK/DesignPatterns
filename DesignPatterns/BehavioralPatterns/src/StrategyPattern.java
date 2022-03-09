interface Strategy {
  public int doOperation(int num1, int num2);
}

class operationAdd implements Strategy {
  @Override
  public int doOperation(int num1, int num2) {
    return num1 + num2;
  }
}

class operationSubstract implements Strategy {
  @Override
  public int doOperation(int num1, int num2) {
    return num1 - num2;
  }
}

class operationMultiply implements Strategy {

  @Override
  public int doOperation(int num1, int num2) {
    return num1 * num2;
  }
}

class Context {
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int executeStrategy(int num1, int num2) {
    return strategy.doOperation(num1, num2);
  }
}


public class StrategyPattern {
  public static void main(String[] args) {
    Context cntxt = new Context(new operationAdd());
    System.out.println("(operation +) " + cntxt.executeStrategy(6, 8));

    cntxt = new Context(new operationSubstract());
    System.out.println("(operation -)" + cntxt.executeStrategy(9, 17));

    cntxt = new Context(new operationMultiply());
    System.out.println("(operation *)" + cntxt.executeStrategy(3, 4));

  }
}
