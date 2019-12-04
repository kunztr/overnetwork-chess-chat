import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class chessGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final int DIMENSION = 8;
    private ChessPiece[][] gamegrid = new ChessPiece[DIMENSION][DIMENSION];
    private GridPane board = new GridPane();
    private BorderPane face = new BorderPane();
    private Boolean isSelected = false;
    private int[] selected;
    private int[] target;
    @Override
    public void start(Stage st) {
        board.setPadding(new Insets(5));
        board.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        board.setMaxSize(500,500);
        gameBoard();
        setInitGameBoard();
        printGameBoard();
        //testGame();
        face.setCenter(board);
        //pane.setRotate(180);
        Scene scene2 = new Scene(face);

        VBox startPane = new VBox();
        startPane.setPadding(new Insets(10));
        startPane.setPrefSize(250,200);

        Label name = new Label("Game of Chess");
        name.setFont(new Font(25));

        Label IPLabel = new Label("Enter IP Address");
        TextField IP = new TextField();
        IP.setMaxWidth(200);

        Label PortLabel = new Label("Enter Port");
        TextField Port = new TextField();
        Port.setMaxWidth(200);

        Button button1 = new Button("Start Game");
        button1.setPadding(new Insets(20));
        button1.setOnAction(e ->
                st.setScene(scene2)
        );
        startPane.getChildren().addAll(IPLabel, IP, PortLabel, Port);
        board.getChildren();
        BorderPane startBP = new BorderPane();
        startBP.setCenter(startPane);
        startBP.setBottom(button1);
        startBP.setTop(name);
        startBP.setAlignment(name, Pos.CENTER);
        startBP.setAlignment(button1, Pos.BOTTOM_RIGHT);
        Scene scene = new Scene(startBP);
        st.setResizable(false);
        st.setTitle("Chess");
        st.setScene(scene);
        st.show();
    }
    private void gameBoard(){
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                Rectangle rect = new Rectangle(75, 75);
                rect.setStroke(Color.BURLYWOOD);
                if ((i + j) % 2 == 0) {
                    rect.setFill(Color.MOCCASIN);
                } else {
                    rect.setFill(Color.BEIGE);
                }
                rect.setOnMouseClicked(e -> {
                    int column = board.getColumnIndex((Node) e.getSource());
                    int row = board.getRowIndex((Node) e.getSource());
                    if (!isSelected) {
                        flash(getRectangle(row, column), isSelected);
                        isSelected = true;
                    }
                    getPiece(row,column);
//                    if (selected.length == 0) {
//                        selected = new int[]{column, row};
//                    }
//                    else {
//                        target = new int[]{column, row};
//
//                    }
                    //getRectangle(row, column).getFill();
                    //getPiece(row,column);

                });
                board.add(rect, j, i);
            }
        }
    }
    private void flash(Node n, Boolean off) {
        FadeTransition ft = new FadeTransition(Duration.millis(600), n);
        if (!off) {
            //FadeTransition ft = new FadeTransition(Duration.millis(600), n);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setAutoReverse(true);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.play();
        }
        else {
            ft.pause();
        }
    }

    private ImageView getPiece(int row, int col) {
        if (col <= board.getColumnCount() && row <= board.getRowCount()) {
            for (Node node : board.getChildren()) {
                if (node instanceof ImageView && GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                    board.getChildren().remove(node);
                }
            }
        }
//        System.out.println(gamegrid[row][col].getName());
//        String player;
//        String name;
//        if (gamegrid[row][col].getName().startsWith("1")){
//            player = "white";
//        }
//        else if (gamegrid[row][col].getName().startsWith("2")){
//            player = "black";
//        }
//        else {
//            return null;
//        }
//
//        if (gamegrid[row][col].getName().endsWith("r")){
//            name = "rook";
//        }
//        else if (gamegrid[row][col].getName().endsWith("n")){
//            name = "knight";
//        }
//        else if (gamegrid[row][col].getName().endsWith("b")){
//            name = "bishop";
//        }
//        else if (gamegrid[row][col].getName().endsWith("k")){
//            name = "king";
//        }
//        else if (gamegrid[row][col].getName().endsWith("q")) {
//            name = "queen";
//        }
//        else{
//            name = "pawn";
//        }
//        System.out.println(player + name);
//        Pieces2D piece = new Pieces2D(player, name);
//        ImageView imgView = new ImageView(new Image(piece.getPieceURL()));
//        imgView.setFitHeight(75);
//        imgView.setFitWidth(75);
//        if (piece.getColor().equals("black")) {
//            imgView.setRotate(180);
//        }
//        return imgView;
        return null;
    }
    private Rectangle getRectangle(int row, int col) {
        if (col <= board.getColumnCount() && row <= board.getRowCount()) {
            for (Node node : board.getChildren()) {
                if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                    return (Rectangle)node;
                }
            }
        }
        return null;
    }
    //Sets initial game board grid
    private void setInitGameBoard() {
        for (int y = gamegrid.length - 1; y >= 0; y--) {
            for (int x = 0; x < gamegrid.length; x++) {
                ChessPiece cp = new ChessPiece("00");
                Pieces2D piece = new Pieces2D("null", "null");;

                //black side and also player 2
                if (y == 1) {
                    cp.setName(2 + "p");
                    piece = new Pieces2D("black", "pawn");
                }
                else if (y == 0) {
                    if (x == 0 || x == 7) {
                        cp.setName(2 + "r");
                        piece = new Pieces2D("black", "rook");
                    } else if (x == 1 || x == 6) {
                        cp.setName(2 + "n");
                        piece = new Pieces2D("black", "knight");
                    } else if (x == 2 || x == 5) {
                        cp.setName(2 + "b");
                        piece = new Pieces2D("black", "bishop");
                    } else if (x == 3) {
                        cp.setName(2 + "k");
                        piece = new Pieces2D("black", "king");
                    } else if (x == 4) {
                        cp.setName(2 + "q");
                        piece = new Pieces2D("black", "queen");
                    }
                }
                //white side and also player 1
                else if (y == 6) {
                    cp.setName(1 + "p");
                    piece = new Pieces2D("white", "pawn");
                }
                else if (y == 7) {
                    if (x == 0 || x == 7) {
                        cp.setName(1 + "r");
                        piece = new Pieces2D("white", "rook");
                    } else if (x == 1 || x == 6) {
                        cp.setName(1 + "n");
                        piece = new Pieces2D("white", "knight");
                    } else if (x == 2 || x == 5) {
                        cp.setName(1 + "b");
                        piece = new Pieces2D("white", "bishop");
                    } else if (x == 3) {
                        cp.setName(1 + "q");
                        piece = new Pieces2D("white", "queen");
                    } else {
                        cp.setName(1 + "k");
                        piece = new Pieces2D("white", "king");
                    }
                }
                gamegrid[y][x] = cp;
                if (!piece.getColor().equals("null")) {
                    ImageView imgView = new ImageView(new Image(piece.getPieceURL()));
                    imgView.setFitHeight(75);
                    imgView.setFitWidth(75);
                    if (piece.getColor().equals("black")) {
                        imgView.setRotate(180);
                    }
                    board.add(imgView, x, y);
                }
            }
        }
    }

    //Moves piece on grid.
    //xO = old x coordinate, xN = new x coordinate, c = ChessPiece selected
    private void movePiece(int xO, int yO, int xN, int yN){
        ChessPiece temp = gamegrid[yO][xO];
        gamegrid[yO][xO] = new ChessPiece("00");
        gamegrid[yN][xN] = temp;
        printGameBoard();
        int[] kingCoordinates = findKingCoordinates();
        boolean check = isInCheck(kingCoordinates[0], kingCoordinates[1]);
        if(check){
            System.out.println("After moving a " + gamegrid[yN][xN].name + ", your king IS in check.");
        }
        else{
            System.out.println("After moving a " + gamegrid[yN][xN].name + ", your king IS NOT in check.");
        }
        //boolean checkmate = isInCheckmate();
    }

    private int[] findKingCoordinates(){
        int[] coordinates = new int[2];
        for (int y = 0; y < gamegrid.length; y++) {
            for (int x = 0; x < gamegrid.length; x++) {
                if (gamegrid[y][x].name.equals("1k"))
                {
                    coordinates[0] = x;
                    coordinates[1] = y;
                }
            }
        }
        //System.out.println("King: X:" + coordinates[0] + ", Y:" + coordinates[1]);
        return coordinates;
    }

    //Returns true if player 1 king is in check. The 2 parameters are the king's coordinates
    private boolean isInCheck(int xCoor, int yCoor) {

        //Pawns
        if(gamegrid[yCoor][xCoor].checkPawn(gamegrid, xCoor, yCoor)){
            return true;
        }
        //Knights
        else if(gamegrid[yCoor][xCoor].checkKnight(gamegrid, xCoor, yCoor)){
            return true;
        }
        //Rooks & Queen
        else if(gamegrid[yCoor][xCoor].checkRook(gamegrid, xCoor, yCoor)){
            return true;
        }
        //Bishops & Queen
        else if(gamegrid[yCoor][xCoor].checkBishop(gamegrid, xCoor, yCoor)){
            return true;
        }
        else if(gamegrid[yCoor][xCoor].checkKing(gamegrid, xCoor, yCoor)){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isInCheckmate(){
        //Finds king
        int[] kCoor = findKingCoordinates();
        int xCoor = kCoor[0];
        int yCoor = kCoor[1];
        boolean checkmate = false;
        int[][] kings = {{-1, -1},{0, -1},{1, -1},{1, 0},{1, 1},{0, 1},{-1, 1},{-1, 0}};//Possible opposing king locations relative to king

        for(int m = 0; m < kings.length; m++) {
            if(xCoor + kings[m][0] >= 0 && xCoor + kings[m][0] < gamegrid.length && yCoor + kings[m][1] >= 0 && yCoor + kings[m][1] < gamegrid.length){
                checkmate = isInCheck(kings[m][0], kings[m][1]);
            }
        }
        return checkmate;
    }

    //For testing
    private void printGameBoard(){
        System.out.println("\n\n");
        System.out.println("  0  1  2  3  4  5  6  7");
        for(int y = 0; y < gamegrid.length; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < gamegrid.length; x++) {
                System.out.print(gamegrid[y][x].getName() + " ");
            }
            System.out.println();
        }
    }
    //private void testGame(){
    //    movePiece(4, 6, 3, 5);
    //    movePiece(3, 6, 0, 2);
//
    //   // movePiece(4, 0, 1, 4);
    //    movePiece(6, 0, 5, 5);
    //    //printGameBoard();
//
    //}
}
