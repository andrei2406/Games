package SeaWar;
//Определяем значение массива по указанному индексу, возвращаем код (новое значение для ячейки карты)
public class checkShot {
    public int code;
    
    public int check(int[] shotCoord, int[][] map) {
        switch (map[shotCoord[0]][shotCoord[1]]) {
            case 0 -> {
                code = 3; //Мимо (miss)
                break;
            }
            case 1 -> {
                code = 2; //Попал (hit)
                break;
            }
            case 2, 3 -> {
                code = 4; //Повторное попадание (re-hit)
                break;
            }
        }
        return code;
    }
}
