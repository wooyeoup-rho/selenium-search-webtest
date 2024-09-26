package com.example.searchbar.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage extends BasePage {
    @FindBy(css = ".close-dialog")
    private WebElement dismissButton;

    @FindBy(css = ".mat-search_icon-search")
    private WebElement searchButton;

    @FindBy(css = ".mat-search_field")
    private WebElement searchContainer;

    @FindBy(css = ".mat-input-element")
    private WebElement searchInput;

    @FindBy(css = ".heading")
    private WebElement heading;

    @FindBy(id = "searchValue")
    private WebElement searchValue;

    @FindBy(css = ".noResultText")
    private WebElement noResultsText;

    @FindBy(css = ".cc-window")
    private WebElement cookiesWindow;

    @FindBy(css = ".cc-dismiss")
    private WebElement dismissCookiesButton;

    @FindBy(css = ".mat-paginator-navigation-next")
    private WebElement nextPageButton;

    @FindBy(css = ".mat-paginator-navigation-previous")
    private WebElement prevPageButton;

    @FindBy(css = ".mat-paginator-range-label")
    private WebElement pageLabel;

    @FindBy(css = ".mat-grid-tile")
    private List<WebElement> searchResults;

    @FindBy(css = ".mat-search_icon-close")
    private WebElement clearButton;
    

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickDismissButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dismissButton)).click();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void enterSearchTerm(String searchTerm) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(searchTerm);
    }

    public void submitSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> webDriver.getCurrentUrl().contains("search?q="));
    }

    public void pressesEnter() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(Keys.ENTER);
    }

    public String getSearchValue() {
        return wait.until(ExpectedConditions.visibilityOf(searchValue)).getText();
    }

    public String getNoResultsText() {
        return wait.until(ExpectedConditions.visibilityOf(noResultsText)).getText();
    }

    public void clickOnDismissCookiesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dismissCookiesButton)).click();
        wait.until(ExpectedConditions.attributeContains(cookiesWindow, "style", "display: none"));
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    public void clickNextPage() {
        wait.until(ExpectedConditions.visibilityOf(nextPageButton)).click();
    }

    public WebElement getPreviousPageButton() {
        return wait.until(ExpectedConditions.visibilityOf(prevPageButton));
    }

    public String getPageLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(pageLabel)).getText();
    }

    public int getSearchResultsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(searchResults)).size();
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOf(heading)).getText();
    }

    public void clickClearButton() {
        wait.until(ExpectedConditions.visibilityOf(clearButton)).click();
    }

    public String getSearchContainerClass() {
        return wait.until(ExpectedConditions.visibilityOf(searchContainer)).getAttribute("class");
    }
}