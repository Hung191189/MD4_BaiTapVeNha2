package com.example.md4_baitapvenha2.controller;
import com.example.md4_baitapvenha2.model.Blog;
import com.example.md4_baitapvenha2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/Blogs")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> showAll(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setIdBlog(blogOptional.get().getIdBlog());
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id){
        blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
