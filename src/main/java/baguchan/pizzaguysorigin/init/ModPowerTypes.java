package baguchan.pizzaguysorigin.init;

import baguchan.pizzaguysorigin.PizzaGuysOrigin;
import baguchan.pizzaguysorigin.powertype.SuperDashPower;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPowerTypes {
	public static final DeferredRegister<PowerFactory<?>> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY_CLASS, PizzaGuysOrigin.MODID);

	public static final RegistryObject<SuperDashPower> SUPER_DASH = POWER_FACTORIES.register("super_dash", SuperDashPower::new);

}
