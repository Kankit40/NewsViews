package com.NewsViews;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUD_Controler {

    public CRUD_Service service;

    public CRUD_Controler(CRUD_Service service){
        this.service = service;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody CRUD crud) throws ExecutionException, ExecutionException, InterruptedException {
        return service.createUser(crud);
    }

    @GetMapping ("/get")
    public CRUD getUser(@RequestParam String ID) throws ExecutionException, ExecutionException, InterruptedException {
        return service.getUser(ID);
    }

    @PutMapping ("/update")
    public String updateUser(@RequestBody CRUD crud) throws ExecutionException, ExecutionException, InterruptedException {
        return service.updateUser(crud);
    }

    @PutMapping ("/delete")
    public String deleteUser(@RequestParam String ID) throws ExecutionException, ExecutionException {
        return service.deleteUser(ID);
    }
//    @GetMapping("/test")
//   public ResponseEntity<String> testGetEndpoint(){
//        return ResponseEntity.ok("Endpoints are working");
//   }


}
