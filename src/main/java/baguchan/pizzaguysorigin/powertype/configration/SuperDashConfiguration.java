package baguchan.pizzaguysorigin.powertype.configration;

import com.mojang.serialization.Codec;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.calio.api.network.CalioCodecHelper;

public record SuperDashConfiguration(float strength) implements IDynamicFeatureConfiguration {
	public static Codec<SuperDashConfiguration> CODEC;

	public SuperDashConfiguration(float strength) {
		this.strength = strength;
	}

	public float strength() {
		return this.strength;
	}

	static {
		CODEC = CalioCodecHelper.optionalField(Codec.FLOAT, "strength", 1.0F).xmap(SuperDashConfiguration::new, SuperDashConfiguration::strength).codec();
	}
}
