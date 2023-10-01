Feature: Saucedemo Test Products Add To Cart


	Scenario Outline:: Products Sorting

	And User Login into Website with "<Username>" and "<Userpassword>"
	Given User Sort Product with Price high to low
	Given User Sort Product with Price low to high
	Given User Sort Product with Name A to Z
	Given User Sort Product with Name Z to A
	Given User Add product to cart
	Then the Cart badge should be update
	Given User Remove product which is alredy selected
	Then the Cart badge should be update with less
	
 Examples: use the to run
| Username	|	Userpassword	|
| standard_user	| secret_sauce	|
