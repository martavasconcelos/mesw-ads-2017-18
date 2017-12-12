package hot.command;

import hot.devices.TV;

public class TurnOn implements Command {


    TV theTV;

    public TurnOn(TV newTV)  {

        theTV = newTV;



    }

    @Override
    public void execute() {

        theTV.turnOn();

    }


}
