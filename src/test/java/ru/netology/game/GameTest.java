package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.player.Player;

public class GameTest {

    @Test
    public void testWhenPlayer1Stronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Ann", 100);
        Player player2 = new Player(2, "Kate", 90);

        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Ann", "Kate");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2Stronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Bill", 150);
        Player player2 = new Player(2, "Tom", 200);

        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Bill", "Tom");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayersEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Sam", 200);
        Player player2 = new Player(2, "Tom", 200);

        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Sam", "Tom");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayersNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Bill", 150);
        Player player2 = new Player(2, "Tom", 220);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nick", "Dan"));
    }

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Bill", 150);
        Player player2 = new Player(2, "Tom", 220);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nick", "Tom"));
    }

    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Bill", 150);
        Player player2 = new Player(2, "Tom", 220);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Bill", "Dan"));
    }
}
