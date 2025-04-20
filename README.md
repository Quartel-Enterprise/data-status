# Data Status

A Kotlin library for handling data loading states in a type-safe way.

## Installation

Add the following to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.quare:data_status:0.1.0")
}
```

## Usage

```kotlin
import com.quare.data_status.DataStatus

// Create a loaded state
val loadedData = DataStatus.Loaded("some data")

// Create a loading state
val loadingState = DataStatus.Loading

// Use with data classes
data class User(
    val id: String,
    val photo: DataStatus<String?>,
    val name: String,
    val email: String?
)

// Example usage
val user = User(
    id = "123",
    photo = DataStatus.Loaded("https://example.com/photo.jpg"),
    name = "John Doe",
    email = "john@example.com"
)
```

## Publishing New Versions

To publish a new version to Maven Central:

1. Update the version in `data_status/build.gradle.kts`
2. Create and push a new tag with the version number:
   ```bash
   git tag v0.1.0
   git push origin v0.1.0
   ```
3. The GitHub Actions workflow will automatically build and publish the package

## License

This project is licensed under the MIT License - see the LICENSE file for details. 