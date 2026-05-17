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
        // Fill every cell with snow (nested loop visits each cell once)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new SnowBlock();
            }
        }

        // Stone wall along the top edge (mountain ridge)
        for (int x = 0; x < width; x++) {
            grid[x][0] = new StoneBlock();
        }

        // Frozen pond (was water before)
        grid[5][5] = new IceBlock();
        grid[6][5] = new IceBlock();
        grid[5][6] = new IceBlock();
        grid[6][6] = new IceBlock();

        // Scattered ice patches for variety
        grid[12][8]  = new IceBlock();
        grid[13][8]  = new IceBlock();
        grid[15][10] = new IceBlock();
        grid[3][12]  = new IceBlock();
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
