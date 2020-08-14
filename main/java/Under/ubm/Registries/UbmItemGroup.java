package Under.ubm.Registries;

import Under.ubm.init.UbmItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UbmItemGroup extends ItemGroup
{

	public UbmItemGroup() 
	{
		super("Ubm");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(UbmItems.diamond_powder);
	}
	
}
