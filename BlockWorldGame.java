import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// ╔══════════════════════════════════════════════════════════╗
// ║  GAME LAUNCHER — extends JFrame.                         ║
// ║  Wires together World + Player + Renderer + input.       ║
// ╚══════════════════════════════════════════════════════════╝
public class BlockWorldGame extends JFrame {


    // ╔══════════════════════════════════════════════════════╗
    // ║  FIELDS — the 3 things the game owns                 ║
    // ╚══════════════════════════════════════════════════════╝
    private final World world;
    private final Player player;
    private final WorldRenderer renderer;


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONSTRUCTOR — builds everything + wires keyboard    ║
    // ╚══════════════════════════════════════════════════════╝
    public BlockWorldGame() {
        super("Block World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the model + view
        world = new World(20, 15);
        player = new Player("Sam", 10, 8);
        renderer = new WorldRenderer(world, player);

        // Anonymous inner class for keyboard input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKey(e.getKeyCode());
            }
        });
        setFocusable(true);    // JFrame needs focus to get key events

        add(renderer);
        pack();
        setLocationRelativeTo(null);
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  KEY HANDLER — bounds + collision + move + repaint   ║
    // ╚══════════════════════════════════════════════════════╝
    private void handleKey(int keyCode) {
        int newX = player.getX();
        int newY = player.getY();

        switch (keyCode) {
            case KeyEvent.VK_W -> newY--;
            case KeyEvent.VK_S -> newY++;
            case KeyEvent.VK_A -> newX--;
            case KeyEvent.VK_D -> newX++;
            default -> { return; }
        }

        // Bounds check — don't walk off the map
        if (newX < 0 || newX >= world.getWidth())  return;
        if (newY < 0 || newY >= world.getHeight()) return;

        // Collision check — can we walk on this block?
        Block target = world.getBlockAt(newX, newY);
        if (!target.isWalkable()) {
            return;    // blocked by stone or water
        }

        // Move, print the block's message, redraw
        player.setX(newX);
        player.setY(newY);
        System.out.println(target.onStep());    // POLYMORPHISM in action
        renderer.repaint();
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  MAIN — entry point                                  ║
    // ╚══════════════════════════════════════════════════════╝
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlockWorldGame().setVisible(true));
    }
}
