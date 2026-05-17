import java.awt.Color;

// ╔══════════════════════════════════════════════════════════╗
// ║  CONCRETE SUBCLASS — extends Block.                      ║
// ║  Water is NOT walkable (treats it as a barrier).         ║
// ╚══════════════════════════════════════════════════════════╝
public class WaterBlock extends Block {

    public WaterBlock() {
        super("Water", new Color(60, 110, 200), false);
        //     ↑       ↑                         ↑
        //     name    color (blue)              walkable=FALSE
    }

    @Override
    public String onStep() {
        return "Your feet splash through cold water.";
    }
}
