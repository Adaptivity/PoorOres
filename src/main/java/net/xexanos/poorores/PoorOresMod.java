package net.xexanos.poorores;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.xexanos.poorores.handler.configHandler;
import net.xexanos.poorores.handler.eventHandler;
import net.xexanos.poorores.handler.fuelHandler;
import net.xexanos.poorores.init.Blocks;
import net.xexanos.poorores.init.Items;
import net.xexanos.poorores.reference.Reference;
import net.xexanos.poorores.worldgen.Generator;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class PoorOresMod {
    File configName;

    @Mod.Instance(Reference.MOD_ID)
    public static PoorOresMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        configName = e.getSuggestedConfigurationFile();

        configHandler.preInit(configName);
        Blocks.preInit();
        Items.preInit();

        MinecraftForge.ORE_GEN_BUS.register(new eventHandler());
        GameRegistry.registerWorldGenerator(new Generator(), 16);
        GameRegistry.registerFuelHandler(new fuelHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        Blocks.init();
        Items.init();

    }
}
