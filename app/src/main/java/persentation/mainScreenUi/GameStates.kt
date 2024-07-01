package persentation.mainScreenUi



data class GameStates (
    val oWinRounds: Int = 0,
    val xWinRounds: Int = 0,
    val roundsPlayed: Int = 0,
    val drawTimes: Int = 0,
    val hintText: String = "X's Turn",
    val currentTurn: BoardCellValue = BoardCellValue.X,
    val victoryType: VictoryType = VictoryType.NONE,
    val hasWon: Boolean = false
)

enum class BoardCellValue {
    X,
    O,
    NONE
}

enum class VictoryType {
    HORIZONTAL1,
    HORIZONTAL2,
    HORIZONTAL3,
    VERTICAL1,
    VERTICAL2,
    VERTICAL3,
    DIAGONAL1,
    DIAGONAL2,
    NONE

}
