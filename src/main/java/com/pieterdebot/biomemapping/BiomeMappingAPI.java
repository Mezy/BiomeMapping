package com.pieterdebot.biomemapping;

import com.pieterdebot.biomemapping.version.*;
import org.bukkit.Bukkit;

public class BiomeMappingAPI implements VersionWrapper{

    private static final String v1_8_R3 = "v1_8_R3";
    private static final String v1_9_R1 = "v1_9_R1";
    private static final String v1_9_R2 = "v1_9_R2";
    private static final String v1_10_R1 = "v1_10_R1";
    private static final String v1_11_R1 = "v1_11_R1";
    private static final String v1_12_R1 = "v1_12_R1";
    private static final String v1_13_R1 = "v1_13_R1";
    private static final String v1_13_R2 = "v1_13_R2";
    private static final String v1_14_R1 = "v1_14_R1";
    private static final String v1_15_R1 = "v1_15_R1";
    private static final String v1_16_R1 = "v1_16_R1";
    private static final String v1_16_R2 = "v1_16_R2";
    private static final String v1_16_R3 = "v1_16_R3";

    private final VersionWrapper wrapper;

    public BiomeMappingAPI(){
        wrapper = getWrapper();
    }

    /**
     * Used to check if the biome is supported on the current server version.
     * @param biome Biome that is being checked.
     * @return Returns true when the biome is supported.
     */
    @Override
    public boolean biomeSupported(Biome biome) {
        return wrapper.biomeSupported(biome);
    }

    /**
     * Replaces two biome types. (This only works for newly generated chunks)
     * Make sure to always use {@link #biomeSupported(Biome)} first to make sure the biomes exist on the current version.
     * @param oldBiome The biome type that gets removed.
     * @param newBiome The biome type that gets added instead of the removed biome.
     * @throws Exception Thrown when an error occurs during the changing of biomes.
     */
    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{
        wrapper.replaceBiomes(oldBiome, newBiome);
    }

    private VersionWrapper getWrapper(){
        String name = Bukkit.getServer().getClass().getPackage().getName();
        String version = name.substring(name.lastIndexOf(46) + 1);

        switch (version){
            case v1_8_R3:
                return new Wrapper_1_8_R3();
            case v1_9_R1:
                return new Wrapper_1_9_R1();
            case v1_9_R2:
                return new Wrapper_1_9_R2();
            case v1_10_R1:
                return new Wrapper_1_10_R1();
            case v1_11_R1:
                return new Wrapper_1_11_R1();
            case v1_12_R1:
                return new Wrapper_1_12_R1();
            case v1_13_R1:
                return new Wrapper_1_13_R1();
            case v1_13_R2:
                return new Wrapper_1_13_R2();
            case v1_14_R1:
                return new Wrapper_1_14_R1();
            case v1_15_R1:
                return new Wrapper_1_15_R1();
            case v1_16_R1:
                return new Wrapper_1_16_R1();
            case v1_16_R2:
                return new Wrapper_1_16_R2();
            case v1_16_R3:
                return new Wrapper_1_16_R3();
        }

        throw new RuntimeException("Version " + version + " is not supported!");
    }

}
