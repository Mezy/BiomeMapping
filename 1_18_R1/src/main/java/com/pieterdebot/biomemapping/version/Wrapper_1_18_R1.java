package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import com.pieterdebot.biomemapping.utils.NMSUtils;
import net.minecraft.data.worldgen.biome.BiomeRegistry;
import net.minecraft.data.worldgen.biome.EndBiomes;
import net.minecraft.data.worldgen.biome.NetherBiomes;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.Biomes;

import java.lang.reflect.Method;

public class Wrapper_1_18_R1 implements VersionWrapper {

    @Override
    public boolean biomeSupported(Biome biome) {
        return getResourceKey(biome) != null;
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
        ResourceKey<BiomeBase> newBiomeResourceKey = getResourceKey(newBiome);

        Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 2);
        registerMethod.invoke(null, newBiomeResourceKey, getBiomeBase(newBiome));
    }

    private ResourceKey<BiomeBase> getResourceKey(Biome biome) {
        switch (biome) {
            case THE_VOID:
                return Biomes.a;
            case PLAINS:
                return Biomes.b;
            case SUNFLOWER_PLAINS:
                return Biomes.c;
            case SNOWY_TUNDRA:
                return Biomes.d;
            case ICE_SPIKES:
                return Biomes.e;
            case DESERT:
                return Biomes.f;
            case SWAMP:
                return Biomes.g;
            case FOREST:
                return Biomes.h;
            case FLOWER_FOREST:
                return Biomes.i;
            case BIRCH_FOREST:
                return Biomes.j;
            case DARK_FOREST:
                return Biomes.k;
            case TALL_BIRCH_FOREST:
                return Biomes.l;
            case GIANT_TREE_TAIGA:
                return Biomes.m;
            case GIANT_SPRUCE_TAIGA:
                return Biomes.n;
            case TAIGA:
                return Biomes.o;
            case SNOWY_TAIGA:
                return Biomes.p;
            case SAVANNA:
                return Biomes.q;
            case SAVANNA_PLATEAU:
                return Biomes.r;
            case MOUNTAINS:
                return Biomes.s;
            case GRAVELLY_MOUNTAINS:
                return Biomes.t;
            case WOODED_MOUNTAINS:
                return Biomes.u;
            case SHATTERED_SAVANNA:
                return Biomes.v;
            case JUNGLE:
                return Biomes.w;
            case JUNGLE_EDGE:
                return Biomes.x;
            case BAMBOO_JUNGLE:
                return Biomes.y;
            case BADLANDS:
                return Biomes.z;
            case ERODED_BADLANDS:
                return Biomes.A;
            case WOODED_BADLANDS_PLATEAU:
                return Biomes.B;
            case MEADOW:
                return Biomes.C;
            case GROVE:
                return Biomes.D;
            case SNOWY_SLOPES:
                return Biomes.E;
            case FROZEN_PEAKS:
                return Biomes.F;
            case JAGGED_PEAKS:
                return Biomes.G;
            case STORY_PEAKS:
                return Biomes.H;
            case RIVER:
                return Biomes.I;
            case FROZEN_RIVER:
                return Biomes.J;
            case BEACH:
                return Biomes.K;
            case SNOWY_BEACH:
                return Biomes.L;
            case STONE_SHORE:
                return Biomes.M;
            case WARM_OCEAN:
                return Biomes.N;
            case LUKEWARM_OCEAN:
                return Biomes.O;
            case DEEP_LUKEWARM_OCEAN:
                return Biomes.P;
            case OCEAN:
                return Biomes.Q;
            case DEEP_OCEAN:
                return Biomes.R;
            case COLD_OCEAN:
                return Biomes.S;
            case DEEP_COLD_OCEAN:
                return Biomes.T;
            case FROZEN_OCEAN:
                return Biomes.U;
            case DEEP_FROZEN_OCEAN:
                return Biomes.V;
            case MUSHROOM_FIELDS:
                return Biomes.W;
            case DRIPSTONE_CAVES:
                return Biomes.X;
            case LUSH_CAVES:
                return Biomes.Y;
            case NETHER_WASTES:
                return Biomes.Z;
            case WARPED_FOREST:
                return Biomes.aa;
            case CRIMSON_FOREST:
                return Biomes.ab;
            case SOUL_SAND_VALLEY:
                return Biomes.ac;
            case BASALT_DELTAS:
                return Biomes.ad;
            case THE_END:
                return Biomes.ae;
            case END_HIGHLANDS:
                return Biomes.af;
            case END_MIDLANDS:
                return Biomes.ag;
            case SMALL_END_ISLANDS:
                return Biomes.ah;
            case END_BARRENS:
                return Biomes.ai;
        }

        return null;
    }

    private BiomeBase getBiomeBase(Biome biome) {
        switch (biome){
            case THE_VOID:
                return OverworldBiomes.i();
            case PLAINS:
                return OverworldBiomes.a(false, false, false);
            case SUNFLOWER_PLAINS:
                return OverworldBiomes.a(true, false, false);
            case SNOWY_TUNDRA:
                return OverworldBiomes.a(false, true, false);
            case ICE_SPIKES:
                return OverworldBiomes.a(false, true, true);
            case DESERT:
                return OverworldBiomes.d();
            case SWAMP:
                return OverworldBiomes.h();
            case FOREST:
                return OverworldBiomes.b(false, false, false);
            case FLOWER_FOREST:
                return OverworldBiomes.b(false, false, true);
            case BIRCH_FOREST:
                return OverworldBiomes.b(true, false, false);
            case DARK_FOREST:
                return OverworldBiomes.g();
            case TALL_BIRCH_FOREST:
                return OverworldBiomes.b(true, true, false);
            case GIANT_TREE_TAIGA:
                return OverworldBiomes.a(false);
            case GIANT_SPRUCE_TAIGA:
                return OverworldBiomes.a(true);
            case TAIGA:
                return OverworldBiomes.h(false);
            case SNOWY_TAIGA:
                return OverworldBiomes.h(true);
            case SAVANNA:
                return OverworldBiomes.a(false, false);
            case SAVANNA_PLATEAU:
                return OverworldBiomes.a(false, true);
            case MOUNTAINS:
                return OverworldBiomes.b(false);
            case GRAVELLY_MOUNTAINS:
                return OverworldBiomes.b(false);
            case WOODED_MOUNTAINS:
                return OverworldBiomes.b(true);
            case SHATTERED_SAVANNA:
                return OverworldBiomes.a(true, false);
            case JUNGLE:
                return OverworldBiomes.b();
            case JUNGLE_EDGE:
                return OverworldBiomes.a();
            case BAMBOO_JUNGLE:
                return OverworldBiomes.c();
            case BADLANDS:
                return OverworldBiomes.c(false);
            case ERODED_BADLANDS:
                return OverworldBiomes.c(false);
            case WOODED_BADLANDS_PLATEAU:
                return OverworldBiomes.c(true);
            case MEADOW:
                return OverworldBiomes.j();
            case GROVE:
                return OverworldBiomes.o();
            case SNOWY_SLOPES:
                return OverworldBiomes.n();
            case FROZEN_PEAKS:
                return OverworldBiomes.k();
            case JAGGED_PEAKS:
                return OverworldBiomes.l();
            case STORY_PEAKS:
                return OverworldBiomes.m();
            case RIVER:
                return OverworldBiomes.i(false);
            case FROZEN_RIVER:
                return OverworldBiomes.i(true);
            case BEACH:
                return OverworldBiomes.b(false, false);
            case SNOWY_BEACH:
                return OverworldBiomes.b(true, false);
            case STONE_SHORE:
                return OverworldBiomes.b(false, true);
            case WARM_OCEAN:
                return OverworldBiomes.f();
            case LUKEWARM_OCEAN:
                return OverworldBiomes.f(false);
            case DEEP_LUKEWARM_OCEAN:
                return OverworldBiomes.f(true);
            case OCEAN:
                return OverworldBiomes.e(false);
            case DEEP_OCEAN:
                return OverworldBiomes.e(true);
            case COLD_OCEAN:
                return OverworldBiomes.d(false);
            case DEEP_COLD_OCEAN:
                return OverworldBiomes.g(false);
            case FROZEN_OCEAN:
                return OverworldBiomes.d(true);
            case DEEP_FROZEN_OCEAN:
                return OverworldBiomes.g(true);
            case MUSHROOM_FIELDS:
                return OverworldBiomes.e();
            case DRIPSTONE_CAVES:
                return OverworldBiomes.q();
            case LUSH_CAVES:
                return OverworldBiomes.p();
            case NETHER_WASTES:
                return NetherBiomes.a();
            case WARPED_FOREST:
                return NetherBiomes.e();
            case CRIMSON_FOREST:
                return NetherBiomes.d();
            case SOUL_SAND_VALLEY:
                return NetherBiomes.b();
            case BASALT_DELTAS:
                return NetherBiomes.c();
            case THE_END:
                return EndBiomes.b();
            case END_HIGHLANDS:
                return EndBiomes.d();
            case END_MIDLANDS:
                return EndBiomes.c();
            case SMALL_END_ISLANDS:
                return EndBiomes.e();
            case END_BARRENS:
                return EndBiomes.a();
            default:
                return getBiomeBase(Biome.PLAINS);
        }
    }

}
