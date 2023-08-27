package co.crisi.shipm8.domain.event;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Message<T> {

    public abstract String getKey();

    private final T value;

}
