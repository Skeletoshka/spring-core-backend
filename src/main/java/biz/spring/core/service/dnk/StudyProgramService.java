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
    @Value("classpath:/script/dnk/studyprogram/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/studyprogram/mainSqlForOne.sql")
    Resource mainSqlForOne;


    public List<StudyProgramView> getAll(GridDataOption gridDataOption) {
        boolean directionFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> "directionId".equals(nf.getName()) && !nf.getValue().equals(-1));
        boolean teacherFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> "teacherId".equals(nf.getName()) && !nf.getValue().equals(-1));
        boolean assistantFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> "assistantId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<StudyProgramView>(mainSql)
                .forClass(StudyProgramView.class)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .injectSqlIf(directionFound, "/*DIRECTION_PLACEHOLDER*/", "AND SP.direction_id = :directionId")
                .injectSqlIf(teacherFound, "/*TEACHER_PLACEHOLDER*/", "AND SP.teacher_id = :teacherId")
                .injectSqlIf(assistantFound, "/*ASSISTANT_PLACEHOLDER*/", "AND SP.assistant_id = :assistantId")
                .setParams(gridDataOption.buildParams())
                .build()
                .execute();
    }

    public StudyProgramView getOne(Integer id){
        return new Query.QueryBuilder<StudyProgramView>(mainSqlForOne)
                .forClass(StudyProgramView.class)
                .build()
                .executeOne(id);
    }
}
