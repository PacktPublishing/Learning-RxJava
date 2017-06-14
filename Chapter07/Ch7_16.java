package ch7;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch7_16 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Label counterLabel = new Label("");
        ToggleButton startStopButton = new ToggleButton();
// Multicast the ToggleButton's true/false selected state
        Observable<Boolean> selectedStates =
                JavaFxObservable.valuesOf(startStopButton.selectedProperty())
                        .publish()
                        .autoConnect(2);
// Using switchMap() with ToggleButton's selected state willdrive
// whether to kick off an Observable.interval(),
// or dispose() it by switching to empty Observable
        selectedStates.switchMap(selected -> {
            if (selected)
                return Observable.interval(1,
                        TimeUnit.MILLISECONDS);
            else
                return Observable.empty();
        }).observeOn(JavaFxScheduler.platform()) // Observe on JavaFX UI thread
                .map(Object::toString)
                .subscribe(counterLabel::setText);
// Change ToggleButton's text depending on its state
        selectedStates.subscribe(selected ->
                startStopButton.setText(selected ? "STOP" :
                        "START")
        );
        root.getChildren().addAll(counterLabel, startStopButton);
        stage.setScene(new Scene(root));
        stage.show();
    }
}