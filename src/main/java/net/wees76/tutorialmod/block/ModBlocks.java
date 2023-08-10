package net.wees76.tutorialmod.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wees76.tutorialmod.item.ModItems;
import net.wees76.tutorialmod.tutorialmod;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, tutorialmod.MODID);

    public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
            ()->new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));
    public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE = registerBlock("deepslate_black_opal_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));
    public static final RegistryObject<Block> NETHERACK_BLACK_OPAL_ORE = registerBlock("netherack_black_opal_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,8)));
    public static final RegistryObject<Block> ENDSTONE_BLACK_OPAL_ORE = registerBlock("endstone_black_opal_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(8f).requiresCorrectToolForDrops(), UniformInt.of(4,10)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
