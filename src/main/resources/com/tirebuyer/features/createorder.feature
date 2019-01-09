Feature: Launch TireBuyer and execute an order

Scenario: Add an item to cart and checkout
Given I launch tirebuyer.com
When I click Tires tab
And I chose Shop By Vehicle section
And Select year as 2010
And Select 'Honda' from Select Make section
And Select 'Accord' from Select Model section
And Select 'EX 2 Dr. 4 Cyl.' from Select style section 
And Enter zip code as 98003
And I click on Shop tires button
And I click Shop all tires on the Recommendation page 
And I click on More details for the second product in Tires Details page
And I click on Add to cart in the details page
And I click on Deliver to a local installer radio button on the cart page
And Select installer number 3 from the local installer list
And I click on Save and continue button in the Delivery to Installer window.
And I Click on Continue to checkout button on the cart page
And I Click on Checkout with PayPal button on the Payment page
And I Enter any dummy credential for PayPal
And I click on Log In button
And I click on Cancel and return to TireBuyer.com