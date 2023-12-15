package Belebey.back_3_lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Belebey.back_3_lab.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    void deleteByTitle(String title);
    Task findTaskByTitle(String title);
}