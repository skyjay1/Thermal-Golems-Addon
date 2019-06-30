package golems_thermal.entity.thermal_foundation;

import com.golems.blocks.BlockUtilityGlow;
import com.golems.entity.ai.EntityAIUtilityBlock;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityManaInfusedGolem extends ThermalGolemColorized {
	
	public static final String ALLOW_SPECIAL = "Allow Special: Emit Light";
	public static final String FREQUENCY = "Light Frequency";

	public EntityManaInfusedGolem(World world) {
		super(world, 0x6499BA, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.MANAINFUSED_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.MITHRIL)));
		final boolean allowed = getConfig(this).getBoolean(ALLOW_SPECIAL);
		final int freq = getConfig(this).getInt(FREQUENCY);
		final IBlockState state = ThermalGolems.blockGlowFixed.getDefaultState().withProperty(BlockUtilityGlow.LIGHT_LEVEL, 7);
		this.tasks.addTask(9, new EntityAIUtilityBlock(this, state, freq, allowed));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return (int) (15728880F * 0.9F);
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness() {
		return 0.9F;
	}
	
	@Override
	public boolean isProvidingLight() {
		return true;
	}
}
