package ru.netology.homeworkCollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {
    @Test
    public void shouldWinFirstPlayer() {
        Player player1 = new Player(1, "dimasik14", 100);
        Player player2 = new Player(2, "oleg_49", 50);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("dimasik14", "oleg_49");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        Player player1 = new Player(1, "dimasik14", 50);
        Player player2 = new Player(2, "oleg_49", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("dimasik14", "oleg_49");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Player player1 = new Player(1, "dimasik14", 100);
        Player player2 = new Player(2, "oleg_49", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("dimasik14", "oleg_49");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCatchExceptionFirstPlayer() {
        Player player1 = new Player(1, "dimasik14", 12);
        Player player2 = new Player(2, "oleg_49", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("pashok123", "oleg_49");
        });
    }

    @Test
    public void shouldCatchExceptionSecondPlayer() {
        Player player1 = new Player(1, "dimasik14", 12);
        Player player2 = new Player(2, "oleg_49", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("dimasik14", "sobaka_ybivaka");
        });
    }
}
