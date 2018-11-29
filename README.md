# The Altening - Java Wrapper
[The Altening API for AuthLib](https://github.com/TheAltening/API-Java-AuthLib) 
How to use:

Add this to your build file of
Gradle:
```css
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

```css
	dependencies {
	        implementation 'com.github.TheAltening:API-Java:api-2.0-SNAPSHOT'
	}
```
Maven:
```markup
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
```markup
	<dependency>
	    <groupId>com.github.TheAltening</groupId>
	    <artifactId>API-Java</artifactId>
	    <version>api-2.0-SNAPSHOT</version>
	</dependency>
```
Make an instance of the `TheAltening` class and provide the api key
\
`private final TheAltening thealtening = new TheAltening("API-KEY")`;`
\
`TheAltening#getUser()` - returns the  User information
\
`TheAltening#generateAccount()` - generates an account
\
`TheAltening#favoriteAccount()` - **NEW!** allows to favorite an account from the API!
\
`TheAltening#privateAccount()` - **NEW!** allows to private an account from the API!

