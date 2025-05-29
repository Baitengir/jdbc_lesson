package org.example.dao;
import org.example.models.Job;
import java.util.List;

public interface JobDao {
    // todo table methods
    void createJobTable();
    void deleteDescriptionColumn();
    // todo Job methods
    void addJob(Job job);
    Job getJobById(Long id);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long id);
}
