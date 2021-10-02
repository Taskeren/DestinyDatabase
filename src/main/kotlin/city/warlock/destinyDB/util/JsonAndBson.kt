package city.warlock.destinyDB.util

import com.google.gson.Gson
import org.bson.Document

inline fun <reified T> Document.deserialize(): T {
	return Gson().fromJson(this.toJson(), T::class.java)
}