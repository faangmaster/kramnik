public class Main {
    public static double WIN_PROBABILITY = 0.88;
    public static double TOTAL_NUMBER_OF_GAMES = 10_000;
    public static int MIN_WIN_STREAK_TO_FIND = 46;
    public static int NUMBER_OF_SIMULATIONS = 10_000;

    public static void main(String[] args) {
        int success = 0;
        for (int s = 0; s < NUMBER_OF_SIMULATIONS; s++) {
            int currentStreakLength = 0;
            int numberOfFoundLongStreak = 0;
            boolean isNewWinStreak = true;
            for (int i = 0; i < TOTAL_NUMBER_OF_GAMES; i++) {
                boolean currentGameResult = play();
                if (currentGameResult) {
                    currentStreakLength++;
                } else {
                    currentStreakLength = 0;
                    isNewWinStreak = true;
                }
                if (isNewWinStreak && currentStreakLength >= MIN_WIN_STREAK_TO_FIND) {
                    numberOfFoundLongStreak++;
                    isNewWinStreak = false;
                }
            }
            if (numberOfFoundLongStreak > 0) {
                success++;
            }
        }
        double probability = ((double) success) / ((double) NUMBER_OF_SIMULATIONS);
        System.out.println(probability);
    }

    private static boolean play() {
        return Math.random() < WIN_PROBABILITY;
    }
}
