package kr.ac.subway.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.subway.model.Subway;

@Repository
@Component

public class SubwayDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSourse(DataSource dataSourse) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSourse);
	}

	public int getRowCount()
	{
		String sqlStatement = "select count(*) from subwayinfomation";// record count
															
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	
	public List<Subway> getSubways() {
		String sqlStatement = "select * from subwayinfomation";
		
		return jdbcTemplateObject.query(sqlStatement, new SubwayMapper());
		
	}
	
	public boolean insert(Subway subway)
	{
		String date = subway.getDate();
		String temperature = subway.getTemperature();
		String humidity = subway.getHumidity();
		
		String sqlStatement = "insert into subwayinfomation (date, temperature, humidity) values (?,?,?)"; 
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{date, temperature, humidity}/*?�� �ش��ϴ� ������*/) == 1 );
	}
	
	public boolean update(Subway subway)
	{
		String date = subway.getDate();
		String temperature = subway.getTemperature();
		String humidity = subway.getHumidity();
		
		String sqlStatement = "update subwayinfomation set temperature=?, humidity=? where date=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{temperature, humidity,  date}/*?�� �ش��ϴ� ������*/) == 1 );//update�̸� 1���� �����̵�
	}
	
	public boolean delete(String date)
	{
		String sqlStatement = "delete from subwayinfomation where date=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{date})==1);
	}
}

