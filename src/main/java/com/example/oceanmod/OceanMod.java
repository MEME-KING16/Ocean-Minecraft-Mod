package com.example.oceanmod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import com.example.oceanmod.entity.ModEntityTypes;
import com.example.oceanmod.event.ModEventBusEvents;
import com.example.oceanmod.block.AirstoneBlock;
import com.example.oceanmod.item.RandomEffectItem;
import com.example.oceanmod.item.ModToolTiers;
// import com.example.oceanmod.worldgen.ModBiomes;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(OceanMod.MOD_ID)
public class OceanMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "oceanmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    
    public static final RegistryObject<Block> SINKER_WOOD_BLOCK = BLOCKS.register("sinker_wood", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).lightLevel(state -> 5).strength(2f)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> SINKER_WOOD_BLOCK_ITEM = ITEMS.register("sinker_wood", () -> new BlockItem(SINKER_WOOD_BLOCK.get(), new Item.Properties()));
    // planks block
    public static final RegistryObject<Block> SINKER_PLANKS_BLOCK = BLOCKS.register("sinker_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2f)));
    //planks item
    public static final RegistryObject<Item> SINKER_PLANKS_BLOCK_ITEM = ITEMS.register("sinker_planks", () -> new BlockItem(SINKER_PLANKS_BLOCK.get(), new Item.Properties()));
    // rusted metal block
    public static final RegistryObject<Block> RUSTED_METAL_BLOCK = BLOCKS.register("rusted_metal", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(5f)));
    // rusted metal item
    public static final RegistryObject<Item> RUSTED_METAL_BLOCK_ITEM = ITEMS.register("rusted_metal", () -> new BlockItem(RUSTED_METAL_BLOCK.get(), new Item.Properties()));
    // shale block
    public static final RegistryObject<Block> SHALE_BLOCK = BLOCKS.register("shale", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.5f)));
    // shale item
    public static final RegistryObject<Item> SHALE_BLOCK_ITEM = ITEMS.register("shale", () -> new BlockItem(SHALE_BLOCK.get(), new Item.Properties()));
    // Sea Glass Green block
    public static final RegistryObject<Block> SEA_GLASS_GREEN_BLOCK = BLOCKS.register("sea_glass_green", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(0.3f).sound(SoundType.GLASS).noOcclusion().isRedstoneConductor((state, world, pos) -> false)));
    // Sea Glass Green item
    public static final RegistryObject<Item> SEA_GLASS_GREEN_ITEM = ITEMS.register("sea_glass_green", () -> new BlockItem(SEA_GLASS_GREEN_BLOCK.get(), new Item.Properties()));
    // Sea Glass Red block
    public static final RegistryObject<Block> SEA_GLASS_RED_BLOCK = BLOCKS.register("sea_glass_red", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(0.3f).sound(SoundType.GLASS).noOcclusion().isRedstoneConductor((state, world, pos) -> false)));
    // Sea Glass Red item
    public static final RegistryObject<Item> SEA_GLASS_RED_ITEM = ITEMS.register("sea_glass_red", () -> new BlockItem(SEA_GLASS_RED_BLOCK.get(), new Item.Properties()));
    // Leaf Light block
    public static final RegistryObject<Block> LIGHT_LEAF_BLOCK = BLOCKS.register("light_leaf", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn((state, level, pos, entityType) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false).lightLevel(state -> 12)));
    // Leaf Light item
    public static final RegistryObject<Item> LIGHT_LEAF_BLOCK_ITEM = ITEMS.register("light_leaf", () -> new BlockItem(LIGHT_LEAF_BLOCK.get(), new Item.Properties()));
    // Pearl Light block
    public static final RegistryObject<Block> PEARL_LIGHT_BLOCK = BLOCKS.register("pearl_light", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).mapColor(MapColor.STONE).strength(0.3f).sound(SoundType.GLASS).noOcclusion().isRedstoneConductor((state, world, pos) -> false).lightLevel(state -> 12)));
    // Pearl Light item
    public static final RegistryObject<Item> PEARL_LIGHT_BLOCK_ITEM = ITEMS.register("pearl_light", () -> new BlockItem(PEARL_LIGHT_BLOCK.get(), new Item.Properties()));
    // Pearl Light2 block
    public static final RegistryObject<Block> PEARL_LIGHT2_BLOCK = BLOCKS.register("pearl_light2", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).mapColor(MapColor.STONE).strength(0.3f).sound(SoundType.GLASS).noOcclusion().isRedstoneConductor((state, world, pos) -> false).lightLevel(state -> 12)));
    // Pearl Light2 item
    public static final RegistryObject<Item> PEARL_LIGHT2_BLOCK_ITEM = ITEMS.register("pearl_light2", () -> new BlockItem(PEARL_LIGHT2_BLOCK.get(), new Item.Properties()));
    // Airstone block
    public static final RegistryObject<Block> AIRSTONE_BLOCK = BLOCKS.register("airstone", () -> new AirstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(5f)));
    // Airstone item
    public static final RegistryObject<Item> AIRSTONE_BLOCK_ITEM = ITEMS.register("airstone", () -> new BlockItem(AIRSTONE_BLOCK.get(), new Item.Properties()));
    // Mystery Meat
    public static final RegistryObject<Item> MYSTERY_MEAT = ITEMS.register("mystery_meat", () -> new RandomEffectItem(new Item.Properties().food(new FoodProperties.Builder()
             .alwaysEat().nutrition(1).saturationMod(1f).build())));
    // Vocal Cords
    public static final RegistryObject<Item> VOCAL_CORDS = ITEMS.register("vocal_cords", () -> new Item(new Item.Properties()));
    // 
    public static final RegistryObject<Item> RUSTED_METAL_SWORD = ITEMS.register("rusted_metal_sword", () -> new SwordItem(ModToolTiers.RUSTED, 3, -2.4f, new Item.Properties()));
    // Creates a creative tab with the id "oceanmod:oceanmod_blocks" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> OCEANMOD_BLOCKS = CREATIVE_MODE_TABS.register("oceanmod_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.oceanmod.oceanmod_blocks"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> SINKER_WOOD_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(SINKER_WOOD_BLOCK_ITEM.get());
                output.accept(SINKER_PLANKS_BLOCK_ITEM.get());
                output.accept(RUSTED_METAL_BLOCK_ITEM.get());
                output.accept(SHALE_BLOCK_ITEM.get());
                output.accept(SEA_GLASS_GREEN_ITEM.get());
                output.accept(SEA_GLASS_RED_ITEM.get());
                output.accept(LIGHT_LEAF_BLOCK_ITEM.get());
                output.accept(PEARL_LIGHT_BLOCK_ITEM.get());
                output.accept(PEARL_LIGHT2_BLOCK_ITEM.get());
                output.accept(AIRSTONE_BLOCK_ITEM.get());
            }).build());

    // Creates a creative tab with the id "oceanmod:oceanmod_items" for the example item, that is placed after the oceanmod_blocks tab
    public static final RegistryObject<CreativeModeTab> OCEANMOD_ITEMS = CREATIVE_MODE_TABS.register("oceanmod_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.oceanmod.oceanmod_items"))
            .withTabsBefore(OCEANMOD_BLOCKS.getKey())
            .icon(() -> SINKER_WOOD_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(MYSTERY_MEAT.get());
                output.accept(VOCAL_CORDS.get());
            }).build());

    // Creates a creative tab with the id "oceanmod:oceanmod_weapons" for the example item, that is placed after the oceanmod_items tab
    public static final RegistryObject<CreativeModeTab> OCEANMOD_WEAPONS = CREATIVE_MODE_TABS.register("oceanmod_weapons", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.oceanmod.oceanmod_weapons"))
            .withTabsBefore(OCEANMOD_BLOCKS.getKey())
            .icon(() -> SINKER_WOOD_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RUSTED_METAL_SWORD.get());
            }).build());

    public OceanMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        modEventBus.register(ModEventBusEvents.class);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
        // Register the biomes
        //ModBiomes.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative); 

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(SINKER_WOOD_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
