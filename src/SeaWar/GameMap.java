package SeaWar;

import java.util.HashMap;
import java.util.Map;
//Выводим карты игроков
public class GameMap {

    public void drawMap(int[][] ghostCoords, int[][] userCoords) {
        Map<Integer, String> symbol = new HashMap<>();
        symbol.put(0, "\u2591");//Пустая ячейка
        symbol.put(1,"\u2588");//Корабль
        symbol.put(2,"\u25A0");//Попадание
        symbol.put(3,"\u25CB");//Мимо
        int mapSize = ghostCoords.length;

        System.out.print("  ");
        for(int j=0; j<mapSize; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for(int i=0; i<ghostCoords.length; i++) {
            System.out.print(i);
            for(int j=0; j<ghostCoords.length; j++) {
                if(ghostCoords[i][j] == 1) {
                    System.out.print(" " + symbol.get(0));//Если в этой ячейке корабль, скрываем его
                } else {
                    System.out.print(" " + symbol.get(ghostCoords[i][j]));
                }
            }
            System.out.print("  "); //Пробел между картами
            for(int j=0; j<ghostCoords.length; j++) {
                System.out.print(" " + symbol.get(userCoords[i][j]));
            }
            System.out.println();
        }
    }
}
