package org.elasticsearch.plugin.example;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.support.ActionFilter;
import org.elasticsearch.action.support.ActionFilterChain;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.tasks.Task;

public class ExampleFilter extends ActionFilter.Simple {
    private Logger log = Logger.getLogger(ExampleFilter.class);

    protected ExampleFilter(Settings settings) {
        super(settings);
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    protected boolean apply(String action, ActionRequest request, ActionListener<?> listener) {
        log.warn("===================="+action);
        this.nodeName();
        listener.onResponse(new Response(){}
        );
        return true;
    }
}
