# The Altening API for Java

[![Java 8+][java-badge]](https://java.oracle.com/)
[![Maven Central][maven-badge]](https://search.maven.org/artifact/pw.stamina/pubsub4k)

[java-badge]: https://img.shields.io/badge/Java-8%2B-informational.svg
[maven-badge]: https://img.shields.io/maven-central/v/pw.stamina/pubsub4k.svg

A fork of The Altening API originally made by [Trol](https://github.com/Trol1337). The objective of this fork is to improve the performance and readability for its users.

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

## License
The fork as the original repository requires it is under [GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/).
