package co.crisi.shipm8.port.spi;

public interface ISendMessagePort<T> {

    void sendMessage(T message);

}
