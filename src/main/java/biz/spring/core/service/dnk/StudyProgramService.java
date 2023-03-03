package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.StudyProgram;
import biz.spring.core.repository.dnk.StudyProgramRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.view.dnk.StudyProgramView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudyProgramService extends BaseService<StudyProgram> {

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @PostConstruct
    public void init(){
        init(studyProgramRepository);
    }
    private final String mainSql = "" +
            "SELECT * " +
            "FROM studyprogram";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM studyprogram " +
            "WHERE studyprogram_id = :id";


    public List<StudyProgramView> getAll(GridDataOption gridDataOption) {
        boolean findStudyProgram = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf ->"studyProgramId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query<StudyProgramView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy("studyprogram_id")
                .injectSqlIf(findStudyProgram, "/*STUDY PROGRAM_PLACEHOLDER*/", " AND studyprogram_id = :postId")
                .forClass(StudyProgramView.class)
                .execute();
    }

    public StudyProgramView getOne(Integer id){
        return new Query<StudyProgramView>(mainSqlForOne)
                .forClass(StudyProgramView.class)
                .executeOne(id);
    }
}
