package dao.impl;

import dao.ProjectDao;
import domain.Project;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectDaoImpl implements ProjectDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Project> findallproject() {
        String sql = "select * from project";
        List<Project> projects = template.query(sql, new BeanPropertyRowMapper<Project>(Project.class));

        return projects;
    }

    @Override
    public void add(Project project) {
        //1.定义sql
        String sql = "insert into project values(?,?,?,?)";
        //2.执行sql
        template.update(sql, project.getPname(), project.getNeed(), project.getSponsor(), project.getContractor());
    }

    @Override
    public void delete(int pid) {
        //1.定义sql
        String sql = "delete from project where pid = ?";
        //2.执行sql
        template.update(sql, pid);
    }

    @Override
    public Project findById(int pid) {
        String sql = "select * from project where pid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Project>(Project.class), pid);
    }

    @Override
    public void update(Project project) {
        String sql = "update project set pname = ?,need = ?,sponsor = ?,constractor = ? where pid = ?";
        template.update(sql, project.getPname(), project.getNeed(), project.getSponsor(), project.getContractor(), project.getPid());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from project where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }




        }
        System.out.println(sb.toString() + "pr------");
        System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }
}
