package com.example.android.newsreport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private final String json = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":1917339,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":191734,\"orderBy\":\"newest\",\"results\":[{\"id\":\"world/2016/dec/21/china-restricts-sharing-of-unofficial-videos-on-social-media\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2016-12-20T23:30:16Z\",\"webTitle\":\"China restricts sharing of 'unofficial' videos on social media\",\"webUrl\":\"https://www.the" +
            "guardian.com/world/2016/dec/21/china-restricts-sharing-of-unofficial-videos-on-social-media\",\"apiUrl\":\"https://content.guardianapis.com/world/2016/dec/21/china-restricts-sharing-of-unofficial-videos-on-social-media\",\"isHosted\":false},{\"id\":\"society/2016/dec/20/lack-of-awareness-of-grape-choking-hazard-putting-children-at-risk-say-doctors\",\"type\":\"article\",\"sectionId\":\"society\",\"sectionName\":\"Society\",\"webPublicationDate\":\"2016-12-20T23:30:02Z\",\"webTitle\":\"Lack of awareness of grape choking hazard puts children at risk, say doctors\",\"webUrl\":\"https://www.theguardian.com/society/2016/dec/20/lack-of-awareness-of-grape-choking-hazard-putting-children-at-risk-say-doctors\",\"apiUrl\":\"https://content.guardianapis.com/society/2016/de" +
            "c/20/lack-of-awareness-of-grape-choking-hazard-putting-children-at-risk-say-doctors\",\"isHosted\":false},{\"id\":\"us-news/2016/dec/20/idaho-football-coat-hanger-rape-teammate-john-rk-howard\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-12-20T23:26:51Z\",\"webTitle\":\"White football player accused of raping black, disabled team-mate avoids prison\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/dec/20/idaho-football-coat-hanger-rape-teammate-john-rk-howard\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/dec/20/idaho-football-coat-hanger-rape-teammate-john-rk-howard\",\"isHosted\":false},{\"id\":\"us-news/2016/dec/20/barack-obama-bans-oil-gas-drilling-arctic-atlantic\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-12-20T22:36:35Z\",\"webTitle\":\"Barack Obama bans oil and gas drilling in most of Arctic and Atlantic oceans\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/dec/20/barack-obama-bans-oil-gas-drilling-arctic-atlantic\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/dec/20/barack-obama-bans-oil-gas-drilling-arctic-atlantic\",\"isHosted\":false},{\"id\":\"football/2016/dec/20/manchester-united-jose-mourinho-contract-extension\",\"type\":\"article\",\"sectionId\":\"football" +
            "\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2016-12-20T22:30:00Z\",\"webTitle\":\"Manchester United consider offering José Mourinho contract extension\",\"webUrl\":\"https://www.theguardian.com/football/2016/dec/20/manchester-united-jose-mourinho-contract-extension\",\"apiUrl\":\"https://content.guardianapis.com/football/2016/dec/20/manchester-united-jose-mourinho-contract-extension\",\"isHosted\":false},{\"id\":\"football/2016/dec/20/yaya-toure-manchester-city-bigger-manchester-united\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2016-12-20T22:30:00Z\",\"webTitle\":\"Yaya Touré: I want Manchester City to be bigger than Manchester United\",\"webUrl\":\"https://www.theguardian.com/football/2016/dec/20/yaya-toure-manchester-city-bigger-manchester-united\",\"apiUrl\":\"https://content.guardianapis.com/football/2016/dec/20/yaya-toure-manchester-city-bigger-manchester-united\",\"isHos" +
            "ted\":false},{\"id\":\"football/2016/dec/20/liverpool-sadio-mane-africa-cup-of-nations-senegal\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2016-12-20T22:30:00Z\",\"webTitle\":\"Liverpool’s matchwinner Sadio Mané will head to Gabon with a heavy heart\",\"webUrl\":\"https://www.theguardian.com/football/2016/dec/20/liverpool-sadio-mane-africa-cup-of-nations-senegal\",\"apiUrl\":\"https://content.guardianapis.com/football/2016/dec/20/liverpool-sadio-mane-africa-cup-of-nations-senegal\",\"isHosted\":false},{\"id\":\"world/live/2016/dec/20/berlin-christmas-market-attack-suspect-pakistan-live-coverage\",\"type\":\"liveblog\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2016-12-20T22:23:01Z\",\"webTitle\":\"Berlin attack: first suspect released as driver thought to still be at large – live\",\"webUrl\":\"https://www.theguardian.com/world/live/2016/dec/20/berlin-christmas-market-attack-suspect-pakistan-live-coverage\",\"apiUrl\":\"https://content.guardianapis.com/world/live/2016/dec/20/berlin-christmas-market-attack-suspect-pakistan-live-coverage\",\"isHosted\":false},{\"id\":\"us-news/2016/dec/20/trumps-response-to-terror-attacks-risks-adding-confusion-to-dangerous-situation\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-12-20T22:16:21Z\",\"webTitle\":\"Trump's response to recent attacks risks adding confusion to dangerous situation\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/dec/20/trumps-response-to-terror-attacks-risks-adding-confusion-to-dangerous-situation\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/dec/20/trumps-re" +
            "sponse-to-terror-attacks-risks-adding-confusion-to-dangerous-situation\",\"isHosted\":false},{\"id\":\"football/2016/dec/20/celtic-partick-thistle-scottish-premiership-match-report\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2016-12-20T22:00:19Z\",\"webTitle\":\"Scott Sinclair fires Celtic 14 points clear with winner against Partick Thistle\",\"webUrl\":\"https://www.theguardian.com/football/2016/dec/20/celtic-partick-thistle-scottish-premiership-match-report\",\"apiUrl\":\"htt" +
            "ps://content.guardianapis.com/football/2016/dec/20/celtic-partick-thistle-scottish-premiership-match-report\",\"isHosted\":false}]}}";

    private String urlRequest = "http://content.guardianapis.com/search?q=football&api-key=fc93e16d-0d30-42cf-a514-41b88adee69d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        lv = (ListView) findViewById(R.id.list_view);


        List<Report> reports = QueryUtils.fetchReportData(urlRequest);

        final ReportAdapter adapter = new ReportAdapter(this, reports );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Report currentReport = adapter.getItem(position);

                Uri reportUri = Uri.parse(currentReport.getUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, reportUri);

                startActivity(websiteIntent);
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
}
