package com.deom.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deom.todo.entities.Todo;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByIsCompleted(boolean completed);
}
