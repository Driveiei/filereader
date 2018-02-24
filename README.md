# filereader
by Kornphon Noiprasert 6010545021

Result of Runtime by reading AliceInWonderland.txt with 52,539 chars.

######Read file 1-char at a time to String         
#####    0.843591 secs
######Read file 1-char at a time to StringBuilder    
#####    0.010712 secs
######Read file line at a time using BufferedReader  
#####    0.038971 secs
 
## Explanation of Results

#### Read String and StringBuilder by same Reader (InputStreamReader).
	
	String is immutable so it always create new String and discard the older String everytime it creates but, StringBuilder is mutable so, It will create new String and append the older String without discard older String. That's mean Read the text by String is slower than StringBuilder.
	
#### Read same String but different Reader (InputStreamReader and BufferedReader).
	Read the text by InputStreamReader is slower than BufferedReader because InputStreamReader reads 1 character from the stream per time but BufferedReader reads 1 line from the Stream per time.
	
 