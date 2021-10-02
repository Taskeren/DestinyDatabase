package city.warlock.d2api.entity

data class DictionaryComponentResponse<K, V>(val data: Map<K, V>, val privacy: Int, val disabled: Boolean?)
