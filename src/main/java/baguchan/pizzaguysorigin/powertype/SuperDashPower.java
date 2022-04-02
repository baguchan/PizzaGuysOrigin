package baguchan.pizzaguysorigin.powertype;

import baguchan.pizzaguysorigin.init.ModPowerTypes;
import baguchan.pizzaguysorigin.powertype.configration.SuperDashConfiguration;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.minecraft.world.entity.LivingEntity;

import java.util.Optional;

public class SuperDashPower extends PowerFactory<SuperDashConfiguration> {
	public static Optional<Float> getSuperDashStrength(LivingEntity living) {
		return !ModPowerTypes.SUPER_DASH.isPresent() ? Optional.empty() : IPowerContainer.getPowers(living, ModPowerTypes.SUPER_DASH.get()).stream().map((x) -> {
			return x.getConfiguration().strength();
		}).max(Float::compareTo);
	}

	public SuperDashPower() {
		super(SuperDashConfiguration.CODEC);
	}
}
