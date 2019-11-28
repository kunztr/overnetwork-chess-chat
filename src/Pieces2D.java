public class Pieces2D {
    private String color;
    private String name;
    private String pieceURL;

    //Black pieces
    private String rookB = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Chess_rdt45.svg/90px-Chess_rdt45.svg.png";
    private String pawnB = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Chess_pdt45.svg/90px-Chess_pdt45.svg.png";
    private String kingB = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Chess_kdt45.svg/90px-Chess_kdt45.svg.png";
    private String queenB = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Chess_qdt45.svg/90px-Chess_qdt45.svg.png";
    private String knightB = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Chess_ndt45.svg/90px-Chess_ndt45.svg.png";
    private String bishopB = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Chess_bdt45.svg/90px-Chess_bdt45.svg.png";
    private String[] blackPiece = {rookB, pawnB, kingB, queenB, knightB, bishopB};

    //White pieces
    private String rookW = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Chess_rlt45.svg/90px-Chess_rlt45.svg.png";
    private String pawnW = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Chess_plt45.svg/90px-Chess_plt45.svg.png";
    private String kingW = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Chess_klt45.svg/90px-Chess_klt45.svg.png";
    private String queenW = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Chess_qlt45.svg/90px-Chess_qlt45.svg.png";
    private String knightW = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Chess_nlt45.svg/90px-Chess_nlt45.svg.png";
    private String bishopW = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Chess_blt45.svg/90px-Chess_blt45.svg.png";
    private String[] whitePiece = {rookW, pawnW, kingW, queenW, knightW, bishopW};

    Pieces2D(String color, String name) {
        this.color = color.toLowerCase();
        this.name = name.toLowerCase();
        this.pieceURL = getURL();
    }
    private String getURL() {
        String url = "";
        if (this.color.equals("white")) {
            switch (this.name) {
                case "rook":
                    url = whitePiece[0];
                    break;
                case "pawn":
                    url = whitePiece[1];
                    break;
                case "king":
                    url = whitePiece[2];
                    break;
                case "queen":
                    url = whitePiece[3];
                    break;
                case "knight":
                    url = whitePiece[4];
                    break;
                case "bishop":
                    url = whitePiece[5];
                    break;
                default:
                    break;
            }
            return url;
        }
        else {
            switch (this.name) {
                case "rook":
                    url = blackPiece[0];
                    break;
                case "pawn":
                    url = blackPiece[1];
                    break;
                case "king":
                    url = blackPiece[2];
                    break;
                case "queen":
                    url = blackPiece[3];
                    break;
                case "knight":
                    url = blackPiece[4];
                    break;
                case "bishop":
                    url = blackPiece[5];
                    break;
                default:
                    break;
            }
            return url;
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPieceURL() {
        return pieceURL;
    }
}
