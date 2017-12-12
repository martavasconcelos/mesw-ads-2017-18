package hot.command;

public class Button {

    Command theCommand;

    public Button(Command newCommand){

        theCommand = newCommand;

    }

    public void press(){

        theCommand.execute();

    }
}
