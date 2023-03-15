package net.jacob.tutorialmod.block;

import net.jacob.tutorialmod.TutorialMod;
import net.jacob.tutorialmod.item.ModCreativeModeTab;
import net.jacob.tutorialmod.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> CHLOROPHYTE_BRICK = RegisterBlock("chlorophyte_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CHLOROPHYTE_ORE = RegisterBlock("chlorophyte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_CHLOROPHYTE_ORE = RegisterBlock("deepslate_chlorophyte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BLOCK_OF_JACOB = RegisterBlock("block_of_jacob",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> PLATINUM_BLOCK = RegisterBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> PLATINUM_ORE = RegisterBlock("platinum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = RegisterBlock("deepslate_platinum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    private static <T extends Block>RegistryObject<T>RegisterBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
