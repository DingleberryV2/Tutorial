package net.jacob.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import net.jacob.tutorialmod.TutorialMod;
import net.jacob.tutorialmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);

    public static final RegistryObject<PoiType> BLOCK_OF_JACOB_POI = POI_TYPES.register("block_of_jacob_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLOCK_OF_JACOB.get().getStateDefinition().getPossibleStates()),
            1,1));

    public static final RegistryObject<VillagerProfession> JACOB_MERCHANT = VILLAGER_PROFESSIONS.register("jacob_merchant",
            () -> new VillagerProfession("jacob_merchant", x -> x.get() == BLOCK_OF_JACOB_POI.get(),
                     x -> x.get() == BLOCK_OF_JACOB_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs()
    {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, BLOCK_OF_JACOB_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
