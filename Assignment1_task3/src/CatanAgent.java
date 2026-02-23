public interface CatanAgent {
    void init(int playerId);
    Move chooseMove(GameState state);
}