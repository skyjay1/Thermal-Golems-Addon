package golems_thermal.entity.thermal_foundation;

import java.util.List;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntitySilverGolem extends ThermalGolemTextured {
	
	public static final String ALLOW_IMMUNE = "Allow Special: Immune to Magic";

	public EntitySilverGolem(World world) {
		super(world);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.SILVER_GOLEM);
		this.setCreativeReturn(ThermalGolemColorized.getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.SILVER)));
	}
	
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return super.isEntityInvulnerable(source) || (source.isMagicDamage() && getConfig(this).getBoolean(ALLOW_IMMUNE));
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.SILVER_GOLEM);
	}
	
	@Override
    public List<String> addSpecialDesc(final List<String> list) {
		if(getConfig(this).getBoolean(ALLOW_IMMUNE)) {
			String sImmune = TextFormatting.LIGHT_PURPLE + trans("entitytip.magic_immunity");
			list.add(sImmune);
		}
		return list;
	}
}
