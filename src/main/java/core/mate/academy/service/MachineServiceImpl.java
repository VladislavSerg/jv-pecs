package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<M extends Machine> implements MachineService<M> {
    private final MachineProducer<Bulldozer> dozerProd = new BulldozerProducer();
    private final MachineProducer<Excavator> excavProd = new ExcavatorProducer();
    private final MachineProducer<Truck> truckProd = new TruckProducer();

    @Override
    public List<? extends M> getAll(Class<? extends M> type) {
        if (type == Bulldozer.class) {
            List<? extends M> result = (List<? extends M>) dozerProd.get();
            return result;
        }
        if (type == Excavator.class) {
            List<? extends M> result = (List<? extends M>) excavProd.get();
            return result;
        }
        if (type == Truck.class) {
            List<? extends M> result = (List<? extends M>) truckProd.get();
            return result;
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }

    @Override
    public void fill(List<? super M> machines, M value) {
        machines.clear();
        machines.add(value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine m : machines) {
            m.doWork();
        }
    }
}
