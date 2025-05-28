package ru.itis.inf403.lab11.seria.dz;

import java.io.*;
import java.util.*;

public class Labirint implements Serializable {
	private static final char WALL = '1';
    private static final char PATH = '0';
    private static final char TRACK = '#';
    private static final char PLAYER = '@';
    private static final char START = 'X';

	private final char[][] labirint = {
            {WALL, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, PATH, PATH, PATH, WALL, PATH, WALL},
            {WALL, PATH, WALL, WALL, PATH, WALL, WALL},
            {WALL, PATH, PATH, PATH, PATH, PATH, WALL},
            {WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, PATH, PATH, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, WALL, WALL, PATH, WALL}
    };

	private final char[][] playerView;
    private int posPlayerI;
    private int posPlayerJ;
    private final int exitPosI = 6;
    private final int exitPosJ = 5;
    private int count = 0;


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Labirint labirint;

		System.out.println("1. Новая игра");
		System.out.println("2. Загрузить игру");
		System.out.print("Выберите действие: ");

		int choice  = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1){
			labirint = new Labirint();
		}else if (choice == 2){
			System.out.println("Выберете файл загрузки");
			String fileName = scanner.nextLine();
			labirint = Labirint.loadGame(fileName);

			if (labirint == null){
				System.out.println("Не удалось загрузить игру");
				labirint = new Labirint();
			}
		}else{
			System.out.println("Неверный выбор. Создаем новую игру");
			labirint = new Labirint();
		}

		labirint.play();
	}



	public Labirint(){
		posPlayerI = 0;
		posPlayerJ = 3;

		playerView = new char[labirint.length][labirint.length];
		for (int i = 0; i < labirint.length; ++i){
			for (int j = 0; j < labirint.length; ++j){
				playerView[i][j] = labirint[i][j] == WALL ? WALL : ' ';
			}
		}

		playerView[posPlayerI][posPlayerJ] = START;
		playerView[exitPosI][exitPosJ] = PATH;

	}

	public  void play(){
		Scanner in = new Scanner(System.in);
		System.out.println("Введите команду (W - вверх, S - вниз, D - вправо, A - влево)");
		System.out.println("Вы сейчас здесь - X");
		printField();

		while (true){
			String command = in.nextLine().trim().toUpperCase();

			if (command.equals("SAVE")){
				System.out.println("Введите имя файла сохранения: ");
				String fileName = in.nextLine();
				saveGame(fileName);
				continue;
			}

			if (command.equals("ESC")){
				break;
			}

			char ch = command.charAt(0);

			if (!movePlayer(ch)){
				System.out.println("Неверный ход! Попробуйте снова.");
				continue;
			}

			printField();

			if (posPlayerI == exitPosI && posPlayerJ == exitPosJ){
			 	System.out.println("Поздравляем! Вы вышли из лабиринта за " + count + " шагов.");
                break;
			}

		}
		in.close();
	}


	public boolean movePlayer(char direction){
		int newI = posPlayerI;
		int newJ = posPlayerJ;

		switch (direction) {
			case 'W': newI--; break;
			case 'S': newI++; break;
			case 'A': newJ--; break;
			case 'D': newJ++; break;
			default: return false;
		}

		if (newI < 0 || newI >= labirint.length || newJ < 0 || newJ >= labirint[0].length){
			return false;
		}

		if (labirint[newI][newJ] != PATH){
			return false;
		}

		playerView[posPlayerI][posPlayerJ] = TRACK;
        posPlayerI = newI;
        posPlayerJ = newJ;
        playerView[posPlayerI][posPlayerJ] = PLAYER;
        count++;

		return true;
	}

	public void printField() {
		for (char[] row : playerView){
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

	public void saveGame(String fileName){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){

			oos.writeObject(this);
			System.out.println("Игра сохранена");
		}catch (IOException e){
			System.out.println("Ошибка сохранения");
		}
	}

	public static Labirint loadGame(String fileName){
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){

			Labirint loadedLabirint = (Labirint) ois.readObject();
			return loadedLabirint;
		}catch (IOException | ClassNotFoundException e){
			System.out.println("Ошибка загрузки");;
			return null;
		}
    }
}