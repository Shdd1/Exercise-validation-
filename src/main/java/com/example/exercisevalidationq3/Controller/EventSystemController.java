package com.example.exercisevalidationq3.Controller;

import com.example.exercisevalidationq3.Model.Event;
import com.example.exercisevalidationq3.Reponse.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v3/event")
public class EventSystemController {
    //********************Q3***********************
        ArrayList<Event> events = new ArrayList<>();
        @GetMapping("/get")
        public ResponseEntity getEvent(){
            return ResponseEntity.status(200).body(events);
        }
        @PostMapping("/add")
        public ResponseEntity addEvent(@Valid @RequestBody Event event, Errors errors){
            if(errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            events.add(event);
            return ResponseEntity.status(200).body(new ApiResponse("Success add")) ;
        }
        @PutMapping("/update/{index}")
        public ResponseEntity updateEvent(@PathVariable int index,@Valid@RequestBody Event event,Errors errors){
            if(errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            events.set(index, event);
            return ResponseEntity.status(200).body(new ApiResponse("Success Update"));
        }
        @DeleteMapping("/delete/{index}")
        public ResponseEntity deletEvent(@PathVariable int index){

            events.remove(index);
            return  ResponseEntity.status(200).body(new ApiResponse("Success remove"));
        }

         //It has to be number
        //It must be more than 25
        @PutMapping("/change/{index}/{number}")
        public ResponseEntity changeCap(@PathVariable int index,@PathVariable int number){
            if(number>25){
            events.get(index).setCapacity(number);
            return ResponseEntity.status(200).body(new ApiResponse("Success change"));
            }
            return ResponseEntity.status(400).body(new ApiResponse("must be more than 25"));
        }


        @GetMapping("/search/{id}")
        public ResponseEntity searchEvent(@PathVariable String id){
            for (Event e:events){
                if(e.getId().equals(id)) {
                    return ResponseEntity.status(200).body(e);
                }
            }
            return ResponseEntity.status(400).body(new ApiResponse("NOT FOUND"));
        }
}
