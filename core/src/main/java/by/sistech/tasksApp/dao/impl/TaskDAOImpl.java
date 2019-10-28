package by.sistech.tasksApp.dao.impl;

import by.sistech.tasksApp.dao.DAOException;
import by.sistech.tasksApp.dao.TaskDAO;
import by.sistech.tasksApp.dto.TaskDTO;
import by.sistech.tasksApp.utility.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Override
    public List<TaskDTO> getAll() throws DAOException {
        List<TaskDTO> tasks = new ArrayList<>();
        try (Connection connection = new Connector().getConnection()) {
            PreparedStatement create = connection.prepareStatement("select * from task_db.task;");
            ResultSet rs = create.executeQuery();
            while (rs.next()) {
                TaskDTO task = new TaskDTO(rs.getLong("ID"), rs.getString("Summary"),
                        rs.getDate("StartDate"), rs.getDate("EndDate"),
                        rs.getString("Assignee"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return tasks;
    }

    @Override
    public void create(TaskDTO task) throws DAOException {
        try (Connection connection = new Connector().getConnection()) {
            PreparedStatement create = connection.prepareStatement("insert into task_db.task (Summary, StartDate, " +
                    "EndDate, Assignee) values (?, ?, ?, ?);");
            create.setString(1, task.getSummary());
            create.setDate(2, task.getStartDate());
            create.setDate(3, task.getEndDate());
            create.setString(4, task.getAssignee());
            create.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}