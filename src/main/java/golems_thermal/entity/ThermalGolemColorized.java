package golems_thermal.entity;

import java.util.Collection;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemColorized;

import golems_thermal.main.ThermalGolems;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
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

	public static boolean doPropsMatch(final IBlockState body, final IBlockState legs, final IBlockState arm1, final IBlockState arm2) {
		final Collection<IProperty<?>> bodyProps = body.getPropertyKeys();
		boolean match = true;
		for(final IProperty<?> prop : bodyProps) {
			// make sure all blocks have similar property maps
			if(legs.getPropertyKeys().contains(prop) 
				&& arm1.getPropertyKeys().contains(prop)
				&& arm2.getPropertyKeys().contains(prop)) {
				// make sure all of these values are equal for this property
				match &= body.getValue(prop) == legs.getValue(prop) &&
						legs.getValue(prop) == arm1.getValue(prop) &&
						arm1.getValue(prop) == arm2.getValue(prop);
			}
		}
		return match;
	}

	public static ItemStack getStack(final IBlockState state) {
		final int damage = state.getBlock().damageDropped(state);
		return new ItemStack(Item.getItemFromBlock(state.getBlock()), 1, damage);
	}

	public static void dropAsItems(final Entity entity, final IBlockState... blocks) {
		for(final IBlockState state : blocks) {
			entity.entityDropItem(ThermalGolemColorized.getStack(state), 0.0F);
		}
	}

	public static void replace(final GolemBase existing, final GolemBase updated) {
		updated.setLocationAndAngles(existing.posX, existing.posY, existing.posZ, existing.rotationYaw, existing.rotationPitch);
		updated.setPlayerCreated(existing.isPlayerCreated());
		existing.getEntityWorld().spawnEntity(updated);
		existing.setDead();
		
	}
	
	public static void replaceFailAnimation(final GolemBase existing) {	
		final World world = existing.getEntityWorld();
		final double x = existing.posX;
		final double y = existing.posY;
		final double z = existing.posZ;
		// spawn particles
		if(world.isRemote) {
			final double motion = 0.12D;
			for (int i1 = 20 + world.rand.nextInt(10); i1 > 0; --i1) {
				world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
					x + world.rand.nextDouble() - 0.5D,
					y + world.rand.nextDouble() + 1.0D, 
					z + world.rand.nextDouble() - 0.5D,
					world.rand.nextDouble() * motion,
					world.rand.nextDouble() * motion * 0.25D,
					world.rand.nextDouble() * motion);
			}
			// play sound to indicate failure
			world.playSound(x, y, z, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 
					0.9F + world.rand.nextFloat(), 1.0F, false);
		}
		
	}
}
