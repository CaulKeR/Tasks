package by.sistech.tasksApp.dao;

import by.sistech.tasksApp.dto.TaskDTO;

import java.util.List;

public interface TaskDAO {

    List<TaskDTO> getAll() throws DAOException;
    void create(TaskDTO task) throws DAOException;

}