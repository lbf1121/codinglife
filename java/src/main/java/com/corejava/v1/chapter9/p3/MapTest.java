package com.corejava.v1.chapter9.p3;

import cn.hutool.core.math.Calculator;
import com.corejava.v1.chapter9.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


/**
 * 映射（Map）测试类
 *
 * @author liubf
 * @date 2024/3/29
 */
@Slf4j
public class MapTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        log.info(String.valueOf(calculator.calculate("1+1")));
        log.warn(String.valueOf(calculator.calculate("1+1")));
        log.debug(String.valueOf(calculator.calculate("1+1")));
        log.error(String.valueOf(calculator.calculate("1+1")));
        assertEquals(2.0, calculator.calculate("1+1"));
    }

    @Test
    public void testGetOrDefault(){
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            // 第一次读取add时，抛NullPointerException，可以使用getDefault代替
//            temp.put("add",temp.get("add")+1);

//            temp.put("add",temp.getOrDefault("add",0)+1);

            temp.merge("add",1,Integer::sum);
        }
        log.info(String.valueOf(temp.get("add")));
        assertEquals(Integer.valueOf(10),temp.get("add"));
    }

    @Test
    public void test1(){
        log.info("test1.....");

        Map<String, Employee> staff = new HashMap<>();
        staff.put("1",new Employee("abc"));
        staff.put("2",new Employee("efg"));
        staff.put("3",new Employee("hij"));
        staff.put("4",new Employee("klm"));

        staff.remove("2");

        staff.put("4",new Employee("nop"));

        staff.forEach((k,v)->{
            System.out.println("key = "+k+",value = "+v);
        });
    }
}
