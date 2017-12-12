package hot.command;

import hot.devices.TV;

public class TurnVolumeUP implements Command{

    TV theTV;

    public TurnVolumeUP(TV newTV)  {

        theTV = newTV;



    }

    @Override
    public void execute() {

        theTV.volumeUp();

    }

}
