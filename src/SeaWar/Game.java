package SeaWar;

public class Game {

    public int[][] getMap(int[][] map, String guessSwitch) {
        userInput input = new userInput();
        InitGame init = new InitGame();
        checkShot shot = new checkShot();
        int[] coord = new int[2];
        int code = 0;
        boolean R = true;

        while(R) {//Проверка на повторное попадание и повторный вывод предложения сделать ход
            if(guessSwitch.equals("User")) {
                String[] str = input.getUserInput(guessSwitch + "'s move (row,column):").split(",");
                for(int i=0; i<str.length; i++) {
                    coord[i] = Integer.parseInt(str[i]);
                }
            }
            else {
                coord[0] = init.randInt(0, map.length-1);
                coord[1] = init.randInt(0, map.length-1);
                System.out.println(guessSwitch + "'s move (row,column):" + coord[0] + "," + coord[1]);
            }
            code = shot.check(coord, map);//Проверяем попадание
            switch (code) {
                case 2 -> {
                    System.out.println(guessSwitch + " hit!");
                    R = false;
                    break;
                }
                case 3 -> {
                    System.out.println(guessSwitch + " missed!");
                    R = false;
                    break;
                }
                case 4 -> {
                    if(!guessSwitch.equals("user")) System.out.println(guessSwitch + " re-hit!");
                    break;
                }
            }
        }
        System.out.println();
        map[coord[0]][coord[1]] = code;//Перезаписываем ячейку
        return map;
    }
}
