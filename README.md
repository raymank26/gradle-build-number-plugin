## About

This plugin helps to maintain a version of Gradle project in a separate `build.number` file.

## Tasks

`:createBuildNumber` — creates a `build.number` file with a version equals to `0.0.1`.
`:incrementBuildNumber` — increments a fix version in a `build.number` file.

## A structure of a `build.number` file

```properties
#Thu Nov 30 21:01:13 MSK 2023
version=0.0.4
```

## Usage

1. Add a plugin block into `plugins{}` section:

    ```
        id("com.github.raymank26.build-number") version "0.0.1"
    ```

2. Update project version `version = rootProject.getBuildNumberVersion()`. Now your version is read from
   a `build.number` file.

At this point you can use `build.number` as a source of truth for a version of the project.




