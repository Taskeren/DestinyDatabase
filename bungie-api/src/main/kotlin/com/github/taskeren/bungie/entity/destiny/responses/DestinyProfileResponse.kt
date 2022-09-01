package com.github.taskeren.bungie.entity.destiny.responses

import com.github.taskeren.bungie.entity.destiny.components.collectibles.DestinyCollectiblesComponent
import com.github.taskeren.bungie.entity.destiny.components.collectibles.DestinyProfileCollectiblesComponent
import com.github.taskeren.bungie.entity.destiny.components.inventory.DestinyCurrenciesComponent
import com.github.taskeren.bungie.entity.destiny.components.inventory.DestinyPlatformSilverComponent
import com.github.taskeren.bungie.entity.destiny.components.kiosks.DestinyKiosksComponent
import com.github.taskeren.bungie.entity.destiny.components.metrics.DestinyMetricsComponent
import com.github.taskeren.bungie.entity.destiny.components.plugsets.DestinyPlugSetsComponent
import com.github.taskeren.bungie.entity.destiny.components.presentation.DestinyPresentationNodesComponent
import com.github.taskeren.bungie.entity.destiny.components.profiles.DestinyProfileProgressionComponent
import com.github.taskeren.bungie.entity.destiny.components.profiles.DestinyProfileTransitoryComponent
import com.github.taskeren.bungie.entity.destiny.components.records.DestinyCharacterRecordsComponent
import com.github.taskeren.bungie.entity.destiny.components.records.DestinyProfileRecordsComponent
import com.github.taskeren.bungie.entity.destiny.components.stringVariables.DestinyStringVariablesComponent
import com.github.taskeren.bungie.entity.*
import com.github.taskeren.bungie.entity.destiny.entities.characters.*
import com.github.taskeren.bungie.entity.destiny.entities.inventory.DestinyInventoryComponent
import com.github.taskeren.bungie.entity.destiny.entities.profiles.DestinyProfileComponent
import com.github.taskeren.bungie.entity.destiny.entities.profiles.DestinyVendorReceiptsComponent

data class DestinyProfileResponse(
	val vendorReceipts: SingleComponentResponse<DestinyVendorReceiptsComponent>?,
	val profileInventory: SingleComponentResponse<DestinyInventoryComponent>?,
	val profileCurrencies: SingleComponentResponse<DestinyInventoryComponent>?,
	val profile: SingleComponentResponse<DestinyProfileComponent>?,
	val platformSilver: SingleComponentResponse<DestinyPlatformSilverComponent>?,
	val profileKiosks: SingleComponentResponse<DestinyKiosksComponent>?,
	val profilePlugSets: SingleComponentResponse<DestinyPlugSetsComponent>?,
	val profileProgression: SingleComponentResponse<DestinyProfileProgressionComponent>?,
	val profilePresentationNodes: SingleComponentResponse<DestinyPresentationNodesComponent>?,
	val profileRecords: SingleComponentResponse<DestinyProfileRecordsComponent>?,
	val profileCollectibles: SingleComponentResponse<DestinyProfileCollectiblesComponent>?,
	val profileTransitoryData: SingleComponentResponse<DestinyProfileTransitoryComponent>?,
	val metrics: SingleComponentResponse<DestinyMetricsComponent>?,
	val profileStringVariables: SingleComponentResponse<DestinyStringVariablesComponent>?,
	val characters: DictionaryComponentResponse<Long, DestinyCharacterComponent>?,
	val characterInventories: DictionaryComponentResponse<Long, DestinyInventoryComponent>?,
	val characterProgressions: DictionaryComponentResponse<Long, DestinyCharacterProgressionComponent>?,
	val characterRenderData: DictionaryComponentResponse<Long, DestinyCharacterRenderComponent>?,
	val characterActivities: DictionaryComponentResponse<Long, DestinyCharacterActivitiesComponent>?,
	val characterEquipment: DictionaryComponentResponse<Long, DestinyInventoryComponent>?,
	val characterKiosks: DictionaryComponentResponse<Long, DestinyKiosksComponent>?,
	val characterPlugSets: DictionaryComponentResponse<Long, DestinyPlugSetsComponent>?,
	val characterUninstancedItemComponents: Map<Long, DestinyBaseItemComponentSet<UInt>>?,
	val characterPresentationNodes: DictionaryComponentResponse<Long, DestinyPresentationNodesComponent>?,
	val characterRecords: DictionaryComponentResponse<Long, DestinyCharacterRecordsComponent>?,
	val characterCollectibles: DictionaryComponentResponse<Long, DestinyCollectiblesComponent>?,
	val characterStringVariables: DictionaryComponentResponse<Long, DestinyStringVariablesComponent>?,
	val itemComponents: DestinyItemComponentSet<Long>?,
	val characterCurrencyLookups: DictionaryComponentResponse<Long, DestinyCurrenciesComponent>?
)