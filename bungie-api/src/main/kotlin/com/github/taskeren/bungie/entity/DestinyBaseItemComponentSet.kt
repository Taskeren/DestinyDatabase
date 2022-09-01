package com.github.taskeren.bungie.entity

import com.github.taskeren.bungie.entity.destiny.entities.items.DestinyItemObjectivesComponent

data class DestinyBaseItemComponentSet<T>(val objectives: DictionaryComponentResponse<T, DestinyItemObjectivesComponent>)
