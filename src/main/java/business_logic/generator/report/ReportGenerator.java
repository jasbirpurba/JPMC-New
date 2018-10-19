package business_logic.generator.report;

import business_logic.calculator.SettlementDateCalculator;
import business_logic.calculator.SettlementStatsCalculator;
import model.Rank;
import model.instruction.Instruction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Here, generate the outing report based on daily incoming and outgoing amount, and also rank the entities based on incoing
 * and outgoing amount, i.e Sell and Buy
 */
public class ReportGenerator implements IReportGenerator {

    private StringBuilder stringBuilder = new StringBuilder();
    private SettlementDateCalculator settlementDateCalculator;
    private SettlementStatsCalculator settlementStatsCalculator;

    public ReportGenerator(final SettlementDateCalculator settlementDateCalculator,
                           final SettlementStatsCalculator settlementStatsCalculator) {
        this.settlementDateCalculator = settlementDateCalculator;
        this.settlementStatsCalculator = settlementStatsCalculator;
    }

    /**
     * Generates the proper report of Outgoing and Incoming amount, Incoming ranking and outgoing ranking
     * @param instructions
     * @return
     */
    @Override
    public String generateInstructionsReport(Set<Instruction> instructions) {
        // first calculate the correct settlement dates
        settlementDateCalculator.updateSettlementDates(instructions);

        generateDailyOutgoingAmount(instructions, stringBuilder);
        generateDailyIncomingAmount(instructions, stringBuilder);
        generateDailyIncomingRanking(instructions, stringBuilder);
        generateDailyOutgoingRanking(instructions, stringBuilder);

        // Convert the report StringBuilder to String for user understanding
        return stringBuilder.toString();
    }

    /**
     * Show Daily Outgoing Amount on console
     * @param instructions
     * @param stringBuilder
     * @return
     */
    private StringBuilder generateDailyOutgoingAmount(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                settlementStatsCalculator.calculateDailyOutgoingAmount(instructions);

        stringBuilder
                .append("\n---------------------------------\n")
                .append("         Daily Outgoing Amount          \n")
                .append("-----------------------------------\n")
                .append("      Date       |    Trade Amount      \n")
                .append("-----------------------------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                .append(date).append("       |      ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }

    /**
     * Show Daily Incoming Amount report on console
     * @param instructions
     * @param stringBuilder
     * @return
     */
    private StringBuilder generateDailyIncomingAmount(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                settlementStatsCalculator.calculateDailyIncomingAmount(instructions);

        stringBuilder
                .append("\n--------------------------------\n")
                .append("         Daily Incoming Amount          \n")
                .append("---------------------------------\n")
                .append("      Date       |    Trade Amount      \n")
                .append("---------------------------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                    .append(date).append("       |      ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }

    /**
     * Show Daily Outgoing Ranking report on console
     * @param instructions
     * @param stringBuilder
     * @return
     */
    private StringBuilder generateDailyOutgoingRanking(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, LinkedList<Rank>> dailyOutgoingRanking =
                settlementStatsCalculator.calculateDailyOutgoingRanking(instructions);

        stringBuilder
                .append("\n----------------------------------------\n")
                .append("         Daily Outgoing Ranking          \n")
                .append("--------------------------------------------\n")
                .append("        Rank    |    Date    |   Entity     \n")
                .append("--------------------------------------------\n");

        for (LocalDate date : dailyOutgoingRanking.keySet()) {
            for (Rank rank : dailyOutgoingRanking.get(date)) {
                stringBuilder
                    .append("      "+rank.getRank()+"   ").append("    |    ")
                    .append(date).append("  |  ")
                    .append(rank.getEntity()).append("\n");
            }
        }

        return stringBuilder;
    }

    /**
     * Show Print Daily Incoming Ranking report on console
     * @param instructions
     * @param stringBuilder
     * @return
     */
    private StringBuilder generateDailyIncomingRanking(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, LinkedList<Rank>> dailyIncomingRanking =
                settlementStatsCalculator.calculateDailyIncomingRanking(instructions);

        stringBuilder
                .append("\n----------------------------------------\n")
                .append("         Incoming Daily Ranking          \n")
                .append("----------------------------------------\n")
                .append("     Date    |     Rank   |   Entity     \n")
                .append("----------------------------------------\n");

        for (LocalDate date : dailyIncomingRanking.keySet()) {
            for (Rank rank : dailyIncomingRanking.get(date)) {
                stringBuilder
                        .append(date).append("   |      ")
                        .append(rank.getRank()).append("     |    ")
                        .append(rank.getEntity()).append("\n");
            }
        }

        return stringBuilder;
    }
}
