package main

import (
	"fmt"
	"runtime"
	"time"
)

func allocateMemory() {
	var m [][]byte
	for i := 0; i < 100000; i++ {
		// 1 MB bellek tahsis et
		b := make([]byte, 1024*1024)
		m = append(m, b)
	}
}

func printGCStats() {
	var stats runtime.MemStats
	runtime.ReadMemStats(&stats)
	fmt.Printf("Allocated memory: %v MB\n", stats.Alloc/1024/1024)
	fmt.Printf("Total GC runs: %v\n", stats.NumGC)
	fmt.Printf("Last GC pause: %v ns\n\n", stats.PauseNs[(stats.NumGC+255)%256])
}

func main() {
	for i := 0; i < 10; i++ {
		fmt.Printf("Iteration: %d\n", i+1)
		allocateMemory()
		printGCStats()
		time.Sleep(1 * time.Second)
	}
}
