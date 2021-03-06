package com.github.anthonywww.mcbot.world.block;

import static com.github.anthonywww.mcbot.world.block.BlockType.Flags.*;
import static com.github.anthonywww.mcbot.world.item.ItemGroup.*;
import com.github.anthonywww.mcbot.world.item.ItemGroup;

/**
 * Block registry
 */
public enum BlockType {

	UNDEFINED(-1, 0),
	
	AIR(0, 0, INDESTRUCTABLE),
	STONE(1, 0, PICKAXE),
	GRANITE(1, 1, PICKAXE),
	POLISHED_GRANITE(1, 2, PICKAXE),
	DIORITE(1, 3, PICKAXE),
	POLISHED_DIORITE(1, 4, PICKAXE),
	ANDESITE(1, 5, PICKAXE),
	POLISHED_ANDESITE(1, 6, PICKAXE),
	GRASS_BLOCK(2, 0, SHOVEL),
	DIRT(3, 0, SHOVEL),
	COARSE_DIRT(3, 1, SHOVEL),
	PODZOL(3, 2, SHOVEL),
	COBBLESTONE(4, 0, PICKAXE),
	OAK_PLANKS(5, 0, AXE),
	SPRUCE_PLANKS(5, 1, AXE,PLACEABLE),
	BIRCH_PLANKS(5, 2, AXE, PLACEABLE),
	JUNGLE_PLANKS(5, 3, AXE, PLACEABLE),
	ACACIA_PLANKS(5, 4, AXE,PLACEABLE),
	DARK_OAK_PLANKS(5, 5, AXE),
	OAK_SAPLING(6, 0, PLACEABLE | INTERACTABLE),
	SPRUCE_SAPLING(6, 1, PLACEABLE | INTERACTABLE),
	BIRCH_SAPLING(6, 2, PLACEABLE | INTERACTABLE),
	JUNGLE_SAPLING(6, 3, PLACEABLE | INTERACTABLE),
	ACACIA_SAPLING(6, 4, PLACEABLE | INTERACTABLE),
	DARK_OAK_SAPLING(6, 5, PLACEABLE | INTERACTABLE),
	BEDROCK(7, 0, SOLID | PLACEABLE | INDESTRUCTABLE), // Adminium, Bedrock
	FLOWING_WATER(8, 0, PLACEABLE | INDESTRUCTABLE),
	WATER(9, 0, PLACEABLE | INDESTRUCTABLE),
	FLOWING_LAVA(10, 0, PLACEABLE | INDESTRUCTABLE),
	LAVA(11, 0, PLACEABLE | INDESTRUCTABLE),
	SAND(12, 0, SHOVEL, SOLID | GRAVITY | PLACEABLE),
	RED_SAND(12, 1, SHOVEL, SOLID | PLACEABLE | GRAVITY),
	GRAVEL(13, 0, SHOVEL, SOLID | PLACEABLE | GRAVITY),
	GOLD_ORE(14, 0, PICKAXE),
	IRON_ORE(15, 0, PICKAXE),
	COAL_ORE(16, 0, PICKAXE),
	OAK_LOG(17, 0, AXE),
	SPRUCE_LOG(17, 1, AXE),
	BIRCH_LOG(17, 2, AXE),
	JUNGLE_LOG(17, 3, AXE),
	OAK_LEAVES(18, 0, SHEARS),
	SPRUCE_LEAVES(18, 1, SHEARS),
	BIRCH_LEAVES(18, 2, SHEARS),
	JUNGLE_LEAVES(18, 3, SHEARS),
	SPONGE(19, 0, SHEARS),
	WET_SPONGE(19, 1, SHEARS),
	GLASS(20, 0, SWORD),
	LAPIS_ORE(21, 0, PICKAXE),
	LAPIS_BLOCK(22, 0, PICKAXE),
	DISPENSER(23, 0, PICKAXE),
	SANDSTONE(24, 0, PICKAXE),
	CHISELED_SANDSTONE(24, 1, PICKAXE),
	CUT_SANDSTONE(24, 2, PICKAXE),
	NOTE_BLOCK(25, 0, AXE),
	BED(26, 0, AXE),
	POWERED_RAIL(27, 0, PICKAXE),
	DETECTOR_RAIL(28, 0, PICKAXE),
	STICKY_PISTON(29, 0, PICKAXE),
	COBWEB(30, 0, SWORD),
	DEAD_SHRUB(31, 0, PLACEABLE),
	GRASS(31, 1, PLACEABLE),
	FERN(31, 2, PLACEABLE),
	DEAD_BUSH(32, 0, PLACEABLE),
	PISTON(33, 0, PICKAXE),
	PISTON_HEAD(34, 0, PICKAXE),
	WHITE_WOOL(35, 0, SHEARS),
	ORANGE_WOOL(35, 1, SHEARS),
	MAGENTA_WOOL(35, 2, SHEARS),
	LIGHT_BLUE_WOOL(35, 3, SHEARS),
	YELLOW_WOOL(35, 4, SHEARS),
	LIME_WOOL(35, 5, SHEARS),
	PINK_WOOL(35, 6, SHEARS),
	GRAY_WOOL(35, 7, SHEARS),
	LIGHT_GRAY_WOOL(35, 8, SHEARS),
	CYAN_WOOL(35, 9, SHEARS),
	PURPLE_WOOL(35, 10, SHEARS),
	BLUE_WOOL(35, 11, SHEARS),
	BROWN_WOOL(35, 12, SHEARS),
	GREEN_WOOL(35, 13, SHEARS),
	RED_WOOL(35, 14, SHEARS),
	BLACK_WOOL(35, 15, SHEARS),
	DANDELION(37, 0, PLACEABLE),
	POPPY(38, 0, PLACEABLE),
	BLUE_ORCHID(38, 1, PLACEABLE),
	ALLIUM(38, 2, PLACEABLE),
	AZURE_BLUET(38, 3, PLACEABLE),
	RED_TULIP(38, 4, PLACEABLE),
	ORANGE_TULIP(38, 5, PLACEABLE),
	WHITE_TULIP(38, 6, PLACEABLE),
	PINK_TULIP(38, 7, PLACEABLE),
	OXEYE_DAISY(38, 8, PLACEABLE),
	BROWN_MUSHROOM(39, 0, PLACEABLE),
	RED_MUSHROOM(40, 0, PLACEABLE),
	GOLD_BLOCK(41, 0, PICKAXE),
	IRON_BLOCK(42, 0, PICKAXE),
	DOUBLE_STONE_SLAB(43, 0, PICKAXE),
	DOUBLE_SANDSTONE_SLAB(43, 1, PICKAXE),
	DOUBLE_WOODEN_SLAB(43, 2, AXE),
	DOUBLE_COBBLESTONE_SLAB(43, 3, PICKAXE),
	DOUBLE_BRICK_SLAB(43, 4, PICKAXE),
	DOUBLE_STONE_BRICK_SLAB(43, 5, PICKAXE),
	DOUBLE_NETHER_BRICK_SLAB(43, 6, PICKAXE),
	SMOOTH_QUARTZ(43, 7, PICKAXE),
	SMOOTH_STONE(43, 8, PICKAXE),
	STONE_SLAB(44, 0, PICKAXE),
	SANDSTONE_SLAB(44, 1, PICKAXE),
	WOODEN_SLAB(44, 2, AXE),
	COBBLESTONE_SLAB(44, 3, PICKAXE),
	BRICK_SLAB(44, 4, PICKAXE),
	STONE_BRICK_SLAB(44, 5, PICKAXE),
	NETHER_BRICK_SLAB(44, 6, PICKAXE),
	QUARTZ_SLAB(44, 7, PICKAXE),
	BRICK_BLOCK(45, 0, PICKAXE),
	TNT(46, 0),
	BOOKSHELF(47, 0, AXE),
	MOSSY_COBBLESTONE(48, 0, PICKAXE),
	OBSIDIAN(49, 0, PICKAXE), // TODO: Diamond pickaxe only
	TORCH(50, 0),
	FIRE(51, 0, PLACEABLE),
	SPAWNER(52, 0, PICKAXE), // TODO: Iron pickaxe and above only
	OAK_STAIRS(53, 0, AXE),
	CHEST(54, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	REDSTONE_WIRE(55, 0, PLACEABLE),
	DIAMOND_ORE(56, 0, PICKAXE), // TODO: Iron pickaxe and above only
	DIAMOND_BLOCK(57, 0, PICKAXE),
	CRAFTING_TABLE(58, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	WHEAT(59, 0, PLACEABLE | INTERACTABLE),
	FARMLAND(60, 0, SHOVEL, SOLID | PLACEABLE | INTERACTABLE),
	FURNACE(61, 0, PICKAXE),
	LIT_FURNACE(62, 0, PICKAXE),
	STANDING_SIGN(63, 0, AXE, PLACEABLE | INTERACTABLE),
	OAK_DOOR(64, 0, AXE),
	LADDER(65, 0, PLACEABLE),
	RAIL(66, 0, PICKAXE, PLACEABLE | INTERACTABLE),
	COBBLESTONE_STAIRS(67, 0, PICKAXE),
	WALL_SIGN(68, 0, AXE, PLACEABLE | INTERACTABLE),
	LEVER(69, 0, PLACEABLE | INTERACTABLE),
	STONE_PRESSURE_PLATE(70, 0, PICKAXE, PLACEABLE),
	IRON_DOOR(71, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	OAK_PRESSURE_PLATE(72, 0, PLACEABLE),
	REDSTONE_ORE(73, 0, PICKAXE),
	LIT_REDSTONE_ORE(74, 0, PICKAXE),
	REDSTONE_TORCH(75, 0, PLACEABLE),
	LIT_REDSTONE_TORCH(76, 0, PLACEABLE),
	STONE_BUTTON(77, 0, PLACEABLE),
	SNOW(78, 0, SHOVEL, SOLID | PLACEABLE | INTERACTABLE),
	ICE(79, 0), // TODO: Needs silk touch to recover
	SNOW_BLOCK(80, 0, SHOVEL),
	CACTUS(81, 0), // TODO: Torches/entities cannot be placed on
	CLAY(82, 0, SHOVEL),
	SUGAR_CANE(83, 0, PLACEABLE | INTERACTABLE),
	JUKEBOX(84, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	OAK_FENCE(85, 0, AXE),
	PUMPKIN(86, 0, AXE),
	NETHERRACK(87, 0, PICKAXE),
	SOUL_SAND(88, 0, SHOVEL),
	GLOWSTONE(89, 0), // TODO: Prefer silk touch 
	NETHER_PORTAL(90, 0, INDESTRUCTABLE),
	JACK_O_LANTERN(91, 0, AXE),
	CAKE(92, 0, SOLID | PLACEABLE | INTERACTABLE),
	REPEATER(93, 0, SOLID | PLACEABLE | INTERACTABLE),
	LIT_REPEATER(94, 0, SOLID | PLACEABLE | INTERACTABLE),
	WHITE_STAINED_GLASS(95, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	ORANGE_STAINED_GLASS(95, 1, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	MAGENTA_STAINED_GLASS(95, 2, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIGHT_BLUE_STAINED_GLASS(95, 3, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	YELLOW_STAINED_GLASS(95, 4, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIME_STAINED_GLASS(95, 5, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	PINK_STAINED_GLASS(95, 6, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	GRAY_STAINED_GLASS(95, 7, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIGHT_GRAY_STAINED_GLASS(95, 8, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	CYAN_STAINED_GLASS(95, 9, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	PURPLE_STAINED_GLASS(95, 10, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BLUE_STAINED_GLASS(95, 11, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BROWN_STAINED_GLASS(95, 12, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	GREEN_STAINED_GLASS(95, 13, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	RED_STAINED_GLASS(95, 14, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BLACK_STAINED_GLASS(95, 15, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	OAK_TRAPDOOR(96, 0, PICKAXE, SOLID | PLACEABLE), //TODO: FIX
	STONE_MONSTER_EGG(97, 0), //TODO FIX GOING FORWARD ABILITIES
	COBBLESTONE_MONSTER_EGG(97, 1), //TODO Fix
	STONE_BRICK_MONSTER_EGG(97, 2), //TODO Fix
	MOSSY_STONE_BRICK_MONSTER_EGG(97, 3),
	INFESTED_CRACKED_STONE_BRICKS(97, 4),
	CHISELED_STONE_BRICK_MOSTER_EGG(97, 5),
	STONE_BRICKS(98, 0, PICKAXE, SOLID | PLACEABLE),
	MOSSY_STONE_BRICKS(98, 1, PICKAXE, SOLID | PLACEABLE),
	CRACKED_STONE_BRICKS(98, 2, PICKAXE, SOLID | PLACEABLE),
	CHISELED_STONE_BRICKS(98, 3, PICKAXE, SOLID | PLACEABLE),
	BROWN_MUSHROOM_BLOCK(99, 0, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	RED_MUSHROOM_BLOCK(100, 0, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	IRON_BARS(101, 0, PICKAXE, SOLID | PLACEABLE),
	GLASS_PANE(102, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	MELON(103, 0, AXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	PUMPKIN_STEM(104, 0), // TODO: Torches/entities cannot be placed on
	MELON_STEM(105, 0), // TODO: Torches/entities cannot be placed on
	VINE(106, 0, SHEARS, PLACEABLE),
	OAK_FENCE_GATE(107, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	BRICK_STAIRS(108, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	STONE_BRICK_STAIRS(109, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	MYCELIUM(110, 0, SHOVEL, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LILY_PAD(111, 0, SOLID | PLACEABLE),
	NETHER_BRICKS(112, 0), // TODO:item
	NETHER_BRICK_FENCE(113, 0, PICKAXE, SOLID | PLACEABLE),
	NETHER_BRICK_STAIRS(114, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	NETHER_WART(115, 0), // TODO: item
	ENCHANTING_TABLE(116, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	BREWING_STAND(117, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	CAULDRON(118, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	END_PORTAL(119, 0, INDESTRUCTABLE),
	END_PORTAL_FRAME(120, 0, SOLID | INDESTRUCTABLE),
	END_STONE(121, 0, PICKAXE, SOLID | PLACEABLE),
	DRAGON_EGG(122, 0, INDESTRUCTABLE),
	REDSTONE_LAMP(123, 0, SOLID | PLACEABLE),
	LIT_REDSTONE_LAMP(124, 0, SOLID | PLACEABLE),
	DOUBLE_OAK_WOOD_SLAB(125, 0, AXE, SOLID | PLACEABLE), // TODO: LOOK INTO double_wooden_slab 
	DOUBLE_SPRUCE_WOOD_SLAB(125, 1, AXE, SOLID | PLACEABLE),
	DOUBLE_BIRCH_WOOD_SLAB(125, 2, AXE, SOLID | PLACEABLE),
	DOUBLE_JUNGLE_WOOD_SLAB(125, 3, AXE, SOLID | PLACEABLE),
	DOUBLE_ACACIA_WOOD_SLAB(125, 4, AXE, SOLID | PLACEABLE),
	DOUBLE_DARK_OAK_WOOD_SLAB(125, 5, AXE, SOLID | PLACEABLE),
	OAK_SLAB(126, 0, AXE, PLACEABLE),
	SPRUCE_SLAB(126, 1, AXE, PLACEABLE),
	BIRCH_SLAB(126, 2, AXE, PLACEABLE),
	JUNGLE_SLAB(126, 3, AXE, PLACEABLE),
	ACACIA_SLAB(126, 4, AXE, PLACEABLE),
	DARK_OAK_SLAB(126, 5, AXE, PLACEABLE), //TODO Look into seeds
	COCOA(127, 0), //TODO Look into seeds
	SANDSTONE_STAIRS(128, 0, PICKAXE, SOLID | PLACEABLE), //TODO: look into stairs
	EMERALD_ORE(129, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	ENDER_CHEST(130, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE), // TODO: Needs silk touch to recover
	TRIPWIRE_HOOK(131, 0, PLACEABLE),
	TRIPWIRE(132, 0, PLACEABLE), //TODO: look into trip wire
	EMERALD_BLOCK(133, 0, PICKAXE, SOLID | PLACEABLE),
	SPRUCE_STAIRS(134, 0, AXE, SOLID | PLACEABLE), //TODO: look into stairs
	BIRCH_STAIRS(135, 0, AXE, SOLID | PLACEABLE), //TODO: look into stairs
	JUNGLE_STAIRS(136, 0, AXE, SOLID | PLACEABLE), //TODO: look into stairs
	COMMAND_BLOCK(137, 0, PICKAXE, SOLID | PLACEABLE),
	BEACON(138, 0, SOLID | PLACEABLE | INTERACTABLE),
	COBBLESTONE_WALL(139, 0, PICKAXE, SOLID | PLACEABLE),
	MOSSY_COBBLESTONE_WALL(139, 1, PICKAXE, SOLID | PLACEABLE),
	FLOWER_POT(140, 0, PLACEABLE), //TODO: look into if this is solid
	CARROTS(141, 0), //TODO: item
	POTATOES(142, 0), //TODO: item
	OAK_BUTTON(143, 0, AXE, PLACEABLE | INTERACTABLE),
	MOB_HEAD(144, 0, PLACEABLE | INTERACTABLE), //TODO: maybe solid?
	ANVIL(145, 0, AXE, PLACEABLE | INTERACTABLE | GRAVITY),
	CHIPPED_ANVIL(145, 1, AXE, PLACEABLE | INTERACTABLE | GRAVITY),
	DAMAGED_ANVIL(145, 2, AXE, PLACEABLE | INTERACTABLE | GRAVITY),
	TRAPPED_CHEST(146, 0, PLACEABLE | INTERACTABLE),
	LIGHT_WEIGHTED_PRESSURE_PLATE(147, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	HEAVY_WEIGHTED_PRESSURE_PLATE(148, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	COMPARATOR(149, 0, PLACEABLE | INTERACTABLE),
	POWERED_COMPARATOR(150, 0, PLACEABLE | INTERACTABLE),
	DAYLIGHT_DETECTOR(151, 0, PLACEABLE | INTERACTABLE),
	REDSTONE_BLOCK(152, 0, PICKAXE, SOLID | PLACEABLE),
	NETHER_QUARTZ_ORE(153, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	HOPPER(154, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	QUARTZ_BLOCK(155, 0, PICKAXE, SOLID | PLACEABLE),
	CHISELED_QUARTZ_BLOCK(155, 1, PICKAXE, SOLID | PLACEABLE),
	QUARTZ_PILLAR(155, 2, PICKAXE, SOLID | PLACEABLE),
	QUARTZ_STAIRS(156, 0, PICKAXE, SOLID | PLACEABLE), //TODO: look into stairs
	ACTIVATOR_RAIL(157, 0, PLACEABLE), //TODO: look into rails
	DROPPER(158, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	WHITE_TERRACOTTA(159, 0), //TODO: is this the same as TERRACOTTA?
	ORANGE_TERRACOTTA(159, 1), //TODO: is this the same as TERRACOTTA?
	MAGENTA_TERRACOTTA(159, 2), //TODO: is this the same as TERRACOTTA?
	LIGHT_BLUE_TERRACOTTA(159, 3), //TODO: is this the same as TERRACOTTA?
	YELLOW_TERRACOTTA(159, 4), //TODO: is this the same as TERRACOTTA?
	LIME_TERRACOTTA(159, 5), //TODO: is this the same as TERRACOTTA?
	PINK_TERRACOTTA(159, 6), //TODO: is this the same as TERRACOTTA?
	GRAY_TERRACOTTA(159, 7), //TODO: is this the same as TERRACOTTA?
	LIGHT_GRAY_TERRACOTTA(159, 8), //TODO: is this the same as TERRACOTTA?
	CYAN_TERRACOTTA(159, 9), //TODO: is this the same as TERRACOTTA?
	PURPLE_TERRACOTTA(159, 10), //TODO: is this the same as TERRACOTTA?
	BLUE_TERRACOTTA(159, 11), //TODO: is this the same as TERRACOTTA?
	BROWN_TERRACOTTA(159, 12), //TODO: is this the same as TERRACOTTA?
	GREEN_TERRACOTTA(159, 13), //TODO: is this the same as TERRACOTTA?
	RED_TERRACOTTA(159, 14), //TODO: is this the same as TERRACOTTA?
	BLACK_TERRACOTTA(159, 15), //TODO: is this the same as TERRACOTTA?
	WHITE_STAINED_GLASS_PANE(160, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	ORANGE_STAINED_GLASS_PANE(160, 1, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	MAGENTA_STAINED_GLASS_PANE(160, 2, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIGHT_BLUE_STAINED_GLASS_PANE(160, 3, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	YELLOW_STAINED_GLASS_PANE(160, 4, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIME_STAINED_GLASS_PANE(160, 5, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	PINK_STAINED_GLASS_PANE(160, 6, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	GRAY_STAINED_GLASS_PANE(160, 7, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	LIGHT_GRAY_STAINED_GLASS_PANE(160, 8, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	CYAN_STAINED_GLASS_PANE(160, 9, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	PURPLE_STAINED_GLASS_PANE(160, 10, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BLUE_STAINED_GLASS_PANE(160, 11, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BROWN_STAINED_GLASS_PANE(160, 12, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	GREEN_STAINED_GLASS_PANE(160, 13, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	RED_STAINED_GLASS_PANE(160, 14, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	BLACK_STAINED_GLASS_PANE(160, 15, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	ACACIA_LEAVES(161, 0, SHEARS),
	DARK_OAK_LEAVES(161, 1, SHEARS),
	ACACIA_LOG(162, 0, AXE, SOLID | PLACEABLE),
	DARK_OAK_LOG(162, 1, AXE, SOLID | PLACEABLE),
	ACACIA_STAIRS(163, 0, AXE, SOLID | PLACEABLE),
	DARK_OAK_STAIRS(164, 0, AXE, SOLID | PLACEABLE),
	SLIME_BLOCK(165, 0, SOLID | PLACEABLE),
	BARRIER(166, 0, INDESTRUCTABLE),
	IRON_TRAPDOOR(167, 0, PICKAXE, SOLID | PLACEABLE),
	PRISMARINE(168, 0, PICKAXE, SOLID | PLACEABLE),
	PRISMARINE_BRICKS(168, 1, PICKAXE, SOLID | PLACEABLE),
	DARK_PRISMARINE(168, 2, PICKAXE, SOLID | PLACEABLE),
	SEA_LANTERN(169, 0, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	HAY_BLOCK(170, 0, SOLID | PLACEABLE),
	WHITE_CARPET(171, 0, SOLID | PLACEABLE), //TODO: carpet increases y by 0.06250
	ORANGE_CARPET(171, 1, SOLID | PLACEABLE),
	MAGENTA_CARPET(171, 2, SOLID | PLACEABLE),
	LIGHT_BLUE_CARPET(171, 3, SOLID | PLACEABLE),
	YELLOW_CARPET(171, 4, SOLID | PLACEABLE),
	LIME_CARPET(171, 5, SOLID | PLACEABLE),
	PINK_CARPET(171, 6, SOLID | PLACEABLE),
	GRAY_CARPET(171, 7, SOLID | PLACEABLE),
	LIGHT_GRAY_CARPET(171, 8, SOLID | PLACEABLE),
	CYAN_CARPET(171, 9, SOLID | PLACEABLE),
	PURPLE_CARPET(171, 10, SOLID | PLACEABLE),
	BLUE_CARPET(171, 11, SOLID | PLACEABLE),
	BROWN_CARPET(171, 12, SOLID | PLACEABLE),
	GREEN_CARPET(171, 13, SOLID | PLACEABLE),
	RED_CARPET(171, 14, SOLID | PLACEABLE),
	BLACK_CARPET(171, 15, SOLID | PLACEABLE),
	HARDENED_CLAY(172, 0), //TODO: look into TERRACOTTA BS
	COAL_BLOCK(173, 0, PICKAXE, SOLID | PLACEABLE),
	PACKED_ICE(174, 0, PICKAXE, SOLID | PLACEABLE), // TODO: Needs silk touch to recover
	SUNFLOWER(175, 0, PLACEABLE),
	LILAC(175, 1, PLACEABLE),
	TALL_GRASS(175, 2, SHEARS, PLACEABLE),
	LARGE_FERN(175, 3, SHEARS, PLACEABLE),
	ROSE_BUSH(175, 5, PLACEABLE),
	PEONY(175, 5, PLACEABLE),
	STANDING_BANNER(176, 0),
	WALL_BANNER(177, 0, PLACEABLE | INTERACTABLE),
	DAYLIGHT_DETECTOR_INVERTED(178, 0, SOLID | PLACEABLE | INTERACTABLE),
	RED_SANDSTONE(179, 0, PICKAXE, SOLID | PLACEABLE),
	CHISELED_RED_SANDSTONE(179, 1, PICKAXE, SOLID | PLACEABLE),
	CUT_RED_SANDSTONE(179, 2, PICKAXE, SOLID | PLACEABLE),
	RED_SANDSTONE_STAIRS(180, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	DOUBLE_RED_SANDSTONE_SLAB(181, 0, PICKAXE, SOLID | PLACEABLE),
	RED_SANDSTONE_SLAB(182, 0, PICKAXE, SOLID | PLACEABLE),
	SPRUCE_FENCE_GATE(183, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	BIRCH_FENCE_GATE(184, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	JUNGLE_FENCE_GATE(185, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	DARK_OAK_FENCE_GATE(186, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	ACACIA_FENCE_GATE(187, 0, AXE, SOLID | PLACEABLE | INTERACTABLE),
	SPRUCE_FENCE(188, 0, AXE, SOLID | PLACEABLE),
	BIRCH_FENCE(189, 0, AXE, SOLID | PLACEABLE),
	JUNGLE_FENCE(190, 0, AXE, SOLID | PLACEABLE),
	DARK_OAK_FENCE(191, 0, AXE, SOLID | PLACEABLE),
	ACACIA_FENCE(192, 0, AXE, SOLID | PLACEABLE),
	SPRUCE_DOOR(193, 0, AXE, SOLID | PLACEABLE),
	BIRCH_DOOR(194, 0, AXE, SOLID | PLACEABLE),
	JUNGLE_DOOR(195, 0, AXE, SOLID | PLACEABLE),
	ACACIA_DOOR(196, 0, AXE, SOLID | PLACEABLE),
	DARK_OAK_DOOR(197, 0, AXE, SOLID | PLACEABLE),
	END_ROD(198, 0, SOLID | PLACEABLE),
	CHORUS_PLANT(199, 0, AXE, SOLID),
	CHORUS_FLOWER(200, 0, AXE, SOLID),
	PURPUR_BLOCK(201, 0, PICKAXE, SOLID | PLACEABLE),
	PURPUR_PILLAR(202, 0, PICKAXE, SOLID | PLACEABLE),
	PURPUR_STAIRS(203, 0, PICKAXE, SOLID | PLACEABLE | WATER_LOGGABLE),
	PURPUR_DOUBLE_SLAB(204, 0, PICKAXE, SOLID | PLACEABLE),
	PURPUR_SLAB(205, 0, PICKAXE, SOLID | PLACEABLE),
	END_STONE_BRICKS(206, 0, PICKAXE, SOLID | PLACEABLE), 
	BEETROOTS(207, 0),
	GRASS_PATH(208, 0, SOLID | PLACEABLE),
	END_GATEWAY(209, 0, INDESTRUCTABLE),
	REPEATING_COMMAND_BLOCK(210, 0, PICKAXE, SOLID | PLACEABLE),
	CHAIN_COMMAND_BLOCK(211, 0, PICKAXE, SOLID | PLACEABLE),
	FROSTED_ICE(212, 0, PICKAXE, SOLID | PLACEABLE), //TODO: needs silk touch
	MAGMA_BLOCK(213, 0, PICKAXE, SOLID | PLACEABLE),
	NETHER_WART_BLOCK(214, 0, SOLID | PLACEABLE),
	RED_NETHER_BRICKS(215, 0, PICKAXE, SOLID | PLACEABLE),
	BONE_BLOCK(216, 0, PICKAXE, SOLID | PLACEABLE),
	STRUCTURE_VOID(217, 0, INDESTRUCTABLE),
	OBSERVER(218, 0, PICKAXE, SOLID | PLACEABLE),
	WHITE_SHULKER_BOX(219, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	ORANGE_SHULKER_BOX(220, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	MAGENTA_SHULKER_BOX(221, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	LIGHT_BLUE_SHULKER_BOX(222, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	YELLOW_SHULKER_BOX(223, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	LIME_SHULKER_BOX(224, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	PINK_SHULKER_BOX(225, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	GRAY_SHULKER_BOX(226, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	LIGHT_GRAY_SHULKER_BOX(227, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	CYAN_SHULKER_BOX(228, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	PURPLE_SHULKER_BOX(229, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	BLUE_SHULKER_BOX(230, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	BROWN_SHULKER_BOX(231, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	GREEN_SHULKER_BOX(232, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	RED_SHULKER_BOX(233, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	BLACK_SHULKER_BOX(234, 0, PICKAXE, SOLID | PLACEABLE | INTERACTABLE),
	WHITE_GLAZED_TERRACOTTA(235, 0, PICKAXE, SOLID | PLACEABLE),
	ORANGE_GLAZED_TERRACOTTA(236, 0, PICKAXE, SOLID | PLACEABLE),
	MAGENTA_GLAZED_TERRACOTTA(237, 0, PICKAXE, SOLID | PLACEABLE),
	LIGHT_BLUE_GLAZED_TERRACOTTA(238, 0, PICKAXE, SOLID | PLACEABLE),
	YELLOW_GLAZED_TERRACOTTA(239, 0, PICKAXE, SOLID | PLACEABLE),
	LIME_GLAZED_TERRACOTTA(240, 0, PICKAXE, SOLID | PLACEABLE),
	PINK_GLAZED_TERRACOTTA(241, 0, PICKAXE, SOLID | PLACEABLE),
	GRAY_GLAZED_TERRACOTTA(242, 0, PICKAXE, SOLID | PLACEABLE),
	LIGHT_GRAY_GLAZED_TERRACOTTA(243, 0, PICKAXE, SOLID | PLACEABLE),
	CYAN_GLAZED_TERRACOTTA(244, 0, PICKAXE, SOLID | PLACEABLE),
	PURPLE_GLAZED_TERRACOTTA(245, 0, PICKAXE, SOLID | PLACEABLE),
	BLUE_GLAZED_TERRACOTTA(246, 0, PICKAXE, SOLID | PLACEABLE),
	BROWN_GLAZED_TERRACOTTA(247, 0, PICKAXE, SOLID | PLACEABLE),
	GREEN_GLAZED_TERRACOTTA(248, 0, PICKAXE, SOLID | PLACEABLE),
	RED_GLAZED_TERRACOTTA(249, 0, PICKAXE, SOLID | PLACEABLE),
	BLACK_GLAZED_TERRACOTTA(250, 0, PICKAXE, SOLID | PLACEABLE),
	WHITE_CONCRETE(251, 0, PICKAXE, SOLID | PLACEABLE),
	ORANGE_CONCRETE(251, 1, PICKAXE, SOLID | PLACEABLE),
	MAGENTA_CONCRETE(251, 2, PICKAXE, SOLID | PLACEABLE),
	LIGHT_BLUE_CONCRETE(251, 3, PICKAXE, SOLID | PLACEABLE),
	YELLOW_CONCRETE(251, 4, PICKAXE, SOLID | PLACEABLE),
	LIME_CONCRETE(251, 5, PICKAXE, SOLID | PLACEABLE),
	PINK_CONCRETE(251, 6, PICKAXE, SOLID | PLACEABLE),
	GRAY_CONCRETE(251, 7, PICKAXE, SOLID | PLACEABLE),
	LIGHT_GRAY_CONCRETE(251, 8, PICKAXE, SOLID | PLACEABLE),
	CYAN_CONCRETE(251, 9, PICKAXE, SOLID | PLACEABLE),
	PURPLE_CONCRETE(251, 10, PICKAXE, SOLID | PLACEABLE),
	BLUE_CONCRETE(251, 11, PICKAXE, SOLID | PLACEABLE),
	BROWN_CONCRETE(251, 12, PICKAXE, SOLID | PLACEABLE),
	GREEN_CONCRETE(251, 13, PICKAXE, SOLID | PLACEABLE),
	RED_CONCRETE(251, 14, PICKAXE, SOLID | PLACEABLE),
	BLACK_CONCRETE(251, 15, PICKAXE, SOLID | PLACEABLE),
	WHITE_CONCRETE_POWDER(252, 0, SOLID | PLACEABLE),
	ORANGE_CONCRETE_POWDER(252, 1, SOLID | PLACEABLE),
	MAGENTA_CONCRETE_POWDER(252, 2, SOLID | PLACEABLE),
	LIGHT_BLUE_CONCRETE_POWDER(252, 3, SOLID | PLACEABLE),
	YELLOW_CONCRETE_POWDER(252, 4, SOLID | PLACEABLE),
	LIME_CONCRETE_POWDER(252, 5, SOLID | PLACEABLE),
	PINK_CONCRETE_POWDER(252, 6, SOLID | PLACEABLE),
	GRAY_CONCRETE_POWDER(252, 7, SOLID | PLACEABLE),
	LIGHT_GRAY_CONCRETE_POWDER(252, 8, SOLID | PLACEABLE),
	CYAN_CONCRETE_POWDER(252, 9, SOLID | PLACEABLE),
	PURPLE_CONCRETE_POWDER(252, 10, SOLID | PLACEABLE),
	BLUE_CONCRETE_POWDER(252, 11, SOLID | PLACEABLE),
	BROWN_CONCRETE_POWDER(252, 12, SOLID | PLACEABLE),
	GREEN_CONCRETE_POWDER(252, 13, SOLID | PLACEABLE),
	RED_CONCRETE_POWDER(252, 14, SOLID | PLACEABLE),
	BLACK_CONCRETE_POWDER(252, 15, SOLID | PLACEABLE),
	STRUCTURE_BLOCK(255, 0, SOLID | PLACEABLE | INDESTRUCTABLE | INTERACTABLE),
	CARROT(391, 0),
	WITHER_SKELETON_SKULL(397, 1),
	BLACK_BANNER(425, 0),
	RED_BANNER(425, 1),
	GREEN_BANNER(425, 2),
	BROWN_BANNER(425, 3),
	BLUE_BANNER(425, 4),
	PURPLE_BANNER(425, 5),
	CYAN_BANNER(425, 6),
	LIGHT_GRAY_BANNER(425, 7),
	GRAY_BANNER(425, 8),
	PINK_BANNER(425, 9),
	LIME_BANNER(425, 10),
	YELLOW_BANNER(245, 11),
	LIGHT_BLUE_BANNER(425, 12),
	MAGENTA_BANNER(425, 13),
	ORANGE_BANNER(245, 14),
	WHITE_BANNER(425, 15),
	
	
	
	//TODO: unknown blocks
	STRIPPED_SPRUCE_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_BIRCH_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_JUNGLE_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_ACACIA_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_DARK_OAK_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_OAK_LOG(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_OAK_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_SPRUCE_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_BIRCH_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_JUNGLE_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_ACACIA_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	STRIPPED_DARK_OAK_WOOD(0, 0, AXE, SOLID | PLACEABLE),
	
	WHITE_BED(0, 0, SOLID | PLACEABLE),
	ORANGE_BED(0, 0, SOLID | PLACEABLE),
	MAGENTA_BED(0, 0, SOLID | PLACEABLE),
	LIGHT_BLUE_BED(0, 0, SOLID | PLACEABLE),
	YELLOW_BED(0, 0, SOLID | PLACEABLE),
	LIME_BED(0, 0, SOLID | PLACEABLE),
	PINK_BED(0, 0, SOLID | PLACEABLE),
	GRAY_BED(0, 0, SOLID | PLACEABLE),
	LIGHT_GRAY_BED(0, 0, SOLID | PLACEABLE),
	CYAN_BED(0, 0, SOLID | PLACEABLE),
	PURPLE_BED(0, 0, SOLID | PLACEABLE),
	BLUE_BED(0, 0, SOLID | PLACEABLE),
	BROWN_BED(0, 0, SOLID | PLACEABLE),
	GREEN_BED(0, 0, SOLID | PLACEABLE),
	RED_BED(0, 0, SOLID | PLACEABLE),
	BLACK_BED(0, 0, SOLID | PLACEABLE),
	
	SEAGRASS(0,0),
	TALL_SEAGRASS(0,0),
	MOVING_PISTON(0,0),
	BRICKS(0,0),
	WALL_TORCH(0,0),
	SIGN(0,0),
	SPRUCE_PRESSURE_PLAT(0,0),
	BIRCH_PRESSURE_PLAT(0,0),
	JUNGLE_PRESSURE_PLAT(0,0),
	ACACIA_PRESSURE_PLAT(0,0),
	DARK_OAK_PRESSURE_PLAT(0,0),
	REDSTONE_WALL_TORCH(0,0),
	CARVED_PUMPKIN(0,0),
	SPRUCE_TRAPDOOR(0,0),
	BIRCH_TRAPDOOR(0,0),
	JUNGLE_TRAPDOOR(0,0),
	ACACIA_TRAPDOOR(0,0),
	DARK_OAK_TRAPDOOR(0,0),
	INFESTED_STONE(0,0),
	INFESTED_COBBLESTONE(0,0),
	INFESTED_STONE_BRICKS(0,0),
	INFESTED_MOSSY_STONE_BRICKS(0,0),
	INFESTED_CRACK_STONE_BRICKS(0,0),
	INFESTED_CHISELED_STONE_BRICKS(0,0),
	MUSHROOM_STEM(0,0),
	ATTACHED_PUMKIN_STEM(0,0),
	ATTACHED_MELON_STEM(0,0),
	POTTED_OAK_SAPLING(0,0),
	POTTED_SPRUCE_SAPLING(0,0),
	POTTED_BIRCH_SAPLING(0,0),
	POTTED_JUNGLE_SAPLING(0,0),
	POTTED_ACACIA_SAPLING(0,0),
	POTTED_DARK_OAK_SAPLING(0,0),
	POTTED_FERN(0,0),
	POTTED_DANDELION(0,0),
	POTTED_POPPY(0,0),
	POTTED_BLUE_ORCHID(0,0),
	POTTED_ALLIUM(0,0),
	POTTED_AZURE_BLUET(0,0),
	POTTED_RED_TULIP(0,0),
	POTTED_ORANGE_TULIP(0,0),
	POTTED_WHITE_TULIP(0,0),
	POTTED_PINK_TULIP(0,0),
	POTTED_OXEYE_DAISY(0,0),
	POTTED_RED_MUSHROOM(0,0),
	POTTED_BROWN_MUSHROOM(0,0),
	POTTED_DEAD_BUSH(0,0),
	POTTED_CACTUS(0,0),
	SPRUCE_BUTTON(0,0),
	BIRCH_BUTTON(0,0),
	JUNGLE_BUTTON(0,0),
	ACACIA_BUTTON(0,0),
	DARK_OAK_BUTTON(0,0),
	SKELETON_WALL_SKULL(0,0),
	SKELETON_SKULL(0,0),
	WITHER_SKELETON_WALL_SKULL(0,0),
	ZOMBIE_WALL_HEAD(0,0),
	ZOMBIE_HEAD(0,0),
	PLAYER_WALL_HEAD(0,0),
	PLAYER_HEAD(0,0),
	CREEPER_WALL_HEAD(0,0),
	CREEPER_HEAD(0,0),
	DRAGON_WALL_HEAD(0,0),
	DRAGON_HEAD(0,0),
	PRISMARINE_STAIRS(0,0),
	PRISMARINE_BRICK_STAIRS(0,0),
	DARK_PRISMARINE_STAIRS(0,0),
	PRISMARINE_SLAB(0,0),
	PRISMARINE_BRICK_SLAB(0,0),
	DARK_PRISMARINE_SLAB(0,0),
	TERRACOTTA(0,0),
	ATTACHED_PUMPKIN_STEM(0,0),
	
	WHITE_WALL_BANNER(0,0),
	ORANGE_WALL_BANNER(0,0),
	MAGENTA_WALL_BANNER(0,0),
	LIGHT_BLUE_WALL_BANNER(0,0),
	YELLOW_WALL_BANNER(0,0),
	LIME_WALL_BANNER(0,0),
	PINK_WALL_BANNER(0,0),
	GRAY_WALL_BANNER(0,0),
	LIGHT_GRAY_WALL_BANNER(0,0),
	CYAN_WALL_BANNER(0,0),
	PURPLE_WALL_BANNER(0,0),
	BLUE_WALL_BANNER(0,0),
	BROWN_WALL_BANNER(0,0),
	GREEN_WALL_BANNER(0,0),
	RED_WALL_BANNER(0,0),
	BLACK_WALL_BANNER(0,0),
	
	PETRIFIED_OAK_SLAB(0,0),
	SMOOTH_SANDSTONE(0,0),
	SHULKER_BOX(0,0),
	KELP(0,0),
	KELP_PLANT(0,0),
	DRIED_KELP_BLOCK(0,0),
	TURTLE_EGG(0,0),
	DEAD_TUBE_CORAL_BLOCK(0,0),
	DEAD_BRAIN_CORAL_BLOCK(0,0),
	DEAD_BUBBLE_CORAL_BLOCK(0,0),
	DEAD_FIRE_CORAL_BLOCK(0,0),
	DEAD_HORN_CORAL_BLOCK(0,0),
	TUBE_CORAL_BLOCK(0,0),
	BRAIN_CORAL_BLOCK(0,0),
	BUBBLE_CORAL_BLOCK(0,0),
	FIRE_CORAL_BLOCK(0,0),
	HORN_CORAL_BLOCK(0,0),
	DEAD_TUBE_CORAL(0,0),
	DEAD_BRAIN_CORAL(0,0),
	DEAD_BUBBLE_CORAL(0,0),
	DEAD_FIRE_CORAL(0,0),
	DEAD_HORN_CORAL(0,0),
	TUBE_CORAL(0,0),
	BRAIN_CORAL(0,0),
	BUBBLE_CORAL(0,0),
	FIRE_CORAL(0,0),
	HORN_CORAL(0,0),
	DEAD_TUBE_CORAL_WALL_FAN(0,0),
	DEAD_BRAIN_CORAL_WALL_FAN(0,0),
	DEAD_BUBBLE_CORAL_WALL_FAN(0,0),
	DEAD_FIRE_CORAL_WALL_FAN(0,0),
	DEAD_HORN_CORAL_WALL_FAN(0,0),
	TUBE_CORAL_WALL_FAN(0,0),
	BRAIN_CORAL_WALL_FAN(0,0),
	BUBBLE_CORAL_WALL_FAN(0,0),
	FIRE_CORAL_WALL_FAN(0,0),
	HORN_CORAL_WALL_FAN(0,0),
	DEAD_TUBE_CORAL_FAN(0,0),
	DEAD_BRAIN_CORAL_FAN(0,0),
	DEAD_BUBBLE_CORAL_FAN(0,0),
	DEAD_FIRE_CORAL_FAN(0,0),
	DEAD_HORN_CORAL_FAN(0,0),
	TUBE_CORAL_FAN(0,0),
	BRAIN_CORAL_FAN(0,0),
	BUBBLE_CORAL_FAN(0,0),
	FIRE_CORAL_FAN(0,0),
	HORN_CORAL_FAN(0,0),
	SEA_PICKLE(0,0),
	CONDUIT(0,0),
	VOID_AIR(0,0),
	CAVE_AIR(0,0),
	BUBBLE_COLUMN(0,0),
	SMOOTH_RED_SANDSTONE(0,0),
	
	OAK_WOOD(0,0),
	SPRUCE_WOOD(0,0),
	BIRCH_WOOD(0,0),
	JUNGLE_WOOD(0,0),
	ACACIA_WOOD(0,0),
	DARK_OAK_WOOD(0,0),
	
	SPRUCE_PRESSURE_PLATE(0,0),
	BIRCH_PRESSURE_PLATE(0,0),
	JUNGLE_PRESSURE_PLATE(0,0),
	ACACIA_PRESSURE_PLATE(0,0),
	DARK_OAK_PRESSURE_PLATE(0,0),
	
	BLUE_ICE(0,0);
	
	
	
	private final int id;
	private final int metadata;
	private final int maxStack;
	private final int flags;
	private final ItemGroup toolType;

//	private BlockType(int id) {
//		this(id, 0);
//	}
	
	private BlockType(int id, int metadata) {
		this(id, metadata, SOLID | PLACEABLE);
	}
	
	private BlockType(int id, int metadata, int flags) {
		this(id, metadata, 64, flags, null);
	}
	
	private BlockType(int id, ItemGroup toolType) {
		this(id, toolType, SOLID | PLACEABLE);
	}
	
	private BlockType(int id, ItemGroup toolType, int flags) {
		this(id, 0, 64, flags, toolType);
	}
	
	private BlockType(int id, int metadata, ItemGroup toolType) {
		this(id, metadata, 64, SOLID | PLACEABLE, toolType);
	}
	
	private BlockType(int id, int metadata, ItemGroup toolType, int flags) {
		this(id, metadata, 64, flags, toolType);
	}
	
	private BlockType(int id, int metadata, int maxStack, int flags, ItemGroup toolType) {
		this.id = id;
		this.metadata = metadata;
		this.flags = flags;
		this.maxStack = maxStack;
		this.toolType = toolType;
	}

	public int getId() {
		return id;
	}
	
	public int getMetadata() {
		return metadata;
	}
	
	public String getName() {
		return this.name().toLowerCase();
	}

	public int getMaxStackSize() {
		return maxStack;
	}

	public boolean isSolid() {
		return (flags & Flags.SOLID) == Flags.SOLID;
	}

	public boolean isInteractable() {
		return (flags & Flags.INTERACTABLE) == Flags.INTERACTABLE;
	}

	public boolean isPlaceable() {
		return (flags & Flags.PLACEABLE) == Flags.PLACEABLE;
	}

	public boolean isIndestructable() {
		return (flags & Flags.INDESTRUCTABLE) == Flags.INDESTRUCTABLE;
	}
	
	public boolean isWaterLoggable() {
		return (flags & Flags.WATER_LOGGABLE) == Flags.WATER_LOGGABLE;
	}

	public boolean hasGravity() {
		return (flags & Flags.GRAVITY) == Flags.GRAVITY;
	}
	
	public ItemGroup getToolType() {
		return toolType;
	}

	public static BlockType getById(int id) {
		for (BlockType type : values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		return UNDEFINED;
	}
	
	public static BlockType getByName(String name) {
		for (BlockType type : values()) {
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}
		return UNDEFINED;
	}


	protected static final class Flags {
		public static final int SOLID = 1, INTERACTABLE = 2, PLACEABLE = 4, INDESTRUCTABLE = 8, WATER_LOGGABLE = 16, GRAVITY = 32;
	}

}

