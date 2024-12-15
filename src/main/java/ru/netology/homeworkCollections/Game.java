package ru.netology.homeworkCollections;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String playerName) {
        for (String key : players.keySet()) {
            if (players.get(key).getName().equals(playerName)) {
                return players.get(key);
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
