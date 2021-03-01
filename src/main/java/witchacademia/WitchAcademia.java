package witchacademia;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import witchacademia.setup.ModSetup;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(value = WitchAcademia.MOD_ID)
public class WitchAcademia {
    public static final String MOD_ID = "witchacademia";

    public static ModSetup setup = new ModSetup();

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public WitchAcademia() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        this.setup.init();
    }
}
