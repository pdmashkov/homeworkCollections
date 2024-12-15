package ru.netology.homeworkCollections;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }

        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок: " + playerName1 + " не зарегистрирован, соревнование невозможно");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок: " + playerName2 + " не зарегистрирован, соревнование невозможно");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
