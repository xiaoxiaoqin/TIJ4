package innerclasses;
//: innerclasses/Parcel8.java

import javax.swing.plaf.synth.SynthSpinnerUI;

// Calling the base-class constructor.

public class Parcel8 {
	public Wrapping wrapping(int x) {
		// Base constructor call:
		return new Wrapping(x) { // Pass constructor argument.
			public int value() {
				return super.value() * 47;
			}
		}; // Semicolon required
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
		System.out.println(w.value());
	}
} /// :~470
