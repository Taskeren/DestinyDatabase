package city.warlock.d2api.entity

import city.warlock.d2api.entity.destiny.entities.items.DestinyItemObjectivesComponent

data class DestinyBaseItemComponentSet<T>(val objectives: DictionaryComponentResponse<T, DestinyItemObjectivesComponent>)
