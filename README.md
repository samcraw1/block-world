# Block World

A 2D tile-based block world built in pure Java with Swing — no game engine, no external libraries.

## Demo

WASD to move. Walk on grass freely. Stone and water block movement.

```
🟢 grass    ⬜ stone    🔵 water    🟠 player
```

## Architecture

8 files demonstrating all four OOP pillars:

| File | Role | OOP concept |
|------|------|-------------|
| `Block.java` | Abstract parent class | Abstraction + encapsulation |
| `GrassBlock.java` | Walkable, prints message on step | Inheritance |
| `StoneBlock.java` | Blocks movement | Inheritance |
| `WaterBlock.java` | Blocks movement | Inheritance |
| `World.java` | 2D grid (`Block[][]`) holding any block subclass | Polymorphism (storage) |
| `Player.java` | Position + name data class | Encapsulation |
| `WorldRenderer.java` | JPanel painting grid + player | Composition + custom Swing rendering |
| `BlockWorldGame.java` | JFrame launcher + WASD KeyListener + BGM | Composition + event handling |
| `MusicPlayer.java` | Looping background audio (reused from my music-player project) | Composition across projects |

The `target.onStep()` call in `BlockWorldGame.handleKey()` is polymorphism in action — game code calls it on any `Block` and Java dispatches to the correct subclass implementation. No `instanceof` checks, no type switching.

## Run it

The audio file isn't committed (binaries kept out of git). Drop any `.wav` file in this folder named `drake-views.wav` (or update the filename in `BlockWorldGame.java`), then:

```bash
javac *.java
java BlockWorldGame
```

Convert any mp3 to wav with `afconvert` (Mac built-in) or any online converter.

## Tech

- Java 25 (works on Java 11+)
- Java Swing (`JFrame`, `JPanel`, custom `paintComponent`)
- No external dependencies, no Maven/Gradle needed

## Phase 1 (current)

- Abstract block hierarchy + 2D grid world
- Swing rendering with custom `paintComponent`
- WASD movement with collision detection
- Polymorphic block behavior (`onStep()`)

## Future phases

- **Phase 2** — mouse click to place/break blocks, inventory bar, save/load world to text file (file I/O)
- **Phase 3** — procedural terrain generation, multiple worlds, sprite-based rendering
