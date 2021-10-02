package city.warlock.d2api.entity

data class SingleComponentResponse<T>(val data: T, val privacy: Int, val disabled: Boolean?)
