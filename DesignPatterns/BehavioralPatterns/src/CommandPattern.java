interface ICommand {
  public void execute();

}

class Light {

  public void on() {
    System.out.println("Light is on");
  }

  public void off() {
    System.out.println("Light is off");
  }

}

class LightOnCommand implements ICommand {
  Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }
}

class LightOffCommand implements ICommand {
  Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();

  }
}

class Stereo {

  public void on() {
    System.out.println("Stereo is on");
  }

  public void off() {
    System.out.println("Stereo is off");
  }

  public void setCD() {
    System.out.println("cd is ready");
  }

  public void setDVD() {
    System.out.println("DVD is ready");
  }

  public void setRadio() {
    System.out.println("Radio is ready");
  }

  public void setVolume(int volume) {
    System.out.println("volume set to" + volume);
  }

}

class StereoOnCommand implements ICommand {
  Stereo stereo;

  StereoOnCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCD();
    stereo.setVolume(10);
  }
}

class StereoOffCommand implements ICommand {
  Stereo stereo;

  StereoOffCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }
}

class SimpleRemoteControl {
  ICommand slot;

  public SimpleRemoteControl() {

  }

  public void setCommand(ICommand iCommand) {
    slot = iCommand;
  }

  public void buttonWasPressed() {
    slot.execute();
  }
}

public class CommandPattern {
  public static void main(String[] args) {

    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light();
    Stereo stereo = new Stereo();


    remote.setCommand(new LightOnCommand(light));
    remote.buttonWasPressed();

    remote.setCommand(new StereoOnCommand(stereo));
    remote.buttonWasPressed();

    remote.setCommand(new StereoOffCommand(stereo));
    remote.buttonWasPressed();
  }
}
