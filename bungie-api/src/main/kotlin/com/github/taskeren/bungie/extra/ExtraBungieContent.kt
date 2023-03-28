package com.github.taskeren.bungie.extra

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

private val http = OkHttpClient()

private const val NEWS_URL =
	"https://cdn.contentstack.io/v3/content_types/news_article/entries/?only[BASE][]=image&only[BASE][]=mobile_image&only[BASE][]=subtitle&only[BASE][]=date&only[BASE][]=title&only[BASE][]=url&locale=zh-cht&desc=date&include_count=true&skip=0&limit=25&environment=live"
private const val API_KEY = "blte410e3b15535c144"
private const val ACCESS_TOKEN = "cs7929311353379d90697fc0b6"

object ExtraBungieContent {

	/**
	 * 获取棒鸡官网新闻
	 */
	fun getBungieNews(): Response {
		val r = Request.Builder()
			.get().url(NEWS_URL)
			.header("api_key", API_KEY)
			.header("access_token", ACCESS_TOKEN)
			.build()

		return http.newCall(r).execute()
	}

}