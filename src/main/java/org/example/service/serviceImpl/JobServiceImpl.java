package org.example.service.serviceImpl;

import org.example.dao.JobDao;
import org.example.dao.daoImpl.JobDaoImpl;
import org.example.models.Job;
import org.example.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
    final JobDao jobDao = new JobDaoImpl();

    @Override
    public void createJobTable() {
        jobDao.createJobTable();
    }

    @Override
    public void deleteDescriptionColumn() {
        jobDao.deleteDescriptionColumn();
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobDao.getJobById(id);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long id) {
        return jobDao.getJobByEmployeeId(id);
    }
}
