package commandhandler.consoleCommandOutput;

import IO.IOHandler;
import commandhandler.CommandOutput;
import commandhandler.commandBase.InventoryCmd;
import zuulutils.ZuulTools;

public class InventoryCmdOutput extends InventoryCmd implements CommandOutput {

	public void init(String[] args) {
		String error = super.validateUserInput(args);
		if(error != null) {
			IOHandler.output.printError(error);
			return;
		}
		IOHandler.output.println("You are currently carrying: ");
		inventory.forEach(s-> IOHandler.output.println(ZuulTools.capitalize(s.getName())));
		
	}
}