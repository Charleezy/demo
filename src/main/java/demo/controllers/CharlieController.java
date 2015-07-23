package demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Charlie on 7/18/2015.
 */
@RestController
public class CharlieController {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CharlieController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/")
    List<String> home() {
        String exampleQuery = "select description from public.conferences";
        List<String> results = jdbcTemplate.query(
                exampleQuery,
                new Object[]{},
                new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("description");
                    }
                }
        );
        return results;
    }
}
