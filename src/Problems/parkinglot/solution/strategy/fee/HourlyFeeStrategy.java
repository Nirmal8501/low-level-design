package Problems.parkinglot.solution.strategy.fee;

import Problems.parkinglot.solution.model.ParkingTicket;

import java.time.Duration;
import java.time.Instant;

public class HourlyFeeStrategy implements FeeStrategy {

    private static final Float FLAT_PER_HOUR_FEE = 30.0f;

    @Override
    public Float calculateFee(ParkingTicket ticket) {
        Instant entry = ticket.getEntryTimeStamp();
        Instant exit = ticket.getExitTimeStamp();

        Duration duration = Duration.between(entry, exit);
        return FLAT_PER_HOUR_FEE * duration.toHours();
    }
}
