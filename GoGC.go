package main

import (
	"fmt"
	"runtime"
)

type Person struct {
	Name string
}

func createPerson() *Person {
	// Allocate a new Person object
	p := &Person{Name: "John Doe"}
	fmt.Println("Created Person:", p.Name)
	return p
}

func main() {
	// Create a Person object and assign it to a variable
	p := createPerson()

	// Simulate some operations
	fmt.Println("Using Person:", p.Name)

	// Remove reference to the Person object
	p = nil

	// Force garbage collection
	runtime.GC()

	// Check if GC has collected the object (not visible directly, but memory should be reclaimed)
	fmt.Println("Garbage Collection triggered.")
}
