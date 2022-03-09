interface Shape {
  public void draw();
}

class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("rectangle :: draw()");
  }
}

class Square implements Shape {
  @Override
  public void draw() {
    System.out.println("square :: draw()");
  }
}

class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("circle :: draw()");
  }
}

class ShapeMaker {
  Shape circle;
  Shape rectangle;
  Shape square;

  public ShapeMaker() {
    this.circle = new Circle();
    this.rectangle = new Rectangle();
    this.square = new Square();
  }

  public void drawCircle() {
    circle.draw();
  }

  public void drawSquare() {
    square.draw();
  }

  public void drawRectangle() {
    rectangle.draw();
  }
}

public class FacadePattern {
  public static void main(String[] args) {
    ShapeMaker shapeMaker = new ShapeMaker();
    shapeMaker.drawCircle();
    shapeMaker.drawSquare();
    shapeMaker.drawRectangle();
    // shapeMaker.drawSquare();
  }
}
