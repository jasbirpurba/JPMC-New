package injector;

import business_logic.calculator.SettlementDateCalculator;
import business_logic.calculator.SettlementStatsCalculator;
import business_logic.generator.report.IReportGenerator;
import business_logic.generator.report.ReportGenerator;

/**
 * Here, from factory get the instances of Report Generator, Settlement date calculator etc
 */
public class ApplicationFactory {
    private static class LazyHolder {
        static ApplicationFactory applicationFactory = new ApplicationFactory();
    }

    public static ApplicationFactory getInstance() {
        return ApplicationFactory.LazyHolder.applicationFactory;
    }

    public IReportGenerator getReportGenerator() {
        return new ReportGenerator(getInstructionSettlementDateCalculator(), getInstructionSettlementStatsCalculator());
    }

    public SettlementDateCalculator getInstructionSettlementDateCalculator() {
        final WorkingDaysFactory workingDaysFactory = WorkingDaysFactory.getInstance();
        return new SettlementDateCalculator(workingDaysFactory.getArabianWorkingDaysInstance(),
                workingDaysFactory.getDefaultWorkingDaysInstance());
    }

    public SettlementStatsCalculator getInstructionSettlementStatsCalculator() {
        return new SettlementStatsCalculator();
    }
}
