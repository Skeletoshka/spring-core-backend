package biz.spring.core.repository.dnk;


import biz.spring.core.model.dnk.StudyProgram;
import biz.spring.core.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class StudyProgramRepository implements TableRepository<StudyProgram> {
    private static Logger logger = LoggerFactory.getLogger(StudyProgramRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/200100-studyprogram.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("studyprogram created");
    }

    @Override
    public void drop() {
        String[] tables = {"studyprogram"};
        drop(tables);
    }

    @Override
    public void load() {
        StudyProgram[] studyPrograms = {
                new StudyProgram(1, "Базы данных", 1, 1, 1),
                new StudyProgram(2, "Пособие по общению с Никитой", 2, 1, 1),
                new StudyProgram(3, "Как выжить после написание пособия, краткий курс", 2, 1, 1)
        };
        insert(Arrays.asList(studyPrograms));
        //DatabaseUtils.setSequenceValue("studyprogram_id_gen", studyPrograms.length+1);
    }
}
