
## pre-commit hook

```bash
#!/bin/bash

echo "Running ktlinter git pre-commit hook"

./gradlew formatKotlin lintKotlin

RESULT=$?

# return 1 exit code if running checks fails
[ $RESULT -ne 0 ] && exit 1
exit 0
```