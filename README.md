# BiomeMapping ![Build Status](https://github.com/Mezy/BiomeMapping/workflows/Java%20CI%20with%20Gradle/badge.svg)
Use this library to replace biomes on newly generated worlds.

This project was made as there is no way to change biome generation through the Spigot / Bukkit API. It requires interaction with NMS and that is a pain in plugins where users have different versions of the server running.

## Requirements
Java 8 and Bukkit / Spigot. Most server versions in the [Spigot Repository](https://hub.spigotmc.org/nexus/) are supported.

### My version isn't supported
If you are a developer, submit a pull request adding a wrapper module for your version. Otherwise, please create an issue
on the issues tab. 

## Usage

### As a dependency

AnvilGUI requires the usage of Maven or a Maven compatible build system. 
```xml
<dependency>
    <groupId>com.github.Mezy</groupId>
    <artifactId>BiomeMapping</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

### In your plugin

The `BiomeMappingAPI` class is how you use the library.
Simply make a new instance of that class and use the methods shown below.

#### `replaceBiomes(Biome biomeA, Biome biomeB)` 
Takes two `Biome` enum arguments, and replaces the first with the second.
```java                                         
BiomeMappingAPI api = new BiomeMappingAPI();
api.replaceBiomes(Biome.OCEAN, Biome.FOREST);                                                
``` 

#### `biomeSupported(Biome biome)`  
Takes a `Biome` enum argument and returns true if the biome is supported on the current minecraft version.           
```java                                                
BiomeMappingAPI api = new BiomeMappingAPI();
if (api.biomeSupported(Biome.SOUL_SAND_VALLEY)){
    // This server version supports the SOUL_SAND_VALLEY biome.
}                                                    
```                                                                                                                                                                                                                                                                                                       

## License
This project is licensed under the [GNU GENERAL PUBLIC LICENSE](LICENSE).

## Copyright Notice
Project structure and documentation partially taken from:
https://github.com/WesJD/AnvilGUI