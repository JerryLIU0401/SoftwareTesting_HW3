package org.example;

public class BaseballGame {
  private int inningA[];
  private int inningB[];
  private int playerA[];
  private int playerB[];

  public BaseballGame(int[] inningA, int[] inningB, int[] playerA, int[] playerB) throws BaseballGameException {
    this.inningA = inningA;
    this.inningB = inningB;
    this.playerA = playerA;
    this.playerB = playerB;
    // 確認資料無誤的例外檢查
    checkInningException();
    checkPlayerException();
  }

  public void checkInningException() throws BaseballGameException {
    int totalA = 0;
    int totalB = 0;
    for (int i = 0; i < 8; i++) {
      totalA += inningA[i];
      totalB += inningB[i];
    }
    totalA += inningA[8];
    // 測試比數有沒有九局下半
    if (totalB > totalA && inningA.length == 9) {
      if (inningB[8] != 'X') {
        throw new BaseballGameException("Inning must be over.");
      }
    }
    // 測試局數正確
    if (inningA.length != inningB.length) {
      throw new BaseballGameException("Inning must be same counts.");
    }
  }
// 用於計算總和的方法
  public int totalScore(int arr[]){
    int total = 0;
    for (int s : arr) {
      if(s != 'X'){
        total += s;
      }
    }
    return total;
  }

  public void checkPlayerException() throws BaseballGameException {
    // 測試球員有沒有大於九位
    if (playerA.length < 9 || playerB.length < 9) {
      throw new BaseballGameException("Players must more than 9.");
    }
    // 測試分數統計有沒有相同
    if((totalScore(inningA) != totalScore(playerA)) || (totalScore(inningB) != totalScore(playerB))){
      throw new BaseballGameException("Player score and inning score must be same.");
    }

  }

  public int score(){
    return totalScore(inningA) - totalScore(inningB);
  }
}
