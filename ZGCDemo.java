public class ZGCDemo {


//javac ZGCDemo.java
//java -XX:StartFlightRecording=filename=gc.jfr -XX:+UseZGC ZGCDemo

//GC logging without JFR  java -XX:+UseZGC "-Xlog:gc*" "-Xlog:gc+stats=debug" ZGCDemo
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ZGC Demo...");

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration: " + (i + 1));

            allocateMemory();


            Runtime runtime = Runtime.getRuntime();
            long memoryUsed = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            System.out.println("Allocated memory: " + memoryUsed + " MB");

            Thread.sleep(1000); // 1 saniye bekleyelim
        }

        System.out.println("ZGC Demo Completed");
    }

    private static void allocateMemory() {
        for (int i = 0; i < 10000; i++) {
            // 1 MB bellek tahsis et
            byte[] b = new byte[1024 * 1024];
        }
    }
}