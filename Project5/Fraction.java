/* Fraction.java  A class (data type) definition file
   This file just defines what a Fraction is
   This file is NOT a program
   ** data members are PRIVATE
   ** method members are PUBLIC
*/
import java.math.*;
public class Fraction
{
	private int numer;
	private int denom;

	// ACCESSORS
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}

	// MUTATORS
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			// error msg OR exception OR exit etc.
		}
	}

	// DEFAULT CONSTRUCTOR - no args passed in
	public Fraction(  )
	{
		this( 0, 1 ); // "this" means call a fellow constructor
	}

	// 1 arg CONSTRUCTOR - 1 arg passed in
	// assume user wants whole number
	public Fraction( int n )
	{
		this( n, 1 ); // "this" means call a fellow constructor

	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction( int n, int d )
	{
		// you COULD calc the gcd(n,d) here and then divide both by gcd in the setter calls
		setNumer(n); // i.e. setNumer( n/gcd );
		setDenom(d); // same here
		reduce();
	}

	// COPY CONSTRUCTOR - takes ref to some already initialized Fraction object
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); // call my full C'Tor with other Fraction's data
	}

	private void reduce()
	{
		int num1;
		int num2;
		int gcd=1;
		if(denom<numer){
			num1 = denom;
			num2 = numer;
		}
		else{
			num1 = numer;
			num2 = denom;
		}
		for(int i=num1/2;i>0;i--){
			if(num1%i==0){
				if(num2%i==0){
					gcd=i;
					break;
				}
			}
		}
		numer=numer/gcd;
		denom=denom/gcd;
	}
	public Fraction add(Fraction other){
		return new Fraction(numer*other.getDenom()+other.getNumer()*denom,denom*other.getDenom());
	}
	public Fraction subtract(Fraction other){
		return new Fraction(numer*other.getDenom()-other.getNumer()*denom,denom*other.getDenom());
	}
	public Fraction multiply(Fraction other){
		return new Fraction(numer*other.getNumer(),denom*other.getDenom());
	}
	public Fraction divide(Fraction other){
		return new Fraction(numer*other.getDenom(),denom*other.getNumer());
	}
	public Fraction reciprocal(){
		return new Fraction(denom,numer);
	}

	//  W R I T E   A L L   Y O U R   N E W   M E T H O D S   A T   B O T T O M   O F   F I L E   R E M O V E   A L L   C O M M E N T S


}// EOF
