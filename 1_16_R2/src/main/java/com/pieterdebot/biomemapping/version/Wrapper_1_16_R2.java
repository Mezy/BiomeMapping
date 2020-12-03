package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_16_R2.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Wrapper_1_16_R2 implements VersionWrapper {

    @Override
    public boolean biomeSupported(Biome biome) {
        try {
            Biomes.class.getField(biome.name());
            return true;
        }catch (NoSuchFieldException ex){
            return false;
        }
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{
        Field newBiomeField = getField(newBiome);
        Object resourceKey = newBiomeField.get(null);

        Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 3);
        registerMethod.invoke(null, oldBiome.getId(), resourceKey, getBiomeBase(newBiome));
    }

    private Field getField(Biome biome) throws ReflectiveOperationException{
        Field field = Biomes.class.getField(biome.name());
        field.setAccessible(true);
        NMSUtils.removeFinal(field);
        return field;
    }

    private BiomeBase getBiomeBase(Biome biome) {
        switch (biome){
            case OCEAN:
                return BiomesSettingsDefault.c(false);
            case PLAINS:
                return BiomesSettingsDefault.a(false);
            case DESERT:
                return BiomesSettingsDefault.a(0.125F, 0.05F, true, true, true);
            case MOUNTAINS:
                return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.m, false);
            case FOREST:
                return BiomesSettingsDefault.c(0.1F, 0.2F);
            case TAIGA:
                return BiomesSettingsDefault.a(0.2F, 0.2F, false, false, true, false);
            case SWAMP:
                return BiomesSettingsDefault.d(-0.2F, 0.1F, false);
            case RIVER:
                return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.5F, 4159204, false);
            case NETHER_WASTES:
                return BiomesSettingsDefault.s();
            case THE_END:
                return BiomesSettingsDefault.i();
            case FROZEN_OCEAN:
                return BiomesSettingsDefault.e(false);
            case FROZEN_RIVER:
                return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.0F, 3750089, true);
            case SNOWY_TUNDRA:
                return BiomesSettingsDefault.a(0.125F, 0.05F, false, false);
            case SNOWY_MOUNTAINS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, false, true);
            case MUSHROOM_FIELDS:
                return BiomesSettingsDefault.a(0.2F, 0.3F);
            case MUSHROOM_FIELD_SHORE:
                return BiomesSettingsDefault.a(0.0F, 0.025F);
            case BEACH:
                return BiomesSettingsDefault.a(0.0F, 0.025F, 0.8F, 0.4F, 4159204, false, false);
            case DESERT_HILLS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, false, true, false);
            case WOODED_HILLS:
                return BiomesSettingsDefault.c(0.45F, 0.3F);
            case TAIGA_HILLS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, false, false, false, false);
            case MOUNTAIN_EDGE:
                return BiomesSettingsDefault.a(0.8F, 0.3F, WorldGenSurfaceComposites.j, true);
            case JUNGLE:
                return BiomesSettingsDefault.a();
            case JUNGLE_HILLS:
                return BiomesSettingsDefault.e();
            case JUNGLE_EDGE:
                return BiomesSettingsDefault.b();
            case DEEP_OCEAN:
                return BiomesSettingsDefault.c(true);
            case STONE_SHORE:
                return BiomesSettingsDefault.a(0.1F, 0.8F, 0.2F, 0.3F, 4159204, false, true);
            case SNOWY_BEACH:
                return BiomesSettingsDefault.a(0.0F, 0.025F, 0.05F, 0.3F, 4020182, true, false);
            case BIRCH_FOREST:
                return BiomesSettingsDefault.a(0.1F, 0.2F, false);
            case BIRCH_FOREST_HILLS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, false);
            case DARK_FOREST:
                return BiomesSettingsDefault.c(0.1F, 0.2F, false);
            case SNOWY_TAIGA:
                return BiomesSettingsDefault.a(0.2F, 0.2F, true, false, false, true);
            case SNOWY_TAIGA_HILLS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, true, false, false, false);
            case GIANT_TREE_TAIGA:
                return BiomesSettingsDefault.a(0.2F, 0.2F, 0.3F, false);
            case GIANT_TREE_TAIGA_HILLS:
                return BiomesSettingsDefault.a(0.45F, 0.3F, 0.3F, false);
            case WOODED_MOUNTAINS:
                return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.j, true);
            case SAVANNA:
                return BiomesSettingsDefault.a(0.125F, 0.05F, 1.2F, false, false);
            case SAVANNA_PLATEAU:
                return BiomesSettingsDefault.m();
            case BADLANDS:
                return BiomesSettingsDefault.b(0.1F, 0.2F, false);
            case WOODED_BADLANDS_PLATEAU:
                return BiomesSettingsDefault.b(1.5F, 0.025F);
            case BADLANDS_PLATEAU:
                return BiomesSettingsDefault.b(1.5F, 0.025F, true);
            case SMALL_END_ISLANDS:
                return BiomesSettingsDefault.l();
            case END_MIDLANDS:
                return BiomesSettingsDefault.j();
            case END_HIGHLANDS:
                return BiomesSettingsDefault.k();
            case END_BARRENS:
                return BiomesSettingsDefault.h();
            case WARM_OCEAN:
                return BiomesSettingsDefault.o();
            case LUKEWARM_OCEAN:
                return BiomesSettingsDefault.d(false);
            case COLD_OCEAN:
                return BiomesSettingsDefault.b(false);
            case DEEP_WARM_OCEAN:
                return BiomesSettingsDefault.p();
            case DEEP_LUKEWARM_OCEAN:
                return BiomesSettingsDefault.d(true);
            case DEEP_COLD_OCEAN:
                return BiomesSettingsDefault.b(true);
            case DEEP_FROZEN_OCEAN:
                return BiomesSettingsDefault.e(true);
            case THE_VOID:
                return BiomesSettingsDefault.r();
            case SUNFLOWER_PLAINS:
                return BiomesSettingsDefault.a(true);
            case DESERT_LAKES:
                return BiomesSettingsDefault.a(0.225F, 0.25F, false, false, false);
            case GRAVELLY_MOUNTAINS:
                return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
            case FLOWER_FOREST:
                return BiomesSettingsDefault.q();
            case TAIGA_MOUNTAINS:
                return BiomesSettingsDefault.a(0.3F, 0.4F, false, true, false, false);
            case SWAMP_HILLS:
                return BiomesSettingsDefault.d(-0.1F, 0.3F, true);
            case ICE_SPIKES:
                return BiomesSettingsDefault.a(0.425F, 0.45000002F, true, false);
            case MODIFIED_JUNGLE:
                return BiomesSettingsDefault.d();
            case MODIFIED_JUNGLE_EDGE:
                return BiomesSettingsDefault.c();
            case TALL_BIRCH_FOREST:
                return BiomesSettingsDefault.a(0.2F, 0.4F, true);
            case TALL_BIRCH_HILLS:
                return BiomesSettingsDefault.a(0.55F, 0.5F, true);
            case DARK_FOREST_HILLS:
                return BiomesSettingsDefault.c(0.2F, 0.4F, true);
            case SNOWY_TAIGA_MOUNTAINS:
                return BiomesSettingsDefault.a(0.3F, 0.4F, true, true, false, false);
            case GIANT_SPRUCE_TAIGA:
                return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
            case GIANT_SPRUCE_TAIGA_HILLS:
                return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
            case SHATTERED_SAVANNA:
                return BiomesSettingsDefault.a(0.3625F, 1.225F, 1.1F, true, true);
            case SHATTERED_SAVANNA_PLATEAU:
                return BiomesSettingsDefault.a(1.05F, 1.2125001F, 1.0F, true, true);
            case ERODED_BADLANDS:
                return BiomesSettingsDefault.n();
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return BiomesSettingsDefault.b(0.45F, 0.3F);
            case MODIFIED_BADLANDS_PLATEAU:
                return BiomesSettingsDefault.b(0.45F, 0.3F, true);
            case BAMBOO_JUNGLE:
                return BiomesSettingsDefault.f();
            case BAMBOO_JUNGLE_HILLS:
                return BiomesSettingsDefault.g();
            case SOUL_SAND_VALLEY:
                return BiomesSettingsDefault.t();
            case CRIMSON_FOREST:
                return BiomesSettingsDefault.v();
            case WARPED_FOREST:
                return BiomesSettingsDefault.w();
            case BASALT_DELTAS:
                return BiomesSettingsDefault.u();
            default:
                return getBiomeBase(Biome.PLAINS);
        }
    }

}
