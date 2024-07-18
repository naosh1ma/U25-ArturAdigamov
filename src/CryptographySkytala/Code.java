package Code;

import java.awt.EventQueue;
import java.io.File;

public class Code {
	
	MyFrame frame = null;
    private int u, z;
    private File file;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
	
	public void crypt(MyFrame frame) {
		System.out.println("Crypt ausgefuert");
		char[] textfield, codefield = null;
        String output = "";
        int lines = z;
        if(!frame.getTextOrig().getText().equals("")) {
        	System.out.println("In if rein");
        	
        	String temp =  frame.getTextOrig().getText();
        	System.out.println(temp);
        	textfield = temp.toCharArray();
        	System.out.println(textfield[0]);
        	
        	codefield = new char[textfield.length];
        	int i = 0;
        	for(int z = 0; z < lines; z++) {
        		for(int s = z; s < textfield.length; s = s+lines) {
        			codefield[i] = textfield[s];
        			i++;
        		}
        	}
        }
        for( int c =0; c < codefield.length; c++){
    		output = output + "" + codefield[c];
    	}
        System.out.println(output);
        frame.getTextCode().setText(output);
        
        
	}
	

}
