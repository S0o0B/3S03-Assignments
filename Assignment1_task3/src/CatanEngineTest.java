import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CatanEngineTest {

    // Spy agent: records whether it was called
    static class SpyAgent implements CatanAgent {
        int calls = 0;

        @Override
        public void init(int playerId) {}

        @Override
        public Move chooseMove(GameState state) {
            calls++;
            return new Move(Move.Type.END_TURN);
        }
    }

    @Test
    void step_callsAgentAndAdvancesTurn() {
        SpyAgent a0 = new SpyAgent();
        SpyAgent a1 = new SpyAgent();

        CatanEngine engine = new CatanEngine(List.of(a0, a1));

        assertEquals(0, engine.getState().getTurnNumber());
        assertEquals(0, engine.getState().getCurrentPlayer());

        engine.step(); // player 0 acts

        assertEquals(1, a0.calls);
        assertEquals(0, a1.calls);
        assertEquals(1, engine.getState().getTurnNumber());
        assertEquals(1, engine.getState().getCurrentPlayer());
    }
}