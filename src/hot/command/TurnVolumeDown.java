package hot.command;

import hot.devices.TV;

public class TurnVolumeDown implements Command{

    TV theTV;

    public TurnVolumeDown(TV newTV)  {

        theTV = newTV;



    }

    @Override
    public void execute() {

        theTV.volumeDown();

    }

}