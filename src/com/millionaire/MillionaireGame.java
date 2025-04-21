package com.millionaire;

import java.util.Scanner;

public class MillionaireGame {
    private final Game game;
    private boolean gameOver;
    private int score;
    private final Scanner scanner;

    public MillionaireGame(Question[] questions) {
        this.game = new Game(questions);
        this.scanner = new Scanner(System.in);
        this.gameOver = false;
        this.score = 0;
    }

    public boolean isGameOver() { return gameOver; }
    public int getScore() { return score; }
    public Question getCurrentQuestion() { return game.getCurrentQuestion(); }

    private void start() {
        printWelcomeMessage();
        while (!gameOver && !game.isCompleted()) {
            showCurrentQuestion();
            processUserInput();
        }
    }

    private void processUserInput() {
        Question current = game.getCurrentQuestion();
        int answersCount = current.getAnswers().length;
        int answer = -1;

        while (answer < 0) {
            try {
                System.out.print("\nВаш ответ (1-" + answersCount + "): ");
                answer = scanner.nextInt() - 1;

                if (answer < 0 || answer >= answersCount) {
                    System.out.println("Введите число от 1 до " + answersCount);
                    answer = -1;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число.");
                scanner.nextLine();
            }
        }

        processAnswer(answer);
        System.out.println(
                gameOver ? "\nНеправильно! Игра окончена." :
                        game.isCompleted() ? "\nПоздравляем! Вы ответили на все вопросы!" :
                                "\nПравильно! Следующий вопрос..."
        );
    }

    private static Question[] prepareQuestions() {
        return new Question[] {
                new Question("Сколько будет 2+2?",
                        new String[]{"3", "4", "5", "6"}, 1),

                new Question("Столица России?",
                        new String[]{"Киев", "Москва", "Минск", "Астана"}, 1),

                new Question("Для какого языка программирования используется JVM?",
                        new String[]{"Python", "Java", "C++", "JavaScript"}, 1),

                new Question("Сколько планет в Солнечной системе?",
                        new String[]{"7", "8", "9", "10"}, 1),

                new Question("Кто написал 'Войну и мир'?",
                        new String[]{"Достоевский", "Толстой", "Чехов", "Тургенев"}, 1),

                new Question("Какая самая длинная река в мире?",
                        new String[]{"Амазонка", "Нил", "Янцзы", "Миссисипи"}, 0),

                new Question("В каком году человек полетел в космос?",
                        new String[]{"1957", "1961", "1969", "1975"}, 1),

                new Question("Сколько континентов на Земле?",
                        new String[]{"5", "6", "7", "8"}, 2),

                new Question("Какая самая высокая гора в мире?",
                        new String[]{"Килиманджаро", "Эверест", "Мак-Кинли", "Аконкагуа"}, 1),

                new Question("Какой химический элемент обозначается как 'Au'?",
                        new String[]{"Серебро", "Железо", "Золото", "Алюминий"}, 2),

                new Question("Кто изобрел телефон?",
                        new String[]{"Эдисон", "Тесла", "Белл", "Маркони"}, 2),

                new Question("Какая самая большая страна по площади?",
                        new String[]{"Китай", "США", "Россия", "Канада"}, 2)
        };
    }

    public boolean isGameCompleted() {
        return !gameOver && game.isCompleted();
    }

    private void showCurrentQuestion() {
        Question current = game.getCurrentQuestion();
        System.out.printf("\nВопрос за $%,d:\n", game.getCurrentPrize());
        System.out.println(current.getText());

        String[] answers = current.getAnswers();
        for (int i = 0; i < answers.length; i++) {
            System.out.printf("%d. %s\n", i + 1, answers[i]);
        }
    }

    public void processAnswer(int answerIndex) {
        if (gameOver) return;

        if (game.getCurrentQuestion().checkAnswer(answerIndex)) {
            score = game.getCurrentPrize();
            game.nextQuestion();
            if (game.isCompleted()) {
                gameOver = true;
            }
        } else {
            gameOver = true;
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Добро пожаловать в игру 'Кто хочет стать миллионером'!");
        System.out.println("Отвечайте на вопросы, чтобы выиграть " + formatPrize(1000000) + "!\n");
    }

    public String formatPrize(int amount) {
        return String.format("$%,d", amount);
    }

    public static void main(String[] args) {
        Question[] questions = prepareQuestions();
        new MillionaireGame(questions).start();
    }
}