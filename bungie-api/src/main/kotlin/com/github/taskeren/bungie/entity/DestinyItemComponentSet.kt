package com.github.taskeren.bungie.entity

import com.github.taskeren.bungie.entity.destiny.entities.items.*
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemComponentSet<T>(
	val instances: DictionaryComponentResponse<T, DestinyItemInstanceComponent>,
	val perks: DictionaryComponentResponse<T, DestinyItemPerksComponent>,
	val renderData: DictionaryComponentResponse<T, DestinyItemRenderComponent>,
	val stats: DictionaryComponentResponse<T, DestinyItemStatsComponent>,
	val sockets: DictionaryComponentResponse<T, DestinyItemSocketsComponent>,
	val reusablePlugs: DictionaryComponentResponse<T, DestinyItemReusablePlugsComponent>,
	val plugObjectives: DictionaryComponentResponse<T, DestinyItemPlugObjectivesComponent>,
	val talentGrids: DictionaryComponentResponse<T, DestinyItemTalentGridComponent>,
	val plugStates: DictionaryComponentResponse<UInt, DestinyItemPlugComponent>,
	val objectives: DictionaryComponentResponse<T, DestinyItemObjectivesComponent>
)
