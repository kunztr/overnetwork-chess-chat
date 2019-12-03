public class ChessPiece {
    String name;


    //1=player1, 2=player2
    //q=queen, k=king, n=knight, b=bishop, r=rook, p=pawn
    //Example: Player1 Rook = 1r, Player2 Queen = 2q
    ChessPiece(String n){
        this.name = n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkPawn(ChessPiece[][] grid, int x, int y){
        if((y - 1 >= 0 && grid[y - 1][x].name.equals("2p")) ||
                (y - 1 >= 0 && x - 1 >= 0 && grid[y - 1][x - 1].name.equals("2p")) ||
                (y - 1 >= 0 && x + 1 < grid.length && grid[y - 1][x + 1].name.equals("2p"))){
            return true;
        }
        return false;
    }

    public boolean checkKnight(ChessPiece[][] grid, int x, int y){
        int[][] knights = {{-2, -1},{-1, -2},{1, -2},{2, -1},{-2, 1},{-1, 2},{1, 2},{2, 1}};//Possible opposing knight positions relative to king
        for(int m = 0; m < knights.length; m++) {
            if(x + knights[m][0] >= 0 && x + knights[m][0] < grid.length && y + knights[m][1] >= 0 && y + knights[m][1] < grid.length &&
            grid[y + knights[m][1]][x + knights[m][0]].name.equals("2n")){
                return true;
            }
        }
        return false;
    }

    public boolean checkRook(ChessPiece[][] grid, int x, int y){
        //Checks right of king
        int currentX = x;
        while(currentX < grid.length){
            if(grid[y][currentX].name.equals("2r") || grid[y][currentX].name.equals("2q")){
                return true;
            }
            if(!(grid[y][currentX].name.equals("1k")) && !(grid[y][currentX].name.equals("00"))){
                break;
            }
            currentX++;
        }
        //Checks left of king
        currentX = x;
        while(currentX >= 0){
            if(grid[y][currentX].name.equals("2r") || grid[y][currentX].name.equals("2q")){
                return true;
            }
            if(!(grid[y][currentX].name.equals("1k")) && !(grid[y][currentX].name.equals("00"))){
                break;
            }
            currentX--;
        }
        //Checks below king
        int currentY = y;
        while(currentY < grid.length){
            if(grid[currentY][x].name.equals("2r") || grid[currentY][x].name.equals("2q")){
                return true;
            }
            if(!(grid[currentY][x].name.equals("1k")) && !(grid[currentY][x].name.equals("00"))){
                break;
            }
            currentY++;
        }
        //Checks above king
        currentY = y;
        while(currentY >= 0){
            if(grid[currentY][x].name.equals("2r") || grid[currentY][x].name.equals("2q")){
                return true;
            }
            if(!(grid[currentY][x].name.equals("1k")) && !(grid[currentY][x].name.equals("00"))){
                break;
            }
            currentY--;
        }
        return false;
    }

    public boolean checkBishop(ChessPiece[][] grid, int x, int y) {
        int currentX = x;
        int currentY = y;
        //Down right
        while (currentX < grid.length && currentY < grid.length) {
            if (grid[currentY][currentX].name.equals("2b") || grid[currentY][currentX].name.equals("2q")) {
                return true;
            }
            if (!(currentX == x) && !(currentY == y) && !(grid[currentY][x].name.equals("00"))) {
                break;
            }
            currentX++;
            currentY++;
        }
        currentX = x;
        currentY = y;
        //Up right
        while (currentX < grid.length && currentY >= 0) {
            if (grid[currentY][currentX].name.equals("2b") || grid[currentY][currentX].name.equals("2q")) {
                return true;
            }
            if (!(currentX == x) && !(currentY == y) && !(grid[currentY][x].name.equals("00"))) {
                break;
            }
            currentX++;
            currentY--;
        }
        currentX = x;
        currentY = y;
        //Up left
        while (currentX >= 0 && currentY >= 0) {
            if (grid[currentY][currentX].name.equals("2b") || grid[currentY][currentX].name.equals("2q")) {
                return true;
            }
            if (!(currentX == x) && !(currentY == y) && !(grid[currentY][x].name.equals("00"))) {
                break;
            }
            currentX--;
            currentY--;
        }
        currentX = x;
        currentY = y;
        //Down left
        while(currentX >= 0 && currentY < grid.length){
            if(grid[currentY][currentX].name.equals("2b") || grid[currentY][currentX].name.equals("2q")){
                return true;
            }
            if(!(currentX == x) && !(currentY == y) && !(grid[currentY][x].name.equals("00"))){
                break;
            }
            currentX--;
            currentY++;
        }
        return false;
    }

    public boolean checkKing(ChessPiece[][] grid, int x, int y){
        int[][] kings = {{-1, -1},{0, -1},{1, -1},{1, 0},{1, 1},{0, 1},{-1, 1},{-1, 0}};//Possible opposing king locations relative to king
        for(int m = 0; m < kings.length; m++) {
            if(x + kings[m][0] >= 0 && x + kings[m][0] < grid.length && y + kings[m][1] >= 0 && y + kings[m][1] < grid.length &&
                    grid[y + kings[m][1]][x + kings[m][0]].name.equals("2k")){
                return true;
            }
        }
        return false;
    }

    }
