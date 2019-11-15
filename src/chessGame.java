import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;

public class chessGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final int DIMENSION = 8;
    private int[][] gamegrid = new int[DIMENSION][DIMENSION];
    private BorderPane pane = new BorderPane();
    private GridPane gp = new GridPane();
    private Boolean isSelected = false;
    @Override
    public void start(Stage st) {
        gp.setPadding(new Insets(5));
        gp.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        gp.setMaxSize(500,500);
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                Rectangle cr = new Rectangle(75, 75);
                cr.setStroke(Color.BURLYWOOD);
                if ((i + j) % 2 == 0) {
                    cr.setFill(Color.MOCCASIN);
                } else {
                    cr.setFill(Color.BEIGE);
                }
                cr.setOnMouseClicked(e -> {
                    int column = gp.getColumnIndex((Node) e.getSource());
                    int row = gp.getRowIndex((Node) e.getSource());
                    if (!isSelected) {
                        flash(getNode(row, column), isSelected);
                        isSelected = true;
                    //}
                    //else {
                    //    flash(getNode(row, column), isSelected);
                    }
                });
                gp.add(cr, j, i);
            }
        }
        Rectangle rect = new Rectangle(20, 20);
        rect.setFill(Color.RED);
        Rectangle rect1 = new Rectangle(20, 20);
        rect1.setFill(Color.RED);
        Rectangle rect2 = new Rectangle(20, 20);
        rect2.setFill(Color.RED);
        Rectangle rect3 = new Rectangle(20, 20);
        rect3.setFill(Color.RED);
        //pane.getChildren().add(rect);
        pane.setCenter(gp);
        pane.setLeft(rect);
        pane.setRight(rect1);
        st.setTitle("Connect Four");
        st.setScene(new Scene(pane));
        st.show();
        //Tyler's comment
    }

    private void boardPane(){

    }
    private void flash(Rectangle n, Boolean off) {
        FadeTransition ft = new FadeTransition(Duration.millis(600), n);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.play();
        if (off) {
            ft.pause();
        }
    }

    private Rectangle getNode(int row, int col) {
        if (col <= gp.getColumnCount() && row <= gp.getRowCount()) {
            for (Node node : gp.getChildren()) {
                if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                    return (Rectangle)node;
                }
            }
        }
        return null;
    }
    void tyler(){

    }
}
