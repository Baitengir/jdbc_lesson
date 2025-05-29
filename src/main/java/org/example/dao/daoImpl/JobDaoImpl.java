package org.example.dao.daoImpl;
import org.example.config.DBConnection;
import org.example.dao.JobDao;
import org.example.models.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao {
private final Connection connection = DBConnection.getConnection();
    @Override
    public void createJobTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS jobs (
                id SERIAL PRIMARY KEY,
                position VARCHAR(50) NOT NULL,
                profession VARCHAR(50) NOT NULL,
                description TEXT,
                experience INTEGER NOT NULL)
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Job table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDescriptionColumn() {
        String sql = """
                ALTER TABLE jobs
                DROP COLUMN IF NOT EXISTS description;
                """;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Description column deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addJob(Job job) {
        String sql = """
                INSERT INTO jobs (position, profession, description, experience)
                VALUES (?, ?, ?, ?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString (1, job.getPosition());
            ps.setString (2, job.getProfession());
            ps.setString (3, job.getDescription());
            ps.setInt (4, job.getExperience());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Job getJobById(Long id) {
        String sql = """
                SELECT *
                FROM jobs
                WHERE id = ?
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Job job = new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                return job;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Job();
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        if (!ascOrDesc.equalsIgnoreCase("asc") && !ascOrDesc.equalsIgnoreCase("desc")){
            System.out.println("Incorrect value! Use ('asc' or 'desc') ");
            return List.of();
        }
        String sql = "SELECT * FROM jobs ORDER BY experience " + ascOrDesc;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Job> jobs = new ArrayList<>();
            while (resultSet.next()){
                Job job = new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public Job getJobByEmployeeId(Long id) {
        String sql = """
                SELECT j.*
                FROM jobs j
                JOIN employees e ON e.job_id = j.id
                WHERE e.id = ?
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Job job = new Job(
                        resultSet.getLong("id"),
                        resultSet.getString("position"),
                        resultSet.getString("profession"),
                        resultSet.getString("description"),
                        resultSet.getInt("experience")
                );
                return job;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
