package baguchan.pizzaguysorigin;

import baguchan.pizzaguysorigin.capability.SuperDashCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PizzaGuysOrigin.MODID)
public class CommonEvents {
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.register(SuperDashCapability.class);
	}

	@SubscribeEvent
	public static void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof LivingEntity) {
			event.addCapability(new ResourceLocation(PizzaGuysOrigin.MODID, "super_dash"), new SuperDashCapability());
		}
	}

	@SubscribeEvent
	public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
		event.getEntityLiving().getCapability(PizzaGuysOrigin.SUPER_DASH_CAP).ifPresent(shadowCapability -> {
			shadowCapability.tick(event.getEntityLiving());
		});
	}

	@SubscribeEvent
	public static void onHurt(LivingHurtEvent event) {
		event.getEntityLiving().getCapability(PizzaGuysOrigin.SUPER_DASH_CAP).ifPresent(shadowCapability -> {
			if (shadowCapability.getPercentBoost() >= 0.5F && !event.getSource().isFire() && !event.getSource().isExplosion() && !event.getSource().isBypassArmor()) {
				event.setAmount(event.getAmount() * (1.0F - shadowCapability.getPercentBoost()));
			}
		});
	}

	@SubscribeEvent
	public static void onLivingKnockback(LivingKnockBackEvent event) {
		event.getEntityLiving().getCapability(PizzaGuysOrigin.SUPER_DASH_CAP).ifPresent(shadowCapability -> {
			if (shadowCapability.getPercentBoost() >= 0.5F) {
				event.setCanceled(true);
			}
		});
	}
}