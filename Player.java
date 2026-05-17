// ╔══════════════════════════════════════════════════════════╗
// ║  PLAYER — holds position + name.                         ║
// ║  Movement logic lives in the game (not here).            ║
// ║  Player just stores WHERE they are.                      ║
// ╚══════════════════════════════════════════════════════════╝
public class Player {


    // ╔══════════════════════════════════════════════════════╗
    // ║  FIELDS                                              ║
    // ║  name = final (identity, doesn't change)             ║
    // ║  x, y = mutable (player moves)                       ║
    // ╚══════════════════════════════════════════════════════════╗
    private final String name;
    private int x;
    private int y;


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONSTRUCTOR                                         ║
    // ╚══════════════════════════════════════════════════════╝
    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  GETTERS                                             ║
    // ╚══════════════════════════════════════════════════════╝
    public String getName()  { return name; }
    public int getX()        { return x; }
    public int getY()        { return y; }


    // ╔══════════════════════════════════════════════════════╗
    // ║  SETTERS — only for mutable fields                   ║
    // ║  (no setName because name is final = unchangeable)   ║
    // ╚══════════════════════════════════════════════════════╝
    public void setX(int x)  { this.x = x; }
    public void setY(int y)  { this.y = y; }
}
