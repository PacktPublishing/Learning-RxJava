package ch9;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observers.JavaFxObserver;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch9_6 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Label label = new Label("");
// Turn Observable into Binding
        Binding<String> binding =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(i -> i.toString())
                        .observeOn(JavaFxScheduler.platform())
                        .to(JavaFxObserver::toBinding);
//Bind Label to Binding
        label.textProperty().bind(binding);
        root.setMinSize(200, 100);
        root.getChildren().addAll(label);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}