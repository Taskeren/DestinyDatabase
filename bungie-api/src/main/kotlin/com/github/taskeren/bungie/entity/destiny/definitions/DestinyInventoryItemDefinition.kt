package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition
import com.github.taskeren.bungie.entity.destiny.definitions.items.DestinyItemPlugDefinition
import com.github.taskeren.bungie.entity.destiny.misc.DestinyColor
import com.github.taskeren.bungie.entity.links.HyperlinkReference
import kotlinx.serialization.Serializable

@Serializable
data class DestinyInventoryItemDefinition(
	val displayProperties: DestinyDisplayPropertiesDefinition,
	val tooltipNotifications: List<DestinyItemTooltipNotification>?,
	val collectibleHash: UInt?,
	val iconWatermark: String?,
	val iconWatermarkShelved: String?,
	val secondaryIcon: String?,
	val secondaryOverlay: String?,
	val secondarySpecial: String?,
	val backgroundColor: DestinyColor?,
	val screenshot: String?,
	val itemTypeDisplayName: String?,
	val flavorText: String?,
	val uilItemDisplayStyle: String?,
	val itemTypeAndTierDisplayName: String?,
	val displaySource: String?,
	val tooltipStyle: String?,
	val action: DestinyItemActionBlockDefinition?,
	val inventory: DestinyItemInventoryBlockDefinition,
	val setData: DestinyItemSetBlockDefinition?,
	val stats: DestinyItemStatBlockDefinition?,
	val emblemObjectiveHash: UInt?,
	val equippingBlock: DestinyEquippingBlockDefinition?,
	val translationBlock: DestinyItemTranslationBlockDefinition?,
	val preview: DestinyItemPreviewBlockDefinition?,
	val quality: DestinyItemQualityBlockDefinition?,
	val value: DestinyItemValueBlockDefinition?,
	val sourceData: DestinyItemSourceBlockDefinition?,
	val objectives: DestinyItemObjectiveBlockDefinition?,
	val metrics: DestinyItemMetricBlockDefinition?,
	val plug: DestinyItemPlugDefinition?,
	val gearset: DestinyItemGearsetBlockDefinition?,
	val sack: DestinyItemSackBlockDefinition?,
	val sockets: DestinyItemSocketBlockDefinition?,
	val summary: DestinyItemSummaryBlockDefinition?,
	val talentGrid: DestinyItemTalentGridBlockDefinition?,
	val investmentStats: List<DestinyItemInvestmentStatDefinition>?,
	val perks: List<DestinyItemPerkEntryDefinition>?,
	val loreHash: UInt?,
	val summaryItemHash: UInt?,
	val animations: List<DestinyAnimationReference>?,
	val allowActions: Boolean,
	val links: List<HyperlinkReference>?,
	val doesPostmasterPullHaveSideEffects: Boolean,
	val nonTransferrable: Boolean,
	val itemCategoryHashes: List<UInt>?,
	val specialItemType: Int,
	val itemType: Int,
	val itemSubType: Int,
	val classType: Int,
	val breakerType: Int,
	val breakerTypeHash: UInt?,
	val equippable: Boolean,
	val damageTypeHashes: List<UInt>?,
	val damageTypes: List<Int>?,
	val defaultDamageType: Int,
	val defaultDamageTypeHash: UInt?,
	val seasonHash: UInt?,
	val isWrapper: Boolean,
	val traitIds: List<String>?,
	val traitHashes: List<UInt>?,
	val hash: UInt?,
	val index: Int?,
	val redacted: Boolean?
) {

	fun getLightGGUrl() = BungieApi.Helpers.getLightGGUrl(hash!!)

}
