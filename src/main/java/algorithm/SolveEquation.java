package algorithm;

import org.junit.Test;

/**
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。

    如果方程没有解，请返回“No solution”。
    
    如果方程有无限解，则返回“Infinite solutions”。
    
    如果方程中只有一个解，要保证返回值 x 是一个整数。
    
    示例 1：
    
    输入: "x+5-3+x=6+x-2"
    输出: "x=2"
    示例 2:
    
    输入: "x=x"
    输出: "Infinite solutions"
    示例 3:
    
    输入: "2x=x"
    输出: "x=0"
    示例 4:
    
    输入: "2x+3x-6x=x+2"
    输出: "x=-1"
    示例 5:
    
    输入: "x=x+2"
    输出: "No solution"
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/solve-the-equation
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: SolveEquation.java, v 0.1 2019年11月8日 下午4:37:23 prd-fuy Exp $
 */
public class SolveEquation {
    public String solveEquation(String equation) {
        int num = 0, x = 0, tmp = 0;
        boolean flag = true, left = true;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (Character.isDigit(c)) {
                if (tmp != 0)
                    tmp = tmp * 10 + Character.getNumericValue(c);
                else
                    tmp = Character.getNumericValue(c);
            } else {
                switch (c) {
                    case '-':
                    case '+':
                        if (tmp != 0) {
                            num += (flag == left ? true : false) ? tmp : -tmp;
                            tmp = 0;
                            flag = true;
                        }
                        flag = c == '-' ? false : true;
                        break;
                    case 'x':
                        if (tmp == 0) {
                            if (i - 1 >= 0 && equation.charAt(i - 1) == '0')
                                break;
                            tmp = 1;
                        }
                        x += (flag == left ? true : false) ? tmp : -tmp;
                        tmp = 0;
                        flag = true;
                        break;
                    case '=':
                        if (tmp != 0) {
                            num += (flag == left ? true : false) ? tmp : -tmp;
                            tmp = 0;
                            flag = true;
                        }
                        left = false;
                        break;
                    default:
                        break;
                }
            }
            if (i == equation.length() - 1 && tmp != 0)
                num += (flag == left ? true : false) ? tmp : -tmp;
        }
        if (x == 0 && num != 0)
            return "No solution";
        if (x == 0 && num == 0)
            return "Infinite solutions";
        return "x=" + String.valueOf(-num / x);
    }
    
    @Test
    public void test1() {
        String a = "2x+3x-6x=x+2";
        System.out.println(solveEquation(a));
    }
    
    @Test
    public void test2() {
        String string = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test3() {
        String string = "x=x";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test4() {
        String string = "2x=x";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test5() {
        String string = "x=x+2";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test6() {
        String string = "-6+2+3x+x =-x+6";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test7() {
        String string = "1+1=x";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test8() {
        String string = "3x=33+22+11";
        System.out.println(solveEquation(string));
    }
    
    @Test
    public void test9() {
        String string = "0x=0";
        System.out.println(solveEquation(string));
    }
}
