//Simple Simulation
//T.C : O(m + n * maxValCommand), m = size of obstacles, n = size of commands
//S.C : O(m)

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String>set = new HashSet<>();

        for( int [] a : obstacles) {
            String x = Integer.toString(a[0]);
            String y = Integer.toString(a[1]);

            String key = x + "_" + y;

            set.add(key);
        }

        int x = 0;
        int y = 0;

        int max = 0;

        //pointing to the north
        int [] dir = new int [] {0,1};

        for(int i=0 ; i<commands.length ; i++) {
            if(commands[i] == -2) {
                dir = new int [] {-dir[1] , dir[0]};
            }
            else if(commands[i] == -1) {
                dir = new int []  {dir[1] , -dir[0]};
            }
            else {
                //move to the direction

                for(int step=0; step<commands[i] ; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String key = Integer.toString(newX) + "_" + Integer.toString(newY);

                    if(set.contains(key) ) {
                        break;
                    }

                    x = newX;
                    y = newY;
                }
                
                max = Math.max(max , x*x + y*y);
            }
        }

        return max;
    }
}