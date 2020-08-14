package Under.ubm.Registries;

import Under.ubm.ubm;
import org.apache.logging.log4j.Logger;

import Under.ubm.init.UbmArmorMaterials;
import Under.ubm.init.UbmBlock;
import Under.ubm.init.UbmBlockContainer;
import Under.ubm.init.UbmItems;
import Under.ubm.init.ubmToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ubmRegistries {
	public static final Logger LOGGER = ubm.LOGGER;
	public static final String MODID = ubm.MODID;
	public static final ItemGroup Ubm = new UbmItemGroup();

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				// Powders
				UbmItems.diamond_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("diamond_powder")),
				UbmItems.gold_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("gold_powder")),
				UbmItems.emerald_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("emerald_powder")),
				UbmItems.coal_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("coal_powder")),
				UbmItems.iron_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("iron_powder")),
				UbmItems.lapis_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("lapis_powder")),
				UbmItems.mixed_powder = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("mixed_powder")),

				// Etc
				UbmItems.mortar_pestel = new Item(new Item.Properties().maxStackSize(1).group(Ubm))
						.setRegistryName(location("mortar_pestel")),

				// Weapons
				UbmItems.ancient_sword = new SwordItem(ubmToolMaterials.ancsword, (int) 0.0f, 6.0f,
						new Item.Properties().group(Ubm)).setRegistryName(location("ancient_sword")),
				UbmItems.true_sword = new SwordItem(ubmToolMaterials.truesword, (int) 100.0f, 20.0f,
						new Item.Properties().group(Ubm)).setRegistryName(location("true_sword")),

				// Ingots
				UbmItems.ancient_ingot = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("ancient_ingot")),
				UbmItems.brittle_ingot = new Item(new Item.Properties().group(Ubm))
						.setRegistryName(location("brittle_ingot")),

				// Blocks
				UbmItems.ancient_ore = new BlockItem(UbmBlock.ancient_ore, new Item.Properties().group(Ubm))
						.setRegistryName(UbmBlock.ancient_ore.getRegistryName()),
				UbmItems.true_ancient_ct = new BlockItem(UbmBlock.true_ancient_ct, new Item.Properties().group(Ubm))
						.setRegistryName(UbmBlock.true_ancient_ct.getRegistryName()),

				// Armor
				UbmItems.ancient_helmet = new ArmorItem(UbmArmorMaterials.head, EquipmentSlotType.HEAD,
						new Item.Properties().group(Ubm)).setRegistryName(location("ancient_helmet")),
				UbmItems.ancient_chestplate = new ArmorItem(UbmArmorMaterials.chest, EquipmentSlotType.CHEST,
						new Item.Properties().group(Ubm)).setRegistryName(location("ancient_chestplate")),
				UbmItems.ancient_leggings = new ArmorItem(UbmArmorMaterials.leg, EquipmentSlotType.LEGS,
						new Item.Properties().group(Ubm)).setRegistryName(location("ancient_leggings")),
				UbmItems.ancient_boots = new ArmorItem(UbmArmorMaterials.boots, EquipmentSlotType.FEET,
						new Item.Properties().group(Ubm)).setRegistryName(location("ancient_boots"))

		// Tables

		);
		LOGGER.info("Items registered");
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				UbmBlock.ancient_ore = new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL))
								.setRegistryName(location("ancient_ore")),
				UbmBlock.true_ancient_ct = new UbmBlockContainer(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL), "true_ancient_ct")
								

		);

		LOGGER.info("Blocks registered.");
	}

	private static ResourceLocation location(String name) {
		return new ResourceLocation(MODID, name);
	}

	@SubscribeEvent
	public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
		TileEntityRegistries.parseTileEntityRegistry(event);
	}
}
