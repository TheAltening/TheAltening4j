# Java implementation of TheAltening API
*Introduction*
This Java Wrapper allows your application to use TheAltening's api to it's fullest

**Gradle dependency:**
```groovy
    repositories {
        maven {
            url = 'https://jitpack.io'
        }
    }
    dependencies {
        implementation 'com.github.TheAltening:API-Java:4.0.0'
    }
```


**Maven dependency:**
```
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>


	<dependency>
	    <groupId>com.github.TheAltening</groupId>
	    <artifactId>API-Java</artifactId>
	    <version>3.0.0</version>
	</dependency>
```


**Usage:** 
```java
import com.thealtening.api.*;
import com.thealtening.api.json.*;

public class Application {   
    public static void main(String[] args){
      final TheAltening theAltening = new TheAltening("API_KEY");
      // Returns info about the account you just generated
      final AccountData AccountData = theAltening.getAccountData();
      // Returns info about license
      final LicenseData LicenseData = theAltening.getLicenseData();
      // adds your account to the privated list
      if(theAltening.privateAccount(AccountData)){
         // DO STUFF
      }
      // adds your account to the favorited list
      if(theAltening.favoriteAccount(AccountData)) {
          // DO STUFF
      }
    }
}
```
Now supports async!
```java
import com.thealtening.api.*;
import com.thealtening.data.*;

public class Application {   
    public static void main(String[] args){
      final TheAltening theAltening = new TheAltening("API_KEY");
      final TheAltening.Asynchronous asynchronous = new TheAltening.Asynchronous(theAltening);
      asynchronous.getAccountData().thenAccept(account -> {
          asynchronous.favoriteAccount(account.getToken()).thenAccept(bool -> {
                    if(bool) {
                        // favorited account
                    }
          }).exceptionally(error -> {
                    // handle error here;
          });
          asynchronous.favoriteAccount(account.getToken()).thenAccept(bool -> {
              if(bool) {
                  // favorited account
              }
          }).exceptionally(error -> {
              // handle error here;
          });
          // Account data 
      }).exceptionally(error -> {
          // handle error here;
      });
      asynchronous.getLicenseData().thenAccept(license -> {
          
      }).exceptionally(error -> {
          // handle error here;
      });
      
    }
}
```


*License data provided*:
    Users username: `LicenseData.getUsername()`;
    Is the account premium: `LicenseData.isPremium()`;
    What generator license they have purchased: `LicenseData.getPremiumName()`;
    Expiry date: `LicenseData.getExpiryDate()`.


**Account data provided**:
    Limit (cycling accounts if true): `AccountData.isLimited()`
    Token: `AccountData.getToken()`
    Username: `AccountData.getUsername()`
    Password: `AccountData.getPassword()`
        Account info from data:
            Hypixel rank: `AccountData.getHypixelRank()`;
            Hypixel level: `AccountData.getHypixelLevel()`;
            Mineplex rank: `AccountData.getMineplexRank()`;
            Mineplex level: `AccountData.getMineplexLevel()`;
            5zig cape: `AccountData.hasFiveZigCape()`;
            labymod cape: `AccountData.hasLabyModCape()`.
