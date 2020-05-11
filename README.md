# Tic-Tac-Toe

Tic Tac Toe game in Java Swing with simple user interface.

## Compilation

Use `javac` command to compile java code source. ⚙️

```bash
javac ./Main.java
javac ./src/main/*.java
javac ./src/exception/*.java
```

## Usage

You can switch between console mode and graphical interface mode by enabling one of the lines marked in the main class `Main.java`. Take of the `//` to enable your mode .

```java
import game.*

public class Main{
    public static void main(String[] args) {
        TicTacToe Game;
        //Game = new ConsoleTicTacToe();   //<
        Game = new GraphicTicTacToe();     //<
        Game.play();
    }
}
```

## Jar file
To have the possibility to quickly execute your java program, here is a tip🔥. generate your jar file and run it.
And to do so , try the command :

```bash
jar cvfm xoxo.jar manifest.txt Main.class game/*.class game/except/*.class
```

make sure to update the  `manifest.txt` file .


## How to play ?

### Graphique mode 
Use the numpad to give your the choice. You can also click on a position with the mouse.

> !! colored bars give information about the role **blue** vs **red**

You may have noticed that the title bar is missing, so press `ESC` to close the game ❌.

![Screen graphique mode](/img/screenG.png)

### Console mode 
This mode is a bit easy, enter the X and Y position of your cell

***Exemple:***

```
 :>    3 2
```

![Screen screen mode](/img/screenC.png)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change. Feel free to use this project.

🕹️ Play and Have Fun 😉

