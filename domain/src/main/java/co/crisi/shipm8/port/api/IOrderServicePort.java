package co.crisi.shipm8.port.api;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.domain.data.input.OrderSaveDto;

public interface IOrderServicePort extends ServicePort<IOrder, Long> {

    IOrder save(OrderSaveDto order);

}
