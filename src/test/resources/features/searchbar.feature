Feature: Search Bar Functionality

Scenario: Search for a valid term
    Given the user is on the website
    And the user opened the search
    When the user enters "Apple" to the search bar
    And the user submits the search
    Then the search results should display items related to "Apple"
    And the search results should display 2 items

Scenario: Search for a valid term with special characters
    Given the user is on the website
    And the user opened the search
    When the user enters "(1000ml)" to the search bar
    And the user submits the search
    Then the search results should display items related to "(1000ml)"
    And the search results should display 6 items

Scenario: Search for an invalid term
    Given the user is on the website
    And the user opened the search
    When the user enters "!@#$" to the search bar
    And the user submits the search
    Then the search results should display no results found

Scenario: Search for an excessively long input
    Given the user is on the website
    And the user opened the search
    When the user enters "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eu laoreet ipsum, fermentum pretium eros. Proin sem purus, fringilla eu suscipit eget, faucibus ut lectus. Sed id erat et odio fermentum tempus id id massa. Sed gravida ante non nisi condimentum efficitur. Nam venenatis risus ac mollis pretium. Donec vel erat eleifend, vestibulum justo a, elementum tellus. Vestibulum ac varius neque, lobortis pharetra sem. Sed at dictum arcu, luctus vestibulum risus. Vestibulum at velit nec justo pulvinar mattis quis finibus enim. In magna arcu, feugiat ac laoreet eget, varius non nunc. In sodales sapien enim, quis ornare lorem egestas a. In interdum mi id ligula molestie, eu lacinia ligula placerat. Quisque leo felis, congue quis est eu, efficitur pulvinar urna. Nullam odio elit, vehicula nec sapien non, efficitur pulvinar felis. Praesent molestie eros at ipsum ullamcorper, sit amet eleifend purus molestie. Sed id tellus non sapien pulvinar dictum." to the search bar
    And the user submits the search
    Then the search results should display no results found

Scenario: Search with no input
    Given the user is on the website
    And the user opened the search
    When the user presses enter
    Then there will be no redirection

Scenario: Result pages should appear and be navigable
    Given the user is on the website
    And the user opened the search
    When the user enters "   " to the search bar
    And the user submits the search
    And the user dismisses the popup
    And the user scrolls to the bottom
    And the user clicks the next page button
    Then the next page of result should appear

Scenario: Verify "Clear" functionality
    Given the user is on the website
    And the user opened the search
    When the user enters "Apple" to the search bar
    And the user clicks the clear button
    Then the search bar should disappear

Scenario: Case insensitive search
    Given the user is on the website
    And the user opened the search
    When the user enters "APPLE" to the search bar
    And the user submits the search
    Then the search results should display items related to "APPLE"
    And the search results should display 2 items

Scenario: Search with SQL injection
    Given the user is on the website
    And the user opened the search
    When the user enters "' OR 1=1; --" to the search bar
    And the user submits the search
    Then the search results should display no results found