package executor.input;

import model.instruction.Instruction;
import model.instruction.InstructionDetails;
import model.instruction.TradeAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

/**
 * Generate dummy data in the form of Set for processing
 */
public class CodedInputExecutor implements InputExecutor {
    public Set<Instruction> getInstructions() {
        return new HashSet<>(Arrays.asList(

            new Instruction(
                "Entity_1",
                TradeAction.BUY,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 20),
                new InstructionDetails(
                        Currency.getInstance("SGD"),
                        BigDecimal.valueOf(0.40),
                        100,
                        BigDecimal.valueOf(100.35))),

            new Instruction(
                "Entity_2",
                TradeAction.BUY,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 19),
                new InstructionDetails(
                        Currency.getInstance("AED"),
                        BigDecimal.valueOf(0.32),
                        350,
                        BigDecimal.valueOf(120.5))),

            new Instruction(
                "Entity_3",
                TradeAction.SELL,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 18),
                new InstructionDetails(
                        Currency.getInstance("SAR"),
                        BigDecimal.valueOf(0.27),
                        150,
                        BigDecimal.valueOf(400.8))),

            new Instruction(
                "Entity_4",
                TradeAction.SELL,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 21),
                new InstructionDetails(
                        Currency.getInstance("EUR"),
                        BigDecimal.valueOf(0.29),
                        60,
                        BigDecimal.valueOf(495.6))),

            new Instruction(
                "Entity_5",
                TradeAction.BUY,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 21),
                new InstructionDetails(
                        Currency.getInstance("EUR"),
                        BigDecimal.valueOf(0.34),
                        20,
                        BigDecimal.valueOf(40.6))),

            new Instruction(
                "Entity_6",
                TradeAction.BUY,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 21),
                new InstructionDetails(
                        Currency.getInstance("EUR"),
                        BigDecimal.valueOf(0.34),
                        20,
                        BigDecimal.valueOf(40.6))),

            new Instruction(
                "Entity_7",
                TradeAction.SELL,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 21),
                new InstructionDetails(
                        Currency.getInstance("EUR"),
                        BigDecimal.valueOf(0.32),
                    1000,
                        BigDecimal.valueOf(156.6))),

            new Instruction(
                "Entity_8",
                TradeAction.SELL,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 21),
                    new InstructionDetails(
                            Currency.getInstance("EUR"),
                            BigDecimal.valueOf(0.34),
                        120,
                            BigDecimal.valueOf(500.6)))
        ));
    }
}
