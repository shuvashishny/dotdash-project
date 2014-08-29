This is a fun project where I briefly extended the functionality of <a href="https://github.com/amadeuspzs/TODO/tree/NSS-TODO">NSS-TODO-List v 1.1</a> made by "amadeus.maclab.org".


<h3>Setup:</h3>

In order to install the NSS-TODO-List (extended) application:
<ul>
<li>Make sure that you have a server installed that can serve PHP. Apache would be a good option.</li>
<li>Make sure you have a PHP 5.2.5 or higher installed on your system.</li>
<li>Start the Apache server if it is not already running.</li>
<li>Checkout the project from here (https://github.com/nxqamar/nss-todo-list-extended.git) and put it in the 'htdocs' (/www) folder of Apache.</li>
<li><strong>Note:</strong> You may want to explore your file read/write permissions on your local file system.</li>
<li>Go to http://localhost/nss-todo-list-extended/index.php and access the application.</li>
</ul>
<h3>Test Cases:</h3>
Write test cases to test various functionalities and features of this app. Imagine you are a QA Lead and how would you go about successfully testing this app. The more scenarios you cover the better coverage you can provide. Please provide your test cases in plain English and paste them under /test_cases.txt file.

<h3>Automation:</h3>
The goal is to use Selenium Webdriver with preferably Java bindings (or any other OO language of your choice). Automate the above test cases in order to test the functional flow through of the application. In particular, we want to test options around creating a todo, assigning categories, modifying/deleting existing todos etc. The application should itself be fairly self-explanatory. Feel free to email us (nqamar@about.com) with any questions about it.


<h3>Bonus exercise:</h3>
Try to use Cucumber. Translate the above test cases to Cucumber gherkin code and then automate them.

<h3>Submission instructions:</h3>
Simply create a new branch under the same repository and push your changes. It is fine if you already have a personal GitHub repository. Just sumbit the proper link to your exercise. Please try to use only one branch and avoid pushing your changes to the master branch!

<h3>Resources:</h3>
<li>API call for backend data validation: There's a fake API call that outputs JSON of the flat file at http://localhost/nss-todo-list-extended/fake-API-call.php </li>
<li>Cucumber documentation: https://github.com/cucumber/cucumber/wiki </li>
<li>Selenium documentation: http://docs.seleniumhq.org/projects/webdriver/ </li>


