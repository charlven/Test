package test1;

import test1.impl.SimpleCar;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("������ͣ�����ĳ���");
        int width = in.nextInt();
        System.out.println("������ͣ�����Ŀ�");
        int height = in.nextInt();

        Park park = new Park(width, height);
        Car car = new Car(new SimpleCar(0, 0), park);

        String tips = "���س�ʼ����ɣ��밴��������ʾ���в�����\n"
                + "Command:\n"
                + "--move  <op><step>  : �ƶ�  eg.��N�ƶ�2�� --move N2\n"
                + "--position          : ��ȡ��ǰ����\n"
                + "--check             : ��鵱ǰλ��\n"
                + "--help              : �������";
        System.out.println(tips);

        while (true) {
            String input = in.nextLine();

            if (input.startsWith("--move")) {
                move(input.replace("--move ", ""), car);
            } else if (input.startsWith("--position")) {
                System.out.println(String.format("���ڶ�λ��x=%s,y=%s, ����%s", car.getX(), car.getY(), car.getOrientation()));
            } else if (input.startsWith("--check")) {
                if (!car.isIllegalPosition()) {
                    System.out.println("��������λ�úϷ���");
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
            System.out.println("�����ʽ�����������������롣����");
            return;
        }
        car.move(input);
        System.out.println(String.format("���ڶ�λ��x=%s,y=%s, ����%s", car.getX(), car.getY(), car.getOrientation()));
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
