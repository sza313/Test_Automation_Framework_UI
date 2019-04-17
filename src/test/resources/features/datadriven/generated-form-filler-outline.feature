Feature: Generated feature file for data-driven scnearios - Form Filler on seleniumeasy.com

    @DataDriven
    Scenario Outline: generated scenario for Form filler
        Given Open site with 'chrome'
        And navigate to url 'https://www.seleniumeasy.com/test/input-form-demo.html'
        When enter <firstname> for first name
        And enter <lastname> for last name
        And enter <email> for email
        And enter <phone> for phone
        And enter '<address>' for address
        And enter '<city>' for city
        And select '<state>' for state
        And enter <zip> for zip
        And enter <domain> for domain
        And select radiobutton <hosting> for hosting
        And enter '<project-description>' for project description
        And submit form
        Then page is reloaded.
		Examples:
			| firstname | lastname | email | phone | address | city | state | zip | domain | hosting | project-description |
			|testfirstname|testlastname|email1@test.com|1234567890|test address 1|test city|Florida|1001|domain1.test.com|yes|test description 1|
			|geza|test|email2@test.com|321654978|test address 2|test city|California|1002|domain2.test.com|yes|test description 2|
			|istvan|test|email3@test.com|456789312|test address 3|test city|Alaska|1003|domain3.test.com|yes|test description 3|
			|miklos|test|email4@test.com|987456321|test address 4|test city|Washington|1004|domain4.test.com|no|test description 4|
			|gergely|test|email5@test.com|456987123|test address 5|test city|New York|1005|domain5.test.com|no|test description 5|
