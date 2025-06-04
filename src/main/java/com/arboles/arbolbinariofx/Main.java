package com.arboles.arbolbinariofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        int canvasWidth = 1000;
        int canvasHeight = 600;
        double nodeRadius = 10;
        double verticalSeparation = 40;

        ArbolVisual arbol = new ArbolVisual(nodeRadius, verticalSeparation);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        arbol.setCanvas(canvas);

        // Crear los labels para mostrar los recorridos
        Label labelPreOrden = new Label();
        Label labelInOrden = new Label();
        Label labelPostOrden = new Label();

        // Crear el contenedor para los labels
        VBox recorridosBox = new VBox(2); // Espacio entre labels
        recorridosBox.getChildren().addAll(labelPreOrden, labelInOrden, labelPostOrden);

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(recorridosBox); // Muestra los recorridos en la parte inferior

        Scene scene = new Scene(root, canvasWidth, canvasHeight + 60); // +60 para espacio de los labels

        // Inserta datos
        arbol.insertar(9);
        arbol.insertar(4);
        arbol.insertar(85);
        arbol.insertar(7);
        arbol.insertar(40);
        arbol.insertar(90);
        arbol.insertar(6);
        arbol.insertar(22);
        arbol.insertar(47);
        arbol.insertar(88);
        arbol.insertar(94);
        arbol.insertar(11);
        arbol.insertar(37);
        arbol.insertar(39);

        // Dibuja el árbol
        arbol.dibujarArbol(canvasWidth);

        // Establece el texto de los labels con los recorridos
        labelPreOrden.setText("PreOrden: " + arbol.recorridoPreOrden());
        labelInOrden.setText("InOrden: " + arbol.recorridoInOrden());
        labelPostOrden.setText("PostOrden: " + arbol.recorridoPostOrden());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Árbol Binario Visual");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
