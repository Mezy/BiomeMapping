package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_15_R1.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class Wrapper_1_15_R1 implements VersionWrapper {

    private static final Biome[] HASH_SET_BIOMES = new Biome[]{Biome.OCEAN, Biome.PLAINS, Biome.DESERT, Biome.MOUNTAINS, Biome.FOREST, Biome.TAIGA, Biome.SWAMP, Biome.RIVER, Biome.FROZEN_RIVER, Biome.SNOWY_TUNDRA, Biome.SNOWY_MOUNTAINS, Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE, Biome.BEACH, Biome.DESERT_HILLS, Biome.WOODED_HILLS, Biome.TAIGA_HILLS, Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.DEEP_OCEAN, Biome.STONE_SHORE, Biome.SNOWY_BEACH, Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.DARK_FOREST, Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.WOODED_MOUNTAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.BADLANDS, Biome.WOODED_BADLANDS_PLATEAU, Biome.BADLANDS_PLATEAU};

    @Override
    public boolean biomeSupported(Biome biome) {
        return getBiomeId(biome) != -1;
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{

        Method registerMethod = NMSUtils.getMethod(Biomes.class, "a");

        Field biomeBaseHashSet = BiomeBase.class.getField("b");
        NMSUtils.removeFinal(biomeBaseHashSet);

        // Biome field to change
        Field oldBiomeField = getField(oldBiome);

        // New registered BiomeBase
        Object newBiomeBase = registerMethod.invoke(null, getBiomeId(oldBiome), oldBiome.name().toLowerCase(), getBiomeBase(newBiome));

        oldBiomeField.set(null, newBiomeBase);

        Set<Object> hashSet = (Set<Object>) biomeBaseHashSet.get(null);
        hashSet.clear();
        for (Biome biome : HASH_SET_BIOMES){
            hashSet.add(getField(biome).get(null));
        }

        biomeBaseHashSet.set(null, hashSet);
    }

    private Field getField(Biome biome) throws ReflectiveOperationException{
        Field field = Biomes.class.getField(biome.name());
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
            case NETHER:
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
            case BAMBOO_JUNGLE:
                return new BiomeBambooJungle();
            case BAMBOO_JUNGLE_HILLS:
                return new BiomeBambooJungleHills();
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
            case NETHER:
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
                return 129;
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
                return 156;
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
            default:
                return -1;
        }
    }

    private BiomeBase getBiomeBaseInstance(Class<? extends BiomeBase> biomeBaseClass) throws ReflectiveOperationException{
        Constructor<?> constructor = biomeBaseClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (BiomeBase) constructor.newInstance();
    }

}
