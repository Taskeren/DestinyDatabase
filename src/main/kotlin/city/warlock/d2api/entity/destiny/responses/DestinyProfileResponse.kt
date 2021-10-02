package city.warlock.d2api.entity.destiny.responses

import city.warlock.d2api.entity.*
import city.warlock.d2api.entity.destiny.components.collectibles.DestinyCollectiblesComponent
import city.warlock.d2api.entity.destiny.components.collectibles.DestinyProfileCollectiblesComponent
import city.warlock.d2api.entity.destiny.components.inventory.DestinyCurrenciesComponent
import city.warlock.d2api.entity.destiny.components.inventory.DestinyPlatformSilverComponent
import city.warlock.d2api.entity.destiny.components.kiosks.DestinyKiosksComponent
import city.warlock.d2api.entity.destiny.components.metrics.DestinyMetricsComponent
import city.warlock.d2api.entity.destiny.components.plugsets.DestinyPlugSetsComponent
import city.warlock.d2api.entity.destiny.components.presentation.DestinyPresentationNodesComponent
import city.warlock.d2api.entity.destiny.components.profiles.DestinyProfileProgressionComponent
import city.warlock.d2api.entity.destiny.components.profiles.DestinyProfileTransitoryComponent
import city.warlock.d2api.entity.destiny.components.records.DestinyCharacterRecordsComponent
import city.warlock.d2api.entity.destiny.components.records.DestinyProfileRecordsComponent
import city.warlock.d2api.entity.destiny.components.stringVariables.DestinyStringVariablesComponent
import city.warlock.d2api.entity.destiny.entities.characters.*
import city.warlock.d2api.entity.destiny.entities.inventory.DestinyInventoryComponent
import city.warlock.d2api.entity.destiny.entities.profiles.DestinyProfileComponent
import city.warlock.d2api.entity.destiny.entities.profiles.DestinyVendorReceiptsComponent

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