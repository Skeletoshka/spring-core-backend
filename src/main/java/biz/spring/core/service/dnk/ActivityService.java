package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Activity;
import biz.spring.core.repository.dnk.ActivityRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.validator.dnk.ActivityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService extends BaseService<Activity> {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityValidator activityValidator;

    @Override
    protected void init() {
        init(activityRepository, activityValidator);
    }
}
