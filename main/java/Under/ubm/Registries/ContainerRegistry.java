package Under.ubm.Registries;

import Under.ubm.Lib.UbmLib;
import Under.ubm.gui.container.true_ancient_ct_Container;
import Under.ubm.gui.true_ancient_ct_Screen;
import Under.ubm.ubm;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class ContainerRegistry
{

        @ObjectHolder(ubm.MODID + ":true_ancient_ct")
        public static ContainerType<true_anceint_ct_Container> true_ancient_ct;

        public static void parseRegistry(RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().register(IForgeContainerType.create((windowID, inv, data) ->
            {
                int entityID = data.readVarInt();
                return new true_ancient_ct_Container(windowID, inv, entityID);
            }).setRegistryName("true_ancient_ct_container"));
        }

        public static void registerScreens () {
            ScreenManager.registerFactory(true_ancient_ct, true_ancient_ct_Screen::new);
        }
}
