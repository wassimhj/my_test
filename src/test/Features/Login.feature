@Login
Feature: Login

    This login feature deals with the login functionalities

    @Stable
    Scenario: Verify user can fill and send the form
        * Enter name and surname
        * Select a city
        * Enter email
        * Enter phone number
        * Submit form
        * Form should be submitted

    Scenario: Verify that the form does not accept wrong email
        * Enter name and surname
        * Select a city
        * Enter a wrong email
        * Enter phone number
        * Submit form
        * Form should be submitted
