Feature: Start a new game
  As a Player,
  I would like to start a new game,
  So that I could start practicing and thus advance my capability in guessing the words.

  Scenario: Game has started
    When I start the game
    Then I should see the first letter of the five letter word
    And I have to be able to start guessing the word

Feature: Start a new round
  As a Player,
  I would like to start a new round,
  So that I could continue guessing words until I Fail 5 times in a row.

  Scenario Outline: Round has started
    Given I have already started a game
    And The previous word was a "<previous_length>" letter word
    When I start the round
    Then I should see a "<next_length>" letter word

    Examples:
      | previous_length | next_length |
      | 5               | 6           |
      | 6               | 7           |
      | 7               | 5           |

Feature: Guess the word
  As a Player,
  I would like to have a chance to guess the word,
  So that I could train my capability and gain points based on my performance.

  Scenario: Start guessing
    Given I have started the round
    When The "5" letter word appears
    Then I can have a try to guess it