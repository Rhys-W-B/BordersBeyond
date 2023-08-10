package net.wees76.tutorialmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.wees76.tutorialmod.tutorialmod;

@Mod.EventBusSubscriber(modid = tutorialmod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true,new ModRecipeProvider(packOutput));
        generator.addProvider(true,ModLootTableProvider.create(packOutput));
        generator.addProvider(true,new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true,new ModItemModelProvider(packOutput, existingFileHelper));
    }
}