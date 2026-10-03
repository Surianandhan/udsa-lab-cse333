package com.example.sql1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName1, editEid1, editsalary1;
    Button btnAdd1, btnDelete1, btnViewAll1, btnModify1, btnView1;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEid1 = (EditText) findViewById(R.id.etId);
        editName1 = (EditText) findViewById(R.id.etName);
        editsalary1 = (EditText) findViewById(R.id.etSal);
        btnAdd1 = (Button) findViewById(R.id.btnAdd1);
        btnDelete1 = (Button) findViewById(R.id.btnDelete1);
        btnModify1 = (Button) findViewById(R.id.btnModify1);
        btnView1 = (Button) findViewById(R.id.btnView1);
        btnViewAll1 = (Button) findViewById(R.id.btnViewAll1);

        btnAdd1.setOnClickListener(this);
        btnDelete1.setOnClickListener(this);
        btnModify1.setOnClickListener(this);
        btnView1.setOnClickListener(this);
        btnViewAll1.setOnClickListener(this);

        db = openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS employee(empid VARCHAR, name VARCHAR, salary VARCHAR);");
    }

    public void onClick(View view) {
        if (view == btnAdd1) {
            if (editEid1.getText().toString().trim().length() == 0 ||
                    editName1.getText().toString().trim().length() == 0 ||
                    editsalary1.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            // Parameterised query (?): input containing quotes, e.g. O'Brien, no longer breaks the SQL
            db.execSQL("INSERT INTO employee VALUES(?, ?, ?);", new Object[]{
                    editEid1.getText().toString(),
                    editName1.getText().toString(),
                    editsalary1.getText().toString()});
            showMessage("Success", "Record added");
            clearText();
        }

        if (view == btnDelete1) {
            if (editEid1.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Employee id");
                return;
            }
            String[] id = {editEid1.getText().toString()};
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE empid=?", id);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM employee WHERE empid=?", id);
                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid Employee id");
            }
            c.close();
            clearText();
        }

        if (view == btnModify1) {
            if (editEid1.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Employee id");
                return;
            }
            String[] id = {editEid1.getText().toString()};
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE empid=?", id);
            if (c.moveToFirst()) {
                db.execSQL("UPDATE employee SET name=?, salary=? WHERE empid=?", new Object[]{
                        editName1.getText().toString(),
                        editsalary1.getText().toString(),
                        editEid1.getText().toString()});
                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", "Invalid Employee id");
            }
            c.close();
            clearText();
        }

        if (view == btnView1) {
            if (editEid1.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Employee id");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE empid=?",
                    new String[]{editEid1.getText().toString()});
            if (c.moveToFirst()) {
                editName1.setText(c.getString(1));
                editsalary1.setText(c.getString(2));
            } else {
                showMessage("Error", "Invalid Employee id");
                clearText();
            }
            c.close();
        }

        if (view == btnViewAll1) {
            Cursor c = db.rawQuery("SELECT * FROM employee", null);
            if (c.getCount() == 0) {
                c.close();
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Employee id: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Salary: " + c.getString(2) + "\n\n");
            }
            c.close();
            showMessage("Employee Details", buffer.toString());
        }
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        editEid1.setText("");
        editName1.setText("");
        editsalary1.setText("");
        editEid1.requestFocus();
    }
}
