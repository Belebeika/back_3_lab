package Belebey.back_3_lab.Controller;

import Belebey.back_3_lab.DTO.TitleDTO;
import Belebey.back_3_lab.Service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Belebey.back_3_lab.Model.Task;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class controller {

    private final TaskService service;

    @GetMapping("titles")
    public List<TitleDTO> getTitles() {
        return service.findAllTitles();
    }

    @GetMapping
    public List<Task> findAllTasks(){
        return service.findAllTasks();
    }

    @PostMapping("save_task")
    public String SaveTask (@RequestBody Task task){
        return service.SaveTask(task);
    }

    @GetMapping("/{title}")
    public Task FindByTitle(@PathVariable String title) {
        return service.FindByTitle(title);
    }

    @PutMapping("update_task")
    public String updateTask(@RequestBody Task task) {
        return service.UpdateTask(task);
    }

    @DeleteMapping("delete_task/{title}")
    public String deleteTask(@PathVariable String title) {
        return service.DeleteTask(title);
    }
}
