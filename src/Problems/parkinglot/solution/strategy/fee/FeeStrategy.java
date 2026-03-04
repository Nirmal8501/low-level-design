package Problems.parkinglot.solution.strategy.fee;

import Problems.parkinglot.solution.model.ParkingTicket;

public interface FeeStrategy {
    Double calculateFee(ParkingTicket ticket);
}
