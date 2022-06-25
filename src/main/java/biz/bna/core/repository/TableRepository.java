package biz.bna.core.repository;

import biz.bna.core.config.ConnectionSettings;
import biz.bna.core.config.DatabaseConfig;
import biz.bna.core.utils.OrmUtils;
import org.hibernate.tool.hbm2ddl.TableMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TableRepository<T> {

    NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
    Map<String, TableMetadata> metaDataMap = new HashMap<>();

    default List<T> getAll(){

        return null;
    }
}
