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
        implementation 'com.github.TheAltening:API-Java:3.0.0'
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
      final TheAltening theAltening = new TheAltening.Builder().setApiKey("API_KEY");
      // Returns info about the account you just generated
      final AccountInfo accountInfo = theAltening.getAccountInfo();
      // Returns info about license
      final LicenseInfo licenseInfo = theAltening.getLicenseInfo();
      // adds your account to the privated list
      if(theAltening.privateAccount(accountInfo)){
         // DO STUFF
      }
      // adds your account to the favorited list
      if(theAltening.favoriteAccount(accountInfo)) {
          // DO STUFF
      }
    }
}
```


*License data provided*:

    Users username: `LicenseInfo.getUsername()`;
    Is the account premium: `LicenseInfo.isPremium()`;
    What generator license they have purchased: `LicenseInfo.getPremiumName()`;
    Expiry date: `LicenseInfo.getExpiryDate()`.


**Account data provided**:

    Limit (cycling accounts if true): `AccountInfo.isLimited()`
    Token: `AccountInfo.getToken()`
    Username: `AccountInfo.getUsername()`
    Password: `AccountInfo.getPassword()`
        Account info from data:
            Hypixel rank: `AccountInfo.Data.getHypixelRank()`;
            Hypixel level: `AccountInfo.Data.getHypixelLevel()`;
            Mineplex rank: `AccountInfo.Data.getMineplexRank()`;
            Mineplex level: `AccountInfo.Data.getMineplexLevel()`;
            5zig cape: `AccountInfo.Data.hasFiveZigCape()`;
            labymod cape: `AccountInfo.Data.hasLabyModCape()`.
