public class AlwaysEndTurnAgent implements CatanAgent {
    @Override
    public void init(int playerId) { /* nothing needed */ }

    @Override
    public Move chooseMove(GameState state) {
        return new Move(Move.Type.END_TURN);
    }
}