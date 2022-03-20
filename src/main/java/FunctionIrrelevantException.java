public class FunctionIrrelevantException extends Exception {
    @Override
    public String toString(){
        return "ERROR: FunctionIrrelevantException, the function has no value on the received input";
    }
}
