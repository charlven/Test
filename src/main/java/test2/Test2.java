package test2;

import java.math.BigDecimal;

public class Test2 {
    private static final BigDecimal A_SPEED = new BigDecimal("0.40");
    private static final BigDecimal B_SPEED = new BigDecimal("0.60");
    private static final BigDecimal TIME_UNIT = new BigDecimal("0.01");
    private static final BigDecimal ONE_ROUND_DISTANCE = new BigDecimal("800.00");

    public static void main(String[] args) {
        Person a = new Person(A_SPEED, BigDecimal.ZERO, TIME_UNIT);
        Person b = new Person(B_SPEED, BigDecimal.ZERO, TIME_UNIT);

        BigDecimal currentTime = new BigDecimal("0.00");
        do {
            a.move();
            b.move();
            currentTime = currentTime.add(TIME_UNIT);
        } while (b.getCurrentDistance().compareTo(ONE_ROUND_DISTANCE) < 0
                || b.getCurrentDistance().compareTo(a.getCurrentDistance().add(ONE_ROUND_DISTANCE)) < 0);

        System.out.println("A跑了 ： " + a.getCurrentDistance().floatValue());
        System.out.println("B跑了 ： " + b.getCurrentDistance().floatValue());
        System.out.println("耗时： " + currentTime + "分钟");
    }


    public static class Person {
        private final BigDecimal restEndTime = new BigDecimal("2.00");

        private BigDecimal speed;
        private boolean isResting = false;
        private BigDecimal restedTime = BigDecimal.ZERO;
        private BigDecimal currentDistance;
        private BigDecimal timeUnit;

        private Person() {
        }

        public Person(BigDecimal speed, BigDecimal currentDistance, BigDecimal timeUnit) {
            this.speed = speed;
            this.currentDistance = currentDistance;
            this.timeUnit = timeUnit;
        }

        public BigDecimal move() {
            if (isResting) {
                restedTime = restedTime.add(timeUnit);
                if (restedTime.compareTo(restEndTime) == 0) {
                    restedTime = BigDecimal.ZERO;
                    isResting = false;
                }
            } else {
                currentDistance = currentDistance.add(speed);
                if (needRest(currentDistance)) {
                    isResting = true;
                }
            }
            return currentDistance;
        }

        private boolean needRest(BigDecimal distance) {
            return (distance.floatValue() / 200f) % 1 == 0;
        }

        public BigDecimal getSpeed() {
            return speed;
        }

        public void setSpeed(BigDecimal speed) {
            this.speed = speed;
        }

        public boolean isResting() {
            return isResting;
        }

        public void setResting(boolean resting) {
            isResting = resting;
        }

        public BigDecimal getCurrentDistance() {
            return currentDistance;
        }
    }

}
