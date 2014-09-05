# Lighter

Android Test-Setup Project

[![Build Status](https://travis-ci.org/aschulhofer/lighter.svg?branch=master)](https://travis-ci.org/aschulhofer/lighter)

### Maven:

#### Profile - 'unit-tests'  (default)

* Run unit-tests:

  `mvn [clean] test`


* Run unit tests and run app:

  `mvn [clean] install anroid:run`

#### Profile - 'integration-tests'

* Run unit and integration-tests:

  `mvn [clean] install -Pintegration-tests`

* Run unit and integration-tests and run app:
  
  `mvn [clean] install android:run -Pintegration-tests`

### Gradle:

* still in work