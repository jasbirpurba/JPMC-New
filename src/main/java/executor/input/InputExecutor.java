package executor.input;

import model.instruction.Instruction;

import java.util.Set;

/**
 * Dummy data generation class Interface
 */
public interface InputExecutor {

    /**
     * Get the dummy or Instructions data in the for of Set
     * @return
     */
    Set<Instruction> getInstructions();
}
