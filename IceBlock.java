import java.awt.Color;

public class IceBlock extends Block {

    public IceBlock() {
        super("Ice", new Color(140, 200, 230), true);
    
    }

    @Override
    public String onStep() {
        return "You step on slippery ice.";

    }

}
