package com.lin.deluxe;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.lin.deluxe.methods.MyInsertAll;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/10
 * \* Time: 10:16
 * \* Description:
 * \
 */
public class MyLogicSqlInjector extends DefaultSqlInjector {

    /**
     * 如果只需增加方法，保留MP自带方法
     * 可以super.getMethodList() 再add
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
//        methodList.add(new DeleteAll());
        methodList.add(new MyInsertAll());
//        methodList.add(new MysqlInsertAllBatch());
        methodList.add(new SelectById());
        return methodList;
    }
}
