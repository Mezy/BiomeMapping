package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import net.minecraft.server.v1_8_R3.BiomeBase;

import java.lang.reflect.Field;

public class Wrapper_1_8_R3 implements VersionWrapper {

    @Override
    public boolean biomeSupported(Biome biome) {
        try {
            getBiomeBase(biome);
            return true;
        }catch (ReflectiveOperationException ex){
            return false;
        }
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
        BiomeBase[] biomes = BiomeBase.getBiomes();

        BiomeBase newBiomeBase = getBiomeBase(newBiome);

        biomes[oldBiome.getId()] = newBiomeBase;
    }

    private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException{
        Field field = BiomeBase.class.getField(biome.getOldName());
        field.setAccessible(true);
        return (BiomeBase) field.get(null);
    }

}
