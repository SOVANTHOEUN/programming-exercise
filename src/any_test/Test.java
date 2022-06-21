package any_test;

import java.io.IOException;

class X{
    public void printFileContent() throws Exception{
        throw new IOException();
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        X obj = new X();
        obj.printFileContent();
    }
}
