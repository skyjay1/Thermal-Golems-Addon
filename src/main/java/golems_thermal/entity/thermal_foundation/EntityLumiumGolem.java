package golems_thermal.entity.thermal_foundation;

import com.golems.blocks.BlockUtilityGlow;
import com.golems.entity.ai.EntityAIUtilityBlock;
import com.golems.main.GolemItems;

import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLumiumGolem extends ThermalGolemTextured {
	
	public static final String ALLOW_SPECIAL = "Allow Special: Emit Light";
	public static final String FREQUENCY = "Light Frequency";

	public EntityLumiumGolem(World world) {
		super(world);
		final boolean allowed = getConfig(this).getBoolean(ALLOW_SPECIAL);
		final int freq = getConfig(this).getInt(FREQUENCY);
		final IBlockState state = GolemItems.blockLightSource.getDefaultState().withProperty(BlockUtilityGlow.LIGHT_LEVEL, 15);
		this.tasks.addTask(9, new EntityAIUtilityBlock(this, state, freq, allowed));
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.LUMIUM_GOLEM);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728880;
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness() {
		return 1.0F;
	}
	
	@Override
	public boolean isProvidingLight() {
		return true;
	}
}
