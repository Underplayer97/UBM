package Under.ubm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Under.ubm.config.Config;
import Under.ubm.world.gen.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("ubm")
public class ubm 
{
	public static ubm instance;
	public static final String MODID = "ubm";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public ubm() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "ubm-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "ubm-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("ubm-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("ubm-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup meathod registered.");
	} 
	
	private void clientRegistries(final FMLClientSetupEvent  event)
	{
		LOGGER.info("clientregistries meathod registered.");
	}

}
