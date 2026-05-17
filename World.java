public class World {

private final int width;
private final int height;
private final Block[][] grid;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Block[width][height];
        buildDefaultWorld();
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  PRIVATE HELPER — paints the starting world          ║
    // ║  Called once from the constructor.                   ║
    // ╚══════════════════════════════════════════════════════╝
    private void buildDefaultWorld() {
        // Fill every cell with grass (nested loop visits each cell once)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new GrassBlock();
            }
        }

        // Stone wall along the top edge (y = 0)
        for (int x = 0; x < width; x++) {
            grid[x][0] = new StoneBlock();
        }

        // Small water pond near the top-left
        grid[5][5] = new WaterBlock();
        grid[6][5] = new WaterBlock();
        grid[5][6] = new WaterBlock();
        grid[6][6] = new WaterBlock();
    }


    // ╔══════════════════════════════════════════════════════╗
    // ║  GETTERS / SETTERS — YOUR TURN                       ║
    // ║  Need: getBlockAt(x,y), setBlockAt(x,y,block),       ║
    // ║        getWidth(), getHeight()                       ║
    // ╚══════════════════════════════════════════════════════╝

    public Block getBlockAt(int x, int y) {
        return grid[x][y];
    }
    public void setBlockAt(int x, int y, Block block) {
        grid[x][y] = block;
    }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

}
