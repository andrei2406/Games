package SeaWar;

import java.util.Random;
//Инициализируем игру
public class InitGame {
    userInput input = new userInput();
    public int mapSize;
    //Генератор случайных чисел
    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
    //Создаем карту игрока User
    public int[][] userCoords() {
        mapSize = Integer.parseInt(input.getUserInput("Set the vertical size of the playing field (number of rows >= 2):"));
        int[][] userCoords = new int[mapSize][mapSize];
        for(int i=0; i<mapSize; i++) {
            int boatSize = Integer.parseInt(input.getUserInput("Row " + i + ", set the warship size (from 1 to " + mapSize + "):"));
            int fPboat = Integer.parseInt(input.getUserInput("Row " + i + ", set the initial coordinate of the warship (from 0 to " + (mapSize-boatSize) + "):"));
            while(boatSize > 0) {
                userCoords[i][fPboat] = 1;
                fPboat++;
                boatSize--;
            }
        }
        return userCoords;
    }
    //Создаем карту игрока Ghost
    public int[][] ghostCoords() {
        int maxBoatSize = mapSize-1; //Максимальный размер корабля
        int minBoatSize = 1;
        int[][] coords = new int[mapSize][mapSize];

        for(int i=0; i < mapSize; i++) { //Для каждой строки на карте
            int boatSize = randInt(minBoatSize, maxBoatSize); // Генерируем размер корабля
            int fPboat = randInt(0, (mapSize - boatSize)); // Генерируем начальную координату корабля
            while(boatSize > 0) { //Для каждой ячейки корабля
                coords[i][fPboat] = 1;
                fPboat++;
                boatSize--;
            }
        }
        return coords;
    }
}
