package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_9_R1.BiomeBase;
import net.minecraft.server.v1_9_R1.Biomes;

import java.lang.reflect.Field;

public class Wrapper_1_9_R1 implements VersionWrapper {

    @Override
    public boolean biomeSupported(Biome biome) {
        return getBiomeField(biome) != null;
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
        Field oldBiomeField = Biomes.class.getField(getBiomeField(oldBiome));
        Field newBiomeField = Biomes.class.getField(getBiomeField(newBiome));

        NMSUtils.removeFinal(oldBiomeField);

        BiomeBase newBiomeBase = (BiomeBase) newBiomeField.get(null);

        oldBiomeField.set(null, newBiomeBase);
    }

    private String getBiomeField(Biome biome) {
        switch (biome) {
            case OCEAN:
                return "a"; // b == a
            case PLAINS:
                return "c";
            case DESERT:
                return "d";
            case MOUNTAINS:
                return "e";
            case FOREST:
                return "f";
            case TAIGA:
                return "g";
            case SWAMP:
                return "h";
            case RIVER:
                return "i";
            case NETHER_WASTES:
                return "j";
            case THE_END:
                return "k";
            case FROZEN_OCEAN:
                return "l";
            case FROZEN_RIVER:
                return "m";
            case SNOWY_TUNDRA:
                return "n";
            case SNOWY_MOUNTAINS:
                return "o";
            case MUSHROOM_FIELDS:
                return "p";
            case MUSHROOM_FIELD_SHORE:
                return "q";
            case BEACH:
                return "r";
            case DESERT_HILLS:
                return "s";
            case WOODED_HILLS:
                return "t";
            case TAIGA_HILLS:
                return "u";
            case MOUNTAIN_EDGE:
                return "v";
            case JUNGLE:
                return "w";
            case JUNGLE_HILLS:
                return "x";
            case JUNGLE_EDGE:
                return "y";
            case DEEP_OCEAN:
                return "z";
            case STONE_SHORE:
                return "A";
            case SNOWY_BEACH:
                return "B";
            case BIRCH_FOREST:
                return "C";
            case BIRCH_FOREST_HILLS:
                return "D";
            case DARK_FOREST:
                return "E";
            case SNOWY_TAIGA:
                return "F";
            case SNOWY_TAIGA_HILLS:
                return "G";
            case GIANT_TREE_TAIGA:
                return "H";
            case GIANT_SPRUCE_TAIGA_HILLS:
                return "I";
            case WOODED_MOUNTAINS:
                return "J";
            case SAVANNA:
                return "K";
            case SAVANNA_PLATEAU:
                return "L";
            case BADLANDS:
                return "M";
            case WOODED_BADLANDS_PLATEAU:
                return "N";
            case BADLANDS_PLATEAU:
                return "O";
            case THE_VOID:
                return "P";
            case SUNFLOWER_PLAINS:
                return "Q";
            case DESERT_LAKES:
                return "R";
            case GRAVELLY_MOUNTAINS:
                return "S";
            case FLOWER_FOREST:
                return "T";
            case TAIGA_MOUNTAINS:
                return "U";
            case SWAMP_HILLS:
                return "V";
            case ICE_SPIKES:
                return "W";
            case MODIFIED_JUNGLE:
                return "X";
            case MODIFIED_JUNGLE_EDGE:
                return "Y";
            case TALL_BIRCH_FOREST:
                return "Z";
            case TALL_BIRCH_HILLS:
                return "aa";
            case DARK_FOREST_HILLS:
                return "ab";
            case SNOWY_TAIGA_MOUNTAINS:
                return "ac";
            case GIANT_SPRUCE_TAIGA:
                return "ad";
            case GIANT_TREE_TAIGA_HILLS:
                return "ae";
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return "af";
            case SHATTERED_SAVANNA:
                return "ag";
            case SHATTERED_SAVANNA_PLATEAU:
                return "ah";
            case ERODED_BADLANDS:
                return "ai";
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return "aj";
            case MODIFIED_BADLANDS_PLATEAU:
                return "ak";
            default:
                return null;
        }
    }

}
