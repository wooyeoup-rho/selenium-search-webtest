# Selenium WebDriver & Cucumber Web Tests

Basic automation framework using Selenium WebDriver and Cucumber.

Testing the search functinonality at [OWASP Juice Shop](https://juice-shop.herokuapp.com/) in the following scenarios:

1. Search for a valid term (Apple)
2. Search for a valid term with special characters (1000ml)
3. Search with an invalid term (!@#$)
4. Search with an excessively long input (lorem ipsum first paragraph)
5. Search with no input
6. Case insensitive search
7. Search with SQL injection
8. Verify clear button works
9. Verify pagination and page results