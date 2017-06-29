package com.weichao.keshi.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.weichao.keshi.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @ datetime: 2017/2/3 on 17:39
 * @ description: StudentDao包
 * @ author: 郑卫超
 * QQ:2318723605
 * Tel：13930023254
 */

public class StudentDao {
    static String path="/data/data/com.weichao.keshi/files/" +"stu.db";

    //增加
    public void add(Student student){
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        ContentValues values=new ContentValues();
        values.put("name", student.getName());
        values.put("sex", student.getSex());

        db.insert("stu20155", null, values);
        db.close();
    }
    //删除
    public void delete(String stu_no){
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        db.delete("stu20155", "stu_no=?", new String[]{stu_no});
        db.close();
    }
    //修改
    public void update(Student student){
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        ContentValues values=new ContentValues();
        values.put("name", student.getName());
        values.put("tezheng", student.getTezheng());

        db.update("stu20155", values, "stu_no=?", new String[]{student.getStu_no()});
        db.close();
    }

    public List<Student> findPart(int index){
        Log.e("zwc", "开始分页加载");
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<Student> list=new ArrayList<Student>();

        Cursor cursor = db.rawQuery("select stu_no,name,sex,birth,idcard,"
                + "kaohao,shenfen,minzu,xiaoqu,yuanxi,zhuanye,banhao,"
                + "xuezhi,cengci,address,tezheng from grade " +
                "order by _id desc " +
                "limit ?,10", new String[]{index+""});
        Log.e("zwc", "查询数据库完毕");
        while(cursor.moveToNext()){
            Student bn=new Student();

            bn.setStu_no(cursor.getString(0));
            bn.setName(cursor.getString(1));
            bn.setSex(cursor.getString(2));
            bn.setBirth(cursor.getString(3));
            bn.setIdcard(cursor.getString(4));
            bn.setKaohao(cursor.getString(5));
            bn.setShenfen(cursor.getString(6));
            bn.setAddress(cursor.getString(7));
            bn.setMinzu(cursor.getString(8));
            bn.setXiaoqu(cursor.getString(9));
            bn.setYuanxi(cursor.getString(10));
            bn.setZhuanye(cursor.getString(11));
            bn.setBanhao(cursor.getString(12));
            bn.setXuezhi(cursor.getString(13));
            bn.setCengci(cursor.getString(14));
            bn.setTezheng(cursor.getString(15));

            list.add(bn);
        }
        cursor.close();
        db.close();
        Log.e("zwc", "分页加载完成");
        return list;
    }

    public static List<Student> query(String name,int queryMode){
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        List<Student> list=new ArrayList<Student>();
        Cursor cursor=null;
        switch (queryMode){
            case 0://按照姓名查询
                cursor = db.query("stu20155", new String[]{
                                "stu_no","name","sex","birth","idcard",
                                "kaohao","shenfen","minzu","xiaoqu","yuanxi",
                                "zhuanye","banhao","xuezhi","cengci","address","tezheng"},
                        "name like ?",new String[]{"%"+name+"%"},
                        null, null, null);
                break;
            case 1://按照专业查询
                cursor = db.query("stu20155", new String[]{
                                "stu_no","name","sex","birth","idcard",
                                "kaohao","shenfen","minzu","xiaoqu","yuanxi",
                                "zhuanye","banhao","xuezhi","cengci","address","tezheng"},
                        "zhuanye like ?",new String[]{"%"+name+"%"},
                        null, null, null);
                break;
            case 2://按照校区查询
                cursor = db.query("stu20155", new String[]{
                                "stu_no","name","sex","birth","idcard",
                                "kaohao","shenfen","minzu","xiaoqu","yuanxi",
                                "zhuanye","banhao","xuezhi","cengci","address","tezheng"},
                        "xiaoqu like ?",new String[]{"%"+name+"%"},
                        null, null, null);
                break;

            default:
                break;
        }

        while(cursor.moveToNext()){
            Student bn=new Student();

            bn.setStu_no(cursor.getString(0));
            bn.setName(cursor.getString(1));
            bn.setSex(cursor.getString(2));
            bn.setBirth(cursor.getString(3));
            bn.setIdcard(cursor.getString(4));
            bn.setKaohao(cursor.getString(5));
            bn.setShenfen(cursor.getString(6));
            bn.setMinzu(cursor.getString(7));
            bn.setXiaoqu(cursor.getString(8));
            bn.setYuanxi(cursor.getString(9));
            bn.setZhuanye(cursor.getString(10));
            bn.setBanhao(cursor.getString(11));
            bn.setXuezhi(cursor.getString(12));
            bn.setCengci(cursor.getString(13));
            bn.setAddress(cursor.getString(14));
            bn.setTezheng(cursor.getString(15));

            list.add(bn);
        }
        cursor.close();
        db.close();
        return list;
    }

}