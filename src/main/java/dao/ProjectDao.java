package dao;



import domain.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    public List<Project> findallproject();

    void add(Project project);

    void delete(int pid);

    Project findById(int i);

    void update(Project user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    //List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
