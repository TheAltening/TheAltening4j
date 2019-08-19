# The Altening API for Java

[![Java 8+][java-badge]](https://java.oracle.com/)
[![Maven Central][maven-badge]](https://search.maven.org/artifact/com.thealtening.api/api)

[java-badge]: https://img.shields.io/badge/Java-8%2B-informational.svg
[maven-badge]: https://img.shields.io/maven-central/v/com.thealtening.api/api.svg
[![GitHub license](https://img.shields.io/github/license/TheAltening/TheAltening4j)](https://github.com/TheAltening/TheAltening4j/blob/4.0/LICENSE)

TheAltening API made by [Vladymyr](https://github.com/Vladymyr) now branded under the official repo with the release tag "4.0.0"
## Gradle


```groovy
repositories {
	mavenCentral()
}
dependencies {
	implementation 'com.thealtening.api:api:@BADGE-VERSION@'
}
```
## Maven


```xml
<dependencies>
	<dependency>
		<groupId>com.thealtening.api</groupId>
		<artifactId>api</artifactId>
		<version>@BADGE-VERSION@</version>
	</dependency>
</dependencies>
```


## Prerequisites
 * Use JDK 1.8+
 
## Usage

To create a new `BasicDataRetriever` instance depending on the wanted type:
```java
import com.thealtening.api.TheAltening

BasicDataRetriever basicDataRetriever = TheAltening.newBasicRetriever("api key");
AsynchronousDataRetriever asynchronousDataRetriever = TheAltening.newAsyncRetriever("api key");
```
you also can pass the ``BasicDataRetriever`` to ``AsynchronousDataRetriever`` using ``toAsync``:

```java
AsynchronousDataRetriever asynchronousDataRetriever = basicDataRetriever.toAsync();
```

Even though most of the other methods are self-explanatory. If you want a little bit more detailed use of the API check out the tests.
