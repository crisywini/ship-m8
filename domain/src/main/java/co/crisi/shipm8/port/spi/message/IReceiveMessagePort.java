package co.crisi.shipm8.port.spi.message;

public interface IReceiveMessagePort<T> {

    void listen(T message);

}
