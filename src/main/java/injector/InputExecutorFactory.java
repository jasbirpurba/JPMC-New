package injector;

import executor.input.CodedInputExecutor;
import executor.input.InputExecutor;

/**
 * This factory provides the instances for dummy data executors
 */
public class InputExecutorFactory {
    private static class LazyHolder {
        static InputExecutorFactory inputExecutorFactory = new InputExecutorFactory();
    }

    public static InputExecutorFactory getInstance() {
        return InputExecutorFactory.LazyHolder.inputExecutorFactory;
    }

    public InputExecutor getCodedInputExecutor() {
        return new CodedInputExecutor();
    }
}
