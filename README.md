# Chat App — Login Project

A Java-based Chat App registration and login system with console and HTML interfaces, built with JUnit 5 unit tests.

---

## Project Structure

```
login-project/
├── src/
│   ├── main/java/
│   │   ├── Login.java       # Core registration & login logic
│   │   └── Main.java        # Console interface
│   └── test/java/
│       └── LoginTest.java   # JUnit 5 unit tests
├── web/
│   ├── index.html           # Main menu screen
│   ├── register.html        # Registration screen
│   ├── login.html           # Login screen
│   ├── validation.js        # Client-side validation logic
│   └── style.css            # Styling
├── lib/
│   └── junit-platform-console-standalone.jar
├── out/                     # Compiled class files (auto-generated)
└── pom.xml                  # Maven build file
```

---

## Prerequisites

- **Java 11+** — [Download](https://adoptium.net)
- **Maven** *(optional — only needed for `mvn` commands)*

Check your Java version:
```bash
java --version
```

---

## Option 1 — Run the Console App

### Step 1: Compile
```bash
mkdir -p out/main
javac -d out/main src/main/java/Login.java src/main/java/Main.java
```

### Step 2: Run
```bash
java -cp out/main Main
```

You will see an interactive menu:
```
========================================
           CHAT APP - MAIN MENU
========================================
  1. Register
  2. Login
  3. Exit
========================================
  Select an option:
```

---

## Option 2 — Run the HTML App

No server needed — just open the file directly in your browser:

```bash
open web/index.html
```

Or double-click `web/index.html` in Finder.

**Screens:**
- `index.html` — Main menu
- `register.html` — Create an account
- `login.html` — Log in to your account

> Account data is stored in `sessionStorage` — it persists for the browser tab session.

---

## Option 3 — Run Unit Tests (JUnit 5)

### Using the standalone JUnit JAR (no Maven required)

#### Step 1: Compile
```bash
mkdir -p out/main out/test
javac -d out/main src/main/java/Login.java
javac -cp lib/junit-platform-console-standalone.jar:out/main -d out/test src/test/java/LoginTest.java
```

#### Step 2: Run tests
```bash
java -jar lib/junit-platform-console-standalone.jar \
  --class-path out/main:out/test \
  --scan-class-path
```

### Using Maven (if installed)
```bash
mvn test
```

### Expected output
```
[         20 tests found           ]
[         20 tests successful      ]
[          0 tests failed          ]
```

---

## Validation Rules

| Field       | Rule                                                              |
|-------------|-------------------------------------------------------------------|
| Username    | Must contain an underscore (`_`) and be no more than 5 characters |
| Password    | Min 8 characters, with uppercase letter, number & special character |
| Cell Phone  | Must include international country code (e.g. `+27831234567`)    |

---

## Login Class Methods

| Method                    | Returns  | Description                              |
|---------------------------|----------|------------------------------------------|
| `checkUserName()`         | boolean  | Validates username format                |
| `checkPasswordComplexity()` | boolean | Validates password complexity rules      |
| `checkCellPhoneNumber()`  | boolean  | Validates cell phone via regex           |
| `registerUser()`          | String   | Runs all checks, returns status message  |
| `loginUser()`             | boolean  | Matches credentials against stored user  |
| `returnLoginStatus()`     | String   | Returns welcome or failure message       |
