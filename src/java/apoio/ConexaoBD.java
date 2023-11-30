package apoio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    private ConexaoBD() {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("apoio/db.properties"));
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbsenha = "postgres";

            Class.forName(dbdriver);

            if (dbuser.length() != 0) {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    public void closeConnection(Connection con, PreparedStatement ps) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
