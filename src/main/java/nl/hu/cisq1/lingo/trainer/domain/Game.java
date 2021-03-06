package nl.hu.cisq1.lingo.trainer.domain;

import lombok.Data;

import java.util.List;

@Data
public class Game {
    private int score;
    private GameStatus gameStatus;
    private List<Round> rounds;

    public Game(GameStatus gameStatus, List<Round> rounds) {
        this.score = 0;
        this.gameStatus = gameStatus;
        this.rounds = rounds;
    }

    public Round provideRound(Word toGuessWord) {
        this.calculateScore();

        Round round = new Round(toGuessWord);
        this.rounds.add(round);

        return round;
    }

    public void calculateScore() {
        int totalScore = 0;

        for (Round round: rounds) {
            if (round.isRoundCompleted()) {
                int attempts = round.getFeedbacks().size();
                totalScore += 5 * (5 - attempts) + 5;
            }
        }

        this.score = totalScore;
    }
}

