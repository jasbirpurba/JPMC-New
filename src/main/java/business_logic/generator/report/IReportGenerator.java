package business_logic.generator.report;

import model.instruction.Instruction;

import java.util.Set;

/**
 * Interface to provide report generation methods
 */
public interface IReportGenerator {
    String generateInstructionsReport(Set<Instruction> instructions);
}
