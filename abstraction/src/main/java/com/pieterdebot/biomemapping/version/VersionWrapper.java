package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;

public interface VersionWrapper {

    boolean biomeSupported(Biome biome);
    void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception;

}
