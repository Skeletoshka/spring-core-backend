package biz.spring.core.repository.dnk;


import biz.spring.core.model.dnk.StudyCase;
import biz.spring.core.repository.TableRepository;
import biz.spring.core.utils.DatabaseUtils;
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
public class StudyCaseRepository implements TableRepository<StudyCase> {
    private static Logger logger = LoggerFactory.getLogger(StudyCaseRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/200500-studycase.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("studycase created");
    }

    public void drop() {
        String[] tables = {"studycase"};
        drop(tables);
    }

    public void load() {
        StudyCase[] studyCases = {
                new StudyCase(1, 1, "Теории заговора", "Слава очень долго подозревал, что за ним следят..", 1, 1),
                new StudyCase(2, 1, "Оглавление", "Тут был хороший текст", 2, 1),
                new StudyCase(3, 1, "Мне лень придумывать название", "Высокоинтеллектуальный текст", 3, 1)
        };
        insert(Arrays.asList(studyCases));
        DatabaseUtils.setSequenceValue("studycase_id_gen", studyCases.length+1);
    }
}
