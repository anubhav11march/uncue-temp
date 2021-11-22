package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.dto.ReturningMessage;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("${api}")
public class BaseController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
    @GetMapping("/getlist/{tablename}/{columnnames}/{selectedcolmn}/{selectedcolumnvalue}")
    public List<Map<String, Object>> retrieveSingleUserData(@PathVariable String tablename, @PathVariable String columnnames, @PathVariable String selectedcolmn, @PathVariable String selectedcolumnvalue){
        System.out.println("JdbcTemplate:"+jdbcTemplate);

        String pkColumn = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'saloon' AND TABLE_NAME = '"+tablename+"'\n" +
                "  AND COLUMN_KEY = 'PRI'";

      String columnName =   jdbcTemplate.queryForObject(pkColumn,new Object[]{},String.class);
        System.out.println("columnName:"+columnName);
        String sql=null;

        sql ="SELECT  "+ columnnames + " FROM "+" "+ tablename+" where  "+selectedcolmn+" = "+selectedcolumnvalue+" order by "+columnName+" desc";

        System.out.println(sql);

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);

        return rows;
    }

    @DeleteMapping("/commonDeleteSingleRecord/{tableName}/{idName}/{idValue}")
    public ReturningMessage deleteSingleRecord(@PathVariable("tableName") String tableName, @PathVariable("idName") String idName, @PathVariable("idValue") Long idValue)
    {

        String idCondition = idName+"="+idValue;

        String sql = "delete from "+tableName+" where "+idName+" = "+idValue+"";

        System.out.println(sql);

        int isDeletedRecord = jdbcTemplate.update(sql);

        System.out.println(isDeletedRecord);

        ReturningMessage returningMessage = new ReturningMessage();

        if(isDeletedRecord==1){

            returningMessage.setStatusMessage("Successfully record is deleted.");

            returningMessage.setData("");

            returningMessage.setError(false);

            return returningMessage;

        }

        else{

            returningMessage.setStatusMessage("Record is not deleted.");

            returningMessage.setData("");

            returningMessage.setError(true);

            return returningMessage;

        }

    }
    @GetMapping("/getlist/{tablename}/{columnnames}")
    public List<Map<String, Object>> retrieveTableData(@PathVariable String tablename, @PathVariable String columnnames)  {

        String		sql=null;

        sql ="SELECT  "+ columnnames + " FROM"+" "+ tablename+" ";

        System.out.println(sql);

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);

        return rows;
    }
    @GetMapping("/getlist/{tablename}/{columnnames}/{columnValue}")
    public List<Map<String, Object>> getTableData(@PathVariable String tablename, @PathVariable String columnnames,
                                                  @PathVariable String columnValue){
        String sql=null;

        sql ="SELECT * FROM"+" "+ tablename+" where "+columnnames+" = "+columnValue+"";

        System.out.println(sql);

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        return rows;
    }

}
