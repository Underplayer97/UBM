package Under.ubm.gui.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class true_ancient_ct_Container extends Container
{
    private IItemHandler playerInventory;

    public true_ancient_ct_Container(int windowId, PlayerInventory PLayerInventory, int entityID)
    {
        super(ContainerRegistry);
    }


    @Override
    public boolean canInteractWith(PlayerEntity playerIn)
    {
        return true;
    }
}
