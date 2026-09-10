package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import sg.edu.ntu.taskflow_api.model.Task;

public interface AiService {
    String summarize(List<Task> tasks);
}
