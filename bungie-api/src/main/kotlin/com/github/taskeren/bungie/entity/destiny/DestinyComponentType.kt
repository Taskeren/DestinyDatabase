package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
enum class DestinyComponentType(val value: Int) {
	None(0),
	Profiles(100),
	VendorReceipts(101),
	ProfileInventories(102),
	ProfileCurrencies(103),
	ProfileProgression(104),
	PlatformSilver(105),
	Characters(200),
	CharacterInventories(201),
	CharacterProgressions(202),
	CharacterRenderData(203),
	CharacterActivities(204),
	CharacterEquipment(205),
	ItemInstances(300),
	ItemObjectives(301),
	ItemPerks(302),
	ItemRenderData(303),
	ItemStats(304),
	ItemSockets(305),
	ItemTalentGrids(306),
	ItemCommonData(307),
	ItemPlugStats(308),
	ItemPlugObjectives(309),
	ItemReusablePlugs(310),
	Vendors(400),
	VendorCategories(401),
	VendorSales(402),
	Kiosks(500),
	CurrencyLookups(600),
	PresentationNodes(700),
	Collectibles(800),
	Records(900),
	Transitory(1000),
	Metrics(1100),
	StringVariables(1200)
}