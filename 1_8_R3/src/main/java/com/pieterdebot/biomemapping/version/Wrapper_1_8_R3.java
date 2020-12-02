package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.server.v1_8_R3.BiomeBase;

import java.lang.reflect.Field;

public class Wrapper_1_8_R3 implements VersionWrapper {

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception{
        Field biomesField = BiomeBase.class.getDeclaredField("biomes");
        biomesField.setAccessible(true);
        NMSUtils.removeFinal(biomesField);

        Field idField = BiomeBase.class.getDeclaredField("id");
        idField.setAccessible(true);

        BiomeBase[] biomes = (BiomeBase[]) biomesField.get(null);

        BiomeBase oldBiomeBase = getBiomeBase(oldBiome);
        BiomeBase newBiomeBase = getBiomeBase(newBiome);

        biomes[oldBiomeBase.id] = newBiomeBase;
        biomesField.set(null, biomes);
    }

    private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException{
        Field field = BiomeBase.class.getField(biome.name());
        field.setAccessible(true);
        return (BiomeBase) field.get(null);
    }

}
