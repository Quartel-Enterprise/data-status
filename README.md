# Data Status

A Kotlin library for handling data loading states in a type-safe way.

A good use case for applying it is when you have parts of your model that may frequently have a loading state, such as when rendering a shimmer effect, for example.

## Installation

Add the following to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("software.quare:data-status:0.2.0")
}
```

## Usage

```kotlin
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

## Extensions

DataStatus provides several useful extensions to make working with loading states more convenient:

### Type Conversion
```kotlin
// Convert a value to a loaded state
val name = "John"
val nameStatus = name.toLoadedStatus() // DataStatus.Loaded("John")

// Extract data from a loaded state
val data = nameStatus.toLoadedData() // "John"
val loadedInfo = nameStatus.toLoadedInformation() // DataStatus.Loaded("John")
```

### Transformation
```kotlin
// Transform loaded data while preserving the loading state
data class User(val name: String, val age: Int)
val userStatus = DataStatus.Loaded(User("John", 30))

// Extract specific fields
val nameStatus = userStatus.mapToStatus { name } // DataStatus.Loaded("John")
val ageStatus = userStatus.mapToStatus { age } // DataStatus.Loaded(30)
```

### List Operations
```kotlin
// Convert a list of values to loaded states
val names = listOf("John", "Jane")
val nameStatuses = names.toLoadedStatus() // List<DataStatus.Loaded<String>>

// Extract data from a list of states
val dataList = nameStatuses.toLoadedData() // List<String>
```

### State Checking
```kotlin
// Check if a state is loading
val isLoading = userStatus.isLoading() // false
```

### Generate a list of loading states
```kotlin
// Create a list of loading states
val loadingList = DataStatusUtils.generateLoading(5)
```

## License

This project is licensed under the MIT License - see the LICENSE file for details. 
