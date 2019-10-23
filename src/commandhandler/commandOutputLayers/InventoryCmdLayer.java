package commandhandler.commandOutputLayers;

import IO.IOHandler;
import commandhandler.CommandOutputLayer;
import commandhandler.commandBases.InventoryCmd;
import zuulutils.ZuulTools;

public class InventoryCmdLayer extends InventoryCmd implements CommandOutputLayer {

	public void init(String[] args) {
		if(super.execute(args)) {
			onSuccess();
		} else {
			onFail();
		}
		
	}
	public void onSuccess() {
		IOHandler.output.println("You are currently carrying: ");
		inventory.forEach(s-> IOHandler.output.println(ZuulTools.capitalize(s.getName())));
	}
	public void onFail() {
		IOHandler.output.println("You do not currently have anything in your inventory");
	}
}