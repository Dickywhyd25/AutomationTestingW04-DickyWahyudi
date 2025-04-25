package com.juaracoding.utils;

public enum ScenarioTest {

    TCC_HR_001("Login failed with invalid credentials"),

    TCC_HR_002("Login with empty username"),

    TCC_HR_003("Login with empty password"),

    TCC_HR_004("Login successful with valid credentials"),

    TCC_HR_005("Add product to cart"),

    TCC_HR_006("Continue shopping and add product to cart");

    private final String scenarioTestName;

    ScenarioTest(String scenarioTestName) {
        this.scenarioTestName = scenarioTestName;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }
}
