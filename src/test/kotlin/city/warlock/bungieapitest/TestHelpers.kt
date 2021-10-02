package city.warlock.bungieapitest

internal fun <T: Any> T?.notNullThen(block: T.() -> Unit): T? {
	if(this != null) {
		block.invoke(this)
	}
	return this;
}