package kr.ac.subway.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.subway.model.Subway;

public class SubwayMapper implements RowMapper<Subway> {

	public Subway mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Subway subway = new Subway();
		return subway;
	}

}
