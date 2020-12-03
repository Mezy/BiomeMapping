package com.pieterdebot.biomemapping;

public enum Biome {
    OCEAN(0),
    PLAINS(1),
    DESERT(2),
    MOUNTAINS(3, "EXTREME_HILLS"),
    FOREST(4),
    TAIGA(5),
    SWAMP(6, "SWAMPLAND"),
    RIVER(7),
    NETHER_WASTES(8, "HELL"),
    THE_END(9, "SKY"),
    FROZEN_OCEAN(10),
    FROZEN_RIVER(11),
    SNOWY_TUNDRA(12, "ICE_PLAINS"),
    SNOWY_MOUNTAINS(13, "ICE_MOUNTAINS"),
    MUSHROOM_FIELDS(14, "MUSHROOM_ISLAND"),
    MUSHROOM_FIELD_SHORE(15, "MUSHROOM_SHORE"),
    BEACH(16),
    DESERT_HILLS(17),
    WOODED_HILLS(18, "FOREST_HILLS"),
    TAIGA_HILLS(19, "TAIGA_HILLS"),
    MOUNTAIN_EDGE(20, "SMALL_MOUNTAINS"),
    JUNGLE(21),
    JUNGLE_HILLS(22),
    JUNGLE_EDGE(23),
    DEEP_OCEAN(24),
    STONE_SHORE(25, "STONE_BEACH"),
    SNOWY_BEACH(26, "COLD_BEACH"),
    BIRCH_FOREST(27),
    BIRCH_FOREST_HILLS(28),
    DARK_FOREST(29, "ROOFED_FOREST"),
    SNOWY_TAIGA(30, "COLD_TAIGA"),
    SNOWY_TAIGA_HILLS(31, "COLD_TAIGA_HILLS"),
    GIANT_TREE_TAIGA(32, "MEGA_TAIGA"),
    GIANT_TREE_TAIGA_HILLS(33, "MEGA_TAIGA_HILLS"),
    WOODED_MOUNTAINS(34, "EXTREME_HILLS_PLUS"),
    SAVANNA(35),
    SAVANNA_PLATEAU(36),
    BADLANDS(37, "MESA"),
    WOODED_BADLANDS_PLATEAU(38, "MESA_PLATEAU_F"),
    BADLANDS_PLATEAU(39, "MESA_PLATEAU"),
    SMALL_END_ISLANDS(40),
    END_MIDLANDS(41),
    END_HIGHLANDS(42),
    END_BARRENS(43),
    WARM_OCEAN(44),
    LUKEWARM_OCEAN(45),
    COLD_OCEAN(46),
    DEEP_WARM_OCEAN(47),
    DEEP_LUKEWARM_OCEAN(48),
    DEEP_COLD_OCEAN(49),
    DEEP_FROZEN_OCEAN(50),
    THE_VOID(127),
    SUNFLOWER_PLAINS(129),
    DESERT_LAKES(130),
    GRAVELLY_MOUNTAINS(131),
    FLOWER_FOREST(132),
    TAIGA_MOUNTAINS(133),
    SWAMP_HILLS(134),
    ICE_SPIKES(140),
    MODIFIED_JUNGLE(149),
    MODIFIED_JUNGLE_EDGE(151),
    TALL_BIRCH_FOREST(155),
    TALL_BIRCH_HILLS(156),
    DARK_FOREST_HILLS(157),
    SNOWY_TAIGA_MOUNTAINS(158),
    GIANT_SPRUCE_TAIGA(160),
    GIANT_SPRUCE_TAIGA_HILLS(161),
    MODIFIED_GRAVELLY_MOUNTAINS(162),
    SHATTERED_SAVANNA(163),
    SHATTERED_SAVANNA_PLATEAU(164),
    ERODED_BADLANDS(165),
    MODIFIED_WOODED_BADLANDS_PLATEAU(166),
    MODIFIED_BADLANDS_PLATEAU(167),
    BAMBOO_JUNGLE(168),
    BAMBOO_JUNGLE_HILLS(169),
    SOUL_SAND_VALLEY(170),
    CRIMSON_FOREST(171),
    WARPED_FOREST(172),
    BASALT_DELTAS(173);

    private final int id;
    private final String oldName;

    Biome(int id, String oldName){
        this.id = id;
        this.oldName = oldName;
    }

    Biome(int id){
        this.id = id;
        oldName = name();
    }

    public int getId() {
        return id;
    }

    public String getOldName() {
        return oldName;
    }

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
