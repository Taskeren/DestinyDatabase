package city.warlock.d2api.entity

import city.warlock.d2api.entity.destiny.entities.items.*

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
