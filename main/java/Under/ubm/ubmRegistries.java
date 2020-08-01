package Under.ubm;

import org.apache.logging.log4j.Logger;

import Under.ubm.init.UbmBlock;
import Under.ubm.init.UbmItems;
import Under.ubm.init.ubmToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ubmRegistries 
{
	public static final Logger LOGGER = ubm.LOGGER;
	public static final String MODID = ubm.MODID;
	public static final ItemGroup Ubm = new UbmItemGroup();
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll
		(
				//Powders
				UbmItems.diamond_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("diamond_powder")),
				UbmItems.gold_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("gold_powder")),
				UbmItems.emerald_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("emerald_powder")),
				UbmItems.coal_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("coal_powder")),
				UbmItems.iron_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("iron_powder")),
				UbmItems.lapis_powder = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("lapis_powder")),
				
				//Etc
				UbmItems.mortar_pestel = new Item(new Item.Properties(SetCount = 1).group(Ubm)).setRegistryName(location("mortar_pestel")),

				//Weapons
				UbmItems.ancient_sword = new SwordItem(ubmToolMaterials.ancsword, (int) 0.0f, 6.0f, new Item.Properties().group(Ubm)).setRegistryName(location("ancient_sword")),
			    UbmItems.true_sword = new SwordItem(ubmToolMaterials.truesword, (int) 100.0f, 20.0f, new Item.Properties().group(Ubm)).setRegistryName(location("true_sword")),

				
				//Ingots
				UbmItems.ancient_ingot = new Item(new Item.Properties().group(Ubm)).setRegistryName(location("ancient_ingot")),
				
				//Blocks
				UbmItems.ancient_ore = new BlockItem(UbmBlock.ancient_ore, new Item.Properties().group(Ubm)).setRegistryName(UbmBlock.ancient_ore.getRegistryName())

				);
		LOGGER.info("Items registered");
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
				UbmBlock.ancient_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("ancient_ore"))

		);
		
		LOGGER.info("Blocks registered.");
	}
	
	private static ResourceLocation location(String name) 
	{
		return new ResourceLocation(MODID, name);
	}
}
