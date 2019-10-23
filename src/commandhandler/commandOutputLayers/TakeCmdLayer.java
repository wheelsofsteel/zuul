package commandhandler.commandOutputLayers;

import IO.IOHandler;
import commandhandler.CommandOutputLayer;
import commandhandler.commandBases.TakeCmd;

public class TakeCmdLayer extends TakeCmd implements CommandOutputLayer {
	public void init(String[] args) {
		if(super.execute(args)) {
			onSuccess();
		} else {
			onFail();
		}
	}
	
	public void onSuccess() {
		IOHandler.output.println("You picked up " + toTake);
	}

	public void onFail() {
		IOHandler.output.println("Sorry, this item is too heavy for you to carry. Try dropping something first");
	}


}