package city.warlock.d2api.entity.destiny.responses

import city.warlock.d2api.entity.*
import city.warlock.d2api.entity.destiny.components.collectibles.DestinyCollectiblesComponent
import city.warlock.d2api.entity.destiny.components.inventory.DestinyCurrenciesComponent
import city.warlock.d2api.entity.destiny.components.kiosks.DestinyKiosksComponent
import city.warlock.d2api.entity.destiny.components.plugsets.DestinyPlugSetsComponent
import city.warlock.d2api.entity.destiny.components.presentation.DestinyPresentationNodesComponent
import city.warlock.d2api.entity.destiny.components.records.DestinyCharacterRecordsComponent
import city.warlock.d2api.entity.destiny.entities.characters.*
import city.warlock.d2api.entity.destiny.entities.inventory.DestinyInventoryComponent

data class DestinyCharacterResponse(
	val inventory: SingleComponentResponse<DestinyInventoryComponent>?,
	val character: SingleComponentResponse<DestinyCharacterComponent>?,
	val progressions: SingleComponentResponse<DestinyCharacterProgressionComponent>?,
	val renderData: SingleComponentResponse<DestinyCharacterRenderComponent>?,
	val activities: SingleComponentResponse<DestinyCharacterActivitiesComponent>?,
	val equipment: SingleComponentResponse<DestinyInventoryComponent>?,
	val kiosks: SingleComponentResponse<DestinyKiosksComponent>?,
	val plugSets: SingleComponentResponse<DestinyPlugSetsComponent>?,
	val presentationNodes: SingleComponentResponse<DestinyPresentationNodesComponent>?,
	val records: SingleComponentResponse<DestinyCharacterRecordsComponent>?,
	val collectibles: SingleComponentResponse<DestinyCollectiblesComponent>?,
	val itemComponents: DestinyItemComponentSet<Long>?,
	val uninstancedItemComponents: DestinyBaseItemComponentSet<UInt>?,
	val currencyLookups: SingleComponentResponse<DestinyCurrenciesComponent>?
)
