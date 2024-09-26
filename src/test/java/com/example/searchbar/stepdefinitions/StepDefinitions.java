package com.example.searchbar.stepdefinitions;

import com.example.searchbar.pages.SearchPage;
import com.example.searchbar.utils.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        searchPage = new SearchPage(driver);
    }

    @After
    public void teardown() {
        Driver.quitDriver();
    }

    @Given("the user is on the website")
    public void user_is_on_website() {
        driver.get("https://juice-shop.herokuapp.com/#/");
        searchPage.clickDismissButton();
    }

    @Given("the user opened the search")
    public void user_opened_search() {
        searchPage.clickSearchButton();
    }

    @When("the user enters {string} to the search bar")
    public void user_enters_string_in_search(String searchTerm) {
        searchPage.enterSearchTerm(searchTerm);
    }

    @When("the user submits the search")
    public void user_submits_search() {
        searchPage.submitSearch();
    }

    @When("the user presses enter")
    public void user_presses_enter() {
        searchPage.pressesEnter();
    }

    @When("the user dismisses the popup")
    public void user_dismisses_popup() {
        searchPage.clickOnDismissCookiesButton();
    }

    @When("the user scrolls to the bottom")
    public void user_scrolls_to_bottom() {
        searchPage.scrollToBottom();
    }

    @When("the user clicks the next page button")
    public void user_clicks_next_page() {
        searchPage.clickNextPage();
    }

    @When("the user clicks the clear button")
    public void user_clicks_clear_button() {
        searchPage.clickClearButton();
    }

    @Then("the search results should display items related to {string}")
    public void search_results_related_to_string(String searchTerm) {
        assertTrue(searchPage.getSearchValue().contains(searchTerm));
    }

    @Then("the search results should display no results found")
    public void search_results_no_results_found() {
        assertTrue(searchPage.getNoResultsText().contains("No results found"));
    }

    @Then("the next page of result should appear")
    public void search_results_next_page() {
        assertTrue(searchPage.getPreviousPageButton().isEnabled());
        assertTrue(searchPage.getPageLabelText().contains("13 – 24 of 37"));
    }

    @Then("the search results should display {int} items")
    public void search_results_contains_items(int numItems) {
        assertEquals(numItems, searchPage.getSearchResultsCount());
    }

    @Then("there will be no redirection")
    public void no_redirection() {
        assertTrue(searchPage.getHeadingText().contains("All Products"));
    }

    @Then("the search bar should disappear")
    public void search_bar_disappear() {
        assertFalse(searchPage.getSearchContainerClass().contains("mat-focused"));
    }
}