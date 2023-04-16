package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.StudyCase;
import biz.spring.core.repository.dnk.StudyCaseRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.StudyCaseValidator;
import biz.spring.core.view.dnk.StudyCaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudyCaseService extends BaseService<StudyCase> {

    @Autowired
    private StudyCaseRepository studyCaseRepository;
    @Autowired
    private StudyCaseValidator studyCaseValidator;

    @PostConstruct
    protected void init() { init(studyCaseRepository, studyCaseValidator); }

    @Value("classpath:/script/dnk/studycase/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public StudyCaseView getOne(Integer id){
        return new Query.QueryBuilder<StudyCaseView>(mainSqlForOne)
                .forClass(StudyCaseView.class)
                .build()
                .executeOne(id);
    }

}
