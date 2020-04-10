package org.daistudy.application.stack;

import org.apache.commons.lang3.StringUtils;
import org.daistudy.datastructure.stack.LinkedStack;
import org.daistudy.datastructure.stack.SequenatialStack;
import org.daistudy.datastructure.stack.Stack;

public class FourArithmeticExpression {
    private String infixExpression;
    private String suffixExpression;

    public String getSuffixExpression() {
        return suffixExpression;
    }

    public FourArithmeticExpression(String infixExpression){
        this.infixExpression = infixExpression;
        this.suffixExpression = this.infix2Suffix();
    }
    
    private String infix2Suffix(){
        Stack<String> stack = new SequenatialStack<>(50);
        String[] strings = this.infixExpression.split(" ");
        StringBuilder suffix = new StringBuilder();
        String item;
        for (int i = 0; i < strings.length - 1; i++) {
            item = strings[i];
            if(StringUtils.isNumeric(item)){
                suffix.append(item).append(" "); // 将数字依次输出
            }else if(isFourArithmetic(item)){
                while(!isPrior(stack.getTop(), item)){
                    suffix.append(stack.pop()).append(" "); // 将优先级低的栈内元素依次输出
                }
                stack.push(item);
            }else if("(".equals(item)){
                stack.push(item);
            }else if(")".equals(item)){
                while(!"(".equals(stack.getTop())){
                    suffix.append(stack.pop()).append(" "); // 将优先级低的栈内元素依次输出
                }
                stack.pop(); // 将"("出栈
            }
        }
        if(strings.length > 0){
            item = strings[strings.length - 1];
            if(StringUtils.isNumeric(item)){
                suffix.append(item).append(" "); // 将数字依次输出
                while(!stack.isEmpty()){
                    suffix.append(stack.pop()).append(" ");// 将栈内元素依次输出
                }
            }
            suffix.deleteCharAt(suffix.lastIndexOf(" "));
        }
        this.suffixExpression = suffix.toString();
        return this.suffixExpression;
    }

    private boolean isFourArithmetic(String str){
        return "+-*/".contains(str);
    }

    /**
     * 优先级高-->进栈
     * @param existed 栈顶元素
     * @param beChecked 待检查元素
     * @return 优先级高，返回 true
     */
    private boolean isPrior(String existed, String beChecked){
        if(StringUtils.isEmpty(existed) || "(".equals(existed)){
            return true;
        }
        switch (existed){
            case "+":
            case "-":
                return "*/".contains(beChecked);
            case "*":
            case "/":
                return false;
            default:
                return true;
        }
    }

    public int calculate(){
        // 1、整数进栈
        // 2、符号，将栈顶两个元素弹出并将计算后结果进栈
        // 3、栈内只有一个整数是就是最后的计算结果
        Stack<String> stack = new LinkedStack<>();
        if(!StringUtils.isEmpty(this.suffixExpression)){
            String[] s = this.suffixExpression.split(" ");
            for (String item : s) {
                if(StringUtils.isNumeric(item)){
                    stack.push(item);
                }else if(this.isFourArithmetic(item)){
                    int rightOperand = Integer.parseInt(stack.pop());
                    int leftOperand = Integer.parseInt(stack.pop());
                    stack.push(this.calculate(leftOperand, item, rightOperand));
                }
            }
            return Integer.parseInt(stack.pop());
        }
        return 0;
    }

    private String calculate(int leftOperand, String operator, int rightOperand){
        switch (operator){
            case "+":
                return String.valueOf(leftOperand + rightOperand);
            case "-":
                return String.valueOf(leftOperand - rightOperand);
            case "*":
                return String.valueOf(leftOperand * rightOperand);
            case "/":
                return String.valueOf(leftOperand / rightOperand);
            default:
                throw new IllegalArgumentException();
        }
    }
}
