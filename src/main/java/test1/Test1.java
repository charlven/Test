package test1;

import test1.impl.SimpleCar;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入停车场的长：");
        int width = in.nextInt();
        System.out.println("请输入停车场的宽：");
        int height = in.nextInt();

        Park park = new Park(width, height);
        Car car = new Car(new SimpleCar(0, 0), park);

        String tips = "场地初始化完成，请按照以下提示进行操作：\n"
                + "Command:\n"
                + "--move  <op><step>  : 移动  eg.向N移动2格 --move N2\n"
                + "--position          : 获取当前坐标\n"
                + "--check             : 检查当前位置\n"
                + "--help              : 输出帮助";
        System.out.println(tips);

        while (true) {
            String input = in.nextLine();

            if (input.startsWith("--move")) {
                move(input.replace("--move ", ""), car);
            } else if (input.startsWith("--position")) {
                System.out.println(String.format("现在定位：x=%s,y=%s, 方向：%s", car.getX(), car.getY(), car.getOrientation()));
            } else if (input.startsWith("--check")) {
                if (!car.isIllegalPosition()) {
                    System.out.println("车辆所在位置合法。");
                }
            } else if (input.startsWith("--help")) {
                System.out.println(tips);
            } else {
                System.out.println("Invalid Command. Try it again or input '--help'");
            }
        }
    }

    public static void move(String input, Car car) throws Exception {
        if (!isValidInput(input)) {
            System.out.println("输入格式错误啦！请重新输入。。。");
            return;
        }
        car.move(input);
        System.out.println(String.format("现在定位：x=%s,y=%s, 方向：%s", car.getX(), car.getY(), car.getOrientation()));
    }

    public static boolean isValidInput(String input) {
        String op = input.substring(0, 1).toUpperCase();
        if (!op.equals("N") && !op.equals("S") && !op.equals("W") && !op.equals("E")) {
            return false;
        }
        String step = input.substring(1);
        try {
            Integer.valueOf(step);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
