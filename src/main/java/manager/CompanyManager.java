package manager;

import dbConnectionProvider.DBConnectionProvider;
import model.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyManager {

    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Company> getCompanies() {
        String sql = "SELECT * FROM company";
        List<Company> companies = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                companies.add(Company.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .address(resultSet.getString("address"))
                        .build());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return companies;
    }

}


