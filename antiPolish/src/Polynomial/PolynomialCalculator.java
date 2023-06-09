package Polynomial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* 多项式计算器，交互操作在此类中实现 */
public class PolynomialCalculator {
    static ArrayList<Result> results;
    static Polynomial poly1;//等号左边第一个多项式
    static Polynomial poly2;//等号左边第二个多项式
    static Polynomial poly3;//等号右边的多项式
    static Scanner input;
    static PolynomialOperation operation;

    /* 构造方法 */
    public PolynomialCalculator(){
        results = new ArrayList<>();
        poly1 = null;
        poly2 = null;
        poly3 = null;
        input = new Scanner(System.in);
        operation = new PolynomialOperation();
    }

    /* 主菜单 */
    public static int mainMenu() throws InputMismatchException{
        int option;
        System.out.println("[主菜单]");
        System.out.println("退出 - - - - - - - - - - - 0");
        System.out.println("查看现有多项式 - - - - - - - 1");
        System.out.println("使用现有多项式进行运算- - - - -2");
        System.out.println("输入多项式进行运算- - - - - - 3");
        System.out.println("导入多项式- - - - - - - - - 4");
        System.out.println("查看结果集- - - - - - - - - 5");
        System.out.println("清空结果集- - - - - - - - - 6");
        System.out.println("多项式赋值运算 - - - - - - - 7");
        System.out.print(">>");
        try {
            option = input.nextInt();
        }catch (Exception e) {
            input.nextLine();//消除错误输入
            System.out.println("输入错误！");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                    + " - - - - - - - - - - - - - - - - - - - - - - - - ");
            throw new InputMismatchException();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                + " - - - - - - - - - - - - - - - - - - - - - - - - ");
        return option;
    }

    /* 多项式的运算菜单 */
    public static int menu() throws InputMismatchException{
        int option;
        System.out.println("[运算菜单]");
        System.out.println("退出- - - - - - - - 0");
        System.out.println("多项式加法 - - - - - 1");
        System.out.println("多项式减法 - - - - - 2");
        System.out.println("多项式乘法 - - - - - 3");
        System.out.println("多项式的幂运算 - - - -4");
        System.out.print(">>");
        try {
            option = input.nextInt();
        }catch (Exception e) {
            input.nextLine();//消除错误输入
            System.out.println("输入错误！");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                    + " - - - - - - - - - - - - - - - - - - - - - - - - ");
            throw new InputMismatchException();
        }
        if(option != 0)
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                    + " - - - - - - - - - - - - - - - - - - - - - - - - ");
        return option;
    }

    /* 多项式输入 */
    public static Polynomial polyInput(){
        Polynomial p = new Polynomial();
        double coef;
        double power;
        while(true){
            System.out.print("系数:");
            coef = input.nextDouble();
            System.out.print("指数:");
            power = input.nextDouble();
            if(coef == 0 && power == 0){
                System.out.println("[输入结束]");
                System.out.println("- - - - - - - - - - - - - - - - - - -");
                break;
            }
            Element e = p.addElement(coef,power);
            System.out.print("输入项：");
            p.printSingle(e);
            System.out.println("\n- - - - - - - - - - - - - - - - - - -");
        }
        if(p.poly.size() == 0) return null;
        System.out.print("最终输入的多项式为：");
        p.printPoly();
        System.out.println();
        return p;
    }

    /* 保存计算结果 */
    public static Result saveResult(Polynomial poly1,Polynomial poly2,Polynomial res,String operator) throws CloneNotSupportedException {
        Result result = new Result(poly1, poly2, res,operator);
        results.add(result);
        return result;
    }

    /* 输入多项式进行计算 */
    public static void calculate(int option) throws Exception {
        try{
            switch(option) {
                case 0:
                    return;
                case 1: {
                    System.out.println("\t\t\t\t\t\t       [多项式的加法运算]");
                    System.out.println("\t\t\t\t\t\t>>>系数和指数都输入为0时结束输入<<<");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly1>");
                    poly1 = polyInput();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly2>");
                    poly2 = polyInput();
                    poly3 = operation.add(poly1, poly2);
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<计算结果>");
                    poly3.printPoly();
                    System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                    String save = input.next();
                    if (save.contains("Y")) saveResult(poly1, poly2, poly3, "+");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    break;
                }
                case 2: {
                    System.out.println("\t\t\t\t\t\t       [多项式的减法运算]");
                    System.out.println("\t\t\t\t\t\t>>>系数和指数都输入为0时结束输入<<<");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly1>");
                    poly1 = polyInput();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly2>");
                    poly2 = polyInput();
                    poly3 = operation.sub(poly1, poly2);
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<计算结果>");
                    poly3.printPoly();
                    System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                    String save = input.next();
                    if (save.contains("Y")) saveResult(poly1, poly2, poly3, "-");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    break;
                }
                case 3: {
                    System.out.println("\t\t\t\t\t\t       [多项式的乘法运算]");
                    System.out.println("\t\t\t\t\t\t>>>系数和指数都输入为0时结束输入<<<");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly1>");
                    poly1 = polyInput();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly2>");
                    poly2 = polyInput();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    poly3 = operation.mult(poly1, poly2);
                    System.out.println("<计算结果>");
                    poly3.printPoly();
                    System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                    String save = input.next();
                    if (save.contains("Y")) saveResult(poly1, poly2, poly3, "*");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    break;
                }
                case 4: {
                    System.out.println("\t\t\t\t\t\t       [多项式的幂运算]");
                    System.out.println("\t\t\t\t\t\t>>>系数和指数都输入为0时结束输入<<<");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("<Poly1>");
                    poly1 = polyInput();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.print("多项式的指数为：");
                    int power = input.nextInt();
                    String operator = null;
                    operator = "^" + power;//设置指数
                    poly3 = operation.pow(poly1, power);
                    System.out.println("<计算结果>");
                    poly3.printPoly();
                    if (power > 10) {
                        System.out.println("\n暂时不支持保存10次方以上的结果!");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                                + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                        return;
                    }
                    System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                    String save = input.next();
                    if (save.contains("Y")) saveResult(poly1, poly2, poly3, operator);
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    break;
                }
                default: {
                    System.out.println("选项输入错误！请重重新输入");
                    break;
                }
            }
        }catch(Exception ex){
            throw ex;
        }
    }

    public static void directCalculate() throws CloneNotSupportedException {
        if(poly1 == null && poly2 == null) {
            System.out.println("poly1和poly2均为空!");
            return;
        }
        int option = 5;
        try {
            option = menu();
        }catch (Exception e) {
            input.nextLine();//消除错误输入
            System.out.println("输入错误！");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                    + " - - - - - - - - - - - - - - - - - - - - - - - - ");
            throw new InputMismatchException();
        }
        switch(option){
            case 0: return;
            case 1: {
                System.out.println("[多项式的加法运算]");
                poly3 = operation.add(poly1,poly2);
                if(poly2 == null){
                    System.out.println("多项式poly1或poly3为null，无法运算poly1 + poly2");
                }
                System.out.println("<计算结果>");
                poly3.printPoly();
                System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                String save = input.next();
                if(save.contains("Y")) saveResult(poly1,poly2,poly3,"+");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                break;
            }
            case 2:{
                System.out.println("[多项式的减法运算]");
                poly3 = operation.sub(poly1,poly2);
                if(poly2 == null){
                    System.out.println("多项式poly1或poly3为null，无法运算poly1 - poly2");
                }
                System.out.println("<计算结果>");
                poly3.printPoly();
                System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                String save = input.next();
                if(save.contains("Y")) saveResult(poly1,poly2,poly3,"-");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                break;
            }
            case 3:{
                System.out.println("[多项式的乘法运算]");
                System.out.println(">>>系数和指数都输入为0时结束输入<<<");
                poly3 = operation.mult(poly1,poly2);
                if(poly2 == null){
                    System.out.println("多项式poly1或poly3为null，无法运算poly1 * poly2");
                }
                System.out.println("<计算结果>");
                poly3.printPoly();
                System.out.print("\n是否需要保存计算结果？(Y/N) >>");
                String save = input.next();
                if(save.contains("Y")) saveResult(poly1,poly2,poly3,"*");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                break;
            }
            case 4:{
                System.out.println("[多项式的幂运算]");
                System.out.println(">>>系数和指数都输入为0时结束输入<<<");
                System.out.println("选择使用poly1还是poly2进行运算？");
                System.out.println("poly1 >>1\npoly2 >>2\n返回 >>3");
                System.out.println(">>");
                int flag = input.nextInt();
                Polynomial poly;
                if(flag == 1){
                    poly = poly1;
                }
                else if(flag == 2){
                    poly = poly2;
                }
                else return;
                System.out.print("多项式的指数为：");
                int power = input.nextInt();
                String operator = null;
                operator = "^" + power;//设置指数
                poly3 = operation.pow(poly,power);
                System.out.println("<计算结果>");
                poly3.printPoly();
                if(power > 10) {
                    System.out.println("\n暂时不支持保存10次方以上的结果!");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                            + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                    return;
                }
                System.out.println("\n是否需要保存计算结果？(Y/N)");
                String save = input.next();
                if(save.contains("Y")) saveResult(poly1,poly2,poly3,operator);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - ");
                break;
            }
            default: {
                System.out.println("选项输入错误！请重重新输入");
            }
        }
    }

    /* 查看存储的全部计算结果 */
    public static void viewResult(){
        if(results.size() == 0) {
            System.out.println("结果集为空!");
            return;
        }
        for(int i = 0;i < results.size();i++){
            Result result = results.get(i);
            result.printResult();
        }
    }

    /* 查看现有的多项式 */
    public static void viewExistingPoly(){
        System.out.print("poly1:");
        if(poly1 != null) poly1.printPoly();
        else System.out.print("null");
        System.out.println();
        System.out.print("ploy2:");
        if(poly2 != null) poly2.printPoly();
        else System.out.print("null");
        System.out.println();
    }

    /* 从结果集导入多项式 */
    public static void importPolyFromResults() throws CloneNotSupportedException {
        if(results.size() == 0) {
            System.out.println("结果集为空!");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                    + " - - - - - - - - - - - - - - - - - - - - - - - - ");
            return;
        }
        /* 获取结果集中的全部多项式 */
        ArrayList<Polynomial> polys = new ArrayList<>();
        for(int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            if(result.poly1 != null) polys.add(result.poly1);
            if(result.poly2 != null) polys.add(result.poly2);
            if(result.res != null) polys.add(result.res);
        }
        /* 打印全部多项式 */
        for(int i = 0;i < polys.size();i++){
            System.out.printf("\n<%d> ",i);
            polys.get(i).printPoly();
        }
        System.out.print("\n请选择导入到poly1或poly2?(1/2) >>");
        int flag = input.nextInt();
        if(flag == 1) {
            while(true){
                System.out.print("请输入导入到poly1的多项式序号:");
                int index = input.nextInt();
                if(index < polys.size()) {
                    poly1 = polys.get(index).clone();
                    break;
                }
                else {
                    System.out.println("多项式序号越界!请重新输入。");
                }
            }
        }
        else {
            while(true){
                System.out.print("请输入导入到poly2的多项式序号:");
                int index = input.nextInt();
                if(index < polys.size()) {
                    poly2 = polys.get(index).clone();
                    break;
                }
                else {
                    System.out.println("多项式序号越界!请重新输入。");
                }
            }
        }
        System.out.println("导入成功!");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                + " - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

    public static void clearResults(){
        if(results.size() == 0) {
            System.out.println("清空结果集成功!");
            return;
        }

        results.subList(0, results.size()).clear();//清空结果集
        System.out.println("清空结果集成功!");
    }

    /* 多项式赋值 */
    public static void assignnValueToPolynomial(){
        if(results.size() == 0) {
            System.out.println("结果集为空!");
            return;
        }
        /* 获取结果集中的全部多项式 */
        ArrayList<Polynomial> polys = new ArrayList<>();
        for(int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            if(result.poly1 != null) polys.add(result.poly1);
            if(result.poly2 != null) polys.add(result.poly2);
            if(result.res != null) polys.add(result.res);
        }
        /* 打印全部多项式 */
        for(int i = 0;i < polys.size();i++){
            System.out.printf("\n<%d> ",i);
            polys.get(i).printPoly();
        }
        int index;
        while(true){
            System.out.print("\n请输入需要赋值的多项式序号:");
            index = input.nextInt();
            if(index < polys.size()) break;
            else
                System.out.println("多项式序号越界!请重新输入。");
        }
        Polynomial poly = polys.get(index);
        System.out.print("赋值:X = ");
        poly.setX(input.nextDouble());
        System.out.printf("多项式赋值结果为：%f\n",poly.getResult());
    }

    /* 多项式计算器的控制台 */
    public static void console() throws CloneNotSupportedException {
        PolynomialCalculator calculator = new PolynomialCalculator();
        while(true){
            int option = 8;
            try {
                option = calculator.mainMenu();
            }catch(InputMismatchException ex){
                continue;
            }
            switch(option){
                case 0: {
                    System.out.println("已退出多项式计算器，感谢您的使用!");
                    return;//返回
                }
                case 1: viewExistingPoly(); break; //查看现有多项式
                case 2: directCalculate(); break; //使用现有多项式进行运算
                case 3: {
                    int flag = 1;
                    while(flag != 0){
                        try {
                            flag = menu();
                        }catch(Exception e){
                            continue;
                        }
                        try{
                            calculate(flag);
                        }catch (Exception e) {
                            System.out.println("出现错误，程序将回到主菜单！");
                            break;
                        }
                    }
                    break;
                }//输入多项式进行运算
                case 4: importPolyFromResults(); break; //从保存的计算结果中导入多项式
                case 5: viewResult(); break;//查看结果集
                case 6: clearResults(); break;//清空结果集
                case 7: assignnValueToPolynomial(); break;//多项式赋值
                default: System.out.println("选项输入错误，请重新输入"); break;
            }
            if(option != 3){
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - ");
            }
        }
    }

    /* 多项式计算器启动 */
    public static void main(String[] args) throws CloneNotSupportedException {
        console();
    }

}
