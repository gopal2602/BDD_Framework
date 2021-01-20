#Author: gopal.gudi@gowrisoftsolutions.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :
@Execute
Feature: Create and Modify User with All Mandatory fields
Description This feaure describes create user functionalities.

Scenario: Create User with All fields
Given I launch the application
And I navigate to the url of the application
|url|
|https://enigmatic-meadow-39517.herokuapp.com/students|
When I login using valid credentials
|username|password|
|gopal.gudi@gmail.com|Qwerty@1982|
Then the Home page should display
Given I click on Users tab
And I click on New User button
When I enter all mandatory fields
|firstname|lastname|email|phonenumber|address|state|zipcode|
|demo|User1|demoUser@gmail.com|9880098800|7th Main,6th Cross Vijayanagar|Karnataka|560021|
And I click on Create User button
Then I get a successful user creation message
Given I click on back button
And I click on destroy button
Then I get a successful user deletion message
When I click on Logout button
Then I find the login page
And I close the Application

Scenario: Modify the User with All Fields
Given I launch the application
And I navigate to the url of the application
|url|
|https://enigmatic-meadow-39517.herokuapp.com/students|
When I login using valid credentials
|username|password|
|gopal.gudi@gmail.com|Qwerty@1982|
Then the Home page should display
Given I click on Users tab
And I click on New User button
When I enter all mandatory fields
|firstname|lastname|email|phonenumber|address|state|zipcode|
|demo|User1|demoUser@gmail.com|9880098800|7th Main,6th Cross Vijayanagar|Karnataka|560021|
And I click on Create User button
Then I get a successful user creation message
Given I click on edit button
When I update the user
|firstname|lastname|email|phonenumber|address|state|zipcode|
|demoNew|User1New|demoUserNew@gmail.com|9887700009|10th Main,19th Cross Hampinagar|Karnataka|560027|
Then I get a successful user updation message
Given I click on back button
And I click on destroy button
Then I get a successful user deletion message
When I click on Logout button
Then I find the login page
And I close the Application