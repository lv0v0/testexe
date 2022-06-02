package service.impl;

import dao.ProjectDao;
import dao.impl.ProjectDaoImpl;
import domain.Project;
import domain.User;
import service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDaoImpl Pdao = new ProjectDaoImpl();

    @Override
    public List<Project> findAll() {
        //调用Dao完成查询
        return Pdao.findallproject();
    }

    @Override
    public void addProject(Project project) {
        Pdao.add(project);
    }

    @Override
    public void deleteProject(String pid) {
        Pdao.delete(Integer.parseInt(pid));
    }

    @Override
    public Project findProjectById(String pid) {
        return Pdao.findById(Integer.parseInt(pid));
    }

    @Override
    public void updateProject(Project project) {
        Pdao.update(project);

    }

    @Override
    public void delSelectedProject(String[] ids) {

    }
}
