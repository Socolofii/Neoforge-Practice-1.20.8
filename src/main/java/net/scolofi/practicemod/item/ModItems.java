package net.scolofi.practicemod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scolofi.practicemod.PracticeMod;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PracticeMod.MODID);

    public static final DeferredItem<Item> ORANGEORB =
            ITEMS.registerItem("orangeorb", Item::new, new Item.Properties());
    public static final DeferredItem<Item> YELLOWORB =
            ITEMS.registerItem("yelloworb", Item::new, new Item.Properties());

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
