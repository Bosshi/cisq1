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

    public void calculateScore() {
        int totalScore = 0;

        for (Round round: rounds) {
            if (round.isFinished()) {
                int attempts = round.getFeedbacks().size();
                totalScore += 5 * (5 - attempts) + 5;
            }
        }

        this.score = totalScore;
    }
}

