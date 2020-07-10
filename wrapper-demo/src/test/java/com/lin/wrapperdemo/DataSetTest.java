package com.lin.wrapperdemo;

import com.lin.wrapperdemo.entity.Dataset;
import com.lin.wrapperdemo.mapper.DatasetMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/9
 * \* Time: 9:24
 * \* Description:
 * \
 */

@SpringBootTest

public class DataSetTest {



    @Autowired
    private DatasetMapper datasetMapper;

    private static String[] benchs =
            {
              "good",
              "bad"
            };

    private static String gene() {
        return benchs[new Random().nextInt(benchs.length)];
    }



    @Test
    public void t3() {
        for (int i = 0; i < 10; i++) {
            System.out.println(gene());
        }
    }

    /**
     * 使用了最新的java8的java.time类，并提供了LocalDateTime和java.util.Date之间的转换。
     *
     * 使用方法：
     *
     * randomLocalDateTime(-3,3) ： 取距离今天前后2天的日期。如果今天为7月12日，则日期随机范围为7月10日~7月14日
     *
     * 测试方法 ：
     */
    @Test
    public void testRandomDateTime(){
        for(int i=0;i<10;i++){
            System.out.println(randomLocalDateTime(-30,30));
        }
    }

    private static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }


    /**
     * 取范围日期的随机日期时间,不含边界
     * @param startDay
     * @param endDay
     * @return
     */
    public LocalDateTime randomLocalDateTime(int startDay,int endDay){

        int plusMinus = 1;
        if(startDay < 0 && endDay > 0){
            plusMinus = Math.random()>0.5?1:-1;
            if(plusMinus>0){
                startDay = 0;
            }else{
                endDay = Math.abs(startDay);
                startDay = 0;
            }
        }else if(startDay < 0 && endDay < 0){
            plusMinus = -1;

            //两个数交换
            startDay = startDay + endDay;
            endDay  = startDay - endDay;
            startDay = startDay -endDay;

            //取绝对值
            startDay = Math.abs(startDay);
            endDay = Math.abs(endDay);

        }

        LocalDate day = LocalDate.now().plusDays(plusMinus * RandomUtils.nextInt(startDay,endDay));
        int hour = RandomUtils.nextInt(1,24);
        int minute = RandomUtils.nextInt(0,60);
        int second = RandomUtils.nextInt(0,60);
        LocalTime time = LocalTime.of(hour, minute, second);
        return LocalDateTime.of(day, time);
    }

    /**
     * 取范围日期的随机日期时间,不含边界
     * @param startDay
     * @param endDay
     * @return
     */
    public Date randomDateTime(int startDay,int endDay){
        LocalDateTime ldt = randomLocalDateTime(startDay,endDay);
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }


    @Test
    public void t1() {
        Random random = new Random(100);
        for (int i = 0; i < 100; i++) {

            String label = RandomStringUtils.randomAlphabetic(6);
            int age = random.nextInt(90);
            String bench = gene();
            LocalDateTime time = randomLocalDateTime(-30,30);

            Dataset dataset = new Dataset();

            dataset.setAge(age);

            dataset.setBench(gene());

            dataset.setLabel(label);

            dataset.setTime(time);

            datasetMapper.insert(dataset);

        }
    }
}
