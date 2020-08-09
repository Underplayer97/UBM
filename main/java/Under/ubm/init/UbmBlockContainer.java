package Under.ubm.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class UbmBlockContainer extends Block

{

	public UbmBlockContainer(Properties builder, String registryName) {
		super(builder);
		this.setRegistryName(registryName);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityUbm();
	}

	@Override
	public boolean hasTileEntity() {

		return true;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
