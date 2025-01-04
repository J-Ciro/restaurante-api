package com.restaurante.restaurante.controllers;


import com.restaurante.restaurante.dto.MenuDTO;
import com.restaurante.restaurante.models.Menu;
import com.restaurante.restaurante.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }



    @PostMapping
    public ResponseEntity<String> addMenu(@RequestBody MenuDTO menuDTO){
        menuService.addMenu(menuDTO);
        return ResponseEntity.ok("Menu agregado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long id){
        return ResponseEntity.ok(menuService.getMenu(id).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getMenus(){
        return ResponseEntity.ok(menuService.getMenus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMenu(@PathVariable Long id, @RequestBody Menu menu){
        try{
            Menu menuUpdated = menuService.updateMenu(id, menu);
            return ResponseEntity.ok("Se ha actualizado exitosamente el menu");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id){
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }



}