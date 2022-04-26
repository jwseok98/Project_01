package sample.cwe495;

import java.util.Arrays;

public class PrivateArrayReturndFromPublicMethod {
	private String[] colors;
	private String co;
	private int[] ints;
	
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	
	public String getCo() {
		return co;
	}

	public String[] getColors() {
		/* POTENTIAL FLAW */
		return colors;
	}
	
	public int[] getInts() {
		/* POTENTIAL FLAW */
		return ints;
	}

	public String[] getColors_good_for_assigned() {
		String[] temp = new String[colors.length];
		
		for(int i=0; i<colors.length; i++) {
			temp[i] = colors[i];
		}
		return temp;
	}
	
	public String[] getColors_good_copy_array() {
		String[] temp = new String[colors.length];
		
		System.arraycopy(colors, 0, temp, 0, colors.length);
	
		return temp;
	}
	
	public String[] getColors_bad_copy_array() {
		String[] temp = new String[colors.length];
		
		System.arraycopy(colors, 0, temp, 0, colors.length);
		
		/* POTENTIAL FLAW */
		return colors;
	}

	public String[] getColors_good_arrays_copyOf() {
		String[] temp = null;
		
		temp = Arrays.copyOf(colors, colors.length);
	
		return temp;
	}
	
	public String[] getColors_good_arrays_copyOfranage() {
		String[] temp = null;
		
		temp = Arrays.copyOfRange(colors, 0, colors.length);
		
		return temp;
	}
	
	public String[] getColors_good_arrays_clone() {
		return colors.clone();
	}
}
