package cl.bootcamp.appcategoriasapi.state

import cl.bootcamp.appcategoriasapi.model.Category

data class CategoryState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null
)
