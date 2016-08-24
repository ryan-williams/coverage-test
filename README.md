# coverage-test
Reproduce coveralls-maven-plugin problem:

```bash
mvn clean test jacoco:report coveralls:report
```

Observe error:

```
[ERROR] Failed to execute goal org.eluder.coveralls:coveralls-maven-plugin:4.2.0:report (default-cli) on project test: Build error: Line number 7 is greater than the source file src/main/scala/org/foo/B.scala size -> [Help 1]
```

[A.scala:7](https://github.com/ryan-williams/coverage-test/blob/607d2486e42ea4d7a24ac3c5f23e75fc96898f1b/src/main/scala/org/foo/A.scala#L7) is where `case class A` is declared, and for some reason that is being looked up in [B.scala](https://github.com/ryan-williams/coverage-test/blob/607d2486e42ea4d7a24ac3c5f23e75fc96898f1b/src/main/scala/org/foo/B.scala), which is only 6 lines long.

The error goes away if either class is made non-`case` or if the `val foo` in `B` is removed.
