package creep3rcrafter.cth;

import creep3rcrafter.cth.common.EventHandler;
import creep3rcrafter.cth.common.TinkersCompat;
import creep3rcrafter.cth.common.commands.Commands;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cth")
public class CTH {

	public static final String MOD_ID = "cth";

	public CTH() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new Commands());
		if (ModList.get().isLoaded("tconstruct")) {
			MinecraftForge.EVENT_BUS.register(new TinkersCompat());
		}
	}

	private void clientSetup(final FMLClientSetupEvent event) {

	}

}
