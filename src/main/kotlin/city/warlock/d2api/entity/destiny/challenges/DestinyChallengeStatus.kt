package city.warlock.d2api.entity.destiny.challenges

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyChallengeStatus(val objective: DestinyObjectiveProgress)
