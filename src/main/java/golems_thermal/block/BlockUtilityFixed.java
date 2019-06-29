package golems_thermal.block;

import com.golems.blocks.BlockUtilityGlow;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockUtilityFixed extends BlockUtilityGlow {

	public BlockUtilityFixed(Material m, float defaultLight, int tickRate, IBlockState replaceWith) {
		super(m, defaultLight, tickRate, replaceWith);
	}

	@Override
	public int getLightValue(IBlockState state) {
		return state.getValue(LIGHT_LEVEL);
	}

}
