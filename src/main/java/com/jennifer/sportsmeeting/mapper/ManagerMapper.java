package com.jennifer.sportsmeeting.mapper;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.bean.ManagerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据连接层
 */
@Repository// 也可以使用@Component，效果都是一样的，只是为了声明为bean
@Mapper
public interface ManagerMapper {
    //按条件查询
    Manager selectUserByManager(Manager manager);
    //修改
    int updateByPwd(Manager manager);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    long countByExample(ManagerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int deleteByExample(ManagerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int deleteByPrimaryKey(String mUsername);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int insert(Manager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int insertSelective(Manager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    List<Manager> selectByExample(ManagerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    Manager selectByPrimaryKey(String mUsername);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int updateByPrimaryKeySelective(Manager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Thu Feb 20 15:47:22 CST 2020
     */
    int updateByPrimaryKey(Manager record);
}