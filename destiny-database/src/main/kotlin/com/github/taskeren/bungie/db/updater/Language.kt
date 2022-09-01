package com.github.taskeren.bungie.db.updater

import com.github.taskeren.bungie.compat.BungieLanguage

/**
 * 本库支持的语言
 */
enum class Language(val bungieCode: String, val bungieLang: BungieLanguage, private val localizedName: String? = null) {

	English("en", BungieLanguage.English, "英文"),
	ChineseSimplified("zh-chs", BungieLanguage.ChineseSimplified, "简体中文"),
	ChineseTraditional("zh-cht", BungieLanguage.Chinese, "繁体中文")
	;

	fun getLocalizedName(): String {
		return localizedName ?: name
	}

}