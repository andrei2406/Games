package SeaWar;

public class StartGame {
    public static void main(String[] args) {
        InitGame init = new InitGame();
        GameMap map = new GameMap();
        checkEndGame end = new checkEndGame();
        Game game = new Game();
        int[][] userCoords = init.userCoords();
        int[][] ghostCoords = init.ghostCoords();
        map.drawMap(ghostCoords, userCoords);//Вывод карты
        String guessSwitch = "User";//Переключатель ходов
        boolean check = false;//Проверка наличия оставшихся ходов

        while(!check) {
            if(guessSwitch.equals("User")) {
                ghostCoords = game.getMap(ghostCoords, guessSwitch);
                map.drawMap(ghostCoords, userCoords);//Вывод карты
                check = end.check(ghostCoords);//Проверяем на наличие доступных ячеек
                if(check) System.out.println(guessSwitch + " win!");
                guessSwitch = "Ghost";//Переключаем ход
            }
            else {
                userCoords = game.getMap(userCoords, guessSwitch);
                map.drawMap(ghostCoords, userCoords);//Вывод карты
                check = end.check(userCoords);//Проверяем на наличие доступных ячеек
                if(check) System.out.println(guessSwitch + " win!");
                guessSwitch = "User";//Переключаем ход
            }
        }
    }
}
