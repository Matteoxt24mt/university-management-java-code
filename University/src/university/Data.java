/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Matteo Trupia 
 */

public class Data 
{
    private GregorianCalendar c;
	
	public Data(){
		c = new GregorianCalendar();
	}
	
	public Data(int g, int m, int a){
		c = new GregorianCalendar(a,m-1,g);
	}
	
	
	//this - d
	public int getDifference(Data d){
		int diff=0;
		long cm = c.getTimeInMillis();
		long dm = d.c.getTimeInMillis();
		long diffm = cm - dm;
		diff = (int) (diffm / (24 * 60 * 60 * 1000));
		return diff;
	}
	
	public boolean equals(Object obj){
		if(obj == null) return false;
		
		if(!(obj instanceof Data)) return false;
		
		return c.equals((GregorianCalendar)obj);
		
	}
	
	public String toString(){
		int anno = c.get(Calendar.YEAR);
		int mese = c.get(Calendar.MONTH) + 1;
		int giorno = c.get(Calendar.DATE);
		return giorno+"/"+mese+"/"+anno;
	}
}
