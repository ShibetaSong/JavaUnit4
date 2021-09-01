package com.shibeta.unit4.day10.meiju;

public class Level {

    public static final Level LOW = new Level(1);
    public static final Level MEDIUM = new Level(50);
    public static final Level HIGH = new Level(100);

    private int levelValue;

    private Level(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }
}
