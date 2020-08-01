package Under.ubm.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import Under.ubm.ubm;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new Builder();
	public static final ForgeConfigSpec SERVER;
	
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new Builder();
	public static final ForgeConfigSpec CLIENT;
	
	static 
	{
		OreGenConfig.init(CLIENT_BUILDER, CLIENT_BUILDER);
		
		SERVER = SERVER_BUILDER.build();
		CLIENT = CLIENT_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		ubm.LOGGER.info("Loading config: " + path);
		final CommentedFileConfig file = (CommentedFileConfig) CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		ubm.LOGGER.info("Built config: " + path); 
		file.load();
		ubm.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
}
