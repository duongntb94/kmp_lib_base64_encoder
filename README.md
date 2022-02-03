# KMP Base64 Encoder Library (Native Libraries: XCFramework for iOS - AAR for Android)

A KMP library which written by Kotlin Multiplatform using Kotlin.  
The purpose is to generate native library using KMP (XCFramework for iOS - AAR for Android).  
This library implements a simple Base64 encoder function.

## Getting Started

These instructions will get you building and running the project on your local machine for development and testing purposes. See usage and supported commands for notes on how to use the application.

## Prerequisites

- Android Studio 4.2 or 2020.3.1 Canary 8 or higher.
- Java SDK 11
- Kotlin plugin (in Android Studio)
- Kotlin Multiplatform Mobile (in Android Studio)

For more detail, please access this link: https://kotlinlang.org/docs/kmm-setup.html

## Setup

- Open project with Android Studio.
- Go to `File` > `Sync Project with Gradle Files`.

## Run test
```bash
./gradlew check
```

## Generate Android .aar library
```bash
./gradlew assemble
```
After the process finished, library will be located at `shared/build/outputs/aar`

## Generate iOS .framework
```bash
./gradlew assembleXCFramework # generate both debug/release .framework
./gradlew assembleDebugXCFramework # generate debug framework - additionally debug artifact that contains dSYMs
./gradlew assembleReleaseXCFramework # generate release framework
```

## Usage (in IOS)
1. Create new project.
2. Go to Target > Link Binary with Libraries > Click [+] button > Add the `shared.framework`
into project
3. In Swift file, `import shared`, and use `Base64Encoder` in your code.

## References
https://kotlinlang.org/docs/mpp-build-native-binaries.html
https://www.marcogomiero.com/posts/2021/kmp-existing-project/

## License

This project is licensed under the MIT License - see the LICENSE file for details
