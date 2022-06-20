package vehicle_manager.utils.support;

import vehicle_manager.controller.ManufactureController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DisplayScanner {
    static Scanner scanner = new Scanner(System.in);

    public static List<String> collectDataFromUserInput(String propsStr) {
        List<String> props = new ArrayList<>(Arrays.asList(propsStr.split(",")));
        List<String> ans = new ArrayList<>();
        for (String x : props) {
            //for special case with MANUFACTURE
            if (x.equalsIgnoreCase("MANUFACTURE")) {
                System.out.println(ManufactureController.getAllNameManufacturer());
                ans.add(getManufacturerValid());
            } else {
                System.out.printf("Input %s ", x);
                String inputData = scanner.nextLine();
                ans.add(inputData);
            }
        }
        return ans;
    }

    public static String getManufacturerValid() {
        while (true) {
            System.out.print("Input Manufacturer ");
            String manufacturer = scanner.nextLine();

            if (isValidManufacturerType(manufacturer)) {
                return manufacturer;
            }
        }
    }

    public static boolean isValidManufacturerType(String type) {
//        return Stream.of("thaco", "samsung", "kia")
//                .collect(Collectors.toList())
//                .parallelStream()
//                .anyMatch(type::equalsIgnoreCase);

        return type.equalsIgnoreCase("thaco") ||
                type.equalsIgnoreCase("kia") ||
                type.equalsIgnoreCase("samsung");
    }

    public static String getChooseTarget(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }
}
