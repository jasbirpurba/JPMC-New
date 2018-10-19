import business_logic.generator.report.IReportGenerator;
import injector.ApplicationFactory;
import injector.InputExecutorFactory;
import model.instruction.Instruction;

import java.util.Set;

public class ApplicationMain {

    public static void main(String[] args) {
        final Set<Instruction> instructions = InputExecutorFactory.getInstance().getCodedInputExecutor().getInstructions();
        final IReportGenerator reportGenerator = ApplicationFactory.getInstance().getReportGenerator();

        System.out.println(reportGenerator.generateInstructionsReport(instructions));
    }
}
