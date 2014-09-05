# Lighter

Android Test-Setup Project

### Maven:

#### Profile - 'unit-tests'

* Run unit-tests:

  `mvn [clean] test -Punit-tests`


* Run unit tests and run app:

  `mvn [clean] install anroid:run -Punit-tests`

#### Profile - 'integration-tests' (default)

* Run unit and integration-tests:

  `mvn [clean] install`

* Run unit and integration-tests and run app:
  
  `mvn [clean] install android:run`

### Gradle:

* still in work