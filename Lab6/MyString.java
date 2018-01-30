public class MyString
{
	private char[] letters;

	public MyString( String other )
	{	// MUST BE DEeP COPY: USE REAL STRING'S BUILT IN METHOD
		// TO RETURN A DEEP COPY OF THE THE UNDERLYING CHAR ARRAY
		letters = new char[other.length()];
		for(int i=0; i<other.length();i++){
			letters[i]=other.charAt(i);
		}
	}
	public MyString( MyString other )
	{	// DONT do this ->  letters = other.letters     BECUASE THAT IS SHALLOW COpY!!!
		letters = new char[other.length()];
		for(int i=0; i<other.length();i++){
			letters[i]=other.charAt(i);
		}
	}
	public int length()
	{
		return letters.length;
	}
	public char charAt(int index)
	{
		return letters[index]; // THE null CHAR
	}
	int compareTo(MyString other)
	{
		if(letters.length>other.length()){
			for(int i=0;i<other.length();i++){
				if(letters[i]>other.charAt(i))
					return 1;
				if(letters[i]<other.charAt(i))
					return -1;
			}
			return 0;
		}
		else if(letters.length<other.length()){
			for(int i=0;i<letters.length;i++){
				if(letters[i]>other.charAt(i))
					return 1;
				if(letters[i]<other.charAt(i))
					return -1;
			}
			return 0;
		}
		else if(letters.length==other.length()){
			for(int i=0;i<letters.length;i++){
				if(letters[i]>other.charAt(i))
					return 1;
				if(letters[i]<other.charAt(i))
					return -1;
			}
			return 0;
		}
		return -1;
	}
	public boolean equals(MyString other)
	{
		if((this.toString().compareTo(other.toString()))==0){
			return true;
		}
		return false;
	}
	public int indexOf(int ch)
	{
		for(int i=0;i<letters.length;i++){
			if(letters[i]==ch)
				return i;
		}
		return -1;
	}
	public int indexOf(MyString other)
	{
		int startIndex =-1;
		for(int i=0; i<letters.length;i++){
			if(letters[i]==(other.charAt(0))){
				for(int j=0;j<other.length()-1;j++){
					if(letters[i+j]==(other.charAt(j))){
						startIndex = i;
					}
				}
			}
		}
		return startIndex;
	}
	public String toString()
	{
		String answer = "";
		for(char a: letters){
			answer+=a;
		}
		return answer;
	}
} // END MYSTRING CLASS
