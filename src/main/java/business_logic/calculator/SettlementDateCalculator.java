package business_logic.calculator;

import utils.date.working_days.IWorkingDays;
import model.instruction.Instruction;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

/**
 * Settlement date calculator
 */
public class SettlementDateCalculator {

    private IWorkingDays jpmcWorkingDays;
    private IWorkingDays defaultWorkingDays;

    public SettlementDateCalculator(final IWorkingDays arabiaWorkingDays,
                                    final IWorkingDays defaultWorkingDays) {
        this.jpmcWorkingDays = arabiaWorkingDays;
        this.defaultWorkingDays = defaultWorkingDays;
    }

    /**
     * Helper function to calculate settlement date for every given instruction
     * @param instructions the instructions of which the settlement date will be calculated
     */
    public void updateSettlementDates(final Set<Instruction> instructions) {
        instructions.forEach(this::updateSettlementDate);
    }

    /**
     * Calculate the settlementDate
     * @param instruction the instruction of which the settlement date will be calculated
     */
    public void updateSettlementDate(final Instruction instruction) {
        // Select strategy based on the Currency
        final IWorkingDays workingDaysMechanism = getWorkingDaysStrategy(instruction.getCurrency());

        // find the correct settlement date
        final LocalDate newSettlementDate =
                workingDaysMechanism.findFirstWorkingDate(instruction.getSettlementDate());

        if (newSettlementDate != null) {
            // set the correct settlement date
            instruction.setSettlementDate(newSettlementDate);
        }
    }

    /**
     * Select strategy based on the Currency
     * @param currency the currency to choose
     * @return the working days strategy
     */
    private IWorkingDays getWorkingDaysStrategy(Currency currency) {
        if ((currency.getCurrencyCode().equals("AED")) ||
            (currency.getCurrencyCode().equals("SAR")))
        {
            return jpmcWorkingDays;
        }
        return defaultWorkingDays;
    }
}
