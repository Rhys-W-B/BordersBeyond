package net.wees76.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wees76.tutorialmod.tutorialmod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, tutorialmod.MODID);

    public static final RegistryObject<Item>BLACK_OPAL = ITEMS.register("black_opal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item>RAW_BLACK_OPAL = ITEMS.register("raw_black_opal", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
