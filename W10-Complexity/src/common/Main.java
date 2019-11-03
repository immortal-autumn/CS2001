package common;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if(args.length != 1) {
            System.err.println("Invalid arguments!");
            System.exit(1);
        }
//        try1(args);
//        try2(args);
//        try3(args);
//        try4(args);
//        try5(args);
//        try6(args);
//        try7(args);
        try8(args);
    }

    private static void try1(String[] args) {
        OutputData output = new OutputData(args[0],1000 );
        output.quickwrite();
    }

    private static void try2(String[] args) {
        OutputData output = new OutputData(args[0], 0);
        for (int i = 200; i < 4000; i++) {
            output.complexityWithSize(i);
        }
        output.closeWriter();
    }

    private static void try3(String[] args) {
        OutputData output = new OutputData(args[0],1000 );
        output.bubbleWrite();
    }

    private static void try4(String[] args) {
        OutputData output = new OutputData(args[0], 0);
        for (int i = 200; i < 4000; i++) {
            output.bubbleComplexityWithSize(i);
        }
        output.closeWriter();
    }

    private static void try5(String[] args) {
        OutputData output = new OutputData(args[0],1000 );
        output.selectionSortWrite();
    }

    private static void try6(String[] args) {
        OutputData output = new OutputData(args[0], 0);
        for (int i = 200; i < 4000; i++) {
            output.selectionComplexityWithSize(i);
        }
        output.closeWriter();
    }

    private static void try7(String[] args) {
        OutputData output = new OutputData(args[0],1000 );
        output.mergeSortWrite();
    }

    private static void try8(String[] args) {
        OutputData output = new OutputData(args[0], 0);
        for (int i = 200; i < 4000; i++) {
            output.mergeComplexityWithSize(i);
        }
        output.closeWriter();
    }
}
