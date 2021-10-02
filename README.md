
<div align="center">
<img src='https://www.bungie.net/common/destiny2_content/icons/e5d9d70aadec948e851d443c64ff5d9d.png' align="center">
</div>

<div align="center">
<h1>DestinyDatabase 命运数据库</h1>
<p>用于机器人开发的数据库，内部集成棒鸡API。</p>
</div>

## 棒鸡API

BungieAPI 位于 `city.warlock.d2api` 包下，通过实例 `BungieApi` 进行操作。

- `BungieApi` 是 Api 主类。
- `BungieException` 是 BungieApi 类出现错误时抛出的异常。
- `compat` 包内为非 Bungie 数据类。
  - `BungieLanguage` 是 Manifest 中语言的枚举。
  - `EntityType` 是 Manifest 中请求数据的枚举。
- `entity` 包内为 Bungie 数据类。可以在 [棒鸡API](https://bungie-net.github.io/multi/index.html) 里找到。

## MongoDB缓存

MongoDatabase 缓存位于 `city.warlock.destinyDB` 包下，通过实例 `DestinyDatabase` 进行操作。

- `DestinyDatabase` 数据库操作类。
- `DestinyDBTricks` 快捷方法类。
- `doc` 包内时为了方便建立的 _TDocument_。
- `updater` 包内是使用 BungieApi 对数据库进行更新的类。使用 `DestinyDatabase#createUpdater` 获取实例。
- `util` 包内是辅助类。