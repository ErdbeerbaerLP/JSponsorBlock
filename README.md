# JSponsorBlock

JSponsorBlock is an simple java library for getting [SponsorBlock](https://sponsor.ajay.app) segments for Videos

## Usage

### Gradle

```gradle
repositories{
   maven { url "https://repo.erdbeerbaerlp.de/repository/maven-public/" }
}

dependencies{
   implementation 'de.erdeerbaerlp.jsponsorblock:jsponsorblock:1.0.0'
}
```

### Maven

Repo
```maven
<repository>
   <id>erdbeerbaerlp</id>
   <name>ErdbeerbaerLP Repository</name>
   <url>https://repo.erdbeerbaerlp.de/repository/maven-public/</url>
</repository>
```
Dependency
```maven
<dependency>
   <groupId>de.erdbeerbaerlp</groupId>
   <artifactId>jsponsorblock</artifactId>
   <version>1.0.0</version>
 </dependency>
```

### Sample Code

```java
import de.erdbeerbaerlp.jsponsorblock.Category;
import de.erdbeerbaerlp.jsponsorblock.JSponsorBlock;
import de.erdbeerbaerlp.jsponsorblock.Segment;

import java.io.IOException;

public class Example {
    public void example() {
        try {
            //Get all the segments for https://www.youtube.com/watch?v=8EXrxGByJJg
            Segment[] segments = JSponsorBlock.getSkipableSegments("8EXrxGByJJg");
            //Iterate over them and print some info
            for (Segment segment : segments) {
                System.out.println("Found a segment of type " + segment.getCategory().name());
                System.out.println("Start: " + segment.getSegmentStart() + "End: " + segment.getSegmentEnd());
                System.out.println("This segment has " + segment.votes + " votes");

                if (segment.category.equals(Category.SPONSOR)) {
                    System.out.println("This video is sponsored by [...]");
                }
            }
        } catch (IOException e) {
            System.out.println("No segments found OR fetching failed. Handle accordingly");
        }
    }
}
```