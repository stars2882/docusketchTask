Feature: Login in Gmail

  Scenario Outline: Positive credentials testing

    Given User opens home page
    And Enter login '<login>' in field
    And Enter password '<password>' in field
    Then Check we are logged in gmail

    Examples:
      | login                     | password |
      | docusketch.task@gmail.com | 101010ab |
      | docusketch.task           | 101010ab |
      | 0636883296                | 101010ab |

  Scenario Outline: Negative testing login

    Given User opens home page
    And Enter login '<login>' in field
    Then Check for an error message login

    Examples:
      | login                                     |
      | task@gmail.com                            |
      | C5ByHQxZidvYiH6m5Yu4HsYNP2z9GGx@gmail.com |
      | oabhnk%&oebyttzfsa#g^j#@#                 |
      |                                           |

  Scenario Outline: Testing a valid username and a non-valid password

    Given User opens home page
    And Enter login '<login>' in field
    And Enter password '<password>' in field
    Then Check for an error message password

    Examples:
      | login                     | password                                                      |
      | docusketch.task@gmail.com |                                                               |
      | docusketch.task@gmail.com | a                                                             |
      | docusketch.task@gmail.com | Aa!@#$%^&*()-_+=`~/\,.?>< b / PaSSword!@#$%^&*()-_+=`~/\,.?>< |