package com.lin.pagination_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.pagination_demo.entity.User1;
import com.lin.pagination_demo.model.MyPage;
import com.lin.pagination_demo.model.ParamSome;
import com.lin.pagination_demo.model.UserChildren;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-07-14
 */
public interface User1Mapper extends BaseMapper<User1> {
    /**
     * 3.x 的 page 可以进行取值,多个入参记得加上注解
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     * <li> 3.1.0 之前的版本使用注解会报错,写在 xml 里就没事 </li>
     * <li> 3.1.0 开始支持注解,但是返回值只支持 IPage ,不支持 IPage 的子类</li>
     *
     * @param myPage 自定义 page
     * @return 分页数据
     */
//    @Select("select * from user where (age = #{pg.selectInt} and name = #{pg.selectStr}) or (age = #{ps.yihao} and name = #{ps.erhao})")
    MyPage<User1> mySelectPage(@Param("pg") MyPage<User1> myPage, @Param("ps") ParamSome paramSome);


    @ResultMap("userChildrenMap")
    @Select("<script>select u.id,u.name,u.email,u.age,c.id as \"c_id\",c.name as \"c_name\",c.user_id as \"c_user_id\" " +
            "from user u " +
            "left join children c on c.user_id = u.id " +
            "<where>" +
            "<if test=\"selectInt != null\"> " +
            "and u.age = #{selectInt} " +
            "</if> " +
            "<if test=\"selectStr != null and selectStr != ''\"> " +
            "and c.name = #{selectStr} " +
            "</if> " +
            "</where>" +
            "</script>")
    MyPage<UserChildren> userChildrenPage(MyPage<UserChildren> myPage);


    MyPage<User1> mySelectPageMap(@Param("pg") MyPage<User1> myPage, @Param("map") Map param);

    List<User1> mySelectMap(Map param);

    List<User1> myPageSelect(MyPage<User1> myPage);

    List<User1> iPageSelect(IPage<User1> myPage);

    List<User1> rowBoundList(RowBounds rowBounds, Map map);
}
