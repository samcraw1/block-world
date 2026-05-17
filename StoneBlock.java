import java.awt.Color;

// ╔══════════════════════════════════════════════════════════╗
// ║  CONCRETE SUBCLASS — extends Block.                      ║
// ║  Stone is NOT walkable (collision: player can't pass).   ║
// ╚══════════════════════════════════════════════════════════╝
public class StoneBlock extends Block {

    public StoneBlock() {
        super("Stone", new Color(120, 120, 120), false);
        //     ↑       ↑                          ↑
        //     name    color (gray)               walkable=FALSE — blocks movement
    }

    @Override
    public String onStep() {
        return "Your boots clack on hard stone.";
    }
}
