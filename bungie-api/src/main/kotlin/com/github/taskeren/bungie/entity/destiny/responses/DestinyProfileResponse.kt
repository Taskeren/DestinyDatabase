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
import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileResponse(
	val vendorReceipts: SingleComponentResponse<DestinyVendorReceiptsComponent>? = null,
	val profileInventory: SingleComponentResponse<DestinyInventoryComponent>? = null,
	val profileCurrencies: SingleComponentResponse<DestinyInventoryComponent>? = null,
	val profile: SingleComponentResponse<DestinyProfileComponent>? = null,
	val platformSilver: SingleComponentResponse<DestinyPlatformSilverComponent>? = null,
	val profileKiosks: SingleComponentResponse<DestinyKiosksComponent>? = null,
	val profilePlugSets: SingleComponentResponse<DestinyPlugSetsComponent>? = null,
	val profileProgression: SingleComponentResponse<DestinyProfileProgressionComponent>? = null,
	val profilePresentationNodes: SingleComponentResponse<DestinyPresentationNodesComponent>? = null,
	val profileRecords: SingleComponentResponse<DestinyProfileRecordsComponent>? = null,
	val profileCollectibles: SingleComponentResponse<DestinyProfileCollectiblesComponent>? = null,
	val profileTransitoryData: SingleComponentResponse<DestinyProfileTransitoryComponent>? = null,
	val metrics: SingleComponentResponse<DestinyMetricsComponent>? = null,
	val profileStringVariables: SingleComponentResponse<DestinyStringVariablesComponent>? = null,
	val characters: DictionaryComponentResponse<Long, DestinyCharacterComponent>? = null,
	val characterInventories: DictionaryComponentResponse<Long, DestinyInventoryComponent>? = null,
	val characterProgressions: DictionaryComponentResponse<Long, DestinyCharacterProgressionComponent>? = null,
	val characterRenderData: DictionaryComponentResponse<Long, DestinyCharacterRenderComponent>? = null,
	val characterActivities: DictionaryComponentResponse<Long, DestinyCharacterActivitiesComponent>? = null,
	val characterEquipment: DictionaryComponentResponse<Long, DestinyInventoryComponent>? = null,
	val characterKiosks: DictionaryComponentResponse<Long, DestinyKiosksComponent>? = null,
	val characterPlugSets: DictionaryComponentResponse<Long, DestinyPlugSetsComponent>? = null,
	val characterUninstancedItemComponents: Map<Long, DestinyBaseItemComponentSet<UInt>>? = null,
	val characterPresentationNodes: DictionaryComponentResponse<Long, DestinyPresentationNodesComponent>? = null,
	val characterRecords: DictionaryComponentResponse<Long, DestinyCharacterRecordsComponent>? = null,
	val characterCollectibles: DictionaryComponentResponse<Long, DestinyCollectiblesComponent>? = null,
	val characterStringVariables: DictionaryComponentResponse<Long, DestinyStringVariablesComponent>? = null,
	val itemComponents: DestinyItemComponentSet<Long>? = null,
	val characterCurrencyLookups: DictionaryComponentResponse<Long, DestinyCurrenciesComponent>? = null
)