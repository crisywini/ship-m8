package co.crisi.shipm8.port.spi.message;

public interface ISendMessagePort<T> {

    void sendMessage(T message);

}
