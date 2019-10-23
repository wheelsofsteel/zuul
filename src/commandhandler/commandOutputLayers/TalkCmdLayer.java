package commandhandler.commandOutputLayers;

import IO.IOHandler;
import commandhandler.CommandOutputLayer;
import commandhandler.commandBases.TalkCmd;

public class TalkCmdLayer extends TalkCmd implements CommandOutputLayer {
	public void init(String[] args) {
		if(super.execute(args)) {
			onSuccess();
		} else {
			onFail();
		}
	}
	public void onSuccess() {
		actor.onTalk();
	}
	public void onFail() {
		IOHandler.output.println("Can't find " + toTalk);
	}
}