package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {
  @Test
  public void testBaseballGame(){
    int[] inningA = {1, 0 ,0, 0, 1, 0, 1, 2, 1}; // 6
    int[] playerA = {0, 2, 0, 3, 0, 0, 0, 0, 1}; // 6
    int[] inningB = {0, 0, 0, 0, 1, 0, 0, 0, 0}; // 1
    // 球員大於9
    int[] playerB = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}; // 1
    // 提早結束的情況
    int[] inningC = {0, 2, 1, 1, 0, 0, 2, 1, 'X'}; // 7
    int[] playerC = {1, 0, 0, 3, 1, 0, 0, 0, 1, 1, 0}; // 7
    // 局數超過9的情況
    int[] inningD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4};
    int[] inningE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3};

    assertAll("Game",
            ()-> assertEquals(5, new BaseballGame(inningA, inningB, playerA, playerB).score()),
            ()-> assertEquals(-6, new BaseballGame(inningB, inningC, playerB, playerC).score()),
            ()-> assertEquals(-1, new BaseballGame(inningA, inningC, playerA, playerC).score()),
            ()-> assertEquals(1, new BaseballGame(inningD, inningE, playerC, playerA).score())
            );
  }
}