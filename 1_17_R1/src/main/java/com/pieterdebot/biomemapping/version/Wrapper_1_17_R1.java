package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.data.worldgen.WorldGenSurfaceComposites;
import net.minecraft.data.worldgen.biome.BiomeRegistry;
import net.minecraft.data.worldgen.biome.BiomesSettingsDefault;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.Biomes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Wrapper_1_17_R1 implements VersionWrapper {

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
        Object newBiomeResourceKey = getResourceKey(newBiome);

        Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 3);
        registerMethod.invoke(null, oldBiome.getId(), newBiomeResourceKey, getBiomeBase(newBiome));
    }

    private Object getResourceKey(Biome biome) throws ReflectiveOperationException{
        Field field = Biomes.class.getField(getBiomeField(biome));
        field.setAccessible(true);
        return field.get(null);
    }

    private String getBiomeField(Biome biome) {
        switch (biome) {
            case OCEAN:
                return "a"; // b == a
            case PLAINS:
                return "b";
            case DESERT:
                return "c";
            case MOUNTAINS:
                return "d";
            case FOREST:
                return "e";
            case TAIGA:
                return "f";
            case SWAMP:
                return "g";
            case RIVER:
                return "h";
            case NETHER_WASTES:
                return "i";
            case THE_END:
                return "j";
            case FROZEN_OCEAN:
                return "k";
            case FROZEN_RIVER:
                return "l";
            case SNOWY_TUNDRA:
                return "m";
            case SNOWY_MOUNTAINS:
                return "n";
            case MUSHROOM_FIELDS:
                return "o";
            case MUSHROOM_FIELD_SHORE:
                return "p";
            case BEACH:
                return "q";
            case DESERT_HILLS:
                return "r";
            case WOODED_HILLS:
                return "s";
            case TAIGA_HILLS:
                return "t";
            case MOUNTAIN_EDGE:
                return "u";
            case JUNGLE:
                return "v";
            case JUNGLE_HILLS:
                return "w";
            case JUNGLE_EDGE:
                return "x";
            case DEEP_OCEAN:
                return "y";
            case STONE_SHORE:
                return "z";
            case SNOWY_BEACH:
                return "A";
            case BIRCH_FOREST:
                return "B";
            case BIRCH_FOREST_HILLS:
                return "C";
            case DARK_FOREST:
                return "D";
            case SNOWY_TAIGA:
                return "E";
            case SNOWY_TAIGA_HILLS:
                return "F";
            case GIANT_TREE_TAIGA:
                return "G";
            case GIANT_SPRUCE_TAIGA_HILLS:
                return "H";
            case WOODED_MOUNTAINS:
                return "I";
            case SAVANNA:
                return "J";
            case SAVANNA_PLATEAU:
                return "K";
            case BADLANDS:
                return "L";
            case WOODED_BADLANDS_PLATEAU:
                return "M";
            case BADLANDS_PLATEAU:
                return "N";
            case SMALL_END_ISLANDS:
                return "O";
            case END_MIDLANDS:
                return "P";
            case END_HIGHLANDS:
                return "Q";
            case END_BARRENS:
                return "R";
            case WARM_OCEAN:
                return "S";
            case LUKEWARM_OCEAN:
                return "T";
            case COLD_OCEAN:
                return "U";
            case DEEP_WARM_OCEAN:
                return "V";
            case DEEP_LUKEWARM_OCEAN:
                return "W";
            case DEEP_COLD_OCEAN:
                return "X";
            case DEEP_FROZEN_OCEAN:
                return "Y";
            case THE_VOID:
                return "Z";
            case SUNFLOWER_PLAINS:
                return "aa";
            case DESERT_LAKES:
                return "ab";
            case GRAVELLY_MOUNTAINS:
                return "ac";
            case FLOWER_FOREST:
                return "ad";
            case TAIGA_MOUNTAINS:
                return "ae";
            case SWAMP_HILLS:
                return "af";
            case ICE_SPIKES:
                return "ag";
            case MODIFIED_JUNGLE:
                return "ah";
            case MODIFIED_JUNGLE_EDGE:
                return "ai";
            case TALL_BIRCH_FOREST:
                return "aj";
            case TALL_BIRCH_HILLS:
                return "ak";
            case DARK_FOREST_HILLS:
                return "al";
            case SNOWY_TAIGA_MOUNTAINS:
                return "am";
            case GIANT_SPRUCE_TAIGA:
                return "an";
            case GIANT_TREE_TAIGA_HILLS:
                return "ao";
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return "ap";
            case SHATTERED_SAVANNA:
                return "aq";
            case SHATTERED_SAVANNA_PLATEAU:
                return "ar";
            case ERODED_BADLANDS:
                return "as";
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return "at";
            case MODIFIED_BADLANDS_PLATEAU:
                return "au";
            case BAMBOO_JUNGLE:
                return "av";
            case BAMBOO_JUNGLE_HILLS:
                return "aw";
            case SOUL_SAND_VALLEY:
                return "ax";
            case CRIMSON_FOREST:
                return "ay";
            case WARPED_FOREST:
                return "az";
            case BASALT_DELTAS:
                return "aA";
            case DRIPSTONE_CAVES:
                return "aB";
            case LUSH_CAVES:
                return "aC";
            default:
                return null;
        }
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
            case DRIPSTONE_CAVES:
                return BiomesSettingsDefault.y();
            case LUSH_CAVES:
                return BiomesSettingsDefault.x();
            default:
                return getBiomeBase(Biome.PLAINS);
        }
    }

}
