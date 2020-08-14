package Under.ubm.init;

import Under.ubm.Registries.TileEntityRegistries;
import net.minecraft.item.Item;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class TileEntityUbm extends TileEntity implements ITickableTileEntity{

	public TileEntityUbm() {
		super(TileEntityRegistries.true_ancient_ct);
		acceptableFuel.put(UbmItems.mixed_powder, 50);
		acceptableFuel.put(UbmItems.brittle_ingot, 100);
	}


	public int fuelAmount = 0;
	public int maxFuel = 100;
	public int progress = 0;
	public int maxProgress = 100;
	public static HashMap<Item, Integer> acceptableFuel = new HashMap<Item, Integer>();

	@Override
	public void tick() {
		if (hasRecipeAndValid(itemSlots)) {
			if (hasFuel()) {
				burnFuel();
				if (progress > maxProgress) {
					removeRecipeInputItems();
				}
			}

		}
	}



	public boolean hasFuel(){
		if(acceptableFuel.containsKey(fuelSlot.getItem)){
			if(fuelAmount <= 0){
				fuelAmount = maxFuel;
				fuelSlot.setCount(fuelSlot.getCount() - 1));
			}
		}

		return (fuelAmount > 0);
	}


	public void burnFuel(){
		if(fuelAmount > 0){
			progress++;
			fuelAmount--;
		}
	}

}

