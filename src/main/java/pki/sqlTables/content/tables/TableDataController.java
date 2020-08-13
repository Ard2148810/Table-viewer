package pki.sqlTables.content.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableDataController {

    @Autowired
    TableDataService tableDataService;

    @GetMapping("/api/tables")
    @CrossOrigin
    public List<TableDataEntity> getAllTableNames() {
        return tableDataService.getAllTableData();
    }
}
