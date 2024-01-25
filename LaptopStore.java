/* Задание

-Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
- Создать множество ноутбуков.
- Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
- Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
- Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LaptopStore {
    public static void main(String[] args) {
        
        int count = 0;
        Map<Integer, Laptop> laptopMap = getLaptopMap();
        Map<Integer, String> trademarkMap = getTrademarkMap();
        Map<Integer, String> osMap = getOsMap();
        Map<Integer, String> colorMap = getColorMap();
        Map<Integer, String> criterions = getCriterions();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printCriterions(criterions);
            System.out.print("Enter the number of required criterion: ");
            
            while(!scanner.hasNextInt()){
                System.out.println("Wrong input! Try again");
                System.out.println();
                printCriterions(criterions);
                System.out.print("Enter the number of required criterion: ");
                scanner.next();
            }

            int criterion = scanner.nextInt();
            System.out.println();

            if(criterion < 1 || criterion > 5) {
                System.out.println("Wrong input! Try again!");
            }

            switch (criterion) {
                case 1:

                    count = 0;
                    System.out.print("Enter the minimum required capacity of RAM: ");

                    while(!scanner.hasNextInt()){
                        System.out.println("Wrong input! Try again");
                        System.out.println();
                        System.out.print("Enter the minimum required capacity of RAM or enter \"0\" to stop: ");
                        scanner.next();
                    }

                    int minRam = scanner.nextInt();

                    if(minRam == 0){
                        break;
                    }

                    System.out.println();
                    System.out.println("Search result: ");
    
                    for (Laptop laptop : laptopMap.values()) {
                        if(laptop.getRam() >= minRam){
                            System.out.println(laptop);
                            count++;
                        }
                    }
    
                    if(count == 0){
                        System.out.println("Not found. Try another criterions.");
                    }
                    break;
    
                case 2:

                    count = 0;
                    System.out.print("Enter the minimum required capacity of HDD: ");

                    while(!scanner.hasNextInt()){
                        System.out.println("Wrong input! Try again");
                        System.out.println();
                        System.out.print("Enter the minimum required capacity of HDD or enter \"0\" to stop: ");
                        scanner.next();
                    }

                    int minHdd = scanner.nextInt();

                    if(minHdd == 0){
                        break;
                    }

                    System.out.println();
                    System.out.println("Search result: ");
    
                    for (Laptop laptop : laptopMap.values()) {
                        if(laptop.getHdd() >= minHdd){
                            System.out.println(laptop);
                            count++;
                        }
                    }
    
                    if(count == 0){
                        System.out.println("Not found. Try another criterions.");
                    }
                    break;
    
                case 3:

                    printCriterions(trademarkMap);
                    System.out.print("Enter the number of trademark: ");

                    while(!scanner.hasNextInt()){
                        System.out.println("Wrong input! Try again");
                        System.out.println();
                        printCriterions(trademarkMap);
                        System.out.print("Enter the number of trademark or enter \"0\" to stop: ");
                        scanner.next();
                    }

                    int trademarkNum = scanner.nextInt();

                    if(trademarkNum == 0){
                        break;
                    }

                    if(trademarkNum > 5){
                        System.out.println("Wrong input! Try again");
                        break;
                    }

                    String trademarkStr = trademarkMap.get(trademarkNum);
                    System.out.println();
                    System.out.println("Search result: ");
    
                    for (Laptop laptop : laptopMap.values()) {
                        if(laptop.getTrademark().equals(trademarkStr)){
                            System.out.println(laptop);
                        }
                    }
                    break;
    
                case 4:

                    printCriterions(osMap);
                    System.out.print("Enter the number of operating system: ");

                    while(!scanner.hasNextInt()){
                        System.out.println("Wrong input! Try again");
                        System.out.println();
                        printCriterions(osMap);
                        System.out.print("Enter the number of operating system or enter \"0\" to stop: ");
                        scanner.next();
                    }

                    int osNum = scanner.nextInt();

                    if(osNum == 0){
                        break;
                    }

                    if(osNum > 4){
                        System.out.println("Wrong input! Try again");
                        break;
                    }

                    System.out.println();
                    String osStr = osMap.get(osNum);
                    System.out.println("Search result: ");
    
                    for (Laptop laptop : laptopMap.values()) {
                        if(laptop.getOperatingSystem().equals(osStr)){
                            System.out.println(laptop);
                        }
                    }
                    break;
    
                case 5:

                    printCriterions(colorMap);
                    System.out.print("Enter the number of laptop color: ");

                    while(!scanner.hasNextInt()){
                        System.out.println("Wrong input! Try again");
                        System.out.println();
                        printCriterions(colorMap);
                        System.out.print("Enter the number of laptop color or enter \"0\" to stop: ");
                        scanner.next();
                    }

                    int colorNum = scanner.nextInt();
                    
                    if(colorNum == 0){
                        break;
                    }

                    if(colorNum > 4){
                        System.out.println("Wrong input! Try again");
                        break;
                    }

                    System.out.println();
                    String colorStr = colorMap.get(colorNum);
                    System.out.println("Search result: ");
    
                    for (Laptop laptop : laptopMap.values()) {
                        if(laptop.getColor().equals(colorStr)){
                            System.out.println(laptop);
                        }
                    }
                    break;
            }

            System.out.println();
            System.out.println("Enter \"1\" to continue searching, or \"2\" to exit: ");
            int input = scanner.nextInt();
            if(input == 1){
                System.out.println();
                continue;
            } else if(input == 2){
                break;
            } else {
                System.out.println("Wrong input!");
                System.out.println();
            } 
        }
        scanner.close();
    }


    private static void printCriterions(Map<Integer, String> criterions) {
        for (Integer key : criterions.keySet()) {
            System.out.println(key + " - " + criterions.get(key));
        }
        System.out.println();
    }


    private static Map<Integer, String> getCriterions() {
        Map<Integer, String> criterions = new HashMap<>();
        criterions.put(1, "RAM");
        criterions.put(2, "HDD");
        criterions.put(3, "Trademark");
        criterions.put(4, "Operating system");
        criterions.put(5, "Color");
        return criterions;
    }


    private static Map<Integer, String> getColorMap() {
        Map<Integer, String> colorMap = new HashMap<>();
        colorMap.put(1, "Black");
        colorMap.put(2, "White");
        colorMap.put(3, "Grey");
        colorMap.put(4, "Blue");
        return colorMap;
    }


    private static Map<Integer, String> getOsMap() {
        Map<Integer, String> osMap = new HashMap<>();
        osMap.put(1, "Linux");
        osMap.put(2, "Chrome OS");
        osMap.put(3, "Windows 10");
        osMap.put(4, "Mac OS");
        return osMap;
    }


    private static Map<Integer, String> getTrademarkMap() {
        Map<Integer, String> trademarkMap = new HashMap<>();
        trademarkMap.put(1, "Dell");
        trademarkMap.put(2, "Lenovo");
        trademarkMap.put(3, "Asus");
        trademarkMap.put(4, "Gigabyte");
        trademarkMap.put(5, "Apple");
        return trademarkMap;
    }


    private static Map<Integer, Laptop> getLaptopMap() {
        Laptop laptop1 = new Laptop(100, 4, 256, "Dell", "Linux", "Black");
        Laptop laptop2 = new Laptop(101, 8, 512, "Dell", "Linux", "White");
        Laptop laptop3 = new Laptop(102, 16, 1000, "Dell", "Linux", "Grey");
        Laptop laptop4 = new Laptop(103, 8, 128, "Lenovo", "Chrome OS", "Blue");
        Laptop laptop5 = new Laptop(104, 4, 128, "Asus", "Chrome OS", "Black");
        Laptop laptop6 = new Laptop(105, 8, 128, "Lenovo", "Chrome OS", "Grey");
        Laptop laptop7 = new Laptop(106, 16, 1000, "Gigabyte", "Windows 10", "Black");
        Laptop laptop8 = new Laptop(107, 32, 4000, "Asus", "Windows 10", "Black");
        Laptop laptop9 = new Laptop(108, 16, 1000, "Gigabyte", "Windows 10", "Blue");
        Laptop laptop10 = new Laptop(109, 32, 1000, "Apple", "Mac OS", "White");
        Laptop laptop11 = new Laptop(110, 48, 1000, "Apple", "Mac OS", "Black");
        Laptop laptop12 = new Laptop(111, 8, 256, "Apple", "Mac OS", "White");

        Map<Integer, Laptop> laptopMap = new HashMap<>();
        laptopMap.put(1, laptop1);
        laptopMap.put(2, laptop2);
        laptopMap.put(3, laptop3);
        laptopMap.put(4, laptop4);
        laptopMap.put(5, laptop5);
        laptopMap.put(6, laptop6);
        laptopMap.put(7, laptop7);
        laptopMap.put(8, laptop8);
        laptopMap.put(9, laptop9);
        laptopMap.put(10, laptop10);
        laptopMap.put(11, laptop11);
        laptopMap.put(12, laptop12);
        return laptopMap;
    }
}