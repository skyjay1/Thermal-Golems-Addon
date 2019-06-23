package golems_thermal.entity;

import com.golems.entity.GolemColorized;

import golems_thermal.main.ThermalGolems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** COLORIZED METAL GOLEM **/
public abstract class ThermalGolemColorized extends GolemColorized {
	
	public static final double METAL_GOLEM_SPEED = 0.22D;
	
	private static final ResourceLocation TEXTURE_BASE = makeTexture(ThermalGolems.MODID, "golem_thermal_base");
	private static final ResourceLocation TEXTURE_OVERLAY_LOW = makeTexture(ThermalGolems.MODID, "golem_thermal_grayscale");
	private static final ResourceLocation TEXTURE_OVERLAY_HIGH = makeTexture(ThermalGolems.MODID, "golem_thermal_grayscale_high");

	public ThermalGolemColorized(World world, long color, boolean isHighContrast) {
		super(world, color, TEXTURE_BASE, (isHighContrast ? TEXTURE_OVERLAY_HIGH : TEXTURE_OVERLAY_LOW));
		this.setCanSwim(false);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(ThermalGolemColorized.METAL_GOLEM_SPEED);
	}
	
	public ThermalGolemColorized(World world, long color) {
		this(world, color, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		final int LIGHT_ADDED = 16;
		return super.getBrightnessForRender() + LIGHT_ADDED;
	}

	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_METAL_STEP;
	}
}
