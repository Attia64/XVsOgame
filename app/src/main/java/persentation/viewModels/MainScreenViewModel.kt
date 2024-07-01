package persentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        if(boardItem[cellNo] != BoardCellValue.NONE) {
            return
        }
        if(state.currentTurn == BoardCellValue.O) {
            boardItem[cellNo] = BoardCellValue.O
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

        }
       else if(state.currentTurn == BoardCellValue.X) {
            boardItem[cellNo] = BoardCellValue.X
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

     fun isBoardFull(): Boolean {
        return !boardItem.containsValue(BoardCellValue.NONE)
    }

}