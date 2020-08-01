package Under.ubm.init;

import Under.ubm.ubm;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum UbmArmorMaterials implements IArmorMaterial
{
	head("ancient", 400, new int[] {2, 3, 1, 1}, 11, UbmItems.ancient_helmet, "entity.ender_dragon.growl", 0.0f),
	chest("ancient", 400, new int[] {2, 3, 1, 1}, 11,UbmItems.ancient_chestplate, "entity.ender_dragon.growl", 0.0f),
	leg("ancient", 400, new int[] {2, 3, 1, 1}, 11, UbmItems.ancient_leggings, "entity.ender_dragon.growl", 0.0f),
	boots("ancient", 400, new int[] {2, 3, 1, 1}, 11,UbmItems.ancient_boots, "entity.ender_dragon.growl", 0.0f)
	;
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, SoundEvent;
	private int durability, enchanability;
	private Item repairItem;
	private int[]  damageReductionAmounts;
	private float toughness;
	
	private UbmArmorMaterials(String name, int durability, int[] damageReductionAmounts, int enchatability, Item repairItem, String SoundEvent, float toughness) 
	{
		this.name = name;
		this.SoundEvent = SoundEvent;
		this.durability = durability;
		this.enchanability = enchatability;
		this.repairItem = repairItem;
		this.toughness = toughness;
		this.damageReductionAmounts = damageReductionAmounts;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchanability;
	}

	@Override
	public String getName() 
	{
		return ubm.MODID + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(SoundEvent));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
