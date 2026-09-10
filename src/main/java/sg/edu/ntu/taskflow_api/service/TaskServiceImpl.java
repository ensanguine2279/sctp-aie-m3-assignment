package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.taskflow_api.exception.TaskNotFoundException;
import sg.edu.ntu.taskflow_api.model.Task;
import sg.edu.ntu.taskflow_api.repository.TaskRepository;

@Service
@Primary
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    public void createTask(Task task) {
        taskRepository.create(task);
    }

    public void markTaskAsCompleted(long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.update(task);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

    public Task updateTask(long id, Task task) throws TaskNotFoundException {
        Task existingTask = taskRepository.findById(id);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setPriority(task.getPriority());
            existingTask.setCompleted(task.isCompleted());
            taskRepository.update(existingTask);
        } else {
            throw new TaskNotFoundException(id);
        }
        return existingTask;
    }

    public void deleteTask(long id) throws TaskNotFoundException {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

}
