package Belebey.back_3_lab.Service;

import Belebey.back_3_lab.DTO.TitleDTO;
import Belebey.back_3_lab.Exceptions.ExistException;
import Belebey.back_3_lab.Model.Task;
import Belebey.back_3_lab.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService{

    private final TaskRepository repository;
    private final ModelMapper mapper;

    public List<TitleDTO> findAllTitles(){
        List <TitleDTO> Titles = new ArrayList<>();
        List <Task> Tasks = repository.findAll();
        for (Task task : Tasks) {
            TitleDTO title = mapper.map(task, TitleDTO.class);
            Titles.add(title);
        }
        return Titles;
    }
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public String SaveTask(Task task) {
        Task task_by_title = repository.findTaskByTitle(task.getTitle());
        if (task_by_title != null){
            return (ExistException.TASK_EXIST);
        }
        repository.save(task);
        return "Задание успешно сохраненно";
    }

    public Task FindByTitle(String title) {
        return repository.findTaskByTitle(title);
    }

    public String UpdateTask(Task task) {
        Task task_by_title = repository.findTaskByTitle(task.getTitle());
        if (task_by_title == null){
            return (ExistException.TASK_NOT_EXIST);
        }
        task_by_title.setText(task.getText());
        repository.save(task_by_title);
        return "Задание успешно обновленно";
    }

    @Transactional
    public String DeleteTask(String title) {
        Task task_by_title = repository.findTaskByTitle(title);
        if (task_by_title == null){
            return (ExistException.TASK_NOT_EXIST);
        }
        repository.deleteByTitle(title);
        return "Задание успешно удаленно";
    }

}
