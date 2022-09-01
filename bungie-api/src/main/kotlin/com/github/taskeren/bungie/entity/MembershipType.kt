package com.github.taskeren.bungie.entity

// https://bungie-net.github.io/multi/schema_BungieMembershipType.html#schema_BungieMembershipType
enum class MembershipType(val value: Int, val trackerName: String? = null) {
	None(0),
	TigerXbox(1, "xbl"),
	TigerPsn(2, "psn"),
	TigerSteam(3, "steam"),
	TigerBlizzard(4),
	TigerStadia(5),
	TigerDemon(10),
	BungieNext(254),
	All(-1);
}

fun Int.toMembershipType(): MembershipType {
	enumValues<MembershipType>().forEach {
		if(it.value == this) {
			return it
		}
	}
	throw NoSuchElementException("$this")
}