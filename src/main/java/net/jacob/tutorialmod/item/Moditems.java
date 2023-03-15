package net.jacob.tutorialmod.item;

import net.jacob.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> chlorophyte = ITEMS.register("chlorophyte",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> platinum = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> mrbeast = ITEMS.register("mrbeast",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> jacob = ITEMS.register("jacob",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> charred_jacob = ITEMS.register("charred_jacob",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
