package com.yourmoneysaver.exceptions;

public class ArgumentIsNullException extends IllegalArgumentException {
    public ArgumentIsNullException(String argumentName) {
        /*
         * had to make this crappy code because constructor of superclass have
         * to be called first
         */
        super((new StringBuilder()).append("Argument \"").append(argumentName)
                .append("\" is null.").toString());
    }
}
