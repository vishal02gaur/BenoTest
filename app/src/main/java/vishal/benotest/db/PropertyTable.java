package vishal.benotest.db;

/**
 * Created by Vishal Gaur on 6/20/2018.
 */

public class PropertyTable {

    public static final String TABLE_NAME = "property";


    public static final String LANDMARK = "landmark";
    public static final String CITY = "city";
    public static final String NAME = "name";
    public static final String REVIEW_COUNT = "review_Count";
    public static final String PRICE = "price";

    public static String getPropertyTableCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(LANDMARK + " TEXT, ");
        query.append(CITY + " TEXT, ");
        query.append(NAME + " TEXT, ");
        query.append(REVIEW_COUNT + " INTEGER, ");
        query.append(PRICE + " REAL");

        query.append(" )");
        return query.toString();
    }

}
