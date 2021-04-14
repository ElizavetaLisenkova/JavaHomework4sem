package com.example.onlineShop.controller;

import com.example.onlineShop.entity.Role;
import com.example.onlineShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }
    @PostMapping("/api/role")
    public ResponseEntity<?> create(@RequestBody Role role){
        roleService.create(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/role")
    public ResponseEntity<List<Role>> findALL(){
        final List<Role> roleList = roleService.findAll();
        return roleList != null && !roleList.isEmpty()
                ? new ResponseEntity<>(roleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/role/{id}")
    public ResponseEntity<Optional<Role>> find(@PathVariable(name = "id")Long id){
        final Optional<Role> role = roleService.find(id);
        return role!=null
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable(name = "id")Long id, @RequestBody Role roleUpdate){
        return roleService.find(id).map(role -> {
            role.setRoleName(roleUpdate.getRoleName());
            roleService.update(role);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}
