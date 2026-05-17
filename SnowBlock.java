import java.awt.Color;

public class SnowBlock extends Block {
    public SnowBlock() {
        super("Snow", new Color(140, 200, 230), true);


}

    @Override
    public String onStep() {
    return "You step on cold snow.";
}
}
