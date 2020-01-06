package fhscapstone.fisheltestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class NewTeamActivity extends AppCompatActivity {

    static Team newTeam;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void infoScreen () {
        EditText teamName = (EditText) findViewById(R.id.teamName);
        EditText coachName = (EditText) findViewById(R.id.coachName);
        Button created = (Button) findViewById(R.id.created);
        Button backToTitle = (Button) findViewById(R.id.backToTitle);
        created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(NewTeamActivity.this, TeamHomeActivity.class));
            }
        });
        backToTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(NewTeamActivity.this, MainActivity.class));
            }
        });


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

    }

    public Team sendTeam () {
            return newTeam;
    }
}
