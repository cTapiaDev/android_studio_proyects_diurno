package cl.bootcamp.claseroom.state

data class CronoState(
    val cronoActivo: Boolean = false,
    val showSaveButton: Boolean = false,
    val showTextField: Boolean = false,
    val title: String = ""
)
