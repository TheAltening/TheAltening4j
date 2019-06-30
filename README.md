
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
        implementation 'com.github.TheAltening:API-Java:master-SNAPSHOT'
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
	    <version>master-SNAPSHOT</version>
	</dependency>
 ```  
 Please look at the tests for how to use the API.
 
License data provided:  
 - Users username: LicenseData.getUsername();  
 - Premium status: LicenseData.isPremium();  
 - Generator license: LicenseData.getPremiumName();  
 - Expiry date: LicenseData.getExpiryDate().  
  
  
Account data provided:  
 - Limit: AccountData.isLimited()
 - Token: AccountData.getToken()
 - Username: AccountData.getUsername()
 - Password: AccountData.getPassword()


Account Info provided by doing AccountData.getInfo():
 - Hypixel rank: AccountInfo.getHypixelRank()
 - Hypixel level: AccountInfo.getHypixelLevel()
 - Mineplex rank: AccountInfo.getMineplexRank()
 - Mineplex level: AccountInfo.getMineplexLevel()
 - 5zig cape: AccountInfo.hasFiveZigCape()
 - Labymod cape: AccountInfo.hasLabyModCape()

