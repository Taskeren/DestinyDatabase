package com.github.taskeren.bungie.entity.destiny.responses

import com.github.taskeren.bungie.entity.SingleComponentResponse
import com.github.taskeren.bungie.entity.destiny.entities.items.*

data class DestinyItemResponse(
	val characterId: Long?,
	val item: SingleComponentResponse<DestinyItemComponent>?,
	val instance: SingleComponentResponse<DestinyItemInstanceComponent>?,
	val objectives: SingleComponentResponse<DestinyItemObjectivesComponent>?,
	val perks: SingleComponentResponse<DestinyItemPerksComponent>?,
	val renderData: SingleComponentResponse<DestinyItemRenderComponent>?,
	val stats: SingleComponentResponse<DestinyItemStatsComponent>?,
	val talentGrid: SingleComponentResponse<DestinyItemTalentGridComponent>?,
	val sockets: SingleComponentResponse<DestinyItemSocketsComponent>?,
	val reusablePlugs: SingleComponentResponse<DestinyItemReusablePlugsComponent>?,
	val plugObjectives: SingleComponentResponse<DestinyItemPlugObjectivesComponent>?
)
