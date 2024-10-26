package com.hi;

public class Runtime {
	
	public long runtime;
	
	@Annotation(val=10)
	public void start() {
		runtime = System.nanoTime()/10000;
	}
	
	public double stop() {
		return (double) (System.nanoTime()/10000-runtime)/100;
	}
	
}
