# RestAssuredAPI

A comprehensive API automation framework built with Java, leveraging Rest Assured for seamless REST API testing. Designed for scalability, maintainability, and robust reporting, this framework enables efficient validation of modern APIs for quality and reliability.

---

## 🚀 Features

- **Java-based Automation:** Object-oriented and modular structure.
- **Rest Assured Integration:** Simplifies REST API requests and assertions.
- **POJO for Payloads:** Clean, maintainable request/response data handling.
- **Lombok:** Reduces boilerplate code with annotations for POJOs.
- **TestNG:** Flexible test orchestration and execution.
- **Allure Reporting:** Generates beautiful, insightful test reports.
- **Maven Build:** Easy dependency management and build lifecycle.

---

## 📦 Tech Stack

- **Language:** Java
- **API Testing:** Rest Assured
- **Object Mapping:** POJO, Lombok
- **Testing Framework:** TestNG
- **Reporting:** Allure
- **Build Tool:** Maven

---

## 🏗️ Project Structure

<details>
<summary>Click to expand</summary>

```
RestAssuredAPI/
├── src/
│   ├── main/
│   │   └── java/           # Core framework code, utilities, POJOs
│   └── test/
│       └── java/           # Test cases
├── resources/              # Test data, config files
├── reports/                # Allure reports
├── pom.xml                 # Maven build configuration
└── README.md
```
</details>

---

## ⚡ Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/sudeeppanshikar/RestAssuredAPI.git
   ```
2. **Install dependencies**
   ```bash
   mvn clean install
   ```
3. **Configure settings**
   - Update configuration files in `/resources` as needed.
4. **Run tests**
   ```bash
   mvn test
   ```
5. **Generate Allure Report**
   ```bash
   mvn allure:serve
   ```

---

## 📄 Usage

- Define API request/response models using POJO and Lombok in the `model` package.
- Write test cases in the `tests` package.
- Configure endpoints and environments in the config files.
- View test execution results in Allure reports after running tests.

---

## 📝 Contribution

Contributions are welcome! Please open issues or submit pull requests for enhancements, bug fixes, or new features.

---

## 💬 Support

For questions, suggestions, or collaborations, please open an issue on GitHub or contact [@sudeeppanshikar](https://github.com/sudeeppanshikar).

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

> **Built with ❤️ by [sudeeppanshikar](https://github.com/sudeeppanshikar)**
