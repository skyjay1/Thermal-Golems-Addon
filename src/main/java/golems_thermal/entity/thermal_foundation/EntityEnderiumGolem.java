package golems_thermal.entity.thermal_foundation;

import java.util.List;

import com.golems.entity.EntityEndstoneGolem;
import com.golems.events.EndGolemTeleportEvent;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityEnderiumGolem extends ThermalGolemColorized {
	
	public static final String ALLOW_SPECIAL = "Allow Special: Teleporting";

	/** Max distance for one teleport; range is 32.0 for endstone golem. **/
	protected double range;
	/** Whether teleporting is allowed for this golem **/
	protected boolean allowTeleport;
	/** Minimum number of ticks between random teleports **/
	protected int ticksBetweenIdleTeleports;
	/** Percent chance to teleport away when hurt by non-projectile. **/
	protected int chanceToTeleportWhenHurt;
	
	public EntityEnderiumGolem(World world) {
		super(world, 0x3A9D9D, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.ENDERIUM_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.ENDERIUM)));
		// teleporting customizations
		this.allowTeleport = getConfig(this).getBoolean(ALLOW_SPECIAL);
		this.range = 32D;
		this.ticksBetweenIdleTeleports = 200;
		this.chanceToTeleportWhenHurt = 15;
	}
	
	////// COPIED FROM ENDSTONE GOLEM CODE //////
	
	@Override
	public void updateAITasks() {
		super.updateAITasks();
		// try to teleport toward target entity
		if (this.getRevengeTarget() != null) {
			this.faceEntity(this.getRevengeTarget(), 100.0F, 100.0F);
			if (this.getRevengeTarget().getDistanceSq(this) > 25.0D 
					&& (rand.nextInt(30) == 0 || this.getRevengeTarget().getRevengeTarget() == this)) {
				this.teleportToEntity(this.getRevengeTarget());
			}
		} else if (rand.nextInt(this.ticksBetweenIdleTeleports) == 0) {
			// or just teleport randomly
			this.teleportRandomly();
		}

	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(final DamageSource src, final float amnt) {
		if (this.isEntityInvulnerable(src)) {
			return false;
		}
		
		// if it's an arrow or something...
		if (src instanceof EntityDamageSourceIndirect) {
			// try to teleport to the attacker
			if(src.getTrueSource() instanceof EntityLivingBase && this.teleportToEntity(src.getTrueSource())) {
				this.setRevengeTarget((EntityLivingBase) src.getTrueSource());
				return super.attackEntityFrom(src, amnt);
			}
			// if teleporting to the attacker didn't work, golem teleports AWAY
			for (int i = 0; i < 32; ++i) {
				if (this.teleportRandomly()) {
					return false;
				}
			}
		} else {
			// if it's something else, golem MIGHT teleport away
			// if it passes a random chance OR has no attack target
			if (rand.nextInt(this.chanceToTeleportWhenHurt) == 0
					|| (this.getRevengeTarget() == null && rand.nextBoolean())) {
				// attempt teleport
				for (int i = 0; i < 16; ++i) {
					if (this.teleportRandomly()) {
						break;
					}
				}
			}
		}
		return super.attackEntityFrom(src, amnt);
	}
	
	protected boolean teleportRandomly() {
		final double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * range;
		final double d1 = this.posY + (this.rand.nextDouble() - 0.5D) * range * 0.5D;
		final double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * range;
		return this.teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport the golem to another entity.
	 **/
	protected boolean teleportToEntity(final Entity entity) {
		Vec3d vec3d = new Vec3d(this.posX - entity.posX,
			this.getEntityBoundingBox().minY + (double) (this.height / 2.0F) - entity.posY
				+ (double) entity.getEyeHeight(),
			this.posZ - entity.posZ);
		vec3d = vec3d.normalize();
		final double d0 = 16.0D;
		final double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * d0;
		final double d2 = this.posY + (double) (this.rand.nextInt(16) - 8) - vec3d.y * d0;
		final double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * d0;
		return this.teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the golem.
	 **/
	protected boolean teleportTo(final double x, final double y, final double z) {
		if (!this.allowTeleport) {
			return false;
		}
		final boolean flag = this.attemptTeleport(x, y, z);

		if (flag) {
			this.world.playSound((EntityPlayer) null, this.prevPosX, this.prevPosY, this.prevPosZ,
				SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
			this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}
	
	@Override
	public List<String> addSpecialDesc(final List<String> list) {
		// this will only fire for the Endstone Golem, not child classes
		if (getConfig(this).getBoolean(ALLOW_SPECIAL)) {
			list.add(TextFormatting.DARK_AQUA + trans("entitytip.can_teleport"));
		}
		return list;
	}
}
