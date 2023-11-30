[![CI](https://github.com/raymank26/gradle-build-number-plugin/actions/workflows/ci.yml/badge.svg)](https://github.com/raymank26/gradle-build-number-plugin/actions/workflows/ci.yml)

## About

This plugin helps maintain the version of a Gradle project in a separate `build.number` file.

There are a few reasons why this is useful:

1. Easy to parse for CI/CD scripts.
2. One well-known place where the version is stored compared to a random line in `build.gradle.kts`.
3. Additional date comment maintains the built date.
4. A few tasks for version manipulation.

## Tasks

- `:createBuildNumber` — creates a `build.number` file with a version equal to `0.0.1`.
- `:incrementBuildNumber` — increments a fix version in a `build.number` file.
- `:refreshBuildNumber` — updates a date (top commented line) in a `build.number` file.

## Usage

1. Add a plugin block into the `plugins{}` section:

    ```groovy
    plugins {
        id("io.github.raymank26.build-number") version "0.0.1"
    }
    ```

2. Update the project version: `version = rootProject.getBuildNumberVersion()`. Now, your version is read from
   a `build.number` file.

At this point, you can use `build.number` as the source of truth for the version of the project.

## Structure of a `build.number` file

```properties
# Thu Nov 30 21:01:13 MSK 2023
version=0.0.4
```
