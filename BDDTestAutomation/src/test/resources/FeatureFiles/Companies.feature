#Author: gopal.gudi@gowrisoftsolutions.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :
@Execute
Feature: Create and Modify Company with All Mandatory fields
Description This feaure describes create and modify company functionalities.

Scenario: Create Company with All fields
Given I launch the application
And I navigate to the url of the application
|url|
|https://enigmatic-meadow-39517.herokuapp.com/students|
When I login using valid credentials
|username|password|
|gopal.gudi@gmail.com|Qwerty@1982|
Then the Home page should display
Given I click on Companies tab
And I click on New Company button
When I enter all mandatory fields for company
|name|email|phonenumber|address|
|demoCompany|demoCompany@gmail.com|9880098800|7th Main,6th Cross Vijayanagar|
And I click on Create Company button
Then I get a successful company creation message
Given I click on back button for company
And I click on destroy button for company
Then I get a successful company deletion message
When I click on Logout button
Then I find the login page
And I close the Application


Scenario: Modify the Company with All Fields
Given I launch the application
And I navigate to the url of the application
|url|
|https://enigmatic-meadow-39517.herokuapp.com/students|
When I login using valid credentials
|username|password|
|gopal.gudi@gmail.com|Qwerty@1982|
Then the Home page should display
Given I click on Companies tab
And I click on New Company button
When I enter all mandatory fields for company
|name|email|phonenumber|address|
|demoCompany|demoCompany@gmail.com|9880098800|7th Main,6th Cross Vijayanagar|
And I click on Create Company button
Then I get a successful company creation message
Given I click on edit button for company
When I update the company
|name|email|phonenumber|address|
|NewdemoCompany|NewdemoCompany@gmail.com|9880098800|8th Main,19th Cross Hampinagar|
Then I get a successful company updation message
Given I click on back button for company
And I click on destroy button for company
Then I get a successful company deletion message
When I click on Logout button
Then I find the login page
And I close the Application