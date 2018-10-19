package injector;

import com.google.common.collect.ImmutableMap;
import utils.date.working_days.WorkingDays;

import java.time.DayOfWeek;

/**
 * Get all the information of working days from here
 */
public class WorkingDaysFactory {
    private static class LazyHolder {
        static WorkingDaysFactory workingDaysFactory = new WorkingDaysFactory();
    }

    public static WorkingDaysFactory getInstance() {
        return LazyHolder.workingDaysFactory;
    }

    /**
     * Get Arab working days
     * @return
     */
    public WorkingDays getArabianWorkingDaysInstance() {
        final ImmutableMap.Builder<DayOfWeek, Boolean> builder = ImmutableMap.builder();
        builder.put(DayOfWeek.SUNDAY, true);
        builder.put(DayOfWeek.MONDAY, true);
        builder.put(DayOfWeek.TUESDAY, true);
        builder.put(DayOfWeek.WEDNESDAY, true);
        builder.put(DayOfWeek.THURSDAY, true);
        builder.put(DayOfWeek.FRIDAY, false); // in Arab Friday is not working day
        builder.put(DayOfWeek.SATURDAY, false); // in Arab Saturday is not working days
        return new WorkingDays().withWorkingDayMap(builder.build());
    }

    /**
     * Get normal working days
     * @return
     */
    public WorkingDays getDefaultWorkingDaysInstance() {
        final ImmutableMap.Builder<DayOfWeek, Boolean> builder = ImmutableMap.builder();
        builder.put(DayOfWeek.SUNDAY, false);
        builder.put(DayOfWeek.MONDAY, true);
        builder.put(DayOfWeek.TUESDAY, true);
        builder.put(DayOfWeek.WEDNESDAY, true);
        builder.put(DayOfWeek.THURSDAY, true);
        builder.put(DayOfWeek.FRIDAY, true);
        builder.put(DayOfWeek.SATURDAY, false);
        return new WorkingDays().withWorkingDayMap(builder.build());
    }

    private WorkingDaysFactory() {
    }
}
