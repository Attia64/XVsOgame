package persentation.viewModels

sealed class UserActions {
    object PlayAgainButtonClicked: UserActions()
    data class BoardClicked(val cellNo: Int): UserActions()
}