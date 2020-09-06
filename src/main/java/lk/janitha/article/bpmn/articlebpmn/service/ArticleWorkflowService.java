package lk.janitha.article.bpmn.articlebpmn.service;


import lk.janitha.article.bpmn.articlebpmn.model.Approval;
import lk.janitha.article.bpmn.articlebpmn.model.Article;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleWorkflowService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Transactional
    public void startProcess(Article article) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        runtimeService.startProcessInstanceByKey("articleReview", variables);
    }

    @Transactional
    public List<Article> getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup(assignee)
                .list();
        return tasks.stream()
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Article(task.getId(), (String) variables.get("author"), (String) variables.get("url"));
                }).collect(Collectors.toList());
    }

    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approval", approval.getStatus());
        taskService.complete(approval.getId(), variables);
    }
}
