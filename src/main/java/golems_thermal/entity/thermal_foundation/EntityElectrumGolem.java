package golems_thermal.entity.thermal_foundation;

import java.util.List;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityElectrumGolem extends ThermalGolemTextured {
	
	public static final String ALLOW_IMMUNE = "Allow Special: Immune to Magic";

	public EntityElectrumGolem(World world) {
		super(world);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.ELECTRUM_GOLEM);
		this.setCreativeReturn(ThermalGolemColorized.getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.ELECTRUM)));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.295D);
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.ELECTRUM_GOLEM);
	}
	
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return super.isEntityInvulnerable(source) || (source.isMagicDamage() && getConfig(this).getBoolean(ALLOW_IMMUNE));
	}
	
	@Override
    public List<String> addSpecialDesc(final List<String> list) {
		// add 2 tips:  magic immunity and speed boost
		if(getConfig(this).getBoolean(ALLOW_IMMUNE)) {
			String sImmune = TextFormatting.LIGHT_PURPLE + trans("entitytip.magic_immunity");
			list.add(sImmune);
		}
		String sFast = TextFormatting.GOLD + trans("entitytip.fast");
		list.add(sFast);
		return list;
	}
}
