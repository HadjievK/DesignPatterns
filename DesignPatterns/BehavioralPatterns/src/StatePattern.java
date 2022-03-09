interface MobileAlertState {
    public void alert(AlertStateContext ctx);
}

class VibrationMode implements MobileAlertState{

    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Vibration...");
    }
}

class SilentMode implements MobileAlertState{

    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Silent mode is ON");
    }
}


class AlertStateContext {
    MobileAlertState currentState;


    AlertStateContext(){
        currentState = new VibrationMode();
    }
    AlertStateContext(MobileAlertState currentState) {
            this.currentState = currentState;
    }

    public void setCurrentState(MobileAlertState currentState) {
        this.currentState = currentState;
    }
    public void alert(){
        currentState.alert(this);
    }

}


public class StatePattern {
    public static void main(String[] args) {
        AlertStateContext stateContext =  new AlertStateContext();
        stateContext.alert();
        stateContext.setCurrentState(new SilentMode());
        stateContext.alert();
        AlertStateContext s = new AlertStateContext(new SilentMode());
        s.alert();


    }
}
