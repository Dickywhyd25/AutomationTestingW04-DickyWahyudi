package com.juaracoding.strategy;


import com.juaracoding.manager.ChromeManager;

public class DriverStrategyImplementor {

    public static ChromeManager chooseStrategy(String strategy) {
        switch (strategy.toUpperCase()) {
            case "CHROME":
            default:
                return new ChromeManager(); // fallback default
        }
    }
}
