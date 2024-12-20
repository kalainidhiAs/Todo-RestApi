package com.deom.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.deom.todo.controller.dtos.TodoDto;
import com.deom.todo.entities.Todo;
import com.deom.todo.repositories.TodoRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/todos")
    public List<Todo> todos(@RequestParam Optional<Boolean> completed) {
        return completed.map(c -> this.todoRepo.findByIsCompleted(c))
                .orElseGet(this.todoRepo::findAll);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return this.todoRepo.findById(id).map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/todos")
    public ResponseEntity<Object> addTodo(@Valid @RequestBody TodoDto todoDto) {
        this.todoRepo.save(new Todo(null, todoDto.getTask(), false));

        return ResponseEntity.ok().build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @Valid @RequestBody TodoDto todoDto) {
        return this.todoRepo.findById(id)
                .map(todo -> {
                    todo.setTitle(todoDto.getTask());
                    this.todoRepo.save(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/todos/{id}/mark_completed")
    public ResponseEntity<Object> markCompleted(@PathVariable Long id) {
        return this.todoRepo.findById(id)
                .map(todo -> {
                    todo.setCompleted(true);
                    this.todoRepo.save(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/todos/{id}/mark_incompleted")
    public ResponseEntity<Object> markIncompleted(@PathVariable Long id) {
        return this.todoRepo.findById(id)
                .map(todo -> {
                    todo.setCompleted(false);
                    this.todoRepo.save(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return this.todoRepo.findById(id)
                .map(todo -> {
                    this.todoRepo.delete(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}