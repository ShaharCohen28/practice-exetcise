package drones.DB;


public class DBmanager {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String SQL_USER = "admin";
    public static final String SQL_PASSWORD = "Sa12345678!!";

    public static final String CREATE_DB = "CREATE SCHEMA `drone_lab`";
    public static final String DROP_DB = "DROP SCHEMA `drone_lab`";

    public static final String CREATE_CUSTOMERS_TABLE = "CREATE TABLE IF NOT EXISTS `drone_lab`.`customer` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `phone` VARCHAR(12) NOT NULL," +
            "  `city` VARCHAR(45) NOT NULL," +
            "  `vip` TINYINT NOT NULL," +
            "  `urgent` TINYINT NOT NULL," +
            "  PRIMARY KEY (`id`))";
    public static final String CREATE_DRONES_TABLE = "CREATE TABLE IF NOT EXISTS`drone_lab`.`drone` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `customer_id` INT NOT NULL," +
            "  `manufacturer` VARCHAR(45) NOT NULL," +
            "  `model` VARCHAR(45) NOT NULL," +
            "  `eta` DATETIME NOT NULL," +
            "  `entered` DATETIME NOT NULL," +
            "  PRIMARY KEY (`id`))";

    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO `drone_lab`.`customer` " +
            "(`name`, `phone`, `city`, `vip`, `urgent`) " +
            "VALUES(?,?,?,?,?)";

    public static final String DELETE_CUSTOMER = "DELETE FROM `drone_lab`.`customer` WHERE `id`=?";

    public static final String UPDATE_CUSTOMER = "UPDATE `drone_lab`.`customer` " +
            "SET name=?, phone=?, city=?, vip=?, urgent=? " +
            "WHERE id=?";

    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM `drone_lab`.`customer`";

    public static final String GET_SINGLE_CUSTOMER = "SELECT * FROM `drone_lab`.`customer` WHERE id=?";

    public static final String GET_ALL_CUSTOMERS_CITY = "SELECT * FROM `drone_lab`.`customer` WHERE city=?";

    public static final String CREATE_DRONE = "INSERT INTO `drone_lab`.`drone` " +
            "(`customer_id`, `manufacturer`, `model`, `eta`, `entered`) " +
            "VALUES(?,?,?,?,?)";

    public static final String DELETE_DRONE = "DELETE FROM `drone_lab`.`drone` WHERE `id`=?";

    public static final String UPDATE_DRONE = "UPDATE `drone_lab`.`drone` " +
            "SET customer_id=?, manufacturer=?, model=?, eta=?, entered=? " +
            "WHERE id=?";

    public static final String GET_ALL_DRONES = "SELECT * FROM `drone_lab`.`drone`";

    public static final String GET_SINGLE_DRONE = "SELECT * FROM `drone_lab`.`drone` WHERE id=?";

    public static final String GET_DRONES_BY_CUSTOMER="SELECT * FROM `drone_lab`.`drone` WHERE customer_id=?";
}
