package com.pieterdebot.biomemapping;

public enum Biome {
    OCEAN,
    PLAINS,
    DESERT,
    MOUNTAINS,
    FOREST,
    TAIGA,
    SWAMP,
    RIVER,
    NETHER_WASTES,
    NETHER,
    THE_END,
    FROZEN_OCEAN,
    FROZEN_RIVER,
    SNOWY_TUNDRA,
    SNOWY_MOUNTAINS,
    MUSHROOM_FIELDS,
    MUSHROOM_FIELD_SHORE,
    BEACH,
    DESERT_HILLS,
    WOODED_HILLS,
    TAIGA_HILLS,
    MOUNTAIN_EDGE,
    JUNGLE,
    JUNGLE_HILLS,
    JUNGLE_EDGE,
    DEEP_OCEAN,
    STONE_SHORE,
    SNOWY_BEACH,
    BIRCH_FOREST,
    BIRCH_FOREST_HILLS,
    DARK_FOREST,
    SNOWY_TAIGA,
    SNOWY_TAIGA_HILLS,
    GIANT_TREE_TAIGA,
    GIANT_TREE_TAIGA_HILLS,
    WOODED_MOUNTAINS,
    SAVANNA,
    SAVANNA_PLATEAU,
    BADLANDS,
    WOODED_BADLANDS_PLATEAU,
    BADLANDS_PLATEAU,
    SMALL_END_ISLANDS,
    END_MIDLANDS,
    END_HIGHLANDS,
    END_BARRENS,
    WARM_OCEAN,
    LUKEWARM_OCEAN,
    COLD_OCEAN,
    DEEP_WARM_OCEAN,
    DEEP_LUKEWARM_OCEAN,
    DEEP_COLD_OCEAN,
    DEEP_FROZEN_OCEAN,
    THE_VOID,
    SUNFLOWER_PLAINS,
    DESERT_LAKES,
    GRAVELLY_MOUNTAINS,
    FLOWER_FOREST,
    TAIGA_MOUNTAINS,
    SWAMP_HILLS,
    ICE_SPIKES,
    MODIFIED_JUNGLE,
    MODIFIED_JUNGLE_EDGE,
    TALL_BIRCH_FOREST,
    TALL_BIRCH_HILLS,
    DARK_FOREST_HILLS,
    SNOWY_TAIGA_MOUNTAINS,
    GIANT_SPRUCE_TAIGA,
    GIANT_SPRUCE_TAIGA_HILLS,
    MODIFIED_GRAVELLY_MOUNTAINS,
    SHATTERED_SAVANNA,
    SHATTERED_SAVANNA_PLATEAU,
    ERODED_BADLANDS,
    MODIFIED_WOODED_BADLANDS_PLATEAU,
    MODIFIED_BADLANDS_PLATEAU,
    BAMBOO_JUNGLE,
    BAMBOO_JUNGLE_HILLS,
    SOUL_SAND_VALLEY,
    CRIMSON_FOREST,
    WARPED_FOREST,
    BASALT_DELTAS;

    /**
     * Used to check if the biome is a ocean type.
     * @return Returns true when the biome is ocean
     */
    public boolean isOcean(){
        switch (this){
            case OCEAN:
            case COLD_OCEAN:
            case DEEP_COLD_OCEAN:
            case DEEP_FROZEN_OCEAN:
            case DEEP_LUKEWARM_OCEAN:
            case DEEP_OCEAN:
            case DEEP_WARM_OCEAN:
            case FROZEN_OCEAN:
            case LUKEWARM_OCEAN:
            case WARM_OCEAN:
                return true;
            default:
                return false;
        }
    }

    /**
     * Used to check if the biome is a jungle type.
     * @return Returns true when the biome is jungle
     */
    public boolean isJungle(){
        switch (this){
            case JUNGLE:
            case JUNGLE_EDGE:
            case JUNGLE_HILLS:
            case BAMBOO_JUNGLE:
            case BAMBOO_JUNGLE_HILLS:
            case MODIFIED_JUNGLE:
            case MODIFIED_JUNGLE_EDGE:
                return true;
            default:
                return false;
        }
    }

    /**
     * Used to check if the biome is a nether type.
     * @return Returns true when the biome is nether
     */
    public boolean isNether(){
        switch (this){
            case NETHER:
            case NETHER_WASTES:
            case SOUL_SAND_VALLEY:
            case CRIMSON_FOREST:
            case WARPED_FOREST:
            case BASALT_DELTAS:
                return true;
            default:
                return false;
        }
    }

    /**
     * Used to check if the biome is a "the end" type.
     * @return Returns true when the biome is "the end"
     */
    public boolean isTheEnd(){
        switch (this){
            case END_BARRENS:
            case END_HIGHLANDS:
            case END_MIDLANDS:
            case THE_END:
            case SMALL_END_ISLANDS:
                return true;
            default:
                return false;
        }
    }

}
