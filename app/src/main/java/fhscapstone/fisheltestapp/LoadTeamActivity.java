package fhscapstone.fisheltestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadTeamActivity extends Activity {

    public static File[] files = new File[3];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_team_activity);

        infoScreen();

    }

    public void infoScreen() {
        Button team1 = (Button) findViewById(R.id.selection1);
        Button team2 = (Button) findViewById(R.id.selection2);
        Button team3 = (Button) findViewById(R.id.selection3);

        TextView file1 = (TextView) findViewById(R.id.file1);
        TextView file2 = (TextView) findViewById(R.id.file2);
        TextView file3 = (TextView) findViewById(R.id.file3);

        if (files[0].equals(null)) {
            team1.setEnabled(false);
            file1.setText("No Team");
        } else {
            team1.setText("Select");
            file1.setText(getTeamFromFile(0).getName());
        }

        if (files[1].equals(null)) {
            team2.setEnabled(false);
            file2.setText("No Team");
        } else {
            team2.setText("Select");
            file2.setText(getTeamFromFile(1).getName());
        }

        if (files[2].equals(null)) {
            team3.setEnabled(false);
            file3.setText("No Team");
        } else {
            team3.setText("Select");
            file3.setText(getTeamFromFile(2).getName());
        }

        team1.setOnClickListener(new View.onClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoadTeamActivity.this, TeamHomeActivity.class));
            }
        });

        team2.setOnClickListener(new View.onClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoadTeamActivity.this, TeamHomeActivity.class));
            }
        });

        team3.setOnClickListener(new View.onClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoadTeamActivity.this, TeamHomeActivity.class));
            }
        });
    }

    public static boolean addSaveFile(File f) {
        if (!files[0].equals(null)) {
            files[0] = f;
        } else if (!files[1].equals(null)) {
            files[1] = f;
        } else if (!files[2].equals(null)) {
            files[2] = f;
        } else {
            return false;
        }
        return true;
    }

    public static Team getTeamFromFile(int fileNo) {
        FileInputStream f;
        ObjectInputStream o;
            try {
                f = new FileInputStream(files[fileNo]);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File Not Found");
                return null;
            }
            try {
                o = new ObjectInputStream(f);
            } catch (IOException e) {
                System.out.println("Error: File Not Found");
                return null;
            }
            try {
                return (Team) o.readObject();
            } catch (IOException e) {
                System.out.println("Error: File Not Found");
                return null;
            } catch (ClassNotFoundException e) {
                System.out.println("Error: File Not Found");
                return null;
            }
    }
}
