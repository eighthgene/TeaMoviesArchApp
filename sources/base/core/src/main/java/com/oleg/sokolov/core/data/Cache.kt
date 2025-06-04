package com.oleg.sokolov.core.data

interface Cacheable {
  val key: String
}

typealias ListCache<T> = Cache<GenericCacheable<List<T>>>

data class GenericCacheable<T>(override val key: String, val value: T) : Cacheable

operator fun <T> ListCache<T>.set(key: String, value: List<T>) { save(key.cacheWith(value)) }

infix fun <T> String.cacheWith(value: T) = GenericCacheable(this, value)


class Cache<T : Cacheable>(private val store: LinkedHashMap<String, T> = LinkedHashMap()) {

  val isLoaded
    get() = store.isNotEmpty()

  operator fun get(key: String) = store[key]

  fun save(item: T) {
    store[item.key] = item
  }

  fun saveAll(items: List<T>) {
    store.putAll(items.map { it.key to it })
  }

  fun clearAndSaveAll(items: List<T>) {
    removeAll()
    saveAll(items)
  }

  fun removeAll() = store.clear()

  fun getAll() = store.values.toList()

  fun getAllByKeys(keys: List<String>): List<T> = keys.mapNotNull { store[it] }

}