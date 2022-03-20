class FactorialOverflowException extends Exception {
    @Override
    public String toString(){
        return "WARN: FactorialOverflowException, decrease in calculation accuracy";
    }
}
