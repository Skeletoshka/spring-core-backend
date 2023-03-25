package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.StudyProgram;
import biz.spring.core.repository.dnk.StudyProgramRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.StudyProgramValidator;
import biz.spring.core.view.dnk.StudyProgramView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudyProgramService extends BaseService<StudyProgram> {

    @Autowired
    private StudyProgramRepository studyProgramRepository;
    @Autowired
    private StudyProgramValidator studyProgramValidator;

    @PostConstruct
    public void init(){
        init(studyProgramRepository, studyProgramValidator);
    }
    @Value("classpath:/script/dnk/studyprogram/mainSQL.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/studyprogram/mainSQL.sql")
    Resource mainSqlForOne;


    public List<StudyProgramView> getAll(GridDataOption gridDataOption) {
        return new Query<StudyProgramView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .forClass(StudyProgramView.class)
                .execute();
    }

    public StudyProgramView getOne(Integer id){
        return new Query<StudyProgramView>(mainSqlForOne)
                .forClass(StudyProgramView.class)
                .executeOne(id);
    }
}
