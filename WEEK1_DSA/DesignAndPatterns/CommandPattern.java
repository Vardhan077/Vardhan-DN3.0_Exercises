public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        // Create command objects
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);

        // Create a remote control instance
        RemoteControl remoteControl = new RemoteControl();

        // Set command to turn on the light and press the button
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        // Set command to turn off the light and press the button
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();
    }
}

// Command interface
interface Command {
    void execute();
}

// Command to turn on the light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Command to turn off the light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver class
class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    // Set command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    // Press button to execute the command
    public void pressButton() {
        command.execute();
    }
}
