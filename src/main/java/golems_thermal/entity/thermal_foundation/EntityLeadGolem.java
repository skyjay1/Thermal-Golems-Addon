package golems_thermal.entity.thermal_foundation;

import java.util.List;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityLeadGolem extends ThermalGolemColorized {

	public EntityLeadGolem(World world) {
		super(world, 0x7683AE, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.LEAD_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.LEAD)));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.215D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
	}
	
	@Override
	public List<String> addSpecialDesc(final List<String> list) { 
		list.add(TextFormatting.BOLD.toString() + TextFormatting.DARK_GRAY + trans("entitytip.heavy"));
		return list;
	}
}
