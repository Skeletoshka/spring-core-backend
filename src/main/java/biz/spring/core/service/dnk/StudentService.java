package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Student;
import biz.spring.core.repository.dnk.StudentRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.StudentValidator;
import biz.spring.core.view.dnk.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudentService extends BaseService<Student> {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentValidator studentValidator;

    @PostConstruct
    public void init(){
        init(studentRepository, studentValidator);
    }

    @Value("classpath:/script/dnk/student/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/student/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<StudentView> getAll(GridDataOption gridDataOption){
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<StudentView>(mainSql)
                .forClass(StudentView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND pg.workgroup_id = :workGroupId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<StudentView>(mainSql)
                .forClass(StudentView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND pg.workgroup_id = :workGroupId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .count();
    }

    public StudentView getOne(Integer id){
        return new Query.QueryBuilder<StudentView>(mainSqlForOne)
                .forClass(StudentView.class, "m0")
                .build()
                .executeOne(id);
    }


}
