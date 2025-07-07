# JUnit Testing
### What is Unit Testing?
- **Unit Testing** = Testing individual components (usually methods) in isolation.
  - Ensures correctness of logic
  - Detects regression early
  - Forms part of TDD (Test-Driven Development)
### Annotations in JUnit-5
| Annotation            | Purpose                                   |
| --------------------- | ----------------------------------------- |
| `@Test`               | Marks a method as a test                  |
| `@BeforeEach`         | Run before each test                      |
| `@AfterEach`          | Run after each test                       |
| `@BeforeAll`          | Run once before all tests (static method) |
| `@AfterAll`           | Run once after all tests (static method)  |
| `@DisplayName("...")` | Custom name for test                      |
| `@Disabled`           | Temporarily disables a test               |
| `@Nested`             | Supports nested tests                     |
| `@Tag("...")`         | Tag tests for filtering                   |
| `@RepeatedTest(N)`    | Runs test N times                         |
| `@ParameterizedTest`  | Runs test with multiple inputs            |
### Assertions in JUnit-5
| Assertion                                          | Description             |
| -------------------------------------------------- | ----------------------- |
| `assertEquals(expected, actual)`                   | Value equality          |
| `assertTrue(condition)`                            | Check boolean true      |
| `assertFalse(condition)`                           | Check boolean false     |
| `assertThrows(Exception.class, () -> ...)`         | Exception test          |
| `assertNotNull(obj)`                               | Not null check          |
| `assertAll(...)`                                   | Run multiple assertions |
| `assertTimeout(Duration.ofMillis(500), () -> ...)` | Timeout check           |
