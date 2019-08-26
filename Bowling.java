package nadiatests;

// https://gist.github.com/mfine/13db6981ad7fda748a1c75d9c9c5c734
// Swift Nav

public class Bowling {

    public static Integer calculateTotal (int[] scores) {
    	int totalGameScore = 0, totalFrameScore = 0,  frameCount = 0;
        Boolean firstRoll = true;
    	for (int i=0 ; i< scores.length ; i++) {
            int score = scores[i];
            if (score == 10) { // strike  - add the next 2 roll scors to this frame
              if (i+2 < scores.length) {
                totalGameScore += score + scores[i+1] + scores[i+2];
              } else {
                totalGameScore += score;
              }
              frameCount++;
            } else {
              if (firstRoll) {
                  totalFrameScore += score;
                  firstRoll = false;
              } else {
                //second roll
                if (totalFrameScore + score == 10) { // spare - add next roll count to this one
                  if (i+1 < scores.length) {
                    totalFrameScore = totalFrameScore + score + scores[i+1];
                  } else {
                    totalFrameScore += score;
                  }
                  totalGameScore += totalFrameScore;
                } else {
                  totalFrameScore += score;
                  totalGameScore += totalFrameScore;
                }
                frameCount++;
                totalFrameScore = 0;
                firstRoll = true;
              }
            }
            if (frameCount == 10) {
                return totalGameScore;
            }
      }
      return totalGameScore;
    }

    public static void main(String[] argc) {
        int gutter[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int ones[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; //score [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] == 20
        int perfect[] = {10,10,10,10,10,10,10,10,10,10,10,10};  //score [10,10,10,10,10,10,10,10,10,10,10,10] == 300
        int sam[] = {8,2,5,4,9,0,10,10,5,5,5,3,6,3,9,1,9,1,10}; //score [8,2,5,4,9,0,10,10,5,5,5,3,6,3,9,1,9,1,10] == 149
        int sara[] = {3,5,10,3,7,8,1,10,10,6,2,5,4,7,3,10,6,3}; //score [3,5,10,3,7,8,1,10,10,6,2,5,4,7,3,10,6,3] == 155
        int ivan[] = {10,10,10,10,10,10,10,10,10,10,5,2}; //score [10,10,10,10,10,10,10,10,10,10,5,2] == 282
        int irena[] = {10,10,10,10,10,10,10,10,10,5,2};   //score [10,10,10,10,10,10,10,10,10,5,2] == 259

        System.out.println("gutter  answer=0   score="+calculateTotal(gutter));
        System.out.println("ones    answer=20  score="+calculateTotal(ones));
        System.out.println("perfect answer=300 score="+calculateTotal(perfect));
        System.out.println("sam     answer=149 score="+calculateTotal(sam));
        System.out.println("sara    answer=155 score="+calculateTotal(sara));
        System.out.println("ivan    answer=282 score="+calculateTotal(ivan));
        System.out.println("irena   answer=259 score="+calculateTotal(irena));

    }



}
