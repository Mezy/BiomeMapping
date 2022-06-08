package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;
import net.minecraft.data.RegistryGeneration;
import net.minecraft.data.worldgen.biome.EndBiomes;
import net.minecraft.data.worldgen.biome.NetherBiomes;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.Biomes;

public class Wrapper_1_19_R1 implements VersionWrapper {

    @Override
    public boolean biomeSupported(Biome biome) {
        return getResourceKey(biome) != null;
    }

    @Override
    public void replaceBiomes(Biome oldBiome, Biome newBiome) {
        ResourceKey<BiomeBase> newBiomeResourceKey = getResourceKey(newBiome);
        RegistryGeneration.a(RegistryGeneration.j, newBiomeResourceKey, getBiomeBase(newBiome));
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
            case MANGROVE_SWAMP:
                return Biomes.h;
            case FOREST:
                return Biomes.i;
            case FLOWER_FOREST:
                return Biomes.j;
            case BIRCH_FOREST:
                return Biomes.k;
            case DARK_FOREST:
                return Biomes.l;
            case TALL_BIRCH_FOREST:
                return Biomes.m;
            case GIANT_TREE_TAIGA:
                return Biomes.n;
            case GIANT_SPRUCE_TAIGA:
                return Biomes.o;
            case TAIGA:
                return Biomes.p;
            case SNOWY_TAIGA:
                return Biomes.q;
            case SAVANNA:
                return Biomes.r;
            case SAVANNA_PLATEAU:
                return Biomes.s;
            case MOUNTAINS:
                return Biomes.t;
            case GRAVELLY_MOUNTAINS:
                return Biomes.u;
            case WOODED_MOUNTAINS:
                return Biomes.v;
            case SHATTERED_SAVANNA:
                return Biomes.w;
            case JUNGLE:
                return Biomes.x;
            case JUNGLE_EDGE:
                return Biomes.y;
            case BAMBOO_JUNGLE:
                return Biomes.z;
            case BADLANDS:
                return Biomes.A;
            case ERODED_BADLANDS:
                return Biomes.B;
            case WOODED_BADLANDS_PLATEAU:
                return Biomes.C;
            case MEADOW:
                return Biomes.D;
            case GROVE:
                return Biomes.E;
            case SNOWY_SLOPES:
                return Biomes.F;
            case FROZEN_PEAKS:
                return Biomes.G;
            case JAGGED_PEAKS:
                return Biomes.H;
            case STORY_PEAKS:
                return Biomes.I;
            case RIVER:
                return Biomes.J;
            case FROZEN_RIVER:
                return Biomes.K;
            case BEACH:
                return Biomes.L;
            case SNOWY_BEACH:
                return Biomes.M;
            case STONE_SHORE:
                return Biomes.N;
            case WARM_OCEAN:
                return Biomes.O;
            case LUKEWARM_OCEAN:
                return Biomes.P;
            case DEEP_LUKEWARM_OCEAN:
                return Biomes.Q;
            case OCEAN:
                return Biomes.R;
            case DEEP_OCEAN:
                return Biomes.S;
            case COLD_OCEAN:
                return Biomes.T;
            case DEEP_COLD_OCEAN:
                return Biomes.U;
            case FROZEN_OCEAN:
                return Biomes.V;
            case DEEP_FROZEN_OCEAN:
                return Biomes.W;
            case MUSHROOM_FIELDS:
                return Biomes.X;
            case DRIPSTONE_CAVES:
                return Biomes.Y;
            case LUSH_CAVES:
                return Biomes.Z;
            case ANCIENT_CITIES:
                return Biomes.aa;
            case NETHER_WASTES:
                return Biomes.ab;
            case WARPED_FOREST:
                return Biomes.ac;
            case CRIMSON_FOREST:
                return Biomes.ad;
            case SOUL_SAND_VALLEY:
                return Biomes.ae;
            case BASALT_DELTAS:
                return Biomes.af;
            case THE_END:
                return Biomes.ag;
            case END_HIGHLANDS:
                return Biomes.ah;
            case END_MIDLANDS:
                return Biomes.ai;
            case SMALL_END_ISLANDS:
                return Biomes.aj;
            case END_BARRENS:
                return Biomes.ak;
        }

        return null;
    }

    private BiomeBase getBiomeBase(Biome biome) {
        switch (biome){
            case THE_VOID:
                return OverworldBiomes.j();
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
            case MANGROVE_SWAMP:
                return OverworldBiomes.i();
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
                return OverworldBiomes.k();
            case GROVE:
                return OverworldBiomes.p();
            case SNOWY_SLOPES:
                return OverworldBiomes.o();
            case FROZEN_PEAKS:
                return OverworldBiomes.l();
            case JAGGED_PEAKS:
                return OverworldBiomes.m();
            case STORY_PEAKS:
                return OverworldBiomes.n();
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
                return OverworldBiomes.r();
            case LUSH_CAVES:
                return OverworldBiomes.q();
            case ANCIENT_CITIES:
                return OverworldBiomes.s();
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
