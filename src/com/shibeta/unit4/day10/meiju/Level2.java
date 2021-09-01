package com.shibeta.unit4.day10.meiju;

public enum Level2 {
    LOW(1), MEDIUM(50), HIGH(100);

    private int levelValue;

    private Level2(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }
}
