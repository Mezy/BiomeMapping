package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_16_R1.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class Wrapper_1_16_R1 implements VersionWrapper {

    private static final Biome[] HASH_SET_BIOMES = new Biome[]{Biome.OCEAN, Biome.PLAINS, Biome.DESERT, Biome.MOUNTAINS, Biome.FOREST, Biome.TAIGA, Biome.SWAMP, Biome.RIVER, Biome.FROZEN_RIVER, Biome.SNOWY_TUNDRA, Biome.SNOWY_MOUNTAINS, Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE, Biome.BEACH, Biome.DESERT_HILLS, Biome.WOODED_HILLS, Biome.TAIGA_HILLS, Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.DEEP_OCEAN, Biome.STONE_SHORE, Biome.SNOWY_BEACH, Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.DARK_FOREST, Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.WOODED_MOUNTAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.BADLANDS, Biome.WOODED_BADLANDS_PLATEAU, Biome.BADLANDS_PLATEAU};

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
        Method registerMethod = NMSUtils.getMethod(Biomes.class, "a");

        Field biomeBaseHashSet = BiomeBase.class.getField("c");
        NMSUtils.removeFinal(biomeBaseHashSet);

        // Biome field to change
        Field oldBiomeField = getField(oldBiome);

        // New registered BiomeBase
        Object newBiomeBase = registerMethod.invoke(null, oldBiome.getId(), oldBiome.name().toLowerCase(), getBiomeBase(newBiome));

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
            case BAMBOO_JUNGLE:
                return new BiomeBambooJungle();
            case BAMBOO_JUNGLE_HILLS:
                return new BiomeBambooJungleHills();
            case SOUL_SAND_VALLEY:
                return getBiomeBaseInstance(BiomeSoulSandValley.class);
            case CRIMSON_FOREST:
                return getBiomeBaseInstance(BiomeCrimsonForest.class);
            case WARPED_FOREST:
                return getBiomeBaseInstance(BiomeWarpedForest.class);
            case BASALT_DELTAS:
                return getBiomeBaseInstance(BiomeBasaltDeltas.class);
            default:
                return getBiomeBase(Biome.PLAINS);
        }
    }

    private BiomeBase getBiomeBaseInstance(Class<? extends BiomeBase> biomeBaseClass) throws ReflectiveOperationException{
        Constructor<?> constructor = biomeBaseClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (BiomeBase) constructor.newInstance();
    }

}
