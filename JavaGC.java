public class JavaGC {

    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }
    }

    public static Person createPerson() {
        // Allocate a new Person object
        Person p = new Person("John Doe");
        System.out.println("Created Person: " + p.name);
        return p;
    }

    public static void main(String[] args) {
        // Create a Person object and assign it to a variable
        Person p = createPerson();

        // Simulate some operations
        System.out.println("Using Person: " + p.name);

        // Remove reference to the Person object
        p = null;

        // Suggest JVM to run garbage collection (not guaranteed to run immediately)
        System.gc();

        // Check if GC has collected the object (not visible directly, but memory should be reclaimed)
        System.out.println("Garbage Collection suggested.");
    }
}
