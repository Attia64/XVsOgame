package persentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import persentation.mainScreenUi.BoardCellValue
import persentation.mainScreenUi.GameStates
import persentation.mainScreenUi.VictoryType

class MainScreenViewModel : ViewModel() {

    var state by mutableStateOf(GameStates())

    val boardItem: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,
    )

    fun onAction(action: UserActions) {

        when (action) {

            is UserActions.BoardClicked -> {
                addValueToBoard(action.cellNo)
            }

            UserActions.PlayAgainButtonClicked -> {
                gameRest()
                state = state.copy(
                    roundsPlayed = state.roundsPlayed + 1
                )
            }

        }
    }

    private fun gameRest() {
        boardItem.forEach { (i, _) ->
            boardItem[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "X's Turn",
            currentTurn = BoardCellValue.X,
            victoryType = VictoryType.NONE,
            hasWon = false
        )
    }

    private fun addValueToBoard(cellNo: Int) {
        if (boardItem[cellNo] != BoardCellValue.NONE) {
            return
        }
        if (state.currentTurn == BoardCellValue.O) {
            boardItem[cellNo] = BoardCellValue.O

            if (checkForVictory(BoardCellValue.O)) {
                state = state.copy(
                    hintText = "O Won",
                    oWinRounds = state.oWinRounds + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            }

            state = if (isBoardFull()) {
                state.copy(
                    hintText = "Draw Game",
                    drawTimes = state.drawTimes + 1
                )
            } else {
                state.copy(
                    hintText = "X's Turn",
                    currentTurn = BoardCellValue.X
                )
            }

        } else if (state.currentTurn == BoardCellValue.X) {
            boardItem[cellNo] = BoardCellValue.X

            if (checkForVictory(BoardCellValue.X)) {
                state = state.copy(
                    hintText = "X Won",
                    xWinRounds = state.xWinRounds + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            }

            state = if (isBoardFull()) {
                state.copy(
                    hintText = "Draw Game",
                    drawTimes = state.drawTimes + 1
                )
            } else {
                state.copy(
                    hintText = "O's Turn",
                    currentTurn = BoardCellValue.O
                )
            }

        }

    }

    private fun checkForVictory(boardValue: BoardCellValue): Boolean {

        when {
            boardItem[1] == boardValue && boardItem[2] == boardValue && boardItem[3] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL1
                )
                return true
            }

            boardItem[4] == boardValue && boardItem[5] == boardValue && boardItem[6] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL2
                )
                return true
            }

            boardItem[7] == boardValue && boardItem[8] == boardValue && boardItem[9] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL3
                )
                return true
            }

            boardItem[1] == boardValue && boardItem[4] == boardValue && boardItem[7] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL1
                )
                return true
            }

            boardItem[2] == boardValue && boardItem[5] == boardValue && boardItem[8] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL2
                )
                return true
            }

            boardItem[3] == boardValue && boardItem[6] == boardValue && boardItem[9] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL3
                )
                return true
            }

            boardItem[1] == boardValue && boardItem[5] == boardValue && boardItem[9] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.DIAGONAL1
                )
                return true
            }

            boardItem[3] == boardValue && boardItem[5] == boardValue && boardItem[7] == boardValue -> {
                state = state.copy(
                    victoryType = VictoryType.DIAGONAL2
                )
                return true
            }

            else -> return false
        }
    }

    fun isBoardFull(): Boolean {
        return !boardItem.containsValue(BoardCellValue.NONE)
    }

}