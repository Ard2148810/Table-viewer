package pki.sqlTables.content.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableDataService {

    @Autowired
    TableDataRepository tableDataRepository;

    public List<TableDataEntity> getAllTableData() {
        List<TableDataEntity> tableData = new ArrayList<>();
        tableDataRepository.findAll().forEach(tableData::add);
        return tableData;
    }
}
