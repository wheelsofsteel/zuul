package commands;

import IO.OutputHandler;
import npc.NPC;
import zuul.GameController;
import zuul.InventoryController;
import zuul.TakeableItem;

public class GiveCmd implements Command{

	public GiveCmd() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String[] args) {
		String preposition = args[2];
		if(!preposition.equals("to")) {
			OutputHandler.println("Invalid command");
			return;
		}
		String itemName = args[1];
		String actorName = args[3];
		actorName = actorName.substring(0, 1).toUpperCase() + actorName.substring(1, actorName.length());
		if(InventoryController.checkIfExists(itemName)) {
			TakeableItem takeableItem = InventoryController.getItem(itemName);
			NPC npc = GameController.getActor(actorName);
			if(!npc.onGive(takeableItem.getName())) {
				OutputHandler.println(npc.getName() + " didn't seem to want the " + itemName);
			} else {
				if(takeableItem.isPerishable()) {
					InventoryController.setWeight(takeableItem.getWeight());
					InventoryController.removeItem(takeableItem);
				}
			}
		} else {
			OutputHandler.println("You do not have " + itemName + " in your inventory"); // TODO: You've written this before
		}
			
	}

}
