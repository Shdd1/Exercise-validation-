package com.example.exercisevalidation.Controller;

import com.example.exercisevalidation.Apiresponse.ApiResponse;
import com.example.exercisevalidation.Model.Project;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2/tracker")
public class TrackerSystemController {
        ArrayList<Project> projects = new ArrayList<>();

        @GetMapping("/get")
        public ResponseEntity getProject() {
            return ResponseEntity.status(200).body(projects);
        }
        @PostMapping("/add")
        public ResponseEntity addProject(@Valid@RequestBody Project project, Errors errors){
           if(errors.hasErrors()){
               String message=errors.getFieldError().getDefaultMessage();
               return ResponseEntity.status(400).body(message);
           }
            projects.add(project);
            return ResponseEntity.status(200).body(new ApiResponse("Success add"));
        }
        @PutMapping("/update/{index}")
        public ResponseEntity updateProject(@PathVariable int index,@Valid@RequestBody Project project,Errors errors){
            if(errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }

            projects.set(index,project);
            return  ResponseEntity.status(200).body(new ApiResponse("Success update"));
        }
        @DeleteMapping("/delete/{index}")
        public ResponseEntity deleteProject(@PathVariable int index){
            projects.remove(index);
            return ResponseEntity.status(200).body(new ApiResponse("Success remove"));
        }

       //Status
        @GetMapping("/status/{index}")
        public ResponseEntity changeStatus(@PathVariable int index){
            if(projects.get(index).getStatus().equalsIgnoreCase("not Started")) {
                projects.get(index).setStatus(" in Progress");
            } else if (projects.get(index).getStatus().equalsIgnoreCase(" in Progress")) {
                projects.get(index).setStatus(" Completed  ");

            }

            return  ResponseEntity.status(200).body(new ApiResponse("Success change"));

        }



        @GetMapping("/search/{title}")
        public ResponseEntity searchPro(@PathVariable String title){
            for (Project p:projects){
                if(p.getTitle().equalsIgnoreCase(title)) {
                    return ResponseEntity.status(200).body(p);
                }
            }
            return null ;
        }

        @GetMapping("/display/{company}")
        public ResponseEntity allProject(@PathVariable String company){
            ArrayList<Project>companyes=new ArrayList<>();
            for (Project p:projects){
                if(p.getCompanyName().equalsIgnoreCase(company)) {
                    companyes.add(p);
                }

            }
            return ResponseEntity.status(200).body(companyes);
        }
}
