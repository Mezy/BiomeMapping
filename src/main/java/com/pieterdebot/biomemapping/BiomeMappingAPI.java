package com.pieterdebot.biomemapping;

import com.pieterdebot.biomemapping.version.*;
import org.bukkit.Bukkit;

public class BiomeMappingAPI implements VersionWrapper{

    private static final String v1_8_R3 = "v1_8_R3";
    private static final String v1_15_R1 = "v1_15_R1";
    private static final String v1_16_R1 = "v1_16_R1";
    private static final String v1_16_R2 = "v1_16_R2";
    private static final String v1_16_R3 = "v1_16_R3";

    private final VersionWrapper wrapper;

    public BiomeMappingAPI(){
        wrapper = getWrapper();
    }

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
            case v1_15_R1:
                return new Wrapper_1_15_R1();
            case v1_16_R1:
                return new Wrapper_1_16_R1();
            case v1_16_R2:
                return new Wrapper_1_16_R2();
            case v1_16_R3:
                return new Wrapper_1_16_R3();
            default:
                System.out.println("No supported wrapper found!");
        }

        throw new RuntimeException("Version " + version + " is not supported!");
    }

}
