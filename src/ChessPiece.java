public class ChessPiece {
    String name;


    //1=player1, 2=player2
    //q=queen, k=king, h=knight(horse), b=bishop, r=rook, p=pawn
    //Player1 Rook = 1r, Player2 Queen = 2q
    ChessPiece(String n){
        this.name = n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
