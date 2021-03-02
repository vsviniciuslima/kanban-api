package com.looplex.kanbanapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.looplex.kanbanapi.controller.TaskController;
import com.looplex.kanbanapi.model.Task;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TaskModelAssembler /*implements RepresentationModelAssembler<Task, EntityModel<Task>>*/ {
    /*
    @Override
    public EntityModel<Task> toModel(Task task) {

        return EntityModel.of(task, //
                linkTo(methodOn(TaskController.class).all()).withRel("tasks"));
    }*/
}
