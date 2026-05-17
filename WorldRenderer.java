import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

// ╔══════════════════════════════════════════════════════════╗
// ║  WORLD RENDERER — extends JPanel.                        ║
// ║  Paints the grid first, then the player on top.          ║
// ║  Composition: HAS-A World and HAS-A Player.              ║
// ╚══════════════════════════════════════════════════════════╝
public class WorldRenderer extends JPanel {


    // ╔══════════════════════════════════════════════════════╗
    // ║  STATIC CONSTANTS                                    ║
    // ╚══════════════════════════════════════════════════════╝
    private static final int CELL_SIZE = 32;                          // pixels per grid cell
    private static final Color PLAYER_COLOR = new Color(255, 140, 0); // orange
    private static final Color GRID_LINE = new Color(0, 0, 0, 60);    // faint black (alpha=60)


    // ╔══════════════════════════════════════════════════════╗
    // ║  FIELDS — what we render                             ║
    // ╚══════════════════════════════════════════════════════╝
    private final World world;
    private final Player player;


    // ╔══════════════════════════════════════════════════════╗
    // ║  CONSTRUCTOR — stores refs + sets panel size         ║
    // ╚══════════════════════════════════════════════════════╝
    public WorldRenderer(World world, Player player) {
        this.world = world;
        this.player = player;

        // Calc pixel dimensions: grid size × cell size
        int panelWidth = world.getWidth() * CELL_SIZE;
        int panelHeight = world.getHeight() * CELL_SIZE;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBackground(Color.BLACK);
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  paintComponent — Swing's "draw whatever" hook       ║
    // ║  Step 1: paint every grid cell                       ║
    // ║  Step 2: paint the player on top                     ║
    // ╚══════════════════════════════════════════════════════╝
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ─── Step 1: draw the grid ───
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                Block block = world.getBlockAt(x, y);

                // Fill the cell with the block's color
                g.setColor(block.getColor());
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                // Faint grid line so cells are visible
                g.setColor(GRID_LINE);
                g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // ─── Step 2: draw the player on top ───
        g.setColor(PLAYER_COLOR);
        int px = player.getX() * CELL_SIZE + 4;     // +4 inset for a small margin
        int py = player.getY() * CELL_SIZE + 4;
        g.fillOval(px, py, CELL_SIZE - 8, CELL_SIZE - 8);
    }
}
