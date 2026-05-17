import java.awt.Color;

// ╔══════════════════════════════════════════════════════════╗
// ║  CONCRETE SUBCLASS — extends the abstract Block.         ║
// ║  Must provide bodies for ALL abstract methods.           ║
// ╚══════════════════════════════════════════════════════════╝
public class GrassBlock extends Block {


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONSTRUCTOR — no params needed.                     ║
    // ║  GrassBlock "knows" what a Grass is — hardcodes the  ║
    // ║  3 values to feed the parent constructor via super().║
    // ╚══════════════════════════════════════════════════════╝
    public GrassBlock() {
        super("Grass", new Color(60, 160, 60), true);
        //     ↑       ↑                       ↑
        //     name    color (green)           walkable=true
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  OVERRIDDEN ABSTRACT METHOD                          ║
    // ║  Block declared `abstract String onStep()` — every   ║
    // ║  subclass MUST implement it. Here's grass's version. ║
    // ╚══════════════════════════════════════════════════════╝
    @Override
    public String onStep() {
        return "You step on soft grass.";
    }
}
