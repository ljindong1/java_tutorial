package org.example.myapp;

public class EnumTutorial {
    public static void main(String[] args) {
        // 1. enum 사용 및 getLevel()
        Grade g = Grade.GOLD;
        System.out.println("Level: " + g.getLevel());  // 출력: 2

        // 2. enum toString() 및 values() 순회
        for (Grade grade : Grade.values()) {
            System.out.println(grade.name() + " - Level: " + grade.getLevel() + ", Bonus: " + grade.getBonus());
        }

        // 3. valueOf 사용
        Grade fromName = Grade.valueOf("SILVER");
        System.out.println("From valueOf: " + fromName);

        // 4. 사용자 정의 fromLevel 메서드
        Grade fromLevel = Grade.fromLevel(1);
        System.out.println("From level 1: " + fromLevel);

        // 5. switch 문 사용
        switch (g) {
            case BASIC -> System.out.println("Basic Member");
            case SILVER -> System.out.println("Silver Member");
            case GOLD -> System.out.println("Gold Member");
        }
    }
    
    enum Grade {
        BASIC(0) {
            public int getBonus() { return 100; }
        },
        SILVER(1) {
            public int getBonus() { return 200; }
        },
        GOLD(2) {
            public int getBonus() { return 500; }
        };

        private final int level;

        Grade(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public abstract int getBonus();

        public static Grade fromLevel(int level) {
            for (Grade g : values()) {
                if (g.level == level) {
                    return g;
                }
            }
            throw new IllegalArgumentException("Invalid level: " + level);
        }
    }
}    
