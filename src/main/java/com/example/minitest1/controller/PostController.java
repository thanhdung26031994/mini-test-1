package com.example.minitest1.controller;

import com.example.minitest1.model.Posts;
import com.example.minitest1.model.PostsForm;
import com.example.minitest1.model.Province;
import com.example.minitest1.service.IPostsService;
import com.example.minitest1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Value("${upload}")
    private String upload;
    @Autowired
    private IPostsService postsService;
    @Autowired
    private IProvinceService provinceService;
    @ModelAttribute("province")
    public Iterable<Province> listProvince(){
        return provinceService.findAll();
    }
    @GetMapping("")
    public ModelAndView listPosts(){
        ModelAndView modelAndView = new ModelAndView("/posts/list");
        Iterable<Posts> postsIterable = postsService.findAll();
        modelAndView.addObject("posts", postsIterable);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/posts/create");
        modelAndView.addObject("posts", new Posts());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(PostsForm postsForm){
        MultipartFile file = postsForm.getImg();
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        Posts posts = new Posts();
        if (posts.getId() == null){
            posts.setId(postsForm.getId());
        }
        posts.setCode(postsForm.getCode());
        posts.setTitle(postsForm.getTitle());
        posts.setContent(postsForm.getContent());
        posts.setDescription(postsForm.getDescription());
        posts.setImg(fileName);
        posts.setProvince(postsForm.getProvince());
        postsService.save(posts);
        return "redirect:/posts";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Integer id){
        Optional<Posts> posts = postsService.findById(id);
        if (posts.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/posts/update");
            modelAndView.addObject("posts", posts.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("posts") Posts posts){
        postsService.save(posts);
        return "redirect:/posts";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        postsService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/posts";
    }
}
