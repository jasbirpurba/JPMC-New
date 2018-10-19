package utils.date.working_days;

import java.time.LocalDate;

public interface IWorkingDays {
    LocalDate findFirstWorkingDate(final LocalDate date);
}
