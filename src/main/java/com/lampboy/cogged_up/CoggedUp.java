package com.lampboy.cogged_up;

import com.mojang.datafixers.TypeRewriteRule;
import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CoggedUp.ADDON_ID)
public class CoggedUp {
    public static final String ADDON_ID = "cogged_up";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ADDON_ID)
            //All the items will show up in SEARCH tab if this is not set.
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ADDON_ID, path);
    }

    public CoggedUp() {
        onInit();
    }

    private void onInit() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        REGISTRATE.registerEventListeners(modEventBus);

        CoggedUpCreativeTabs.register(modEventBus);
        CoggedUpBlocks.register();
        CoggedUpBETypes.register();
        CoggedUpPartialModels.register();
    }
}
