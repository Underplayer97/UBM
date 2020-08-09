package Under.ubm.init;

import Under.ubm.TileEntityRegistries;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityUbm extends TileEntity implements ITickableTileEntity{

	public TileEntityUbm() {
		super(TileEntityRegistries.true_ancient_ct);
	}

	@Override
	public void tick() 
	{
		
	}

}
