package xxl.algorithm.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author zhangliangbo
 * @since 2021/12/4
 **/


@Slf4j
public class ReversePolishNotation {

    public int evalRpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num2, num1, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        int i = rpn.evalRpn(new String[]{"2", "1", "3", "*", "+"});
        System.err.println(i);
    }

}
