package commandhandler.commandBases;

import com.github.cliftonlabs.json_simple.JsonObject;

import commandhandler.CommandBase;
import zuul.GameController;
import zuul.InventoryController;
import zuul.RoomController;
import zuul.TakeableItem;

// TODO: Could be cleaner
public class TakeCmd implements CommandBase {
	protected String toTake;
	@Override
	public boolean execute(String[] args) {
		toTake = args[1];
		if(RoomController.hasTakeableItems()) {
			JsonObject obj = RoomController.ifExistsInArrayReturnObj(toTake, "takeableItems");
			if (obj != null) {
				String name = (String) obj.get("name");
				int weight = Integer.parseInt((String) obj.get("weight"));
				boolean perishable = obj.containsKey("perishable");
				TakeableItem item = null;
				if (!GameController.getCurrentPlayer().getInvController().overWeightLimit(weight)) {
					if(perishable) {
						item = new TakeableItem(name, weight, true);
					} else {
						item = new TakeableItem(name, weight);
					}
					GameController.getCurrentPlayer().getInvController().addItem(item);
					GameController.getCurrentPlayer().getInvController().setWeight(weight);
					RoomController.removeTakeableItem(obj);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

		// TODO: Not been covered by subclass
//		ZuulEventRouter.output.cantFind(args[1]);
	}
}