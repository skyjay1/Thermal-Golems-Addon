package golems_thermal.entity.thermal_foundation;

import com.golems.entity.GolemColorizedMultiTextured;
import com.golems.entity.GolemMultiTextured;

import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemDye;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRockwoolGolem extends GolemColorizedMultiTextured {

	private static final ResourceLocation TEXTURE_BASE = makeTexture(ThermalGolems.MODID, "golem_thermal_base");
	private static final ResourceLocation TEXTURE_OVERLAY = makeTexture(ThermalGolems.MODID, ThermalGolemNames.ROCKWOOL_GOLEM);
	public static final int[] COLOR_ARRAY = ItemDye.DYE_COLORS;

	public EntityRockwoolGolem(World world) {
		super(world, TEXTURE_BASE, TEXTURE_OVERLAY, COLOR_ARRAY);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
	}
	
	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_STONE_STEP;
	}	
}
