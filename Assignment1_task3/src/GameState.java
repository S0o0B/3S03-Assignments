public class GameState {
    private int currentPlayer = 0;
    private int turnNumber = 0;

    public int getCurrentPlayer() { return currentPlayer; }
    public int getTurnNumber() { return turnNumber; }

    void advanceTurn(int numPlayers) {
        turnNumber++;
        currentPlayer = (currentPlayer + 1) % numPlayers;
    }
}