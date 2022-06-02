package service;

import domain.PageBean;
import domain.Project;
import domain.User;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    /**
     * 查询所有项目信息
     * @return
     */
    public List<Project> findAll();

    /**
     * 保存Project
     * @param project
     */
    void addProject(Project project);

    /**
     * 根据id删除Project
     * @param pid
     */
    void deleteProject(String pid);

    /**
     * 根据id查询
     * @param pid
     * @return
     */
    Project findProjectById(String pid);

    /**
     * 修改项目信息
     * @param project
     */
    void updateProject(Project project);

    /**
     * 批量删除项目
     * @param ids
     */
    void delSelectedProject(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    //PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
