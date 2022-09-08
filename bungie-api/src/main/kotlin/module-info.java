module taskeren.destiny.api {

	requires kotlin.stdlib;
	requires kotlinx.serialization.core;
	requires kotlinx.serialization.json;
	requires org.apache.logging.log4j;

	exports com.github.taskeren.bungie;
	exports com.github.taskeren.bungie.compat;
	exports com.github.taskeren.bungie.entity;
	exports com.github.taskeren.bungie.entity.dates;
	exports com.github.taskeren.bungie.entity.destiny;
	exports com.github.taskeren.bungie.entity.destiny.artifacts;
	exports com.github.taskeren.bungie.entity.destiny.challenges;
	exports com.github.taskeren.bungie.entity.destiny.character;
	exports com.github.taskeren.bungie.entity.destiny.components.collectibles;
	exports com.github.taskeren.bungie.entity.destiny.components.inventory;
	exports com.github.taskeren.bungie.entity.destiny.components.kiosks;
	exports com.github.taskeren.bungie.entity.destiny.components.metrics;
	exports com.github.taskeren.bungie.entity.destiny.components.plugsets;
	exports com.github.taskeren.bungie.entity.destiny.components.presentation;
	exports com.github.taskeren.bungie.entity.destiny.components.profiles;
	exports com.github.taskeren.bungie.entity.destiny.components.records;
	exports com.github.taskeren.bungie.entity.destiny.components.stringVariables;
	exports com.github.taskeren.bungie.entity.destiny.config;
	exports com.github.taskeren.bungie.entity.destiny.definitions;
	exports com.github.taskeren.bungie.entity.destiny.definitions.common;
	exports com.github.taskeren.bungie.entity.destiny.definitions.items;
	exports com.github.taskeren.bungie.entity.destiny.definitions.sources;
	exports com.github.taskeren.bungie.entity.destiny.entities.characters;
	exports com.github.taskeren.bungie.entity.destiny.entities.inventory;
	exports com.github.taskeren.bungie.entity.destiny.entities.items;
	exports com.github.taskeren.bungie.entity.destiny.entities.profiles;
	exports com.github.taskeren.bungie.entity.destiny.milestones;
	exports com.github.taskeren.bungie.entity.destiny.misc;
	exports com.github.taskeren.bungie.entity.destiny.perks;
	exports com.github.taskeren.bungie.entity.destiny.progression;
	exports com.github.taskeren.bungie.entity.destiny.quests;
	exports com.github.taskeren.bungie.entity.destiny.responses;
	exports com.github.taskeren.bungie.entity.destiny.vendors;
	exports com.github.taskeren.bungie.entity.links;
	exports com.github.taskeren.bungie.entity.user;
}