package lk.janitha.article.bpmn.articlebpmn.controller;

import lk.janitha.article.bpmn.articlebpmn.model.Approval;
import lk.janitha.article.bpmn.articlebpmn.model.Article;
import lk.janitha.article.bpmn.articlebpmn.service.ArticleWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleWorkflowController {

    @Autowired
    private ArticleWorkflowService articleWorkflowService;

    @PostMapping("/submit")
    public void submit(@RequestBody Article article){
        articleWorkflowService.startProcess(article);
    }

    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam String assignee){
       return articleWorkflowService.getTasks(assignee);
    }

    @PostMapping("/review")
    public void review(@RequestBody Approval approval){
        articleWorkflowService.submitReview(approval);
    }
}
