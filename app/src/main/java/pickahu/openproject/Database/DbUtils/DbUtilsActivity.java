package pickahu.openproject.Database.DbUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pickahu.openproject.Database.DbUtils.bean.ChildInfo;
import pickahu.openproject.R;


/**
 * Created by Administrator on 2017/5/11.
 */
public class DbUtilsActivity extends Activity implements View.OnClickListener {

    private DbManager db;
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_db);
        initViews();
        initDB();
        initData();
    }

    private void initViews() {

        findViewById(R.id.btn_add).setOnClickListener(this);

        findViewById(R.id.btn_select).setOnClickListener(this);

        etText = (EditText) findViewById(R.id.et_name);
    }

    private void initData() {


        ArrayList<ChildInfo> childInfos = new ArrayList<>();
        childInfos.add(new ChildInfo("zhangsan"));
        childInfos.add(new ChildInfo("lisi"));
        childInfos.add(new ChildInfo("wangwu"));
        childInfos.add(new ChildInfo("zhaoliu"));
        childInfos.add(new ChildInfo("qianqi"));
        childInfos.add(new ChildInfo("sunba"));
        //db.save()方法不仅可以插入单个对象，还能插入集合
        try {
            db.save(childInfos);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_select:
                select();
                break;
        }
    }

    private void add() {

        ChildInfo childInfo = new ChildInfo(etText.getText().toString());
        try {
            db.save(childInfo);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    private void select() {

        try {
            List<ChildInfo> all = db.findAll(ChildInfo.class);

            for (int i = 0; i < all.size(); i++) {
                Log.e("dbutils", all.get(i).toString() );
            }


        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    private void initDB() {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //设置数据库名，默认xutils.db
                .setDbName("myapp.db")
                //设置数据库路径，默认存储在app的私有目录
                .setDbDir(new File("/mnt/sdcard/"))
                //设置数据库的版本号
                .setDbVersion(1)
                //设置数据库打开的监听
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                //设置数据库更新的监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    }
                })
                //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table) {
                        Log.i("JAVA", "onTableCreated：" + table.getName());
                    }
                });
        //设置是否允许事务，默认true
        //.setAllowTransaction(true)

        db = x.getDb(daoConfig);
    }

    private void all() {

        /**
         * 插入
         */
//        用集合向child_info表中插入多条数据
//        ArrayList<ChildInfo> childInfos = new ArrayList<>();
//        childInfos.add(new ChildInfo("zhangsan"));
//        childInfos.add(new ChildInfo("lisi"));
//        childInfos.add(new ChildInfo("wangwu"));
//        childInfos.add(new ChildInfo("zhaoliu"));
//        childInfos.add(new ChildInfo("qianqi"));
//        childInfos.add(new ChildInfo("sunba"));
//        //db.save()方法不仅可以插入单个对象，还能插入集合
//        db.save(childInfos);

        /**
         * 删除数据库   db.dropDb();
         * 删除表     db.dropTable(ChildInfo.class);
         */

        /**
         * 新增表中的数据
         *
         *  ChildInfo childInfo = new ChildInfo("zhangsan123");
         db.save(childInfo);
         */

        /**
         * 删除表中数据
         *
         //第一种写法：
         db.delete(ChildInfo.class); //child_info表中数据将被全部删除
         //第二种写法，添加删除条件：
         WhereBuilder b = WhereBuilder.b();
         b.and("id",">",2); //构造修改的条件
         b.and("id","<",4);
         db.delete(ChildInfo.class, b);
         */

        /**
         * 修改表中的数据
         * //第一种写法：
         ChildInfo first = db.findFirst(ChildInfo.class);
         first.setcName("zhansan2");
         db.update(first,"c_name"); //c_name：表中的字段名
         //第二种写法：
         WhereBuilder b = WhereBuilder.b();
         b.and("id","=",first.getId()); //构造修改的条件
         KeyValue name = new KeyValue("c_name","zhansan3");
         db.update(ChildInfo.class,b,name);
         //第三种写法：
         first.setcName("zhansan4");
         db.saveOrUpdate(first);
         */

        /**
         * 查询表中的数据
         *
         //查询数据库表中第一条数据
         ChildInfo first = db.findFirst(ChildInfo.class);
         Log.i("JAVA",first.toString());
         //添加查询条件进行查询
         List<ChildInfo> all = db.selector(ChildInfo.class).where("id",">",2).and("id","<",4).findAll();
         for(ChildInfo childInfo :all){
         Log.i("JAVA",childInfo.toString());
         }
         */

    }


}
