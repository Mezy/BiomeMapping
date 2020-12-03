package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_13_R1.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class Wrapper_1_13_R1 implements VersionWrapper {

    private static final Biome[] HASH_SET_BIOMES = new Biome[]{Biome.OCEAN, Biome.PLAINS, Biome.DESERT, Biome.MOUNTAINS, Biome.FOREST, Biome.TAIGA, Biome.SWAMP, Biome.RIVER, Biome.FROZEN_RIVER, Biome.SNOWY_TUNDRA, Biome.SNOWY_MOUNTAINS, Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE, Biome.BEACH, Biome.DESERT_HILLS, Biome.WOODED_HILLS, Biome.TAIGA_HILLS, Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.DEEP_OCEAN, Biome.STONE_SHORE, Biome.SNOWY_BEACH, Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.DARK_FOREST, Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.WOODED_MOUNTAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.BADLANDS, Biome.WOODED_BADLANDS_PLATEAU, Biome.BADLANDS_PLATEAU};

    @Override
    public boolean biomeSupported(Biome biome) {
        return getBiomeField(biome) != null;
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{

        Method registerMethod = NMSUtils.getMethod(BiomeBase.class, "a", int.class, String.class, BiomeBase.class);

        Field biomeBaseHashSet = BiomeBase.class.getField("aG");
        NMSUtils.removeFinal(biomeBaseHashSet);

        // New registered BiomeBase
        registerMethod.invoke(null, oldBiome.getId(), oldBiome.name().toLowerCase(), getBiomeBase(newBiome));

        Set<Object> hashSet = (Set<Object>) biomeBaseHashSet.get(null);
        hashSet.clear();
        for (Biome biome : HASH_SET_BIOMES){
            hashSet.add(getField(biome).get(null));
        }

        biomeBaseHashSet.set(null, hashSet);
    }

    private Field getField(Biome biome) throws ReflectiveOperationException{
        Field field = Biomes.class.getField(getBiomeField(biome));
        field.setAccessible(true);
        NMSUtils.removeFinal(field);
        return field;
    }

    private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException{
        switch (biome){
            case OCEAN:
                return new BiomeOcean();
            case PLAINS:
                return getBiomeBaseInstance(BiomePlains.class);
            case DESERT:
                return new BiomeDesert();
            case MOUNTAINS:
                return getBiomeBaseInstance(BiomeBigHills.class);
            case FOREST:
                return new BiomeForest();
            case TAIGA:
                return new BiomeTaiga();
            case SWAMP:
                return getBiomeBaseInstance(BiomeSwamp.class);
            case RIVER:
                return new BiomeRiver();
            case NETHER_WASTES:
                return getBiomeBaseInstance(BiomeHell.class);
            case THE_END:
                return new BiomeTheEnd();
            case FROZEN_OCEAN:
                return new BiomeFrozenOcean();
            case FROZEN_RIVER:
                return new BiomeFrozenRiver();
            case SNOWY_TUNDRA:
                return new BiomeIcePlains();
            case SNOWY_MOUNTAINS:
                return new BiomeIceMountains();
            case MUSHROOM_FIELDS:
                return new BiomeMushrooms();
            case MUSHROOM_FIELD_SHORE:
                return new BiomeMushroomIslandShore();
            case BEACH:
                return new BiomeBeach();
            case DESERT_HILLS:
                return new BiomeDesertHills();
            case WOODED_HILLS:
                return new BiomeForestHills();
            case TAIGA_HILLS:
                return new BiomeTaigaHills();
            case MOUNTAIN_EDGE:
                return getBiomeBaseInstance(BiomeExtremeHillsEdge.class);
            case JUNGLE:
                return new BiomeJungle();
            case JUNGLE_HILLS:
                return new BiomeJungleHills();
            case JUNGLE_EDGE:
                return new BiomeJungleEdge();
            case DEEP_OCEAN:
                return new BiomeDeepOcean();
            case STONE_SHORE:
                return new BiomeStoneBeach();
            case SNOWY_BEACH:
                return new BiomeColdBeach();
            case BIRCH_FOREST:
                return new BiomeBirchForest();
            case BIRCH_FOREST_HILLS:
                return new BiomeBirchForestHills();
            case DARK_FOREST:
                return new BiomeRoofedForest();
            case SNOWY_TAIGA:
                return new BiomeColdTaiga();
            case SNOWY_TAIGA_HILLS:
                return new BiomeColdTaigaHills();
            case GIANT_TREE_TAIGA:
                return new BiomeMegaTaiga();
            case GIANT_TREE_TAIGA_HILLS:
                return new BiomeMegaTaigaHills();
            case WOODED_MOUNTAINS:
                return getBiomeBaseInstance(BiomeExtremeHillsWithTrees.class);
            case SAVANNA:
                return getBiomeBaseInstance(BiomeSavanna.class);
            case SAVANNA_PLATEAU:
                return getBiomeBaseInstance(BiomeSavannaPlateau.class);
            case BADLANDS:
                return new BiomeMesa();
            case WOODED_BADLANDS_PLATEAU:
                return new BiomeMesaPlataeu();
            case BADLANDS_PLATEAU:
                return new BiomeMesaPlataeuClear();
            case SMALL_END_ISLANDS:
                return new BiomeTheEndFloatingIslands();
            case END_MIDLANDS:
                return new BiomeTheEndMediumIsland();
            case END_HIGHLANDS:
                return new BiomeTheEndHighIsland();
            case END_BARRENS:
                return new BiomeTheEndBarrenIsland();
            case WARM_OCEAN:
                return new BiomeWarmOcean();
            case LUKEWARM_OCEAN:
                return new BiomeLukewarmOcean();
            case COLD_OCEAN:
                return new BiomeColdOcean();
            case DEEP_WARM_OCEAN:
                return new BiomeWarmDeepOcean();
            case DEEP_LUKEWARM_OCEAN:
                return new BiomeLukewarmDeepOcean();
            case DEEP_COLD_OCEAN:
                return new BiomeColdDeepOcean();
            case DEEP_FROZEN_OCEAN:
                return new BiomeFrozenDeepOcean();
            case THE_VOID:
                return new BiomeVoid();
            case SUNFLOWER_PLAINS:
                return getBiomeBaseInstance(BiomeSunflowerPlains.class);
            case DESERT_LAKES:
                return new BiomeDesertMutated();
            case GRAVELLY_MOUNTAINS:
                return getBiomeBaseInstance(BiomeExtremeHillsMutated.class);
            case FLOWER_FOREST:
                return new BiomeFlowerForest();
            case TAIGA_MOUNTAINS:
                return new BiomeTaigaMutated();
            case SWAMP_HILLS:
                return getBiomeBaseInstance(BiomeSwamplandMutated.class);
            case ICE_SPIKES:
                return new BiomeIcePlainsSpikes();
            case MODIFIED_JUNGLE:
                return new BiomeJungleMutated();
            case MODIFIED_JUNGLE_EDGE:
                return new BiomeJungleEdgeMutated();
            case TALL_BIRCH_FOREST:
                return new BiomeBirchForestMutated();
            case TALL_BIRCH_HILLS:
                return new BiomeBirchForestHillsMutated();
            case DARK_FOREST_HILLS:
                return new BiomeBirchForestHillsMutated();
            case SNOWY_TAIGA_MOUNTAINS:
                return new BiomeColdTaigaMutated();
            case GIANT_SPRUCE_TAIGA:
                return new BiomeMegaSpruceTaiga();
            case GIANT_SPRUCE_TAIGA_HILLS:
                return new BiomeRedwoodTaigaHillsMutated();
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return getBiomeBaseInstance(BiomeExtremeHillsWithTreesMutated.class);
            case SHATTERED_SAVANNA:
                return new BiomeSavannaMutated();
            case SHATTERED_SAVANNA_PLATEAU:
                return new BiomeSavannaPlateauMutated();
            case ERODED_BADLANDS:
                return new BiomeMesaBryce();
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return new BiomeMesaPlateauMutated();
            case MODIFIED_BADLANDS_PLATEAU:
                return new BiomeMesaPlateauClearMutated();
            default:
                return getBiomeBase(Biome.PLAINS);
        }
    }

    private BiomeBase getBiomeBaseInstance(Class<? extends BiomeBase> biomeBaseClass) throws ReflectiveOperationException{
        Constructor<?> constructor = biomeBaseClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (BiomeBase) constructor.newInstance();
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
            case SMALL_END_ISLANDS:
                return "P";
            case END_MIDLANDS:
                return "Q";
            case END_HIGHLANDS:
                return "R";
            case END_BARRENS:
                return "S";
            case WARM_OCEAN:
                return "T";
            case LUKEWARM_OCEAN:
                return "U";
            case COLD_OCEAN:
                return "V";
            case DEEP_WARM_OCEAN:
                return "W";
            case DEEP_LUKEWARM_OCEAN:
                return "X";
            case DEEP_COLD_OCEAN:
                return "Y";
            case DEEP_FROZEN_OCEAN:
                return "Z";
            case THE_VOID:
                return "aa";
            case SUNFLOWER_PLAINS:
                return "ab";
            case DESERT_LAKES:
                return "ac";
            case GRAVELLY_MOUNTAINS:
                return "ad";
            case FLOWER_FOREST:
                return "ae";
            case TAIGA_MOUNTAINS:
                return "af";
            case SWAMP_HILLS:
                return "ag";
            case ICE_SPIKES:
                return "ah";
            case MODIFIED_JUNGLE:
                return "ai";
            case MODIFIED_JUNGLE_EDGE:
                return "aj";
            case TALL_BIRCH_FOREST:
                return "ak";
            case TALL_BIRCH_HILLS:
                return "al";
            case DARK_FOREST_HILLS:
                return "am";
            case SNOWY_TAIGA_MOUNTAINS:
                return "an";
            case GIANT_SPRUCE_TAIGA:
                return "ao";
            case GIANT_TREE_TAIGA_HILLS:
                return "ap";
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return "aq";
            case SHATTERED_SAVANNA:
                return "ar";
            case SHATTERED_SAVANNA_PLATEAU:
                return "as";
            case ERODED_BADLANDS:
                return "at";
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return "au";
            case MODIFIED_BADLANDS_PLATEAU:
                return "av";
            default:
                return null;
        }
    }

}
