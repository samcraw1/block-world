import java.awt.Color;

// ╔══════════════════════════════════════════════════════════╗
// ║  ABSTRACT CLASS — cannot be instantiated directly.       ║
// ║  Must be extended by concrete subclasses.                ║
// ║  Holds shared STATE + BEHAVIOR for all block types.      ║
// ╚══════════════════════════════════════════════════════════╝
public abstract class Block {


    // ╔══════════════════════════════════════════════════════╗
    // ║  FIELDS — shared by every block type                 ║
    // ║  `protected` = visible to this class + subclasses    ║
    // ╚══════════════════════════════════════════════════════╝
    protected final String name;
    protected final Color color;
    protected final boolean walkable;


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONSTRUCTOR — called by subclasses via super(...)   ║
    // ║  Abstract classes CAN have constructors even though  ║
    // ║  you can't directly `new` them.                      ║
    // ╚══════════════════════════════════════════════════════╝
    protected Block(String name, Color color, boolean walkable) {
        this.name = name;
        this.color = color;
        this.walkable = walkable;
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONCRETE METHODS — subclasses inherit these AS-IS   ║
    // ╚══════════════════════════════════════════════════════╝
    public String getName()      { return name; }
    public Color getColor()      { return color; }
    public boolean isWalkable()  { return walkable; }


    // ╔══════════════════════════════════════════════════════╗
    // ║  ABSTRACT METHOD — no body, subclasses MUST implement║
    // ║  Forces every Block subclass to define its own onStep║
    // ╚══════════════════════════════════════════════════════╝
    public abstract String onStep();
}
