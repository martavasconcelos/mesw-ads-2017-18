package hot.command;

import hot.devices.TV;

public class TurnOff implements Command {

    TV theTV;

    public TurnOff(TV newTV)  {

        theTV = newTV;



    }

    @Override
    public void execute() {

        theTV.turnOff();

    }


}