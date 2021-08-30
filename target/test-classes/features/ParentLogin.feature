 Feature: Parent Login
 Checking Login Functionality 
 
  Scenario Outline: Login successfully
  Given Parent In the Login Page
  When Enter Valid <username> and <password>
  Then Parent Redirected to Profile Page
  
  Examples:
  |username|password|
  |"anas123@gmail.com|"123456"|
  