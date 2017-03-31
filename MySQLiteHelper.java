package css.cis3334hailey.vogelladatabase;

/**
 * This class contains the getters and setters relative to the table columns (ID and Comment)
 *
 * @author  Vogella, Hailey Vold
 * @date    3/31/2017
 *
 * @see Comment
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments";                                             // Creating constant string variable for table comments
    public static final String COLUMN_ID = "_id";                                                       // Creating constant string variable for the table column ID
    public static final String COLUMN_COMMENT = "comment";                                              // Creating constant string variable for the table column Comment

    private static final String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Creates the Database through SQL using two columns: ID and Comment
     *
     * @param  TABLE_COMMENTS
     * @param  COLUMN_ID
     * @param  COLUMN_COMMENT
     */
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";


    /**
     * Adds additional context to the database like Name and Version
     *
     * @param  context
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * When the app is opened, SQL is executed and therefore the database it created
     *
     * @param  database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }


    /**
     * Deletes existing data and recreates the table (old version and new version) in the case of a SQL upgrade
     *
     * @param  db
     * @param  oldVersion
     * @param  newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);                                                                                   // Standard Create Statement:

                                                                                                        //  CREATE TABLE table_name (
                                                                                                        //         column_1 data_type COLUMN CONSTRAINT,
                                                                                                        //         column_2 data_type COLUMN CONSTRAINT,
                                                                                                        //         column_3 data_type COLUMN CONSTRAINT,
                                                                                                        //         );
    }
}