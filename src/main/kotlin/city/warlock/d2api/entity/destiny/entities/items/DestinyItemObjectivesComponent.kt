package city.warlock.d2api.entity.destiny.entities.items

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress
import java.util.*

data class DestinyItemObjectivesComponent(val objectives: List<DestinyObjectiveProgress>, val flavorObjective: DestinyObjectiveProgress, val dateCompleted: Date?)
