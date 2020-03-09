package fhscapstone.fisheltestapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewTeamActivity extends AppCompatActivity {

    public static Team newTeam;
    public static File f = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_team_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        infoScreen();
    }

    public void infoScreen () {
        EditText teamName = (EditText) findViewById(R.id.teamName);
        EditText coachName = (EditText) findViewById(R.id.coachName);


        Spinner primaryPgStat = (Spinner) findViewById(R.id.primaryPgStat);
        Spinner secondaryPgStat = (Spinner) findViewById(R.id.secondaryPgStat);
        Spinner primarySgStat = (Spinner) findViewById(R.id.primarySgStat);
        Spinner secondarySgStat = (Spinner) findViewById(R.id.secondarySgStat);
        Spinner primarySfStat = (Spinner) findViewById(R.id.primarySfStat);
        Spinner secondarySfStat = (Spinner) findViewById(R.id.secondarySfStat);
        Spinner primaryPfStat = (Spinner) findViewById(R.id.primaryPfStat);
        Spinner secondaryPfStat = (Spinner) findViewById(R.id.secondaryPfStat);
        Spinner primaryCStat = (Spinner) findViewById(R.id.primaryCStat);
        Spinner secondaryCStat = (Spinner) findViewById(R.id.secondaryCStat);

        final Coach newCoach = new Coach(coachName.getText().toString(), new int[2][5]);
        int i = 0;
        while (i >= 9) {
            ArrayList<String> a = new ArrayList<String>();
            a.add("Points");
            a.add("Rebounds");
            a.add("Assists");
            a.add("Blocks");
            a.add("Steals");
            a.add("Turnovers");
            ArrayAdapter<String> r = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, a);
            r.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            primaryPgStat.setAdapter(r);
            secondaryPgStat.setAdapter(r);
            primarySgStat.setAdapter(r);
            secondarySgStat.setAdapter(r);
            primarySfStat.setAdapter(r);
            secondarySfStat.setAdapter(r);
            primaryPfStat.setAdapter(r);
            secondaryPfStat.setAdapter(r);
            primaryCStat.setAdapter(r);
            secondaryCStat.setAdapter(r);
            primaryPgStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(true, 0, position+2);
                }
            });

            secondaryPgStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(false, 0, position+2);
                }
            });
            primarySgStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(true, 1, position+2);
                }
            });

            secondarySgStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(false, 1, position+2);
                }
            });

            primarySfStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(true, 2, position+2);
                }
            });

            secondarySfStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(false, 2, position+2);
                }
            });

            primaryPfStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(true, 3, position+2);
                }
            });

            secondaryPfStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(false, 3, position+2);
                }
            });

            primaryCStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(true, 4, position+2);
                }
            });

            secondaryCStat.setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newCoach.fillStat(false, 4, position+2);
                }
            });
            //ch[i].setAdapter(r);
            /*ch[i].setOnItemSelectedListener(new AdapterView.onItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   int selection = position;
                   //FIGURE OUT HOW TO ASSIGN THIS STAT TO COACH
                   }
               });

            }*/

        }

        TextView title2 = (TextView) findViewById(R.id.title2);
        TextView pg = (TextView) findViewById(R.id.pg);
        TextView sg = (TextView) findViewById(R.id.sg);
        TextView sf = (TextView) findViewById(R.id.sf);
        TextView pf = (TextView) findViewById(R.id.pf);
        TextView c = (TextView) findViewById(R.id.c);
        TextView prim = (TextView) findViewById(R.id.prim);
        TextView sec = (TextView) findViewById(R.id.sec);

        newTeam = new Team(teamName.getText().toString(), newCoach);

        Button created = (Button) findViewById(R.id.created);
        Button backToTitle = (Button) findViewById(R.id.backToTitle);
        created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
            if (save())
                startActivity(new Intent(NewTeamActivity.this, TeamHomeActivity.class));
            }
        });
        backToTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(NewTeamActivity.this, MainActivity.class));
            }
        });

    }

    public boolean save () {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = getFilesDir();
            fos = openFileOutput("Team List", Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(newTeam);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (LoadTeamActivity.addSaveFile(f)) {
            Toast.makeText(this, "Team Created! " + f, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
