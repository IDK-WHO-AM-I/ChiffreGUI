package chiffre;

import java.time.Duration;
import java.time.LocalTime;

public abstract class ChiffreAlgorythm<T> {

    private T key;
    private String text;
    private LocalTime startTime;
    private Duration operationDuration;

    public ChiffreAlgorythm(T key) {
        this.key = key;
    }

    public abstract String encrypt();

    public abstract String decrypt();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text.toLowerCase();
    }

    protected void startTiming() {
        startTime = LocalTime.now();
    }

    protected void stopTiming() {
        operationDuration = Duration.between(startTime, LocalTime.now());
    }

    public Duration getOperationDuration() {
        return operationDuration;
    }

    public T getKey() {
        return key;
    }
}
