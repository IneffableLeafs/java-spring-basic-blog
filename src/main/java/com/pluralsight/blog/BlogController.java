package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.model.Post;

import java.util.List;

@Controller
public class BlogController {

        @RequestMapping("/")
        public String listPosts(ModelMap m) {
            List<Post> posts = postRepository.getAllPosts();
            m.put("posts", posts);
            return "home";
        }

        private PostRepository postRepository = new PostRepository();

        public BlogController(PostRepository p) {
            postRepository = p;
        }

        @RequestMapping("/post/{id}")
        public String postDetails(@PathVariable Long id, ModelMap modelMap) {
            Post p = postRepository.findById(id);
            modelMap.put("post", p);
            return "post-details"; // the name of the template to display
        }

}
