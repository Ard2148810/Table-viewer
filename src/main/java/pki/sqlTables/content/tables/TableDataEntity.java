package pki.sqlTables.content.tables;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Immutable
@Entity
@Table(name = "pg_stat_user_tables")
public class TableDataEntity {

    @Id
    @GeneratedValue
    @Column(name = "relid")
    int id;

    @Column(name = "relname")
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
