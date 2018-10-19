package utils.date.working_days;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WorkingDays implements IWorkingDays {
    protected Map<DayOfWeek, Boolean> isWorkingDayMap;

    public WorkingDays() {
        this.isWorkingDayMap = new HashMap<>();
    }

    public WorkingDays withWorkingDayMap(final Map<DayOfWeek, Boolean> isWorkingDayMap) {
        this.isWorkingDayMap = isWorkingDayMap;
        return this;
    }

    public LocalDate findFirstWorkingDate(final LocalDate date) {

        //check if there is an available weekday
        if (isWorkingDayMap.values().stream().noneMatch(b -> b)) {
            return null;
        }

        // check for the first working day of available working days,
        return getFirstWorkingDate(date);
    }

        private LocalDate getFirstWorkingDate(final LocalDate date) {
        final DayOfWeek inputDay = date.getDayOfWeek();

        // if given date is working date, return day
        if (isWorkingDayMap.get(inputDay)) {
            return date;
        } else {
            // else look for the next working day (Recursively)
            return getFirstWorkingDate(date.plusDays(1));
        }
    }
}
