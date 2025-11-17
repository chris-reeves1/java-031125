package Rtesting;

public class Main {

}


/*


Testing
-------

Evaluate software to ensure it meets required standards and functions correctly.

    - Verification(specification/requirements) and validation(Expected behaviour).
    - Identify defects, bugs, errors. 
    - Ensure quality. 
    - Types of testing:
        - unit tests - business logic in isolation. 
        - int tests - combined parts. 
        - automation tests - selenium.
        - performance testing/load testing  
        - regression testing
        - security testing - pen testing, security scans(trivy, owasp zap, sonarqube).
        - UAT
        - QA - compliance/data
        - Systems testing

    TDD - test driven dev - write failing tests, then write minimum code to pass.
    
    Testing in Java:
        - Prove a behaviour - one at a time. A unit test should answer
            a simple, clear question. 
        - Isolated, repeatable, fast(<100ms)
        - Document intent. naming convention - clear what failed/passed.
        - failing test should indicate what and why.   

    Rules:
        - AAA pattern
            - arrange (dependancies/inputs) 
            - act (one action)
            - assert (behaviour was intended.)

        - Isolation
            - networks
            - Db's
            - Time
            - Randomness
            - env vars
            - filesystem

        - keep small. test what matters. keep data simple. 
        - Dont test private stuff + language(java)
        - Only test whats publiccly exposed. 

        - do test:
            - happy paths
            - edge cases (null, zero, min/max)
            - Error handling
            - idempotant
            - interactions - was the function called/how many times/order

        




















































 */