public class Move {
    public enum Type { END_TURN }
    public final Type type;

    public Move(Type type) {
        this.type = type;
    }
}