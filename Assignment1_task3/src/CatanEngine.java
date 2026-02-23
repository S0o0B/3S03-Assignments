import java.util.List;

public class CatanEngine {
    private final List<CatanAgent> agents;
    private final GameState state = new GameState();

    public CatanEngine(List<CatanAgent> agents) {
        this.agents = agents;
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).init(i);
        }
    }

    public GameState getState() {
        return state;
    }

    // One engine step: ask current agent -> apply move -> advance turn
    public void step() {
        int p = state.getCurrentPlayer();
        Move move = agents.get(p).chooseMove(state);

        // Minimal apply: only END_TURN exists in this demo
        if (move == null) throw new IllegalArgumentException("Agent returned null move");
        if (move.type != Move.Type.END_TURN) throw new IllegalArgumentException("Unsupported move: " + move.type);

        state.advanceTurn(agents.size());
    }
}