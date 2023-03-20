# Technology:

- Java v8
- TestNG

# Run project by maven:

Run all tests:
```mvn clean test```

Run with parameters:
```mvn clean test -Dbrowser=chrome -Dsuite=testng -Dheight=1920 -Dwidth=1080 -DthreadCount=2```

# Report launch:

```mvn allure::serve```