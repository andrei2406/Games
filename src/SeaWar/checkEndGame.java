package SeaWar;
//Проверяем значения массива на наличие "1" - остались-ли корабли на карте
public class checkEndGame {

    public boolean check(int[][] coords) {
        int len = coords.length;
        boolean result = true;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(coords[i][j] == 1) result = false;
            }
        }
        return result;
    }
}
