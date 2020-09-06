package lk.janitha.article.bpmn.articlebpmn.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class PublicArticleService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Publishing the approved article.");
    }
}
