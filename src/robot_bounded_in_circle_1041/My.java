package robot_bounded_in_circle_1041;

public class My {
    public boolean result(String instructions){
        int dir = 0;
        int row = 0;
        int col = 0;

        for (char instruction : instructions.toCharArray()) {
            switch (instruction){
                case 'G':
                    if(dir==0) row--; else if(dir==1)col++;
                    else if(dir==2) row++; else if(dir==3)col--;
                    break;
                case 'L':
                    dir = (dir+3)%4;
                    break;
                case 'R':
                    dir = (dir+1)%4;
                    break;
            }
        }
        if (row == 0 && col == 0
                || (row != 0 || col != 0) && dir != 0)
            return true;
        return false;
    }
}

