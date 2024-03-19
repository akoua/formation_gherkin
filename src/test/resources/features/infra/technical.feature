Feature: Process to verify all observability of application

  Background:
    * a root logger set to DEBUG

  Scenario: verify that application is UP
#    When we get "/actuator/health"
    When the api management calls "/actuator/health"
    Then it receives a status OK_200 and a Map:
    """yml
    status: UP
    groups:
    - custom
    """