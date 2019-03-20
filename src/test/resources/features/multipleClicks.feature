Feature: Multiple clicks

@Sample
@MultipleClicks
Scenario: Clicking on multiple alert buttons on bootstrap alerts page
Given Open site
When Click to 'Alerts_&_Modals' menu item
And Click to 'Bootstrap_Alerts' submenu item
Then The bootstrap alerts page opens
When Click to all of the normal bootstrap alert buttons
Then All of the alert messages show up