package kosariev.cs22m.lab1.repository;

import kosariev.cs22m.lab1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Student findById(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<>(Student.class), id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setPassportSeries(rs.getString("passport_series"));
            student.setPassportNumber(rs.getString("passport_number"));
            return student;
        }
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public void deleteById(int student_id) {
        jdbcTemplate.update("delete from student where id=?", student_id);
    }

    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id, first_name, last_name, passport_series, passport_number) " + "values(?, ?, ?, ?, ?)",
                student.getId(), student.getFirstName(), student.getLastName(), student.getPassportSeries(), student.getPassportNumber());
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set first_name = ?, last_name = ?, passport_series = ?, passport_number = ? " + " where id = ?",
                student.getFirstName(), student.getLastName(), student.getPassportSeries(), student.getPassportNumber(), student.getId());
    }
}
