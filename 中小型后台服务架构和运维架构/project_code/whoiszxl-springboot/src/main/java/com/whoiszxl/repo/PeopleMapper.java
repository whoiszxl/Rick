package com.whoiszxl.repo;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

import com.whoiszxl.bean.secondary.People;


/**
 * 次数据源people mybatis操作接口
 * @author Administrator
 *
 */
@Mapper
public interface PeopleMapper {

	@Select("SELECT * FROM people WHERE `username` = #{username}")
	People findByUsername(@Param("username") String username);
	
	@Insert("INSERT INTO people(`username`,`address`) VALUES(#{username},#{address})")
	int insert(@Param("username")String username, @Param("address")String address);
	
	@Update("UPDATE people SET `username` = #{username} WHERE `id` = #{id}")
	int updateUsernameById(@Param("id")Long id,@Param("username") String username);
	
	
	//注解配置使用map
	@Insert("insert into people(`username`,`address`) values(#{username,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})")
	int insertByMap(Map<String, Object> map);
	
	@Insert("insert into people(username,address) values(#{username},#{address})")
	int insertByEntity(People people);
	
	@Delete("delete from people where id = {#id}")
	int delete(Long id);
}
