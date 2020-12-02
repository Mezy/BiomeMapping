package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import com.pieterdebot.biomemapping.version.VersionWrapper;
import net.minecraft.server.v1_16_R3.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Wrapper_1_16_R3 implements VersionWrapper {
    
    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{
        Field newBiomeField = getField(newBiome);
        Object resourceKey = newBiomeField.get(null);

        Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 3);
        registerMethod.invoke(null, getBiomeId(oldBiome), resourceKey, getBiomeBase(newBiome));
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

    private int getBiomeId(Biome biome) {
        switch (biome){
            case OCEAN:
                return 0;
            case PLAINS:
                return 1;
            case DESERT:
                return 2;
            case MOUNTAINS:
                return 3;
            case FOREST:
                return 4;
            case TAIGA:
                return 5;
            case SWAMP:
                return 6;
            case RIVER:
                return 7;
            case NETHER_WASTES:
                return 8;
            case THE_END:
                return 9;
            case FROZEN_OCEAN:
                return 10;
            case FROZEN_RIVER:
                return 11;
            case SNOWY_TUNDRA:
                return 12;
            case SNOWY_MOUNTAINS:
                return 13;
            case MUSHROOM_FIELDS:
                return 14;
            case MUSHROOM_FIELD_SHORE:
                return 15;
            case BEACH:
                return 16;
            case DESERT_HILLS:
                return 17;
            case WOODED_HILLS:
                return 18;
            case TAIGA_HILLS:
                return 19;
            case MOUNTAIN_EDGE:
                return 20;
            case JUNGLE:
                return 21;
            case JUNGLE_HILLS:
                return 22;
            case JUNGLE_EDGE:
                return 23;
            case DEEP_OCEAN:
                return 24;
            case STONE_SHORE:
                return 25;
            case SNOWY_BEACH:
                return 26;
            case BIRCH_FOREST:
                return 27;
            case BIRCH_FOREST_HILLS:
                return 28;
            case DARK_FOREST:
                return 29;
            case SNOWY_TAIGA:
                return 30;
            case SNOWY_TAIGA_HILLS:
                return 31;
            case GIANT_TREE_TAIGA:
                return 32;
            case GIANT_TREE_TAIGA_HILLS:
                return 33;
            case WOODED_MOUNTAINS:
                return 34;
            case SAVANNA:
                return 35;
            case SAVANNA_PLATEAU:
                return 36;
            case BADLANDS:
                return 37;
            case WOODED_BADLANDS_PLATEAU:
                return 38;
            case BADLANDS_PLATEAU:
                return 39;
            case SMALL_END_ISLANDS:
                return 40;
            case END_MIDLANDS:
                return 41;
            case END_HIGHLANDS:
                return 42;
            case END_BARRENS:
                return 43;
            case WARM_OCEAN:
                return 44;
            case LUKEWARM_OCEAN:
                return 45;
            case COLD_OCEAN:
                return 46;
            case DEEP_WARM_OCEAN:
                return 47;
            case DEEP_LUKEWARM_OCEAN:
                return 48;
            case DEEP_COLD_OCEAN:
                return 49;
            case DEEP_FROZEN_OCEAN:
                return 50;

            case THE_VOID:
                return 127;
            case SUNFLOWER_PLAINS:
                return 129;
            case DESERT_LAKES:
                return 130;
            case GRAVELLY_MOUNTAINS:
                return 131;
            case FLOWER_FOREST:
                return 132;
            case TAIGA_MOUNTAINS:
                return 133;
            case SWAMP_HILLS:
                return 134;
            case ICE_SPIKES:
                return 140;
            case MODIFIED_JUNGLE:
                return 149;
            case MODIFIED_JUNGLE_EDGE:
                return 151;
            case TALL_BIRCH_FOREST:
                return 155;
            case TALL_BIRCH_HILLS:
                return 156;
            case DARK_FOREST_HILLS:
                return 157;
            case SNOWY_TAIGA_MOUNTAINS:
                return 158;
            case GIANT_SPRUCE_TAIGA:
                return 160;
            case GIANT_SPRUCE_TAIGA_HILLS:
                return 161;
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return 162;
            case SHATTERED_SAVANNA:
                return 163;
            case SHATTERED_SAVANNA_PLATEAU:
                return 164;
            case ERODED_BADLANDS:
                return 165;
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return 166;
            case MODIFIED_BADLANDS_PLATEAU:
                return 167;
            case BAMBOO_JUNGLE:
                return 168;
            case BAMBOO_JUNGLE_HILLS:
                return 169;
            case SOUL_SAND_VALLEY:
                return 170;
            case CRIMSON_FOREST:
                return 171;
            case WARPED_FOREST:
                return 172;
            case BASALT_DELTAS:
                return 173;
            default:
                return getBiomeId(Biome.PLAINS);
        }
    }

}
