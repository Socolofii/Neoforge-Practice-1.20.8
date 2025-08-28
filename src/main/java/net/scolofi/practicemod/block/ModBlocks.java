package net.scolofi.practicemod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scolofi.practicemod.PracticeMod;
import net.scolofi.practicemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PracticeMod.MODID);

    public static final DeferredBlock<Block> ENERGY_BLOCK = registerBlock("energy_block", BlockBehaviour.Properties.of()
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.AMETHYST).instabreak()
            .lightLevel((ll) -> 14)
    );

    private static DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties props)
    {
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name, (property) -> new Block(props), props);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.registerItem(
                name,
                (hi) -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PracticeMod.MODID, name))))
        );
    }

    public static void register (IEventBus eventBus)
    {
        BLOCKS.register(eventBus);


    }
}
