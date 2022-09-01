package com.github.taskeren.bungie.entity.destiny.responses

import com.github.taskeren.bungie.entity.destiny.components.collectibles.DestinyCollectiblesComponent
import com.github.taskeren.bungie.entity.destiny.components.inventory.DestinyCurrenciesComponent
import com.github.taskeren.bungie.entity.destiny.components.kiosks.DestinyKiosksComponent
import com.github.taskeren.bungie.entity.destiny.components.plugsets.DestinyPlugSetsComponent
import com.github.taskeren.bungie.entity.destiny.components.presentation.DestinyPresentationNodesComponent
import com.github.taskeren.bungie.entity.destiny.components.records.DestinyCharacterRecordsComponent
import com.github.taskeren.bungie.entity.*
import com.github.taskeren.bungie.entity.destiny.entities.characters.*
import com.github.taskeren.bungie.entity.destiny.entities.inventory.DestinyInventoryComponent

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
