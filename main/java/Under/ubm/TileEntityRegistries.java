package Under.ubm;

import java.util.function.Supplier;

import Under.ubm.init.TileEntityUbm;
import Under.ubm.init.UbmBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class TileEntityRegistries 
{
	@ObjectHolder(UbmLib.TRUE_ANCIENT_CT)
	public static TileEntityType<?> true_ancient_ct;
	public static void parseTileEntityRegistry(RegistryEvent.Register<TileEntityType<?>> e) 
	{
	e.getRegistry().registerAll(TileEntityType.Builder.create((Supplier<TileEntity>)TileEntityUbm::new, UbmBlock.true_ancient_ct).build(null).setRegistryName(UbmLib.TRUE_ANCIENT_CT));
	}
	
}
