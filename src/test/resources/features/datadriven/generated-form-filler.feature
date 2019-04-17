Feature: Form filler according to csv.

@Sample
    @DataDriven
    Scenario: generated scenario for csv line 1
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter 'testfirstname' for first name
        And enter 'testlastname' for last name
        And enter 'email1@test.com' for email
        And enter '1234567890' for phone
        And enter 'test address 1' for address
        And enter 'test city' for city
        And select 'Florida' for state
        And enter '1001' for zip
        And enter 'domain1.test.com' for domain
        And select radiobutton 'yes' for hosting
        And enter 'test description 1' for project description
        And submit form
        Then page is reloaded.

    @DataDriven
    Scenario: generated scenario for csv line 2
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter 'geza' for first name
        And enter 'test' for last name
        And enter 'email2@test.com' for email
        And enter '321654978' for phone
        And enter 'test address 2' for address
        And enter 'test city' for city
        And select 'California' for state
        And enter '1002' for zip
        And enter 'domain2.test.com' for domain
        And select radiobutton 'yes' for hosting
        And enter 'test description 2' for project description
        And submit form
        Then page is reloaded.

    @DataDriven
    Scenario: generated scenario for csv line 3
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter 'istvan' for first name
        And enter 'test' for last name
        And enter 'email3@test.com' for email
        And enter '456789312' for phone
        And enter 'test address 3' for address
        And enter 'test city' for city
        And select 'Alaska' for state
        And enter '1003' for zip
        And enter 'domain3.test.com' for domain
        And select radiobutton 'yes' for hosting
        And enter 'test description 3' for project description
        And submit form
        Then page is reloaded.

    @DataDriven
    Scenario: generated scenario for csv line 4
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter 'miklos' for first name
        And enter 'test' for last name
        And enter 'email4@test.com' for email
        And enter '987456321' for phone
        And enter 'test address 4' for address
        And enter 'test city' for city
        And select 'Washington' for state
        And enter '1004' for zip
        And enter 'domain4.test.com' for domain
        And select radiobutton 'no' for hosting
        And enter 'test description 4' for project description
        And submit form
        Then page is reloaded.

    @DataDriven
    Scenario: generated scenario for csv line 5
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter 'gergely' for first name
        And enter 'test' for last name
        And enter 'email5@test.com' for email
        And enter '456987123' for phone
        And enter 'test address 5' for address
        And enter 'test city' for city
        And select 'New York' for state
        And enter '1005' for zip
        And enter 'domain5.test.com' for domain
        And select radiobutton 'no' for hosting
        And enter 'test description 5' for project description
        And submit form
        Then page is reloaded.

